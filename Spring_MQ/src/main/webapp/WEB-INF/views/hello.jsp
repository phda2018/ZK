<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<script src="../../../resources/js/jquery-3.3.1.min.js"></script>

<script>
	function send(){
		 var message = $("#message").val();
		 var type =$('input:radio:checked').val();
		 
		 $.post("sendMessage",{"msg":message,"type":type},function(text){
			 alert(text);
		 });
		 
		 	
	}
</script>

<body >
	<table align="center" border="1" style="height:280px;">
		<tr><td colspan="2">消息队列测试:</td></tr>
		<tr><td width=100>方式:</td>
			<td>
				<input id="radio1" type="radio" name="type"  value="pointToPoint" checked="checked"/>点对点
				<input id="radio2" type="radio" name="type" value="broadcast" />广播<br/>
			</td>
		</tr>
		<tr>
			<td>消息:</td>
			<td>
				<textarea id="message"  name="message" value="" rows="3" cols="60" ></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="send" onclick="send()" />
			</td>
		</tr>
	</table>
	
	

	
	
</body>
</html>