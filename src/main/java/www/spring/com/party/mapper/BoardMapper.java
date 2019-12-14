package www.spring.com.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.spring.com.party.framework.PageDTO;
import www.spring.com.party.model.BoardVO;
import www.spring.com.party.model.criteria.BoardCriteria;

public interface BoardMapper {
	public int getTotalCount(@Param("cri") BoardCriteria cri);
	public List<BoardVO> getAllBoard();
	public List<BoardVO> getListWithPagingByCondition(@Param("cri") BoardCriteria cri);
	public BoardVO getBoard(int bno);
	public BoardVO getBoardLatest();
	public List<BoardVO> getBoardTwoLatest();
	public int insertBoard(BoardVO boardVO);
	public int updateBoard(BoardVO boardVO);
	public int deleteBoard(int bno);
	public int deleteBoardByColl(List<Integer> listBno);


	public List<BoardVO> getListWithPaging(PageDTO cri);
}
