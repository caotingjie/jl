<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery/jquery-1.8.3.js"></script>
</head>
<body>
    <table>
        <c:forEach items="${test}" var="temp">
            <tr>
                <td>${temp.userName}</td>
                <td>${temp.password}</td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>
