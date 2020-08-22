package com.san.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.san.calservice;
import com.san.beans.Facts;
import com.san.dao.BmiDao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class BmiController {

	@Autowired    
    BmiDao dao;
	
	 @RequestMapping("/viewbmi")    
	    public String viewemp(Model m){    
	        List<Facts> list=dao.getFacts();    
	        m.addAttribute("list",list);  
	        return "viewbmi";    
	    }   
	 @RequestMapping("/bmi1")
		public String bmi(HttpServletRequest request,HttpServletResponse response,Model m)
		
		{
			
			float height=Float.parseFloat(request.getParameter("t2"));
			float weight=Float.parseFloat(request.getParameter("t3"));
			
			calservice cs=new calservice();
			float ans=cs.add(height,weight);
			List<Facts> list=dao.getFacts();
			System.out.println(list.size());
	        m.addAttribute("list",list); 
//	        m.addAttribute("bmi",ans);
			Facts f=list.get(1);
			System.out.println(f.getLowerLimit());
			
//			ModelAndView mv=new ModelAndView();
//			mv.setViewName("viewbmi");
//			mv.addObject("list",list);
//			mv.addObject("result",ans);
			return "viewbmi";
			
			
		}
	 
	 
	 
}
