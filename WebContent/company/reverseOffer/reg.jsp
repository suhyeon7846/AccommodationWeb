<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/company/reverseOffer/reg.css"  type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/company/reverseOffer/reg.js"></script>
    <title>TEUM | 틈을 채우다</title>
</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="/index">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="/user/offer/reg">제안하기</a></li>
                    <li><a href="">예약내역</a></li>
                    <li class="sub-page">
                        <a href="">더보기</a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="/notice/list">공지사항</a></li>
                                <li><a href="/event/list">이벤트</a></li>
                                <li><a href="">1:1 문의</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sub-page">
                        <a href="" class="character"><i class="fas fa-sort-down"></i></a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="">내정보</a></li>
                                <li><a href="">제안내역</a></li>
                                <li><a href="">찜한 숙소</a></li>
                                <li><a href="/logout">로그아웃</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
    </header>

    <section class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <ul>
                    <li><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;메뉴1</a></li>
                    <li class="active"><a><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;메뉴2</a></li>
                    <li><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;메뉴3</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;???&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;???&nbsp;&nbsp;&nbsp;</li>
                    </ul>
                </div>
                <div>
                    <div class="btn-left" style="align-self: center;"><i style="font-size: 50px; color: gray; opacity: 0.5;" class="fas fa-angle-left"></i></div>
                    <div style="width: 700px; overflow:hidden;">
                        <div class="proposal-item-container" style="display: flex;">
                            <div class="proposal-info">
                                <h2>제안정보</h2>
                                <ul>
                                    <li>
                                        <div>날짜</div>
                                        <div>2020.12.12 ~ 2020.12.15</div>
                                    </li>
                                    <li>
                                        <div>위치</div>
                                        <div>경기도 하남시</div>
                                    </li>
                                    <li>
                                        <div>인원수</div>
                                        <div>4</div>
                                    </li>
                                    <li>
                                        <div>희망하는 가격</div>
                                        <div class="wanted-price">120,000원</div>
                                    </li>
                                </ul>
                            </div>
                            <div class="proposal-info">
                                <h2>제안정보</h2>
                                <ul>
                                    <li>
                                        <div>날짜</div>
                                        <div>2020.12.12 ~ 2020.12.15</div>
                                    </li>
                                    <li>
                                        <div>위치</div>
                                        <div>경기도 하남시</div>
                                    </li>
                                    <li>
                                        <div>인원수</div>
                                        <div>4</div>
                                    </li>
                                    <li>
                                        <div>희망하는 가격</div>
                                        <div class="wanted-price">120,000원</div>
                                    </li>
                                </ul>
                            </div>
                            <div class="proposal-info">
                                <h2>제안정보</h2>
                                <ul>
                                    <li>
                                        <div>날짜</div>
                                        <div>2020.12.12 ~ 2020.12.15</div>
                                    </li>
                                    <li>
                                        <div>위치</div>
                                        <div>경기도 하남시</div>
                                    </li>
                                    <li>
                                        <div>인원수</div>
                                        <div>4</div>
                                    </li>
                                    <li>
                                        <div>희망하는 가격</div>
                                        <div class="wanted-price">120,000원</div>
                                    </li>
                                </ul>
                            </div>
                            <div class="proposal-info">
                                <h2>제안정보</h2>
                                <ul>
                                    <li>
                                        <div>날짜</div>
                                        <div>2020.12.12 ~ 2020.12.15</div>
                                    </li>
                                    <li>
                                        <div>위치</div>
                                        <div>경기도 하남시</div>
                                    </li>
                                    <li>
                                        <div>인원수</div>
                                        <div>4</div>
                                    </li>
                                    <li>
                                        <div>희망하는 가격</div>
                                        <div class="wanted-price">120,000원</div>
                                    </li>
                                </ul>
                            </div>
                            
                        </div>
                    </div>
                    <div class="btn-right" style="align-self: center;"><i style="font-size: 50px; color: gray; opacity: 0.5;" class="fas fa-angle-right"></i></div>
                </div>
                <section class="offer-sec">
                    <h1>역제안이 가능한 방 목록</h1>
                    <form class="offer-form">
                        <section>
                            <div class="radio-container">
                                <input type="radio" name="radio" id="radio-1" class="radio" required>
                                <label for="radio-1"><span></span></label>
                            </div>
                            <div class="offer-container">
                                <div class="offer-img-container">
                                    <a href=""><img src="../../images/company/호텔/서울/강남,역삼,삼성/라마다호텔/슈페리얼더블/슈페리얼더블1.jpg" alt=""></a>
                                </div>
                                <div class="offer-detail-container">
                                    <div class="offer-room">
                                        <span>스탠다드 더블</span>
                                    </div>
                                    <div class="offer-bed-count">
                                        <div>침대개수</div>
                                        <div>2</div>
                                    </div>
                                    <div class="offer-max-headcount">
                                        <div>최대 수용인원</div>
                                        <div>4</div>
                                    </div>
                                    <div class="offer-price">
                                        <div>가격</div>
                                        <div>128,260원</div>
                                    </div>
                                    <div class="highlight-btn-container">
                                        <input type="button" class="highlight-btn" value="예약이 가능한 방입니다">
                                    </div>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="radio-container">
                                <input type="radio" name="radio" id="radio-2" class="radio" required>
                                <label for="radio-2"><span></span></label>
                            </div>
                            <div class="offer-container">
                                <div class="offer-img-container">
                                    <a href=""><img src="../../images/company/호텔/서울/강남,역삼,삼성/라마다호텔/슈페리얼트윈/슈페리얼트윈2.jpg"></a>
                                </div>
                                <div class="offer-detail-container">
                                    <div class="offer-room">
                                        <span>VIP 커플룸(PC포함)</span>
                                    </div>
                                    <div class="offer-bed-count">
                                        <div>침대개수</div>
                                        <div>1</div>
                                    </div>
                                    <div class="offer-max-headcount">
                                        <div>최대 수용인원</div>
                                        <div>2</div>
                                    </div>
                                    <div class="offer-price">
                                        <div>가격</div>
                                        <div>500,260원</div>
                                    </div>
                                    <div class="highlight-btn-container">
                                        <input type="button" class="highlight-btn" value="예약이 가능한 방입니다">
                                    </div>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="radio-container">
                                <input type="radio" name="radio" id="radio-3" class="radio" required>
                                <label for="radio-3"><span></span></label>
                            </div>
                            <div class="offer-container">
                                <div class="offer-img-container">
                                    <a href=""><img src="../../images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_더블/신라스테이_삼성_스탠다드더블2.jpg"></a>
                                </div>
                                <div class="offer-detail-container">
                                    <div class="offer-room">
                                        <span>스위트룸</span>
                                    </div>
                                    <div class="offer-bed-count">
                                        <div>침대개수</div>
                                        <div>3</div>
                                    </div>
                                    <div class="offer-max-headcount">
                                        <div>최대 수용인원</div>
                                        <div>2</div>
                                    </div>
                                    <div class="offer-price">
                                        <div>가격</div>
                                        <div>258,220원</div>
                                    </div>
                                    <div class="highlight-btn-container">
                                        <input type="button" class="highlight-btn" value="예약이 가능한 방입니다">
                                    </div>
                                </div>
                            </div>
                        </section>
                        <div class="submit-btn-container">
                            <input type="submit" class="submit-btn" value="역제안하기">
                        </div>
                    </form>
                </section>
            </main>
        </div>
    </section>

    <section>
        <footer id="footer" class="footer">
            <div>
                <ul>
                    <li>
                        <a href="">회사소개</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">이용약관</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">개인정보처리방침</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">사업자정보확인</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">틈 마케팅센터</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">액티비티 호스트센터</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li><a href="">콘텐츠산업진흥법에의한 표시</a></li>
                </ul>

                <p><b>고객행복센터 1577-8282</b> 오전 09:00 ~ 오후18:00</p>

                <address>
                    <span>(주)TEUM</span>
                    주소 : 서울특별시 종로구 인사동길 12 대일빌딩 15층
                    <br />대표이사 : 신중언 | 사업자등록번호 777-11-45678 <br />통신판매번호 : 2020-서울강남-12345 | 관광사업자 등록번호 : 제
                    1324-55호 <br />전화번호 : 010-1111-2222 <br />전자우편주소 : teum@teum.co.kr <br />Copyright TEUM COMPANY Corp. All rights
                    reserved.
                </address>
            </div>
        </footer>
    </section>
</body>
</html>