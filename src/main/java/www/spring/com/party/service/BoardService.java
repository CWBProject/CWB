package www.spring.com.party.service;

import java.util.List;

import www.spring.com.party.framework.PageDTO;
import www.spring.com.party.model.BoardVO;
import www.spring.com.party.model.criteria.BoardCriteria;

public interface BoardService {
	public int getTotalCount(BoardCriteria cri);
	public List<BoardVO> getAllBoard();
	public List<BoardVO> getListWithPagingByCondition(BoardCriteria cri);
	public BoardVO getBoard(int bno);
	public int insertBoard(BoardVO boardVO);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);


	public List<BoardVO> getListWithPaging(PageDTO cri);

}
