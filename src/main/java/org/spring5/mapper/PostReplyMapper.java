package org.spring5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring5.domain.Criteria;
import org.spring5.domain.ReplyVO;

public interface PostReplyMapper {

	//��� �߰�
	public int postReplyInsert(ReplyVO replyVO);
	
	//��� ��ȸ
	public ReplyVO postReplyRead(Long rno);
	
	//�����ȸ ����¡
	public List<ReplyVO> postReplyGetList(@Param("cri") Criteria cri,
									  @Param("bno") Long bno);
	
	//Ư�� �Խñۿ� ���� - ��� ����
	public Long postReplyGetCountByBno(Long bno);

	//��� ����
	public int postReplyDelete(Long rno);
	
	//��� ����
	public int postReplyModify(ReplyVO replyVO);
	
	

}
