package com.humanedu.pjt03.mapper;

import com.humanedu.pjt03.domain.BoardVO;
import com.humanedu.pjt03.domain.Criteria;
import com.humanedu.pjt03.domain.MybatisDynamicTestVO;

import java.util.List;


public interface BoardMapper {
  //@Select("select * from tbl_board where bno > 0")
  List<BoardVO> getList(Criteria cri);        // 게시판 전체 목록 조회

  void insert(BoardVO board);     // 게시판 등록

  void insertSelectKey(BoardVO board);    // 게시판 등록

  BoardVO read(Long bno);

  int delete(Long bno);

  int update(BoardVO board);

  List<BoardVO> getDynamicMybatis(MybatisDynamicTestVO test);
  List<BoardVO> getDynamicMybatis2(MybatisDynamicTestVO test);
}
