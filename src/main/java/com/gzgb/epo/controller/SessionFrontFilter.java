
package com.gzgb.epo.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <pre>
 * url过滤器
 * 记录shiro前置url
 * </pre>
 */
public class SessionFrontFilter implements Filter
{
	protected static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}
	
	/**
	 * 此过滤器部署在shiro过滤器之前，用于存储当前两个最新的请求路径，
	 * 因为shiro过滤器在接收请求，判断为session已经超时的情况下会直接改掉请求路径为/login,
	 * 流转到下一个过滤器就会获取不到超时前的访问路径
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
			ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		String reqUri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String reqPage = "";
		if (contextPath.equals("/")){
			reqPage = reqUri;
		}else{
			reqPage = reqUri.replaceFirst(contextPath, "");
		}
		reqPage = reqPage.replaceAll("//", "/");
		String[] urls = new String[]{"",""};
		if(req.getSession().getAttribute("curr_url")!=null){
			 urls= (String[]) req.getSession().getAttribute("curr_url");
			 urls[0] = urls[1];
			 urls[1] = reqPage;
			 req.getSession().setAttribute("curr_url", urls);
		}else{
			urls[0] = "";
			urls[1] = reqPage;
			req.getSession().setAttribute("curr_url", urls);
		}
		filterChain.doFilter(request, response);
	}
	
	public void destroy()
	{
	}

}
