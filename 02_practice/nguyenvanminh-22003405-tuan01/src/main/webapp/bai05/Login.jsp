<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Đăng nhập</title>
  </head>
  <body>
    <h2>Đăng nhập</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="login" method="post">
      <label for="username">Tên đăng nhập:</label>
      <input type="text" id="username" name="username"/><br/><br/>

      <label for="password">Mật khẩu:</label>
      <input type="password" id="password" name="password"/><br/><br/>

      <input type="submit" value="Đăng nhập"/>
    </form>
  </body>
</html>
