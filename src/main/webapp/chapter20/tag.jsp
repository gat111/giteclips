<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<jsp:useBean id="STUDENTS" class="bean.STUDENTS" scope="request" />

<p>
	<jsp:getProperty name="STUDENTS" property="classname" />：
	<jsp:getProperty name="STUDENTS" property="name" />：
	<jsp:getProperty name="STUDENTS" property="student_id" />
	<jsp:getProperty name="STUDENTS" property="age" />
	
</p>

<%@include file="../footer.html"%>
