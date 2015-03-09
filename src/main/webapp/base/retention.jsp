<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link type="text/css" href="../css/jquery-ui-1.8.17.custom.css"
	rel="stylesheet" />
<link type="text/css" href="../css/jquery-ui-timepicker-addon.css"
	rel="stylesheet" />
<link type="text/css" href="../css/myStyle.css"
	rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="../js/jquery-ui-1.8.17.custom.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="../js/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript">
    $(function () {
        $(".ui_timepicker").datetimepicker({
            showOn: "button",
            buttonImage: "../css/images/icon_calendar.gif",
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
		<img src="../images/04.gif" /> 统计 &gt; <span>用户留存率</span>
	</div>
	<table id="rounded-corner" summary="查看留存率">
		<thead>
			<tr>
				<th scope="col" class="rounded-company">起始时间</th>
				<th scope="col" class="rounded-q4" colspan="3"><input
					type="text" name="datetime" class="ui_timepicker" value=""></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td class="rounded-foot-left"></td>
				<td class="rounded-foot-right" colspan="3"><input type="submit"
					name="Submit" value="查看" /></td>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td>结束时间</td>
				<td colspan="3"><input
					type="text" name="datetime" class="ui_timepicker" value=""></td>
			</tr>
			<tr>
				<td>选择留存</td>
				<td><label><input type="radio" name="RadioGroup1"
						value="1" checked="checked" />次日留存</label></td>
				<td><label><input type="radio" name="RadioGroup1"
						value="2" />三日留存</label></td>
				<td><label><input type="radio" name="RadioGroup1"
						value="3" />七日留存</label></td>
			</tr>
		</tbody>
	</table>
	<table id="newspaper-a" summary="2007 Major IT Companies' Profit">
    <thead>
    	<tr>
        	<th scope="col">注册日期</th>
        	<th scope="col">注册人数</th>
            <th scope="col">留存人数</th>
            <th scope="col">留存率</th>
        </tr>
    </thead>
    <tbody>
    	<tr>
        	<td>Microsoft</td>
            <td>20.3</td>
            <td>20.3</td>
            <td>30.5</td>
        </tr>
        <tr>
        	<td>Google</td>
            <td>50.2</td>
            <td>50.2</td>
            <td>40.63</td>
        </tr>
    </tbody>
</table>
</div>