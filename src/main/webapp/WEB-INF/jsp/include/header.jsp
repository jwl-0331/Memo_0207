<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<header class="d-flex justify-content-between align-items-center">
			<h1 class="pl-2">Memo</h1>
			<%--세션에 "userId" 라는 키에 값이 있다면 로그인된 상태 --%>
			<%--세션 객체가 있어야되고 통해서 get attribute 통해 키 가 필요 --%>
			<%--jsp 가 해줌 --%>
			<c:if test="${not empty userId }">
				<div class="mr-3">${userName  } <a href="/user/signout">로그아웃</a></div>
			</c:if>
		</header>