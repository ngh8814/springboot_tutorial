package com.spring.training.web.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.training.dto.mgr.MemberDTO;
import com.spring.training.service.mgr.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired MemberService memberService;
	
	@GetMapping("/insert")
	public String insertForm() {
		return "memberForm";
	}
	
	@PostMapping("/insert")
	public String insert(MemberDTO dto) {
		memberService.insert(dto);
		return "redirect:/";
	}
	
}
