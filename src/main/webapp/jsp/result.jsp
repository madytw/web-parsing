<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 22.11.2016
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="i18n.text"/>
<html>
<head>
    <title><fmt:message key="text.result.title"/> </title>
</head>
<body>
<h3><fmt:message key="text.info.start"/> ${parsType} <fmt:message key="text.info.end"/> </h3>
<table border="1">
    <thead>
    <tr>
        <th rowspan="2"><fmt:message key="table.inj.name"/> </th>
        <th rowspan="2"><fmt:message key="table.inj.group"/> </th>
        <th colspan="2"><fmt:message key="table.inj.dosage"/> </th>
        <th rowspan="2"><fmt:message key="table.inj.type"/> </th>
    </tr>
    <tr>
        <th><fmt:message key="table.drug.dosage"/> </th>
        <th><fmt:message key="table.frequency"/> </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="elem" items="${injections}" varStatus="status">
        <tr>
            <td><c:out value="${ elem.name }" /></td>
            <td><c:out value="${ elem.group }" /></td>
            <td><c:out value="${ elem.dosage.drugDosage }" /></td>
            <td><c:out value="${ elem.dosage.frequencyReception }" /></td>
            <td><c:out value="${ elem.injectionType }" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table border="1">
    <thead>
    <tr>
        <th rowspan="3"><fmt:message key="table.drug.name"/> </th>
        <th rowspan="3"><fmt:message key="table.drug.group"/></th>
        <th colspan="9"><fmt:message key="table.drug.pharm"/></th>
        <th rowspan="3"><fmt:message key="table.drug.analogs"/></th>
        <th rowspan="3"><fmt:message key="table.drug.versions"/></th>
    </tr>
    <tr>
        <th colspan="4"><fmt:message key="table.pharm.sertificate"/></th>
        <th colspan="2"><fmt:message key="table.pharm.dosage"/></th>
        <th colspan="3"><fmt:message key="table.pharm.pack"/></th>
    </tr>
    <tr>
        <th><fmt:message key="table.certificate.id"/></th>
        <th><fmt:message key="table.certificate.issue"/></th>
        <th><fmt:message key="table.certificate.expiration"/></th>
        <th><fmt:message key="table.certificate.org"/></th>
        <th><fmt:message key="table.drug.dosage"/></th>
        <th><fmt:message key="table.frequency"/></th>
        <th><fmt:message key="table.package.amount"/></th>
        <th><fmt:message key="table.package.price"/></th>
        <th><fmt:message key="table.package.type"/></th>
    </tr>
    </thead>
    <c:forEach var="elem" items="${drugs}" varStatus="status">
        <tr>
            <td><c:out value="${ elem.name }" /></td>
            <td><c:out value="${ elem.group }" /></td>
            <td><c:out value="${ elem.pharm.certificate.certificateId }" /></td>
            <td><c:out value="${ elem.pharm.certificate.dateOfIssue }" /></td>
            <td><c:out value="${ elem.pharm.certificate.expirationDate }" /></td>
            <td><c:out value="${ elem.pharm.certificate.registryOrganization }" /></td>
            <td><c:out value="${ elem.pharm.dosage.drugDosage }" /></td>
            <td><c:out value="${ elem.pharm.dosage.frequencyReception }" /></td>
            <td><c:out value="${ elem.pharm.medPackage.amount }" /></td>
            <td><c:out value="${ elem.pharm.medPackage.price }" /></td>
            <td><c:out value="${ elem.pharm.medPackage.type }" /></td>
            <td><c:out value="${elem.analogueNames}" /></td>
            <td><c:out value="${elem.versions}" /></td>
        </tr>
    </c:forEach>
</table>
<a href="parsing"><fmt:message key="text.back"/></a>
<a href="parsing?command=change_lang&lang=en_US">English</a>
<a href="parsing?command=change_lang&lang=ru_RU">Русский</a>
</body>
</html>
