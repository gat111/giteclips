<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@taglib prefix="c" uri="jakarta.tags.core"%>

<c:forEach var="p" items="${STUDENTS}">
	${p.className}：${p.name}：${p.student_id}
	<select name="count">
		<c:forEach var="i" items="${STUDENTS}" varStatus="status">
			<option value="${i.student_id}">${i.className}</option>
		</c:forEach>
	</select>
	<br>
</c:forEach>


<%@include file="../footer.html"%>
