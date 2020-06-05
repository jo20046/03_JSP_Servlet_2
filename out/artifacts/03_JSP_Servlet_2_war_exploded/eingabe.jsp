<html>
<head>
    <title>Eingabe</title>
</head>
<body>
<%
    String helperText = (String) session.getAttribute("urlInput");
    String notFoundText = (String) session.getAttribute("notFoundText");
    if (helperText == null) helperText = "";
    if (notFoundText == null) notFoundText = "";
%>
<form method="post" action="${pageContext.request.contextPath}/Pruefung">
    <label>URL:
        <input type="text" name="url" value="<%=helperText%>"><br>
    </label>
    <label><%=notFoundText%></label><br>
    <input type="submit" value="Best&auml;tigen">
</form>
</body>
</html>
