<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<jsp:useBean id="STUDENTS" class="bean.STUDENTS" />

<jsp:setProperty name="STUDENTS" property="className" value="1の1"/>：
	<jsp:setProperty name="STUDENTS" property="name" value="simizu"/>：
	<jsp:setProperty name="STUDENTS" property="student_id" value="1"/>：
	<jsp:setProperty name="STUDENTS" property="age" value="100"/>：
	
<jsp:getProperty name="STUDENTS" property="className" />：
	<jsp:getProperty name="STUDENTS" property="name" />：
	<jsp:getProperty name="STUDENTS" property="student_id" />：
	<jsp:getProperty name="STUDENTS" property="age" />：

<%@include file="../footer.html" %>
