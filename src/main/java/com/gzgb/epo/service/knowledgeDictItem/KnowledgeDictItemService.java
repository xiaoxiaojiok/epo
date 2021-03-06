package com.gzgb.epo.service.knowledgeDictItem;

import java.io.File;
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
		public List<KnowledgeDictItem> getNewItem(List<Long> kdlIdList) throws QueryException{
			try {
				logger.info("---getNewItem()方法");
				List<KnowledgeDictItem>  list =  kdiDao.getNewItem(kdlIdList);
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
		public Map<String, Object> searchItem(List<Long> kdlIdList, Long kdqId, String fuzzy,Integer page, Integer rows,
				String sort, String order) throws QueryException{
			try {
				logger.info("---searchItem方法");
				Map<String, Object>  map =  kdiDao.searchItem( kdlIdList, kdqId, fuzzy, page,  rows,sort,  order);
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
		public Map<String, Object> inputItemByBatch(User user, String filePath, Long libId, Long parentId){
			Map<String, Object> map = new HashMap<String, Object>();
			int insertCount=0;
			String hadInsertItem  = "已成功插入的记录的编号为：";
			String errorString = "";
			String hadExits = "";
			File file = new File(filePath);
			if(!file.exists()){
				map.put("error", "系统找不到上传的文件，请重新上传！");
				return map;
			}
			try {
				logger.info("---inputItemByBatch方法");
				List<List<Object>>  rowList =  ReadExcel.readExcel(filePath);
				String kdiName = null;
				KnowledgeDictQuality kdqId = null;
				Float kdiWeight = null;
				String kdiPingyin = null;
				if(libId == null )
					libId = parentId;
				KnowledgeDictLib kdlId = kdlDao.findById(libId, KnowledgeDictLib.class);;
				//KnowledgeDictItem kdi = null;
				byte kdiStatus = 1;
				int kdiSwitch = 1;
				int kdiSegmentation = 1;
				Integer ctime = null;
				Integer utime = null;
				
				//KnowledgeDictLib libId = kdlDao.findById(kdlId, KnowledgeDictLib.class);
				for(int i=0; i<rowList.size(); i++){
				   kdiName = (String)rowList.get(i).get(0);
				   kdqId = kdqDao.findByName((String)rowList.get(i).get(1));
				   if(rowList.get(i).get(2) != null)
				   kdiWeight = Float.valueOf((String)rowList.get(i).get(2));
				   if(kdiName == null || kdqId == null || kdiWeight == null){
					   errorString+=(i+1) + ",";
					   continue;
				   }
					  
				   else{
					   Long time = new Date().getTime()/1000;
					   ctime = time.intValue();
					   utime = ctime;
					   KnowledgeDictItem kdi = null;
					   //判断数据库是否已有该记录
					   Map<String, String >nameMap = new HashMap<String, String>();
					   
					   if((kdi = kdiDao.findByNameAndKdlId(kdiName, libId)) != null){
						   if(kdi.getKdqId().getId() == kdqId.getId()){
							   hadExits+=(i+1)+",";
						       continue;
						   }
					   }
					   kdi = new KnowledgeDictItem();
					   kdi.setKdiName(kdiName);
					   kdi.setKdiPinyin(kdiPingyin);
					   kdi.setKdlId(kdlId);
					   kdi.setKdqId(kdqId);
					   kdi.setKdiWeight(kdiWeight);
					   kdi.setKdiStatus(kdiStatus);
					   kdi.setKdiSwitch(kdiSwitch);
					   kdi.setKdiSegmentation(kdiSegmentation);
					   kdi.setUserId(user);
					   kdi.setKdiCreateTime(ctime);
					   kdi.setKdiUpdateTime(utime);
					   kdiDao.save(kdi);
					   insertCount++;
					   hadInsertItem+=(i+1)+",";
					   
				   }
				}
				KnowledgeDictLib child = kdlDao.findById(libId, KnowledgeDictLib.class);
				child.setKdlCount((insertCount+child.getKdlCount()));
				if(child.getKdlParentId().getId() != 1){
					KnowledgeDictLib parent = kdlDao.findById(parentId, KnowledgeDictLib.class);
					parent.setKdlCount((insertCount+parent.getKdlCount()));
					kdlDao.update(parent);
				}
				kdlDao.update(child);
				
			} catch (Exception ex) {
				logger.error(ex.toString());
		//		map.put("error", "插入数据库时发生错误，已插入的记录为："+insertCount+"条     \n"+hadInsertItem);
				map.put("error", "插入数据库时发生错误，已插入的记录为："+insertCount+"条");

				return map;
			}
			map.put("error", false);
			if(errorString != null && errorString.length() > 0){
				if(errorString.length() > 10){
					errorString = errorString.substring(0, 10);
					errorString+="等";
				}
				
				if(hadExits != null && hadExits.length() > 0){
				//	map.put("data", "成功插入数据库，已插入的记录为："+insertCount+"条!\n 其中编号为：" + errorString + "的记录插入时出现问题，请检查记录名是否为空，权重是否为空（权重必须为数值），或是记录的对应词性不符合规定！\n"+"编号为："+hadExits+"的记录已经存在！");
					map.put("data", "插入数据库时发生错误，已插入的记录为："+insertCount+"条!\n 其中编号为：" + errorString + "的记录插入时出现问题，请检查记录名是否为空，权重是否为空（权重必须为数值），或是记录的对应词性不符合规定！");

				}
				else{
				//	map.put("data", "成功插入数据库，已插入的记录为："+insertCount+"条!\n 其中编号为：" + errorString + "的记录插入时出现问题，请检查记录名是否为空，权重是否为空（权重必须为数值），或是记录的对应词性不符合规定！");
					map.put("data", "插入数据库时发生错误，已插入的记录为："+insertCount+"条!\n 其中编号为：" + errorString + "的记录插入时出现问题，请检查记录名是否为空，权重是否为空（权重必须为数值），或是记录的对应词性不符合规定！");

				}
			}else{
				if(hadExits != null && hadExits.length() > 0){
					if(hadExits.length() > 10){
						hadExits = hadExits.substring(0, 10);
						hadExits+="等";
					}
						
				//	map.put("data", "成功插入数据库，已插入的记录为："+insertCount+"条!\n "+"编号为："+hadExits+"的记录已经存在！");
					map.put("data", "成功插入数据库，已插入的记录为："+insertCount+"条!\n "+"编号为："+hadExits+"的记录已经存在！");

				}
				else{
					//map.put("data", "成功插入数据库，已插入的记录为："+insertCount+"条");
					map.put("data", "成功插入数据库，已插入的记录为："+insertCount+"条");
				}
			}
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
