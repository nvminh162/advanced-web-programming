<%--
  Created by IntelliJ IDEA.
  User: nvmin
  Date: 9/14/2025
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Form Upload</h1>
    <form action="${pageContext.request.contextPath}/upload-multi" method="post" enctype="multipart/form-data">
        File #1: <input type="file" name="file"/><br/><br/>
        File #2: <input type="file" name="file"/><br/><br/>
        File #3: <input type="file" name="file"/><br/><br/>
        File #4: <input type="file" name="file"/><br/><br/>
        File #5: <input type="file" name="file"/><br/><br/>
        <input type="submit" value="Upload"/>
        <input type="reset" value="Reset"/>
    </form>
</body>
</html>
