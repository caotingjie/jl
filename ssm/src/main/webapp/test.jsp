<%--
  Created by IntelliJ IDEA.
  User: tingjie.cao
  Date: 2016/9/18
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/js/jquery/jquery-2.2.3.min.js"></script>
    <script>
        function test() {
            $.ajax({
                url:"/test.do",
                type:"post",
                dataType:"json",
                success:function (data) {
                    if (data.flag == 'failed'){
                        alert(data.msg)
                    }
                },
                error:function () {
                    alert("保存失败");
                }
            });
        }
    </script>
</head>
<body>
    <button id="test" onclick="test()">测试</button>
</body>
</html>
