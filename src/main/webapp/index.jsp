<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="i18n.text"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="text.title"/></title>
</head>
<body>
<form action="parsing" method="post" enctype="multipart/form-data">
    <input name="data" type="file"/>
    <fmt:message key="text.button.upload" var="uploadValue"/>
    <input type="submit" value="${uploadValue}"/>
</form>
<h3><fmt:message key="text.header"/></h3>
<form name="Simple" action="parsing" method="POST">
    <select name="parsType" required>
        <option value="sax">SAX</option>
        <option value="dom">DOM</option>
        <option value="stax">StAX</option>
    </select>
    <fmt:message key="text.button.value" var="buttonValue"/>
    <input type="submit" name="button" value="${buttonValue}"/>
    <input type="hidden" name="command" value="parse">
</form>
<a href="parsing?command=change_lang&lang=en_US">English</a>
<a href="parsing?command=change_lang&lang=ru_RU">Русский</a>
</body>
</html>
