<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() +
            ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <link rel="stylesheet" type="text/css" href="jquery/bootstrap_3.3.0/css/bootstrap.min.css">
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
    <meta charset="UTF-8">
    <title>datetimepickertest</title>
    <script type="text/javascript" >
        $(function () {
            $(".myDate").datetimepicker({
                language:'zh-CN',
                format:'yyyy-mm-dd',
                minValue:'mouth',
                initialDate:new Date(),
                autoclose:true,
                todayBtn:true,
                clearBtn:true
            });
        });



    </script>
</head>
<body>
<input type="text" id="myDate">
</body>
</html>