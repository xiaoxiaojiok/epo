package com.gzgb.epo.dao.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
 * 基础dao接口
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
public interface BaseDao<T> {
	/**
	 * 
	 * <pre>
	 * 根据id和class得到一条实体
	 * </pre>
	 * 
	 * @param id
	 * @param cls
	 * @return
	 */
	T findById(Object id, Class<T> cls);

	/**
	 * 
	 * <pre>
	 * 添加一条记录
	 * </pre>
	 * 
	 * @param obj
	 * @return
	 */
	void save(T t);

	/**
	 * 
	 * <pre>
	 * 更新一条记录
	 * </pre>
	 * 
	 * @param obj
	 * @return
	 */
	void update(T e);

	/**
	 * 
	 * <pre>
	 * 删除一条记录
	 * </pre>
	 * 
	 * @param obj
	 * @return
	 */
	void delete(T e);

	/**
	 * 
	 * <pre>
	 * 查询所有记录
	 * </pre>
	 * 
	 * @param cls
	 * @return
	 */
	List<T> findAll(Class<T> cls);

	/**
	 * 
	 * <pre>
	 * 查询所有记录,附带参数,参数要严格相等
	 * </pre>
	 * 
	 * @param cls
	 *            实体类
	 * @param map
	 *            参数列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List<T> getAll(Class<T> cls, Map map);

	/**
	 * 
	 * <pre>
	 * 查询所有记录,附带参数并排序,参数可模糊匹配
	 * </pre>
	 * 
	 * @param cls
	 *            实体类名
	 * @param mapString
	 *            字符串参数列表
	 * @param mapByte
	 *            字字节型参数列表
	 * @param mapInt
	 *            整形参数列表
	 * @param mapLong
	 *            Long型参数列表
	 * @param page
	 *            当前第几页
	 * @param rows
	 *            每页显示数目
	 * @param sort
	 *            按某字段排序
	 * @param order
	 *            升/降序
	 * @return
	 */
	Map<String, Object> getAll(Class<T> cls, Map<String, String> mapString,
			Map<String, Byte> mapByte, Map<String, Integer> mapInt,
			Map<String, Long> mapLong, Integer page, Integer rows, String sort,
			String order);

}
