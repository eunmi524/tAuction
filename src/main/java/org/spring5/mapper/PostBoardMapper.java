package org.spring5.mapper;

import java.util.List;

import org.spring5.domain.BoardVO;
import org.spring5.domain.Criteria;

public interface PostBoardMapper {

	
	public List<BoardVO> postBoardGetList(Criteria cri);
	
	public List<BoardVO> postBoardGetListWithPagingAndSearching(Criteria cri);
	
	//�� �Խù� ����
	public int postBoardGetTotalCount(Criteria cri);
	
	//������ �߰�(Insert)
	public int postBoardInsert(BoardVO boardVO);
	
	//������ �б�
	public BoardVO postBoardRead(Long bno);
	public int viewCount(Long bno);
	
	//������ ����
	public int postBoardModify(BoardVO boardVO);
	
	//������ ����
	public int postBoardDelete(Long bno);
	
}

