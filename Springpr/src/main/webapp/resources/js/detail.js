/**
 * 
 */
$(document).ready(function() {
	// 상세 페이지가 실행되면 댓글 글쓰기 버튼 활성화
	$("#modalRegisterBtn").show();
	// 상세 페이지가 실행되면 댓글 수정 버튼 활성화
	$("#modalModBtn").show();
	// 상세 페이지가 실행되면 댓글 글쓰기 버튼 활성화
	$("#modalRemoveBtn").show();
	
	
	
	// 댓글 쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click", function() {
		// 댓글 수정 버튼 비활성화 
		$("#modalModBtn").hide();
		// 댓글 삭제 버튼 비활성화
		$("#modalRemoveBtn").hide();
		
		// 모달창을 띄워라
	});
	
	//bno값
	var bno = $("#bno").html();
	
	showList(); // detail.jsp가 실행되자마자 댓글 목록이 보여저야 함

	function showList() {
		replyService.getList({bno:bno}, function(list){
			
			console.log(list);
			var str="";
			
			for(var i=0; i<list.length; i++){
				str+="<li><div><b>"+list[i].replyer+"</b></div>";
				str+="<div>"+list[i].reply+"</div>";
				str+="</li>";
			}
			
			$("#relist").html(str);
			
		});
	}
	// 댓글 쓰기 버튼(id값이 modalRegisterBtn)을 클릭하면
	$("#modalRegisterBtn").on("click",function(){
		//사용자가 입력한 댓글 내용을 저장
		var reply = $("input[name='reply']").val();
		//사용자가 입력한 댓글 작성자를 저장
		var replyer = $("input[name='replyer']").val();
		
		
		//					ajax로 보내고자 하는 JSON 타입				
		replyService.add({reply:reply,replyer:replyer, bno:bno},
				function(result){	// callback 함수 호출(일반적인 controller에서의 redirect 역할)
									// 콜백 함수는 insert가 끝난 후 후조치로 하는 것! -> redirect
									alert("insert 작업 : "+result);
									//목록 리스트를 처리(새로고침 안 해도 되게끔)
									showList();
								}
		);
		// 모달창을 숨겨라
		$(".modal").modal("hide");
	}) 
	
	
	// 모달창 안에 댓글 쓰기 버튼
	// 댓글 내용을 클릭하면(수정 및 삭제만 가능)
	$("#relist").on("click", function() {
		
		replyService.reDetail(7,function(detail){
			          
			console.log(detail.replyer);
			console.log(detail.reply);
			
			$("input[name='replyer']").val(detail.replyer);
			$("input[name='reply']").val(detail.reply);
			
			//글쓰기 버튼 비활성화
			$("#modalRegisterBtn").hide();
			//글수정 버튼 활성화
			$("#modalModBtn").show();
			//글삭제 버튼 활성화
			$("#modalRemoveBtn").show();
			
			// modal 창을 띄워라.
			$(".modal").modal("show");
		})
		
		
	})
})



// ------------------------------------------함수 선언부----------------------------------------------------------




var replyService=(function(){
	// 댓글 쓰기를 하기 위한 함수 선언
	function add(reply,callback) {
		console.log("reply........")
		$.ajax({
			url:"/replies/new",
			type:"post",
			data:JSON.stringify(reply),	// JSON.stringify : 자바스크립트의 값을 JSON 문자열로 변환
			contentType:"application/json; charset=utf-8",
			success:function(result){ // 통신이 정상적으로 성공했으면
				// callback 함수 선언
				// 만약에 callback이 있으면
				if (callback)
				// callback 함수를 호출
					callback(result);
			},		
			error:function(){ // 통신이 비정상적으로 처리가 되어 error가 있으면
				
			}			
		})
	}
	// 댓글 목록 리스트를 보기 위한 함수 선언
	function getList(param, callback) {
		var bno = param.bno;
		console.log(bno);
		$.getJSON(
				"/replies/list/"+bno+".json",
				function(data){
					if (callback)
						callback(data);
				}) 
	}
	
	// 댓글 수정을 하기 위해 댓글 내용 가져오기
	function reDetail(rno, callback) {
		var rno=rno;
		$.getJSON(
				"/replies/"+rno+".json",
				function(data) {
					if(callback)
						callback(data);
				}
		)
	}
	// 댓글 수정을 하기 위한 함수 선언
	
	// 댓글 삭제를 하기 위한 함수 선언
	return {
		add:add,
		getList:getList,
		reDetail:reDetail
	};
})()