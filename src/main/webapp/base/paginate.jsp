<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:if test="${(totalPage > 0) && (currentPage <= totalPage)}">
	<c:set var="startPage" value="${currentPage - 4}" />
	<c:if test="${startPage < 1}" >
		<c:set var="startPage" value="1" />
	</c:if>
	<c:set var="endPage" value="${currentPage + 4}" />
	<c:if test="${endPage > totalPage}" >
		<c:set var="endPage" value="totalPage" />
	</c:if>
	
	<div class="pagination">
		<c:if test="${currentPage <= 8}">
			<c:set var="startPage" value="1" />
		</c:if>
		
		<c:if test="${(totalPage - currentPage) < 8}">
			<c:set var="endPage" value="${totalPage}" />
		</c:if>
		
		<c:choose>
			<c:when test="${currentPage == 1}">
				<span class="disabled" style="margin-right:0px;color:#666;">上页</span>
			</c:when>
			<c:otherwise>
				<a href="javascript:splitPage('${currentPage - 1}${urlParas}', '${actionUrl}', '${pagename}')">上页</a>
			</c:otherwise>
		</c:choose>
		
		<c:if test="${currentPage > 8}">
			<a href="javascript:splitPage('${1}${urlParas}', '${actionUrl}', '${pagename}')">${1}</a>
			<a href="javascript:splitPage('${2}${urlParas}', '${actionUrl}', '${pagename}')">${2}</a>
			<span class="gap" style="margin-right:0px;">…</span>
		</c:if>
		
		<c:forEach begin="${startPage}" end="${endPage}" var="i">
			<c:choose>
				<c:when test="${currentPage == i}">
					<span class="current" style="margin-right:0px;">${i}</span>
				</c:when>
				<c:otherwise>
					<a href="javascript:splitPage('${i}${urlParas}', '${actionUrl}', '${pagename}')">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${(totalPage - currentPage) >= 8}">
			<span class="gap" style="margin-right:0px;">…</span>
			<a href="javascript:splitPage('${totalPage - 1}${urlParas}', '${actionUrl}', '${pagename}')">${totalPage - 1}</a>
			<a href="javascript:splitPage('${totalPage}${urlParas}', '${actionUrl}', '${pagename}')">${totalPage}</a>
		</c:if>
		
		<c:choose>
			<c:when test="${currentPage == totalPage}">
				<span class="disabled" style="margin-right:0px;color:#666;">下页</span>
			</c:when>
			<c:otherwise>
				<a href="javascript:splitPage('${currentPage + 1}${urlParas}', '${actionUrl}', '${pagename}')" rel="next">下页</a>
			</c:otherwise>
		</c:choose>
	</div>
</c:if>