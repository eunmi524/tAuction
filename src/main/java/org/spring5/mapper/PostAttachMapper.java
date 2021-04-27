package org.spring5.mapper;

import java.util.List;

import org.spring5.domain.BoardAttachVO;

public interface PostAttachMapper {

		//÷������ �������
		public void attachInsert(BoardAttachVO vo);
		
		//÷������ ��������
		public void attachDelete(String uuid);
		
		//÷������ ���� �ҷ�����
		public List<BoardAttachVO> attachFindByBno(Long bno);
		
		//�Խñ� ������ �ش�bno ÷������ ����
		public void attachDeleteAll(Long bno);
		
		public int imageFileUpate(Long bno);
	
}
