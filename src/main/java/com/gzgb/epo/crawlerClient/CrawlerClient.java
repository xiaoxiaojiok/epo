package com.gzgb.epo.crawlerClient;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.gzgb.epo.entity.WebGatherNode;

public class CrawlerClient {

	private static CrawlerClient instance = null;

	public CrawlerClient() {
	}

	public static CrawlerClient newInstance() {
		if (instance == null) {
			instance = new CrawlerClient();
		}
		return instance;
	}

	public int crawlerOperation(int enable, WebGatherNodeBean w) {
		MyServiceImplService msis = new MyServiceImplService();
		IMyService ms = msis.getMyServiceImplPort();
		ms.crawlerOperation(enable, w);
		return 0;
	}
	
	public void getGatherNodeBean(WebGatherNodeBean wgn,WebGatherNode webGatherNode){
		if (webGatherNode != null) {
			wgn.setId(webGatherNode.getId());
			wgn.setWebSiteID(webGatherNode.getWsmId().getId());
			wgn.setWeBSiteName(webGatherNode.getWsmId().getWsmName());
			wgn.setWgnUpdateTime(convertToXMLGregorianCalendar(webGatherNode.getWgnUpdateTime()));
			wgn.setWgnName(webGatherNode.getWgnName());
			wgn.setWgnUniqueId(webGatherNode.getWgnUniqueId());
			wgn.setWgnEntryUrl(webGatherNode.getWgnEntryUrl());
			wgn.setWgnAllowRule(webGatherNode.getWgnAllowRule());
			wgn.setWgnDenyRule(webGatherNode.getWgnDenyRule());
			wgn.setWgnNextPage(webGatherNode.getWgnNextPage());
			wgn.setWgnAllowDomain(webGatherNode.getWgnAllowDomain());
			wgn.setWgnWeight(webGatherNode.getWgnWeight());
			wgn.setWgnType(webGatherNode.getWgnType());
			wgn.setWgnSpiderEnable(webGatherNode.getWgnSpiderEnable());
			wgn.setWgnDelay(webGatherNode.getWgnDelay());
			wgn.setWgnCookiesEnable(webGatherNode.getWgnCookiesEnable());
			wgn.setWgnProcessLinks(webGatherNode.getWgnProcessLinks());
			wgn.setWgnProxies(webGatherNode.getWgnProxies());
			wgn.setWgnLoginAccount(webGatherNode.getWgnLoginAccount());
			wgn.setWgnLoginEnable(webGatherNode.getWgnLoginEnable());
			wgn.setWgnLoginEntry(webGatherNode.getWgnLoginEntry());
			wgn.setWgnLoginPassword(webGatherNode.getWgnLoginPassword());
			wgn.setWgnDepthLimit(webGatherNode.getWgnDepthLimit());
			wgn.setWgnTimeInterval(webGatherNode.getWgnTimeInterval());
			wgn.setWgnTimeRefresh(webGatherNode.getWgnTimeRefresh());
			wgn.setWgnUserAgents(webGatherNode.getWgnUserAgents());
			wgn.setWgnTraditional(webGatherNode.getWgnTraditional());
			wgn.setWgnIsClean(webGatherNode.getWgnIsClean());
			wgn.setWgnCreateTime(convertToXMLGregorianCalendar(webGatherNode.getWgnCreateTime()));
			wgn.setWgnUpdateTime(convertToXMLGregorianCalendar(webGatherNode.getWgnUpdateTime()));
			wgn.setWgnJobId(webGatherNode.getWgnJobId());
			wgn.setWgnDelete(webGatherNode.getWgnDelete());
		}

	}
	
	public XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {

             e.printStackTrace();
        }
        return gc;
    }
 
     public  Date convertToDate(XMLGregorianCalendar cal) throws Exception{
         GregorianCalendar ca = cal.toGregorianCalendar();
         return ca.getTime();
     }

	/*
	 * public static void main(String[] args) throws MalformedURLException {
	 * //创建访问wsdl服务地址的url URL url = new URL("http://localhost:8989/ns?wsdl");
	 * //通过Qname指明服务的具体信息 QName sname = new QName("http://service.gzgb.org/",
	 * "MyServiceImplService"); MyServiceImplService msis = new
	 * MyServiceImplService(url,sname); //MyServiceImplService msis = new
	 * MyServiceImplService(); IMyService ms = msis.getMyServiceImplPort();
	 * WebGatherNodeBean w = new WebGatherNodeBean(); w.setWeBSiteName("新浪");
	 * System.out.println(ms.crawlerOperation(true, w));
	 * 
	 * }
	 */

}
