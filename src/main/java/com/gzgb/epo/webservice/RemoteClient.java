package com.gzgb.epo.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.vo.WebGatherNodeBean;

@Component
@Transactional(readOnly = true)
public class RemoteClient {

	/**
	 * 
	 * <pre>
	 * 第一种：与Spring整合的客户端
	 * </pre>
	 * @param args
	 */
/*	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"webService-server.xml");
		RemoteService client = (RemoteService) ctx.getBean("gzgbClient");
		String type = "类型1";
		String ids = "1,2,3,4,5,6,7";
		String str = client.callChange(type, ids);
		System.out.println(str);
		WebGatherNodeBean webGatherNodeBean = client.getConf((long)10);
		System.out.println(webGatherNodeBean.getWgnName());
	}*/

	/**
	 * 第二种:独立的客户端
	 */
	public static void main(String[] args) {
		// 创建WebService客户端代理工厂
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		// 注册WebService接口
		factory.setServiceClass(RemoteService.class);
		// 设置WebService地址
		factory.setAddress("http://125.216.245.197:8080/webservice/gzgb");
		RemoteService client = (RemoteService) factory.create();
		String type = "类型2";
		String ids = "1,2,3,4,5,6,7";
		String str = client.callChange(type, ids);
		System.out.println(str);
		WebGatherNodeBean webGatherNodeBean = client.getConf((long)10);
		System.out.println(webGatherNodeBean.getWgnName());
	}

}
