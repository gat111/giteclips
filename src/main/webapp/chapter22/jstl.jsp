<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@taglib prefix="c" uri="jakarta.tags.core"%>

<c:if test="${isAdmin}">
	<p>管理者メニューが表示されます。</p>
</c:if>


<form action="/book/chapter6/selectzz" method="get">
	<c:forEach var="p" items="${list}">

		<c:if test="${p.price > 100}">
			<p>
				<input type="checkbox" name="genre" value="${p.id}">${p.name}</p>
		</c:if>


	</c:forEach>

	<input type="submit" value="計算">
</form>


<c:if test="${20 >= 18}" var="isAdult">
    <p>このコンテンツは表示されます。</p>
</c:if>
<p>成人: ${isAdult}</p>


<c:choose>
    <c:when test="${userRole == 'admin'}">
        <p>管理者用メニューを表示します。</p>
    </c:when>
    <c:when test="${userRole == 'editor'}">
        <p>編集者用メニューを表示します。</p>
    </c:when>
    <c:otherwise>
        <p>一般ユーザー用メニューを表示します。</p>
    </c:otherwise>
</c:choose>
<%@include file="../footer.html"%>
