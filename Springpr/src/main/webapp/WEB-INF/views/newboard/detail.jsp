<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 상세 페이지</title>
		
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
		<link href="../resources/css/newboard/all.css" rel="stylesheet" type="text/css">
	    <link href="../resources/css/newboard/sb-admin-2.css" rel="stylesheet">
	    <link href="../resources/css/newboard/dataTables.bootstrap4.css" rel="stylesheet">
	</head>
	
	<body>
		<div>${detail.title}</div>
		<div>${detail.content}</div>
		
		<a href="/newboard/modify?bno=${detail.bno}">수정</a>
		<a href="/newboard/remove?bno=${detail.bno}">삭제</a>
		
		<div>
			<div class="panel-body">
				<!-- Button trigger modal -->
				<button id="addReplyBtn" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	                	댓글쓰기
	            </button>
	            
         		<div>
	            	<ul id="relist"></ul>
	            </div>
	            
	            <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="myModalLabel">댓글</h4>
                            </div>
                            <div class="modal-body">
                            	<div class="modal-body">
                            		<input type="text" name="rno"/>
                           		</div>
                            	<div class="modal-body">
                            		<label>Replyer</label>
                            		<input type="text" name="replyer"/>
                           		</div>
                           		<div class="modal-body">
                            		<label>Reply</label>
                            		<input type="text" name="reply">
                           		</div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" id="modalRegisterBtn" class="btn btn-primary">댓글 쓰기</button>
                                <button type="button" id="modalModBtn" class="btn btn-primary">댓글 수정</button>
                                <button type="button" id="modalRemoveBtn" class="btn btn-primary">댓글 삭제</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->
            </div>
		</div>
	</body>
</html>