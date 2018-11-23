<%--
  Created by IntelliJ IDEA.
  User: ami
  Date: 2018/11/23
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json Test</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        function requestJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath }/requestJson.action',
                contentType: 'application/json;charset=utf-8',
                data: '{"name":"水杯","id":"101"}',
                success: function (data) {
                    alert(data.name)
                }

            });
        }
        
        function responseJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath }/responseJson.action',
//                contentType: 'application/json;charset=utf-8',
                data: 'name=水杯&id=101',
                success: function (data) {
                    alert(data.name)
                }

            });

            
        }
    </script>
</head>
<body>

<input type="button" value="请求Json响应Json" onclick="requestJson()">
<input type="button" value="请求key/value响应Json" onclick="responseJson()">

</body>
</html>
