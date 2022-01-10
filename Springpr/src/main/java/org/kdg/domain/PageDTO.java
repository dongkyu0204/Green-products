package org.kdg.domain;

public class PageDTO {
	//시작 페이지 번호
	private int startPage;
	//끝 페이지 번호
	private int endPage;
	//이전 페이지 유무
	private boolean prev;
	//다음 페이지 유무
	private boolean next;
	//boolean인 이유는 어떤 페이지에서는 보이고 다른 페이지에선 안 보이기 때문
	//true false
	//board 테이블의 총 데이터 수(어디까지가 끝인지 알 수 있기 위해)
	private int total;
	//endPage를 계산하기 위한 pageNum가 필요하므로 Criteria 클래스를 포함
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri=cri;
		this.total=total;
		// (int)(Math.ceil(현재 페이지 번호/10.0))*10
		// 그런데 현재 페이지 번호가 Criteria 클래스에 있음 -> 포함시킨 이유
		// 계산된 결과를 endPage에 저장
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		// 10-9=1, 20-9=11...
		this.startPage=endPage-9;
		
		// 위 코드는 전체 건수를 고려하지 X
		// 전체 건수를 고려한 endPage -> realEnd
		// (int)(Math.ceil((전체건수*1.0)/10));
		int realEnd=(int)(Math.ceil(total*10)/cri.getAmount());
		// 하지만 위 코드만 사용하면 1부터 36까지 한 줄로 표시됨(?)
		
		//realEnd < endPage => realEnd값을 endPage에 저장
		if(realEnd < endPage) {
			this.endPage=realEnd;
		}
		
		this.prev=this.startPage > 1;
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
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}


	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}}