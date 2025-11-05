<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${fn:contains('hello world', 'world')}">
    <p>含まれています。</p>
</c:if>
<p>置換後の文字列: ${fn:replace('hello world', 'world', 'JSTL')}</p>
<%@include file="../footer.html"%>
