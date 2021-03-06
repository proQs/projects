<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<base href="${ctx_path}/">
<link type="text/css" href="css/jquery-ui-1.8.17.custom.css"
	rel="stylesheet" />
<link type="text/css" href="css/jquery-ui-timepicker-addon.css"
	rel="stylesheet" />
<link type="text/css" href="css/myStyle.css"
	rel="stylesheet" />
<script type="text/javascript" src="${ctx_path}/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="${ctx_path}/js/jquery-ui-1.8.17.custom.min.js"></script>
<script type="text/javascript" src="${ctx_path}/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${ctx_path}/js/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript">
    $(function () {
        $(".ui_timepicker").datetimepicker({
            showOn: "button",
            buttonImage: "css/images/icon_calendar.gif",
            buttonImageOnly: true,
            showSecond: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1
        });
    });
    </script>

	
<div class="right" id="li010">
		
	<div class="right01">
		<img src="${ctx_path}/images/04.gif" /> Log &gt; <span>Log查询</span>&gt; <span>多人查询</span>
	</div>
	<div style="margin-left: 45px;margin-top: 10px;font-size: 18px;">
		<a href="javascript:document.getElementById('multilog').submit();" style="text-decoration: none;color: #1303F7;text-shadow: 0px 0px 2px white;">
			回到查询</a>
	</div>
	<table id="newspaper-a" summary="Log详细">
		    <thead>
		    	<tr>
		        	<th scope="col">用户UID</th>
		        	<th scope="col">Log类型</th>
		        	<th scope="col">记录时间</th>
		            <th scope="col" colspan="4">Log内容</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<c:if test="${fn:length(multiLoglist) == 0}">
		    		<tr>
			        	<td>--</td>
			        	<td>--</td>
			        	<td>--</td>
			        	<td colspan="4">--</td>
			        </tr>
		    	</c:if> 
		   		<c:forEach items="${multiLoglist}" var="slist">
		   			<c:set var="logTime" value="${slist.log_time}"/>
			    	<tr>
			        	<td>${slist.uid}</td>
			        	<td>${slist.type}</td>
			        	<td>${fn:substring(logTime, 0, 19)}</td>
			        	<td colspan="4">${slist.msg}</td>
			        </tr>
				</c:forEach>
		    </tbody>
			<caption align="bottom">
				<c:set var="currentPage" value="${splitPage.pageNumber}" />
				<c:set var="totalPage" value="${splitPage.totalPage}" />
				<c:set var="actionUrl" value="${ctx_path}/PSadmin/viewmultilog?currentPage=" />
				<c:set var="pagename" value="multilogResult" />
				<c:set var="urlParas" value="" />
				<%@ include file="/base/paginate.jsp"%>
			</caption>
		</table>
</div>