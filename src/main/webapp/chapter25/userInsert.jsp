<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<h2>ユーザー追加</h2>

<form action="UserInsert.action" method="post">
	<table style="border-collapse:separate;border-spacing:10px;">
		<tr>
			<td>ログイン名:</td>
			<td><input type="text" name="login" required></td>
		</tr>
		<tr>
			<td>パスワード:</td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="追加">
			</td>
		</tr>
	</table>
</form>

<%@include file="../footer.html" %>
