<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="description" content="자바 기반 풀스택 과정, 고용노동부 지정 우수훈련기관, 100%무료교육, 취업지원 진행">
    <meta name="keywords" content="검색키워드등록">
    <meta name="classification" content="검색사이트 카테고리 등록">
    <title>회원가입완료</title>
    <link rel="icon" th:href="@{/img/favicon.ico}" />
    
    <!-- CSS -->
    <link rel="stylesheet" th:href="@{/css/basic.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/board.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/layout.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/main.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/content.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/custom.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/mobile.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/jquery.datetimepicker.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/slick.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/slick-theme.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/swiper.css}" type="text/css" media="all" />
    <link rel="stylesheet" th:href="@{/css/swiper.min.css}" type="text/css" media="all" />
    
    <!-- Scripts -->
    <script type="text/javascript" th:src="@{/js/jquery.js}"></script>
    <script type="text/javascript" th:src="@{/js/jquery.datetimepicker.full.js}"></script>
    <script type="text/javascript" th:src="@{/js/function.js}"></script>
    <script type="text/javascript" th:src="@{/js/slick.min.js}"></script>
    <script type="text/javascript" th:src="@{/js/swiper.min.js}"></script>
</head>
<body>
<div id="wrap">

    <!-- Header -->
    <div id="header">
        <h1 class="logo"><a th:href="@{/}"><img th:src="@{/img/logo.png}" alt="logo" /></a></h1>
        <div class="gnb">
            <ul>
                <li>
                    <a th:href="@{/about/intro/index}">교육센터소개</a>
                    <ul class="depth02">
                        <li><a th:href="@{/about/intro/index}">센터소개</a></li>
                        <li><a th:href="@{/about/history/index}">연혁</a></li>
                        <li><a th:href="@{/about/teacher/index}">강사소개</a></li>
                    </ul>
                </li>
                <li>
                    <a th:href="@{/employment/gangnam/index}">취업과정</a>
                    <ul class="depth02">
                        <li><a th:href="@{/employment/gangnam/index}">강남교육센터</a></li>
                        <li><a th:href="@{/employment/gangbuk/index}">강북교육센터</a></li>
                    </ul>
                </li>
                <li>
                    <a th:href="@{/incumbent/gangnam/index}">재직자과정</a>
                    <ul class="depth02">
                        <li><a th:href="@{/incumbent/gangnam/index}">강남교육센터</a></li>
                        <li><a th:href="@{/incumbent/gangbuk/index}">강북교육센터</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="right_box">
            <ul>
                <li><a th:href="@{/include/logout}">로그아웃</a></li>
                <li><a th:href="@{/member/edit}">마이페이지</a></li>
            </ul>
        </div>
    </div>

    <!-- Main Content -->
    <div class="join_complete">
        <p class="tit">회원가입이 <span>완료</span> 되었습니다.</p>
        <p class="desc">가입하신 아이디와 비밀번호로 로그인이 가능합니다.</p>
        <img th:src="@{/img/complate_icon.png}" alt="">
        <p class="txt">
            <span class="color_pink" th:text="${userName}"></span>, 회원이 되신 것을 환영합니다.
        </p>
        <div class="btn_wrap pink_type">
            <a th:href="@{/}">홈으로</a>
        </div>
    </div>

    <!-- Footer -->
    <div id="footer">
        <div class="inner">
            <div class="footer_top">
                <h4>SIST 고객센터</h4>
                <ul>
                    <li>
                        <h6><span>강남교육센터</span></h6>
                        <a th:href="tel:0234824632"><p>02.3482.4632</p></a>
                    </li>
                    <li>
                        <h6><span>강북교육센터</span></h6>
                        <a th:href="tel:023368546"><p>02.336.8546</p></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>
</body>
</html>