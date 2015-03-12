<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>PS后台管理</title>
<link href="${ctx_path}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx_path}/js/myScript.js" type="text/javascript" ></script>
</head>

<body>
	<div class="header">
		<div class="header03"></div>
		<div class="header01"></div>
		<div class="header02">昱泉国际PS后台管理系统</div>
	</div>
	<div class="left" id="LeftBox">
		<div class="left01">
			<div class="left01_right"></div>
			<div class="left01_left"></div>
			<div class="left01_c">
				<c:choose>
					<c:when test="${user.permissions == 1}" >超级管理员：${user.name}</c:when>
					<c:otherwise>普通管理员：${user.name}</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="left01">
			<div class="left01_right"></div>
			<div class="left01_left"></div>
			<div class="left01_c">
			选择服务器：<select name="ballName" id="ballName" onchange="mbar(this,'${ctx_path}/PSselectSV');"> 
						<option value="-1">请选择</option>
						<c:forEach items="${serverList}" var="list">
							<option value="${list.id}" ${serverId == list.id ?"selected= 'selected'" : ""}>${list.name}</option>
						</c:forEach>
					</select>
			</div>
		</div>
		<div class="left02">
			<div class="left02top">
				<div class="left02top_right"></div>
				<div class="left02top_left"></div>
				<div class="left02top_c">统计</div>
			</div>
			<div class="left02down">
				<div class="left02down01">
					<a onclick="show_menuB(80)" href="javascript:document.getElementById('retention').submit();">
					<div id="Bf080" class="left02down01_img"></div>用户留存率</a>
				</div>
			</div>
		</div>
		<div class="left01">
			<div class="left03_right"></div>
			<div class="left01_left"></div>
			<a href="javascript:document.getElementById('logout').submit();"><div class="left03_c">安全退出</div></a>
		</div>
	</div>
	<div class="rrcc" id="RightBox">
		<div class="center" id="Mobile" onclick="show_menuC()"></div>
		<c:choose>
			<c:when test="${page == 'retention'}"><%@ include file="/base/retention.jsp"%></c:when>
			<c:otherwise><%@ include file="/base/selectServer.jsp"%></c:otherwise>
		</c:choose>
	</div>
	<form id="logout" action="${ctx_path}/PSadminlogin/logout" method="post"></form>
	<form id="retention" action="${ctx_path}/PSadmin/retention" method="post">
		<input type="hidden" name="serverId" value="${serverId}"/>
		<input type="hidden" name="username" value="${user.name}"/>
		<input type="hidden" name="page" value="retention"/>
	</form>
	<form id="selectSv" method="post">
		<input type="hidden" name="username" value="${user.name}"/>
	</form>
</body>
</html>