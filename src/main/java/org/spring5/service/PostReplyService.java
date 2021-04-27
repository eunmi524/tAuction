package org.spring5.service;

import org.spring5.domain.Criteria;
import org.spring5.domain.ReplyPageDTO;
import org.spring5.domain.ReplyVO;

public interface PostReplyService {

	//��� �߰�
	public int postReplyInsert(ReplyVO replyVO);
		
	//�����ȸ
	public ReplyVO postReplyRead(Long rno);
	
	//�����ȸ : ��� ���� & ��۸�� ���� (����¡)
	public ReplyPageDTO postReplyGetList(Criteria cri, Long bno);
		
	//��� ����
	public int postReplyDelete(Long rno);
		
	//��� ����
	public int postReplyModify(ReplyVO replyVO);
}
