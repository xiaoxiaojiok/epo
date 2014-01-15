package com.gzgb.epo.controller.mainMedia;

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
 * 主流媒体舆情控制器
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Controller
@RequestMapping(value = "/mainMedia")
public class MainMediaController {

	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(MainMediaController.class);

	/**
	 * 进入主流媒体舆情页面
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaIndex";
	}
	
	/**
	 * 进入境内外涉穂新闻页面
	 * @return
	 */
	@RequestMapping(value = "mainMediaInOutNews")
	public String inOutNews(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaInOutNews";
	}
	
	/**
	 * 进入境内外涉穂评论页面
	 * @return
	 */
	@RequestMapping(value = "mainMediaInOutComments")
	public String inOutComments(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaInOutComments";
	}
	
	/**
	 * 进入热点涉穂新闻页面
	 * @return
	 */
	@RequestMapping(value = "mainMediaHotNews")
	public String hotNews(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaHotNews";
	}
	
	/**
	 * 进入热点涉穂评论页面
	 * @return
	 */
	@RequestMapping(value = "mainMediaHotComments")
	public String hotComments(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaHotComments";
	}
	
	/**
	 * 进入九大网站关注度页面
	 * @return
	 */
	@RequestMapping(value = "mainMediaTopNineSite")
	public String topNineSite(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaTopNineSite";
	}
	
	/**
	 * 进入区县关注度页面
	 * @return
	 */
	@RequestMapping(value = "mainMediaRegionConcern")
	public String regionConcern(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaRegionConcern";
	}
	
	/**
	 * 进入实时新闻舆情页面
	 * @return
	 */
	@RequestMapping(value = "mainMediaNowNews")
	public String nowNews(Model model,HttpServletRequest request){
			return "mainMedia/mainMediaNowNews";
	}
	
}
