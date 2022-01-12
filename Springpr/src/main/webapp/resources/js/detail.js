/**
 * 
 */
$(document).ready(function() {
	// 댓글 쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click", function() {
		// 모달창을 띄워라
		$(".modal fade").modal("show");
	});
	
	//bno값
	var bno = $("#bno").html();
	
	// 댓글 쓰기 버튼(id값이 modalRegisterBtn)을 클릭하면
	$("#modalRegisterBtn").on("click",function(){
		//사용자가 입력한 댓글 내용을 저장
		var reply = $("input[name='reply']").val();
		//사용자가 입력한 댓글 작성자를 저장
		var replyer = $("input[name='replyer']").val();
		replyService.add({reply:reply,replyer:replyer, bno:bno});
	})
})

var replyService=(function(){
	// 댓글 쓰기를 하기 위한 함수 선언
	function add(reply) {
		console.log("reply........")
		$.ajax({
			url:"/replies/new",
			type:"post",
			data:JSON.stringify(reply),	// JSON.stringify : 자바스크립트의 값을 JSON 문자열로 변환
			contentType:"application/json; charset=utf-8",
			success:function(){ // 통신이 정상적으로 성공했으면
				
			},		
			error:function(){ // 통신이 비정상적으로 처리가 되어 error가 있으면
				
			}			
		})
	}
	// 댓글 목록 리스트를 보기 위한 함수 선언
	
	// 댓글 수정을 하기 위한 함수 선언
	
	// 댓글 삭제를 하기 위한 함수 선언
	return {add:add};
})()

var repa = (function(){}) ()