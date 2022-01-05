package org.kdg.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //Mapping : server와 파일을 연결시켜준다
	public String home(Locale locale, Model model) {
		// logger.info == System.out.println()
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();	// 현재 날짜와 시간
		// 날짜 형식을 정해주는 DateFormate 클래스
		// 2021-01-05 or 2021/01/05 or 2021년 01월 05일
		
		System.out.println(date);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		// date 참조변수와 dateformat 참조변수를 결합
		String formattedDate = dateFormat.format(date);
		// request.setAttribute()와 동일
		System.out.println(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public void index() {
		
	}
	
}
