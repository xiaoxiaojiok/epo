package com.gzgb.epo.service.knowledgeDictLib;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.knowledgeDictLib.KnowledgeDictLibDao;
import com.gzgb.epo.entity.KnowledgeDictLib;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 词库管理service
 * </pre>
 * 
 * @author Liuyongbin
 * @version 1.0, 2014-1-3
 */
@Service
@Transactional(readOnly = true)
public class KnowledgeDictLibService extends BaseService<KnowledgeDictLib>{

		private static Logger logger = LoggerFactory.getLogger(KnowledgeDictLibService.class);

		@Autowired
		private KnowledgeDictLibDao kdlDao;

		/**
		 * 
		 * <pre>
		 * 通过parentId找出子级词库
		 * </pre>
		 * 
		 * @param parentId
		 * @return
		 */
		public Collection<KnowledgeDictLib> findAllChildrenLibByPid(Long parentId){
			try {
				logger.info("---findAllChildrenLibByPid()方法");
				return  kdlDao.findAllChildrenLibByPid(parentId);
			} catch (Exception ex) {
				logger.error(ex.toString());
				return null;
			}

		}

		/**
		 * 
		 * <pre>
		 * 找出一级词库的数量
		 * </pre>
		 * 
		 * @param parentId
		 * @return
		 */
		public int getCountOfLib(){
			try {
				logger.info("---getCountOfLib()()方法");
				return kdlDao.getCountOfLib();
			} catch (Exception ex) {
				logger.error(ex.toString());
				return -1;
			}

		}

		/**
		 * 
		 * <pre>
		 * 根据级别找出词库List
		 * </pre>
		 * 
		 * @param
		 * @return
		 */

		public List<KnowledgeDictLib> getLibByLevel(int level) throws QueryException{
			try {
				logger.info("---getLibByLevel()方法");
				List<KnowledgeDictLib>  list =  kdlDao.getLibByLevel(level);
				return list;
			} catch (Exception ex) {
				logger.error(ex.toString());
				return null;
			}

		}
		

		/**
		 * 
		 * <pre>
		 * 通过词库的名字查找
		 * </pre>
		 * 
		 * @param kdlName
		 * @return
		 */
		public KnowledgeDictLib findByName(String kdlName){
			try {
				logger.info("---findByName()方法");
				return  kdlDao.findByName(kdlName);
			} catch (Exception ex) {
				logger.error(ex.toString());
				return null;
			}

		}


}
