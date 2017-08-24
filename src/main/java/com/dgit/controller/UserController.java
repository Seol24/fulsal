package com.dgit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.Members;
import com.dgit.service.MemberService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logPage() {
		return "user/login";
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void postLogin(Members members, Model model) throws Exception{
		System.out.println("--------------loginPost---------------");
		Members login = service.login(members.getMid(), members.getMpass());
		
		if(login == null){
			//회원가입을 한적이 없으면, memberVO키가 없음.
			//interceptor에서 memberVO키가 없으면 login화면으로 다시 가도록 처리
			return;
		}
		model.addAttribute("loginVO",login);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request){
		session.removeAttribute("login");
		session.invalidate();
		String url = "main";
		return "redirect:/" + url;
	}
	@RequestMapping(value="/loginInfo", method=RequestMethod.GET)
	public String getLoginInfo() throws Exception{
		System.out.println("--------------loginInfo---------------");
		return "user/loginInfo";
	}
	@RequestMapping(value="/loginInfo", method=RequestMethod.POST)
	public String postLoginInfo(Members members) throws Exception{
		System.out.println("--------------loginInfo---------------");
		service.createMember(members);
		return "user/login";
	}
	
}
