package com.gzgb.epo.controller.leaderRecognition;

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
 * 舆论领袖识别控制器
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Controller
@RequestMapping(value = "/leaderRecognition")
public class LeaderRecognitionController {

	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(LeaderRecognitionController.class);

	/**
	 * 进入舆论领袖识别页面
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(Model model,HttpServletRequest request){
			return "leaderRecognition/leaderRecognitionIndex";
	}


}
