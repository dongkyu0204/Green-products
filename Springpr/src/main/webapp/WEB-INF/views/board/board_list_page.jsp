<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>

    <link rel="icon" href="./img/favicon_hu.png" type="image/x-icon">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/HuggiesCss/header.css">
    <link rel="stylesheet" href="../resources/HuggiesCss/board_list_page.css">
    <link rel="stylesheet" href="../resources/HuggiesCss/footer.css">
</head>
<body>
	<div id="board">
            <div class="board__back">
                <a href="board_list.html"><i class="fas fa-arrow-left fa-3x"></i></a>
            </div>

            <div class="board__in">
                <div class="board__header">
                    <div class="board__left">
                        <h2><span class="boardName">&lt공지사항&gt</span> 제품 교환 및 환불 안내</h2>
                        <p>
                            <span>관리자 &nbsp</span>
                            <span>2022-01-01 11:58 &nbsp</span>
                            <span>조회 486</span>
                        </p>
                    </div>

                    <div class="board__right">
                        <a href="#"><i class="fas fa-share-alt-square fa-2x"></i></a>
                        <a href="#"><i class="fas fa-print fa-2x"></i></a>
                    </div>
                </div>

                <div class="board__content">
                    Lorem ipsum, dolor sit amet consectetur adipisicing elit. Officiis, nulla expedita reiciendis maxime, ducimus quis iure voluptatibus ex deserunt odit quam rerum id at dolor quisquam itaque, asperiores eos repudiandae?
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quae suscipit libero aut ea optio ut officia, laboriosam unde cupiditate accusantium dolores obcaecati facere magnam, tenetur omnis numquam odio repellat similique.
                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Consequatur reprehenderit quas eaque. Tempore quos sed sit voluptates iure? Esse tempora nesciunt repellat quibusdam alias, aut officiis! Consequuntur quaerat placeat aliquam?
                </div>
                
                <div class="board__list">
                    <div class="board__list-top">
                        <p>목록</p>
                        <p><a href="board_list.html">전체 글 보기</a></p>
                    </div>

                    <div class="board__list-box">
                        <ul>    
                            <li class="listOn">
                                <div>
                                    <p class="listName"><a href="">공지사항</a></p>
                                    <p><a href="">제품 교환 및 환불 안내</a></p>
                                </div>
                                <a href="#" class="writer"><span>관리자</span></a>
                                <span>2022.01.01</span>
                            </li>
                            <li>
                                <div>
                                    <p class="listName"><a href="">공지사항</a></p>
                                    <p><a href="">[이벤트] 홈페이지 리뉴얼 기념 이벤트 당첨자 안내</a></p>
                                </div>
                                <a href="#" class="writer"><span>관리자</span></a>
                                <span>2022.12.15</span>
                            </li>
                            <li>
                                <div>
                                    <p class="listName"><a href="">공지사항</a></p>
                                    <p><a href="">[이벤트] 홈페이지 리뉴얼 기념 sns 이벤트</a></p>
                                </div>
                                <a href="#" class="writer"><span>관리자</span></a>
                                <span>2022.12.01</span>
                            </li>
                            <li>
                                <div>
                                    <p class="listName"><a href="">공지사항</a></p>
                                    <p><a href="">개인정보 처리 방침 안내</a></p>
                                </div>
                                <a href="#" class="writer"><span>관리자</span></a>
                                <span>2022.11.19</span>
                            </li>
                            <li>
                                <div>
                                    <p class="listName"><a href="">공지사항/이벤트</a></p>
                                    <p><a href="">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Id error velit, asperiores dolores vel commodi quisquam ad voluptatibus alias dignissimos dolorem accusamus quia non ut, est reprehenderit hic fuga porro.</a></p>
                                </div>
                                <a href="#" class="writer"><span>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vero facere animi cumque vitae nemo maxime expedita.</span></a>
                                <span>2022.11.18</span>
                            </li>
                            
                        </ul>
                    </div>

                    <div class="board__list-pager">
                        <ul>
                            <li><a href="#" class="pagerOn">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>