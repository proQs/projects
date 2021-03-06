<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form id="retention" action="${ctx_path}/PSadmin/viewretention" method="post">
		<input type="hidden" name="serverId" value="${serverId}"/>
		<input type="hidden" name="username" value="${user.name}"/>
		<input type="hidden" name="page" value="retention"/>
		
		<div class="right01">
			<img src="${ctx_path}/images/04.gif" /> 统计 &gt; <span>用户留存率</span>
		</div>
		<table id="rounded-corner" summary="查看留存率">
			<thead>
				<tr>
					<th scope="col" class="rounded-company">查询时间</th>
					<th scope="col" class="rounded-q4" colspan="3">
						<input type="text" name="startDate" class="ui_timepicker" value="${startDatere}"></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td class="rounded-foot-left"></td>
					<td class="rounded-foot-right" colspan="3">
						<input type="submit" name="Submit" value="查看"/></td>
				</tr>
			</tfoot>
			<tbody>
			</tbody>
		</table>
		<c:if test="${viewRetention != null}"> 
			<table id="newspaper-a" summary="留存详细">
				<caption>
					<span>注册日期:${startDatere}</span>
					<span>注册人数:${retentionlist[0].createMembers}</span>
					<span>登录人数:${retentionlist[0].loginMembers}</span>
				</caption>
			    <thead>
			    	<tr>
			        	<th>留存类型</th>
			            <th>留存人数</th>
			            <th>留存率</th>
			        </tr>
			    </thead>
			    <tbody>
	    			<c:forEach items="${retentionlist}" var="rlist">
				    	<tr>
				    		<c:choose>
				    			<c:when test="${rlist.retentionType == 1}">
						        	<td>次日留存</td>
						        	<td>${rlist.retentionMembers}</td>
						        	<td>${rlist.prob / 100}%</td>
				        		</c:when>
				        		<c:when test="${rlist.retentionType == 3}">
						        	<td>三日留存</td>
						        	<td>${rlist.retentionMembers}</td>
						        	<td>${rlist.prob / 100}%</td>
				        		</c:when>
				        		<c:when test="${rlist.retentionType == 7}">
						        	<td>七日留存</td>
						        	<td>${rlist.retentionMembers}</td>
						        	<td>${rlist.prob / 100}%</td>
				        		</c:when>
				        	</c:choose>
				        </tr>
	        		</c:forEach>
			    </tbody>
			</table>
		</c:if> 
	</form>
</div>