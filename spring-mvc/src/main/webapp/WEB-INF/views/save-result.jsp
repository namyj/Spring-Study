<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--  방법1 : 너무 복잡함--%>
<%--  <li>id = <%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--  <li>username = <%=((Member)request.getAttribute("member")).getUsername()%></li>--%>
<%--  <li>age = <%=((Member)request.getAttribute("member")).getAge()%></li>--%>

<%--  아래 방식대로 적고 > 자동으로 getAge, getId 이런식으로 불려짐--%>
  <li>id =${member.id}</li>
  <li>username =${member.username}</li>
  <li>age =${member.age}</li>
  <a href="index.html">메인</a>
</ul>
</body>
</html>
