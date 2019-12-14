package www.spring.com.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.spring.com.party.framework.PageDTO;
import www.spring.com.party.mapper.BoardMapper;
import www.spring.com.party.model.BoardVO;
import www.spring.com.party.model.criteria.BoardCriteria;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;

	public int getTotalCount(BoardCriteria cri) {
		return boardMapper.getTotalCount(cri);
	}
	
	public List<BoardVO> getAllBoard() {
		List<BoardVO> listAllBoard = boardMapper.getAllBoard();
		return listAllBoard;
	}

	public List<BoardVO> getListWithPagingByCondition(BoardCriteria cri) {
		return boardMapper.getListWithPagingByCondition(cri);
	}
	

	public BoardVO getBoard(int bno) {
		return boardMapper.getBoard(bno);
	}

	public int insertBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

	public int updateBoard(BoardVO board) {
		return boardMapper.updateBoard(board);
	}
	public int deleteBoard(int bno) {
		return boardMapper.deleteBoard(bno);
	}

	public List<BoardVO> getListWithPaging(PageDTO cri) {
		List<BoardVO> listAllBoard = boardMapper.getListWithPaging(cri);
		return listAllBoard;
	}
}
