<html>
<head>
    <title>Eingabe</title>
</head>
<body>
<%
    String helperText1 = (String) session.getAttribute("urlInput1");
    String helperText2 = (String) session.getAttribute("urlInput2");
    String helperText3 = (String) session.getAttribute("urlInput3");
    String notFoundText1 = (String) session.getAttribute("notFoundText1");
    String notFoundText2 = (String) session.getAttribute("notFoundText2");
    String notFoundText3 = (String) session.getAttribute("notFoundText3");
    if (helperText1 == null) helperText1 = "";
    if (helperText2 == null) helperText2 = "";
    if (helperText3 == null) helperText3 = "";
    if (notFoundText1 == null) notFoundText1 = "";
    if (notFoundText2 == null) notFoundText2 = "";
    if (notFoundText3 == null) notFoundText3 = "";
%>
<form method="post" action="${pageContext.request.contextPath}/Pruefung">
    <label>1. URL:
        <input type="text" name="url1" value="<%=helperText1%>"> <%=notFoundText1%><br>
    </label>
    <label>2. URL:
        <input type="text" name="url2" value="<%=helperText2%>"> <%=notFoundText2%><br>
    </label>
    <label>3. URL:
        <input type="text" name="url3" value="<%=helperText3%>"> <%=notFoundText3%><br>
    </label>
    <input type="submit" value="Best&auml;tigen">
</form>
</body>
</html>
