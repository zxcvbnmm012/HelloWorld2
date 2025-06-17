package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

/*
 * 업무단위의 처리
 */

public interface BoardService {
	public List<BoardVO> boardList(SearchDTO search); // 목록조회
	public BoardVO getBoard(int bno); // 단건조회
	public boolean registerBoard(BoardVO board); // 등록기능
	public boolean modifyBoard(BoardVO board); // 수정기능
	public boolean removeBoard(BoardVO board); // 삭제기능
	public int getTotalCount(SearchDTO search); // 전체카운트 계산
	public List<Map> chartCount();
	public List<Map> eventList(); // 캘린더 이벤트리스트
	public boolean addEvent(EventVO event); // 캘린더 이벤트 등록
	public boolean removeEvent(EventVO event); // 캘린더 이벤트 삭제
	
}
