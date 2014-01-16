package com.gzgb.epo.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gzgb.epo.service.webgathernode.WebGatherNodeService;
import com.gzgb.epo.vo.WebGatherNodeBean;

@Component
@WebService
public class RemoteServiceImpl implements RemoteService
{
	@Autowired
	private WebGatherNodeService webGatherNodeService;

	@Override
	public String callChange(@WebParam(name="type")String type, @WebParam(name="ids")String ids)
	{
		return type+"----"+ids;
	}

	@Override
	public WebGatherNodeBean getConf(@WebParam(name="id")Long id) {
		WebGatherNodeBean webGatherNodeBean = null;
		if(id!=null){
			webGatherNodeBean = new WebGatherNodeBean();
			webGatherNodeService.fillGatherNodeBean(webGatherNodeBean, id);
		}
		return webGatherNodeBean;
	}
	
}
