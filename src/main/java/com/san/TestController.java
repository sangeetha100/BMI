package com.san;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/bmi")
	public ModelAndView bmi(HttpServletRequest request,HttpServletResponse response)
	
	{
		
		float height=Float.parseFloat(request.getParameter("t2"));
		float weight=Float.parseFloat(request.getParameter("t3"));
		
		calservice cs=new calservice();
		float ans=cs.add(height,weight);
		
		
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result",ans);
		return mv;
		
		
	}
	
}
