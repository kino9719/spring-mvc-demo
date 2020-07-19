<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<p>
    Hi, <c:out value="${fn:escapeXml(sessionScope.username)}"/>
    <a href="/logout">登出</a>
</p>
<hr />
