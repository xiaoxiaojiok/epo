package com.gzgb.epo.dao.mainMedia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.CommentList;
import com.gzgb.epo.entity.NewsList;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.service.shiro.ShiroDbRealm.ShiroUser;
import com.gzgb.epo.service.user.UserService;

/**
 * 
 * <pre>
 * 评论舆情DAO实现类
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-26
 */
@Repository
public class CommentListDaoImpl extends BaseDaoImpl<CommentList> implements
CommentListDao {

	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findComment(Integer startTime, Integer endTime,
			Integer site, String content, Integer page, Integer rows,
			String sort, String order) {
		Criteria c = getSession().createCriteria(CommentList.class);
		addAuthority(c);
		c.add(Restrictions.between("mmcTimestamp", startTime, endTime));
		if (site != null) {
			if(site==19){
				c.add(Restrictions.eq("mmcIsAbroad", (byte)1));
			}else{
				c.add(Restrictions.eq("mmcIsAbroad", (byte)0));
			}
		}
		if (content != null) {
			content = "%" + content + "%";
			c.add(Restrictions.like("mmcContent", content));
		}

		List<NewsList> list = c.list();
		int total = 0;
		if (list != null) {
			total = list.size();
		}
		if (page == null || page == 0) {
			page = 1;
		}
		if (rows == null || rows == 0) {
			rows = 20;
		}
		if (sort != null && order != null) {
			if ("asc".equals(order)) {
				c.addOrder(Order.asc(sort));
			} else {
				c.addOrder(Order.desc(sort));
			}
		} else {
			// 默认按照转载量降序排序
			c.addOrder(Order.desc("mmcReserved"));
		}
		List<CommentList> objList = c.setFirstResult((page - 1) * rows)
				.setMaxResults(rows).list();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (objList != null && objList.size() > 0) {
			returnMap.put("total", total);
			returnMap.put("rows", objList);
			return returnMap;
		} else {
			returnMap.put("total", total);
			returnMap.put("rows", "");
			return returnMap;
		}
	}
	
	/**
	 * 
	 * <pre>
	 * 根据用户不同区县和不同的部门，展示不同的信息
	 * </pre>
	 * @param c
	 */
	public void addAuthority (Criteria c){
		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		if(shiroUser == null){
			return ;
		}
		User user = userService.findById(shiroUser.getId(), User.class);
		if(user.getRbiId()!=null){
			c.add(Restrictions.eq("rbiId.id", user.getRbiId().getId()));
		}
	}

}
