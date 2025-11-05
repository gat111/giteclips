<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@page import="java.util.List, java.util.ArrayList"%>
<%@page import="java.util.Map, java.util.HashMap"%>

<%
int[] array = { 0, 1, 2 };
request.setAttribute("array", array);

List<String> list = new ArrayList<>();
list.add("zero");
list.add("one");
list.add("two");
request.setAttribute("list", list);

Map<String, String> map = new HashMap<>();
map.put("zero", "零");
map.put("one", "壱");
map.put("two", "弐");
request.setAttribute("map", map);
%>

${array[1]}
<br>
${list[2]}
<br>
${map["one"]}
<br>
${map.two}

<p>商: ${10 / 2}</p> <!-- 結果: 5 -->
<p>${empty "清水"}</p> <!-- 結果: true -->

<%@include file="../footer.html"%>
