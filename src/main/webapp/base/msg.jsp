<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>操作失败</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<style>
		*{
			margin:0;
			padding:0;
		}
		body{
			font-family: 'Audiowide', cursive, arial, helvetica, sans-serif;
			background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAUElEQVQYV2NkYGAwBuKzQAwDID4IoIgxIikAMZE1oRiArBDdZBSNMIXoJiFbDZYDKcSmCOYimDuNSVKIzRNYrUYOFuQgweoZbIoxgoeoAAcAEckW11HVTfcAAAAASUVORK5CYII=) repeat;
			background-color:#212121;
			color:white;
			font-size: 18px;
			padding-bottom:20px;
		}
		.error-code{
			font-family: 'Creepster', cursive, arial, helvetica, sans-serif;
			font-size: 200px;
			color: white;
			color: rgba(255, 255, 255, 0.98);
			width: 50%;
			text-align: right;
			margin-top: 5%;
			text-shadow: 5px 5px hsl(0, 0%, 25%);
			float: left;
		}
		.not-found{
			width: 47%;
			float: right;
			margin-top: 5%;
			font-size: 50px;
			color: white;
			text-shadow: 2px 2px 5px hsl(0, 0%, 61%);
			padding-top: 70px;
		}
		.clear{
			float:none;
			clear:both;
		}
		.content{
			text-align:center;
			line-height: 30px;
		}
		input[type=text]{
			border: hsl(247, 89%, 72%) solid 1px;
			outline: none;
			padding: 5px 3px;
			font-size: 16px;
			border-radius: 8px;
		}
		a{
			text-decoration: none;
			color: #9ECDFF;
			text-shadow: 0px 0px 2px white;
		}
		a:hover{
			color:white;
		}
	</style>
</head>
<body>
	<p class="error-code">失败</p>
	<p class="not-found">Not<br/>Found</p>
	<div class="clear"></div>
	<div class="content">说明：${msg}!<br/>
		<a href="javascript:history.go(-1);">后退</a> 或者 &nbsp;<a href="${ctx_path}/PSadminlogin">转到登陆</a>
	</div>
</body>
</html>
