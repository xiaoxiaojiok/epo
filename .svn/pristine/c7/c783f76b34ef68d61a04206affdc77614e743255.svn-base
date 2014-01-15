package com.gzgb.epo.service.knowledgeDictItem;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.knowledgeDictItem.KnowledgeDictItemDao;
import com.gzgb.epo.dao.knowledgeDictLib.KnowledgeDictLibDao;
import com.gzgb.epo.dao.knowledgeDictQuality.KnowledgeDictQualityDao;
import com.gzgb.epo.dao.user.UserDao;
import com.gzgb.epo.entity.KnowledgeDictItem;
import com.gzgb.epo.entity.KnowledgeDictLib;
import com.gzgb.epo.entity.KnowledgeDictQuality;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.service.base.BaseService;
import com.gzgb.epo.util.ReadExcel;

/**
 * 
 * <pre>
 * 词条管理service
 * </pre>
 * 
 * @author Liuyongbin
 * @version 1.0, 2014-1-3
 */
@Service
@Transactional(readOnly = false)
public class KnowledgeDictItemService extends BaseService<KnowledgeDictItem>{
	
		private static Logger logger = LoggerFactory.getLogger(KnowledgeDictItemService.class);

		@Autowired
		private KnowledgeDictItemDao kdiDao;
		@Autowired
		private KnowledgeDictLibDao kdlDao;
		@Autowired
		private KnowledgeDictQualityDao kdqDao;
		@Autowired
		private UserDao userDao;

		/**
		*
		* <pre>
		* 获得本月新增词条
		* </pre>
		* @param 
		* @return 
		*/
		public int getNewCountsOfThisMonth(){
			try {
				logger.info("---getNewCountsOfThisMonth()方法");
				return  kdiDao.getNewCountsOfThisMonth();
			} catch (Exception ex) {
				logger.error(ex.toString());
				return -1;
			}

		}
		/**
		*
		* <pre>
		* 获得本年新增词条
		* </pre>
		* @param 
		* @return 
		*/
		public int getNewCountsOfThisYear(){
			try {
				logger.info("---getNewCountsOfThisYear()方法");
				return  kdiDao.getNewCountsOfThisYear();
			} catch (Exception ex) {
				logger.error(ex.toString());
				return -1;
			}
		}

		/**
		*
		* <pre>
		* 获得词条总数
		* </pre>
		* @param 
		* @return 
		*/

		public long getCountOfAll(){
			try {
				logger.info("---getCountOfAll()()方法");
				return kdiDao.getCountOfAll();
			} catch (Exception ex) {
				logger.error(ex.toString());
				return -1;
			}

		}

		/**
		*
		* <pre>
		* 获得最新的10条词条
		* </pre>
		* @param 
		* @return 
		*/
		public List<KnowledgeDictItem> getNewItem() throws QueryException{
			try {
				logger.info("---getNewItem()方法");
				List<KnowledgeDictItem>  list =  kdiDao.getNewItem();
				return list;
			} catch (Exception ex) {
				logger.error(ex.toString());
				return null;
			}

		}

		/**
		*
		* <pre>
		* 获得最新的10条词条
		* </pre>
		* @param 
		* @return 
		*/
		public Map<String, Object> searchItem(Long parentId, Long kdqId, String fuzzy,Integer page, Integer rows,
				String sort, String order) throws QueryException{
			try {
				logger.info("---searchItem方法");
				Map<String, Object>  map =  kdiDao.searchItem( parentId, kdqId, fuzzy, page,  rows,sort,  order);
				return map;
			} catch (Exception ex) {
				logger.error(ex.toString());
				return null;
			}

		}

		/**
		*
		* <pre>
		*批量导入词条
		** </pre>
		* @param 
		* @return 
		*/
		public Map<String, Object> inputItemByBatch(String filePath, Long libId, Long parentId){
			Map<String, Object> map = new HashMap<String, Object>();
			int insertCount=0;
			try {
				logger.info("---inputItemByBatch方法");
				List<List<Object>>  rowList =  ReadExcel.readExcel(filePath);
				String kdiName = null;
				KnowledgeDictQuality kdqId = null;
				float kdiWeight = 0;
				String kdiPingyin = null;
				KnowledgeDictLib kdlId = kdlDao.findById(libId, KnowledgeDictLib.class);;
				//KnowledgeDictItem kdi = null;
				byte kdiStatus = 1;
				int kdiSwitch = 1;
				int kdiSegmentation = 1;
				User userId = userDao.findById((long)2, User.class);
				Integer ctime = null;
				Integer utime = null;
				//KnowledgeDictLib libId = kdlDao.findById(kdlId, KnowledgeDictLib.class);
				for(int i=0; i<rowList.size(); i++){
				   kdiName = (String)rowList.get(i).get(0);
				   kdqId = kdqDao.findByName((String)rowList.get(i).get(1));
				   kdiWeight = Float.valueOf((String)rowList.get(i).get(2));
				   if(kdiName == null)
					   continue;
				   else{
					   Long time = new Date().getTime()/1000;
					   ctime = time.intValue();
					   utime = ctime;
					   KnowledgeDictItem kdi = new KnowledgeDictItem();
					   kdi.setKdiName(kdiName);
					   kdi.setKdiPinyin(kdiPingyin);
					   kdi.setKdlId(kdlId);
					   kdi.setKdqId(kdqId);
					   kdi.setKdiWeight(kdiWeight);
					   kdi.setKdiStatus(kdiStatus);
					   kdi.setKdiSwitch(kdiSwitch);
					   kdi.setKdiSegmentation(kdiSegmentation);
					   kdi.setUserId(userId);
					   kdi.setKdiCreateTime(ctime);
					   kdi.setKdiUpdateTime(utime);
					   kdiDao.save(kdi);
					   insertCount++;
					   
				   }
				}
				KnowledgeDictLib child = kdlDao.findById(libId, KnowledgeDictLib.class);
				child.setKdlCount((insertCount+child.getKdlCount()));
				KnowledgeDictLib parent = kdlDao.findById(parentId, KnowledgeDictLib.class);
				parent.setKdlCount((insertCount+parent.getKdlCount()));
				kdlDao.update(child);
				kdlDao.update(parent);
			} catch (Exception ex) {
				logger.error(ex.toString());
				map.put("error", true);
				map.put("data", "插入数据库时发生错误，已插入的记录为："+insertCount+"条");
				return map;
			}
			map.put("error", false);
			map.put("data", "成功插入数据库，已插入的记录为："+insertCount+"条");
			return map;
		}
		
		/**
		 * 
		 * <pre>
		 * 通过词条的名字查找
		 * </pre>
		 * 
		 * @param kdlName
		 * @return
		 */
		public KnowledgeDictItem findByName(String kdiName){
			try {
				logger.info("---findByName()方法");
				return  kdiDao.findByName(kdiName);
			} catch (Exception ex) {
				logger.error(ex.toString());
				return null;
			}

		}


}
