<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/25/2025
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="display: flex; justify-content: center; margin-top: 100px">
        <form action="${pageContext.request.contextPath}/bai06/uploadmulti" method="post" enctype="multipart/form-data">
            File #1: <input type="file" name="file"/><br/><br/>
            File #2: <input type="file" name="file"/><br/><br/>
            File #3: <input type="file" name="file"/><br/><br/>
            File #4: <input type="file" name="file"/><br/><br/>
            File #5: <input type="file" name="file"/><br/><br/>
            <input type="submit" value="Upload"/>
            <input type="reset" value="Reset"/>
        </form>
    </div>
</body>
</html>
