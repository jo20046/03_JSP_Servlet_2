<%@ page import="whs.jo20046.beans.URLsBean" %>
<%@ page import="whs.jo20046.beans.NotFoundBean" %>
<html>
<head>
    <title>Eingabe</title>
</head>
<body>
<%
    URLsBean urLsBean = (URLsBean) session.getAttribute("URLs");
    NotFoundBean notFoundBean = (NotFoundBean) session.getAttribute("NotFound");
    if (urLsBean == null) urLsBean = new URLsBean("", "", "");
    if (notFoundBean == null) notFoundBean = new NotFoundBean();
%>
<form method="post" action="${pageContext.request.contextPath}/Pruefung">
    <label>1. URL:
        <input type="text" name="url1" value="<%=urLsBean.getUrl1()%>"> <%=notFoundBean.getNotFoundText(0)%><br><br>
    </label>
    <label>2. URL:
        <input type="text" name="url2" value="<%=urLsBean.getUrl2()%>"> <%=notFoundBean.getNotFoundText(1)%><br><br>
    </label>
    <label>3. URL:
        <input type="text" name="url3" value="<%=urLsBean.getUrl3()%>"> <%=notFoundBean.getNotFoundText(2)%><br><br>
    </label>
    <input type="submit" value="Best&auml;tigen">
</form>
</body>
</html>
