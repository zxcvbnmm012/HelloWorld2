package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 인터페이스(BoardMapper) - XML(BoardMapper.xml) 매칭.
 */

public interface BoardMapper {
	public List<BoardVO> selectList();
	public int insertBoard(BoardVO board); // insert, update, delete는 처리된 건수 반환 -> int 타입
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
}
