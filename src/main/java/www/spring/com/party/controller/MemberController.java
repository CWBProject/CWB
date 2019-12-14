package www.spring.com.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.spring.com.party.model.MemberVO;
import www.spring.com.party.service.MemberService;

@Controller
@RequestMapping("/party/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private PasswordEncoder passwordEncoder; 

	@RequestMapping("/list")
	public String listAllMember(Model model) {
		List<MemberVO> listAllMember = memberService.getAllMember();
		model.addAttribute("listAllMember", listAllMember);
		return "member/listAllMember";
	}

	// 상세조회 및 수정을 같은 화면으로...
	@GetMapping({"showDetail", "modify"})
	public void getPosting(String uid, Model model) {
		MemberVO member = memberService.getMember(uid);
		model.addAttribute("member", member);
		
	}

	@GetMapping("/register")
	public String createPost() {
		return "log/register";
	}
	@GetMapping("/party/signOutPage")
	public String createSignout() {
		return "signout";
	}
	
	
	
	@PostMapping("/insert.do")
	public String insertMember(MemberVO memberVO, RedirectAttributes rttr) {
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		memberService.insertMember(memberVO);
		
		rttr.addFlashAttribute("result", memberVO.getId());
		return "redirect:/customLogin";
	}

	@PostMapping("/update.do")
	public String updateMember(MemberVO memberVO, RedirectAttributes rttr) {
		memberService.updateMember(memberVO);
		rttr.addFlashAttribute("result", "수정 처리완료");
		return "redirect:/member/showDetail";
	}

	@PostMapping("/deleteMember")
	public String deleteMember(String id, RedirectAttributes rttr) {
		memberService.deleteMember(id);
		rttr.addFlashAttribute("result", "삭제 처리완료");
		return "redirect:/customLogin";
	}

}
