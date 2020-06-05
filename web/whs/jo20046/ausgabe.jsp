<%@ page import="whs.jo20046.beans.URLsBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ausgabe</title>
</head>
<body>
<%
    URLsBean urLsBean = (URLsBean) session.getAttribute("URLs");
%>
url1: <%= urLsBean.getUrl1() %><br>
url2: <%= urLsBean.getUrl2() %><br>
url3: <%= urLsBean.getUrl3() %><br>

</body>
</html>
