package www.spring.com.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.spring.com.party.model.BoardVO;
import www.spring.com.party.model.criteria.BoardCriteria;
import www.spring.com.party.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String listAllBoard(BoardCriteria cri, Model model) {
		List<BoardVO> listAllBoard = boardService.getListWithPagingByCondition(cri);
		model.addAttribute("listAllBoard", listAllBoard);
		
		int totalCnt = boardService.getTotalCount(cri);
		BoardCriteria criWithTot = new BoardCriteria(cri, totalCnt);

		model.addAttribute("pageMaker", criWithTot);
		
		return "board/listAllBoard";
	}
	
	//ㅏㅓㄴㅇ라ㅓㅗㅁㄴㅇ라ㅗ/showDetail?bno=2
	@GetMapping({"showDetail", "modify"})
	public void getPosting(BoardCriteria cri, int bno, Model model) {
		BoardVO board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		model.addAttribute("pageMaker", cri);
	}

	@GetMapping("createPost")
	public void createPost() {}
	
	@PostMapping("/insert.do")
	public String insertBoard(BoardVO boardVO, RedirectAttributes rttr) {
		boardService.insertBoard(boardVO);
		rttr.addFlashAttribute("result", boardVO.getBno());
		return "redirect:/board/list";
	}

	@PostMapping("/update.do")
	public String updateBoard(@ModelAttribute("pageMaker") BoardCriteria cri, BoardVO boardVO, RedirectAttributes rttr) {
		boardService.updateBoard(boardVO);
		rttr.addFlashAttribute("result", "수정 처리 완료");

		return "redirect:/board/list" + cri.getListLink();
	}

	@PostMapping("deletePosting")
	public String deletePosting(@ModelAttribute("pageMaker") BoardCriteria cri, int bno, RedirectAttributes rttr) {
		boardService.deleteBoard(bno);
		rttr.addFlashAttribute("result", "삭제 처리 완료");

		return "redirect:/board/list" + cri.getListLink();
	}

}

















