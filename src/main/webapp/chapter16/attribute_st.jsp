<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@page import="bean.STUDENTS, java.util.List"%>

<!-- 下記の@SuppressWarningsはEclipseの警告を消すための記述です。 -->
<%
List<STUDENTS> list = (List<STUDENTS>) request.getAttribute("list");
%>


<%
for (STUDENTS p : list) {
%>
<p><%=p.getStudent_id()%>：<%=p.getName()%>：<%=p.getAge()%></p>
<%
}
%>

		<select name="count">
<%
for (STUDENTS p : list) {
%>
			<option value=<%=p.getStudent_id()%>><%=p.getName()%></option>
<%
}
%>
		</select>




<%@include file="../footer.html"%>
