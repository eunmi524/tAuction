package org.spring5.service;

import java.util.ArrayList;
import java.util.List;

import org.spring5.domain.BoardVO;
import org.spring5.domain.ChartVO;
import org.spring5.domain.Criteria;
import org.spring5.domain.MemberVO;
import org.spring5.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AdminServiceImpl implements AdminService{

	@Setter(onMethod_=@Autowired)
	private AdminMapper adminMapper;
	
	@Override
	public List<MemberVO> memberList() {
		return adminMapper.memberList();
	}

	@Override
	public List<MemberVO> memberRemoveList() {
		return adminMapper.memberRemoveList();
	}

	@Override
	public List<BoardVO> boardList() {
		return adminMapper.boardList();
	}

	@Override
	public List<BoardVO> boardRemoveList() {
		return adminMapper.boardRemoveList();
	}

	@Override
	public List<BoardVO> cmBoardList() {
		return adminMapper.cmBoardList();
	}

	@Override
	public List<BoardVO> cmBoardRemoveList() {
		return adminMapper.cmBoardRemoveList();
	}

	//////////////////////////////
	
	@Override
	public int boardRemoveTotalCount(Criteria cri) {
		return adminMapper.boardRemoveTotalCount(cri);
	}
	
	@Override
	public int memberListTotalCount(Criteria cri) {
		return adminMapper.boardRemoveTotalCount(cri);
	}
	
	@Override
	public int memberRemoveTotalCount(Criteria cri) {
		return adminMapper.boardRemoveTotalCount(cri);
	}


	@Override
	public int cmBoardRemoveTotalCount(Criteria cri) {
		return adminMapper.cmBoardRemoveTotalCount(cri);
	}
	
	@Override
	public int memberDelete(String memberId) {
		return adminMapper.memberDelete(memberId);
	}

	@Override
	public int memberRestore(String memberId) {
		return adminMapper.memberRestore(memberId);
	}
	
	@Override
	public int boardDelete(Long bno) {
		return adminMapper.boardDelete(bno);
	}

	@Override
	public int boardRestore(Long bno) {
		return adminMapper.boardRestore(bno);
	}

	
	@Override
	public int cmBoardDelete(Long bno) {
		return adminMapper.cmBoardDelete(bno);
	}

	@Override
	public int cmBoardRestore(Long bno) {
		return adminMapper.cmBoardRestore(bno);
	}
	
	
	/////////////
	@Override
	public List<String> memberYearCount(String year) {
		// TODO Auto-generated method stub
		List<String> countList= new ArrayList<>();
		for(int i=0;i<12;i++)
		{
			if((i+1)<10) {
				countList.add(adminMapper.memberYearCount(year+"/0"+(i+1)));
			}
			else
			{
				countList.add(adminMapper.memberYearCount(year+"/"+(i+1)));
			}
			
		}
		return countList;
	}
	
	@Override
	public List<String> boardYearCount(String year) {
		// TODO Auto-generated method stub
		List<String> countList= new ArrayList<>();
		for(int i=0;i<12;i++)
		{
			if((i+1)<10) {
				countList.add(adminMapper.boardYearCount(year+"/0"+(i+1)));
			}
			else
			{
				countList.add(adminMapper.boardYearCount(year+"/"+(i+1)));
			}
			
		}
		return countList;
	}

	@Override
	public List<String> memberMonthCount(String yearMonth) {
		// TODO Auto-generated method stub
		List<String> countList= new ArrayList<>();
		for(int i=1;i<=31;i++)
		{
			if(i<10)
			{
				countList.add(adminMapper.memberMonthCount(yearMonth+"/0"+i));
			}
			else 
			{
				countList.add(adminMapper.memberMonthCount(yearMonth+"/"+i));
			}
			
			
		}
		return countList;
	}

	@Override
	public List<String> boardMonthCount(String yearMonth) {
		// TODO Auto-generated method stub
		List<String> countList= new ArrayList<>();
		for(int i=1;i<=31;i++)
		{
			if(i<10)
			{
				countList.add(adminMapper.boardMonthCount(yearMonth+"/0"+i));
			}
			else 
			{
				countList.add(adminMapper.boardMonthCount(yearMonth+"/"+i));
			}
			
			
		}
		return countList;
	}

	@Override
	public ChartVO adminCountView(String yearMonth) {
		// TODO Auto-generated method stub
		ChartVO ChartVO =new ChartVO();
		
		ChartVO.setBidCount(adminMapper.bidCount(yearMonth));
		
		ChartVO.setBoardCount(adminMapper.boardYearCount(yearMonth));
		
		String successbidCount =adminMapper.successbidCount(yearMonth);
		ChartVO.setSuccessbidCount(successbidCount);
		
		String successbidPrice=adminMapper.successbidPrice(yearMonth);
		ChartVO.setSuccessbidPrice(successbidPrice);
		
		if(Integer.parseInt(successbidCount)==0)
		{
			ChartVO.setPriceAvg(0);
		}
		else {
			int priceAvg = Integer.parseInt(successbidPrice)/Integer.parseInt(successbidCount);
			ChartVO.setPriceAvg(priceAvg);
		}
		
		if(adminMapper.visitorCountViewYear(yearMonth)==""||adminMapper.visitorCountViewYear(yearMonth).length()==0)
	      {  
	         ChartVO.setVisitorCountView(0);
	      }
	      else{
	         ChartVO.setVisitorCountView(Integer.parseInt(adminMapper.visitorCountViewYear(yearMonth)));
	         
	      }
		return ChartVO;
	}


   @Override
   public ChartVO mainChart(String day) {
      // TODO Auto-generated method stub
      ChartVO ChartVO =new ChartVO();
      ChartVO.setBidCount(adminMapper.dayBidCount(day));
      ChartVO.setBoardCount(adminMapper.dayBoardCount(day));
      
      String successbidCount =adminMapper.daySuccessbidCount(day);
      ChartVO.setSuccessbidCount(successbidCount);
      
      String successbidPrice=adminMapper.daySuccessbidPrice(day);
      ChartVO.setSuccessbidPrice(successbidPrice);
      
      if(Integer.parseInt(successbidCount)==0)
      {
         ChartVO.setPriceAvg(0);
      }
      else {
         int priceAvg = Integer.parseInt(successbidPrice)/Integer.parseInt(successbidCount);
         ChartVO.setPriceAvg(priceAvg);
      }
      log.info(adminMapper.visitorCountView(day));
      if(adminMapper.visitorCountView(day)==""||adminMapper.visitorCountView(day).length()==0)
      {  
         ChartVO.setVisitorCountView(0);
      }
      else{
         ChartVO.setVisitorCountView(Integer.parseInt(adminMapper.visitorCountView(day)));
         
      }
      
      return ChartVO;
   }

}
