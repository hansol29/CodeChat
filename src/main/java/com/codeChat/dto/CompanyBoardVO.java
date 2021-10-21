package com.codeChat.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyBoardVO {

	// name = 회사명 - sql테이블의 companyboard에는 없음. 근데 공고 작성 시 회사 이름을 자동으로 적어주기 위해 해당 요소가 필요했음.
	// companyBoardDAO에서 company테이블과 조인해서 데이터 받아옴
	private String name;
	private int seq;	// 글 등록 번호
	private String id;	// 로그인했던 회사 id
	private String title;	// 채용공고 제목
	private String content;	// 채용공고 내용
	private String career;	// 경력 관련 사항(신입,경력,무관) 
	private String loc;	// 	지역 관련 사항(서울, 인천 등)
	private int sal;	// 연봉
	private Date regdate;	// 작성시간
	private int cnt;	// 조회수
	
	// 조건검색할 때 값이 여러개가 넘어옴으로 그걸 해결하려면 배열로 받아 처리해야했기에 추가함
	private String[] careerArr;
	private String[] locArr;
	private int[] salArr;
	
	// 그냥 결과 확인해보려고 오버라이딩함
	@Override
	public String toString() {
		return "CompanyBoardVO = [name=" + name + ", seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", career=" + career + ", loc=" + loc + ", sal=" + sal + ", regdate=" + regdate + ", cnt=" + cnt+ "]";
	}
}
