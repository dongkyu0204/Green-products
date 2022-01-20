/**
 * 
 */
$(document).ready(function() {
	//bno값
	var bno = $("#bno").html();
	
	// 상세 페이지가 시작되자마자 이미지를 출력하기 위한 ajax
	$.getJSON(
		"/board/fileList/"+bno+".json",
		function(data) { //BoardController에 있는 fileList를 통해 얻어진 select 결과를 data에 저장한 후,
			// detail.jsp에 뿌리기
			console.log(data);
			var str="";
			$(data).each(function(i, obj){
				if(!obj.image) {	// 사용자가 업로드 한 파일의 이미지가 아니면 (exl, ppt 등) -> obj안에 image가 boolean 타입으로 나와있음
					// 해당 파일을 download 할 수 있도록 설정할 거임
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					str+="<li data-path='"+obj.uploadPath+"'";
					str+=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
					str+="<a href='/download?fileName="+fileCallPath+"'>"+obj.fileName+"</a></li>";
				} else {	// 사용자가 업로드 한 파일의 타입이 이미지면 (png, jpg, gif)
					
					// 기존에는 경로 사이가 \로 표시되기에 해당 src로 찾아가지 못함
					// 아래 함수는 원화 표시를 /로 바꿔줌
					// 더불어 아래의 /display?fileName을 encode 안에 넣게되면 / 또한 해석을 하기 때문에 정상적으로 작동하지 않음
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
					
					//img 태그를 사용하여 웹브라우저에 출력
					str+="<li data-path='"+obj.uploadPath+"'";
					str+=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
					str+="<img src='/display?fileName="+fileCallPath+"'></li>";
				}
			})
			$("#uploadResult ul").html(str);
		}
	)
	
	
	
	
	
	
	
	// 상세 페이지가 실행되면 댓글 글쓰기 버튼 활성화
	$("#modalRegisterBtn").show();
	// 상세 페이지가 실행되면 댓글 수정 버튼 활성화
	$("#modalModBtn").show();
	// 상세 페이지가 실행되면 댓글 글쓰기 버튼 활성화
	$("#modalRemoveBtn").show();
	
	
	
	// 댓글 쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click", function() {
		reply = $("input[name='reply']").val("");
		//사용자가 입력한 댓글 작성자를 저장
		replyer = $("input[name='replyer']").val("");
		// 상세 페이지가 실행되면 댓글 글쓰기 버튼 활성화
		$("#modalRegisterBtn").show();
		// 댓글 수정 버튼 비활성화 
		$("#modalModBtn").hide();
		// 댓글 삭제 버튼 비활성화
		$("#modalRemoveBtn").hide();
		
		// 모달창을 띄워라(bootstrap.js 안에 자동 실행되도록 설정)
	});
	
	showList(); // detail.jsp가 실행되자마자 댓글 목록이 보여저야 함

	function showList() {
		replyService.getList({bno:bno}, function(list){
			
//			console.log(list);
			var str="";
			
			for(var i=0; i<list.length; i++){
				str+="<li data-rno='"+list[i].rno+"'><div><b>"+list[i].replyer+"</b></div>";
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
	$("#relist").on("click","li" ,function() {	//li : event_delegate : 범위 한정(?) -> ul도 포함
												// 후손 선택자를 이용하게되면 li들만 선택하는 것
		
		// rno값 가져오기 (for문에 사용했던 data-rno와 연관 : data 선택자)
		var rno = $(this).data("rno");
		
		
		
		replyService.reDetail(rno,function(detail){
			          
			console.log(detail.replyer);
			console.log(detail.reply);
			
			$("input[name='rno']").val(rno);
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
	
	// 댓글 수정 버튼을 클릭하면
	$("#modalModBtn").on("click", function() {
		var reply = {rno:$("input[name='rno']").val(), reply:$("input[name='reply']").val()}
		
		// 댓글 수정 함수를 호출해서 처리
		replyService.reupdate(reply,function(update){
			// 콜백영역(update가 정상적으로 처리된 후 조치)
			alert("update 작업 : " + update)
			// 모달창을 닫고
			$(".modal").modal("hide");
			// 목록 리스트를 실행함으로써 새로고침
			showList();
		})
		
	})
	
	
	// 댓글 삭제 버튼을 클릭하면
	$("#modalRemoveBtn").on("click",function() {
		// alert("aaa");
		var reply = {rno:$("input[name='rno']").val()}
		// 댓글 삭제 함수를 호출해서 처리
		replyService.remove(reply, function(remove){
			// 콜백영역(update가 정상적으로 처리된 후 조치)
			alert("delete 작업 : " + remove);
			// 모달창을 닫고
			$(".modal").modal("hide");
			// 목록 리스트를 실행함으로써 새로고침
			showList();
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
	function reupdate(reply, callback) {
		$.ajax({
			url:"/replies/update",
			type:"put",
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success:function(result){
				if (callback)
					callback(result);
			},		
			error:function(){
			}
		})
	}
	
	
	// 댓글 삭제를 하기 위한 함수 선언
	function remove(reply, callback) {
		$.ajax({
			url:"/replies/remove",
			type:"delete",
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success:function(result){
				if (callback)
					callback(result);
			},		
			error:function(){
			}
		})
	}
	
	
	
	return {
		add:add,
		getList:getList,
		reDetail:reDetail,
		reupdate:reupdate,
		remove:remove
	};
})()