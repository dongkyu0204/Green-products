package org.kdg.domain;

public class NewPageDTO {
	// 시작 페이지 번호
	private int startPage;
	// 끝 페이지 번호
	private int endPage;
	// 이전 페이지 유무
	private boolean prev;
	// 다음 페이지 유무
	private boolean next;
	// board 테이블의 총 데이터 수
	private int total;
	// endPage를 계산하기 위해 pageNum이 필요 -> pageNum을 가지고 있는 클래스인 NewCriteriaDTO 포함
	private NewCriteriaDTO cri;
	
	public NewPageDTO(NewCriteriaDTO cri, int total) {
		this.cri =cri;
		this.total=total;
		this.endPage=(int)(Math.ceil(cri.getPageNum()*0.1))*10;
		this.startPage=endPage-9;
		
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount()));
		if(realEnd < endPage) {
			this.endPage = realEnd;
		}
		
		this.prev=this.startPage>1;
		this.next=this.endPage<realEnd;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public NewCriteriaDTO getCri() {
		return cri;
	}
	public void setCri(NewCriteriaDTO cri) {
		this.cri = cri;
	}
	
	@Override
	public String toString() {
		return "NewPageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	
}
