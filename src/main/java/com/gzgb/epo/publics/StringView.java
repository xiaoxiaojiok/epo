package com.gzgb.epo.publics;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

/**
 */
public class StringView implements View {
	
	private String content;
	
	public StringView() {
	}

	public StringView(String content) {
		this.content = content;
	}

	public String getContentType() {
		return "text/plain;charset=UTF-8";
	}

	@SuppressWarnings("unchecked")
	public void render(Map params, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType(getContentType());
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		String str = getContent();
		try {
			out.write(getContent());
		} finally {
			out.close();
			out = null;
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
