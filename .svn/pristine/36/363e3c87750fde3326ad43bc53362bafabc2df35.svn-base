package com.gzgb.epo.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.gzgb.epo.vo.WebGatherNodeBean;

@WebService
public interface RemoteService
{
	/**
	 * 
	 * <pre>
	 * 呼叫响应
	 * </pre>
	 * @param type
	 * @param ids
	 * @return
	 */
	public String callChange(@WebParam(name="type")String type,@WebParam(name="ids")String ids);
	
	/**
	 * 
	 * <pre>
	 * 通过id得到采集点配置信息
	 * </pre>
	 * @param id
	 * @return
	 */
	public WebGatherNodeBean getConf(@WebParam(name="id")Long id);
	

}
