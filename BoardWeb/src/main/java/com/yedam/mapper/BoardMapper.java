package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

/*
 * 인터페이스(BoardMapper) - XML(BoardMapper.xml) 매칭.
 */
public interface BoardMapper {
	public List<BoardVO> selectList(); //목록. 사용X
	public List<BoardVO> selectListWithPaging(SearchDTO search);
	public BoardVO selectBoard(int bno); //단건조회.
	public int updateReadCnt(int bno); //조회count증가.
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
	//전체 건수.
	public int selectCount(SearchDTO search);
	public List<Map> selectUserByCount();
	
	// 캘린더
	public List<Map> selectEvent();
	public int insertEvent(EventVO event);
	public int deleteEvent(EventVO event);
}