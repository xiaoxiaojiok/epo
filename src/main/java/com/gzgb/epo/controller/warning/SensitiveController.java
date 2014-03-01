package com.gzgb.epo.controller.warning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzgb.epo.service.warning.SensitiveListService;

/**
 * 
 * <pre>
 * 敏感信息控制器
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-1
 */
@Controller
@RequestMapping(value = "/sensitive")
public class SensitiveController {
	
	@Autowired
	private SensitiveListService sensitiveListService;
	Logger logger = LoggerFactory.getLogger(BlogController.class);

}
