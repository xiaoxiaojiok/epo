package com.gzgb.epo.controller.cityRecognize;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gzgb.epo.service.user.UserService;

/**
 * 
 * <pre>
 * 城市形象与认知度控制器
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Controller
@RequestMapping(value = "/cityRecognize")
public class CityRecognizeController {

	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(CityRecognizeController.class);

	/**
	 * 进入城市形象与认知度页面
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(Model model,HttpServletRequest request){
			return "cityRecognize/cityRecognizeIndex";
	}
	
	/**
	 * 进入情感分析页面
	 * @return
	 */
	@RequestMapping(value = "cityRecognizeSentimentAnalysis")
	public String sentimentAnalysis(Model model,HttpServletRequest request){
			return "cityRecognize/cityRecognizeSentimentAnalysis";
	}
	
	/**
	 * 进入印象关键词页面
	 * @return
	 */
	@RequestMapping(value = "cityRecognizeImpressionKey")
	public String impressionKey(Model model,HttpServletRequest request){
			return "cityRecognize/cityRecognizeImpressionKey";
	}
	
	/**
	 * 进入涉穗报道分布图页面
	 * @return
	 */
	@RequestMapping(value = "cityRecognizeDistributionMap")
	public String distributionMap(Model model,HttpServletRequest request){
			return "cityRecognize/cityRecognizeDistributionMap";
	}
	
	/**
	 * 进入主流媒体关注度页面
	 * @return
	 */
	@RequestMapping(value = "cityRecognizeMainMediaConcern")
	public String mainMediaConcern(Model model,HttpServletRequest request){
			return "cityRecognize/cityRecognizeMainMediaConcern";
	}
	
	/**
	 * 进入公众评价页面
	 * @return
	 */
	@RequestMapping(value = "cityRecognizePublicOpinion")
	public String publicOpinion(Model model,HttpServletRequest request){
			return "cityRecognize/cityRecognizePublicOpinion";
	}

}
