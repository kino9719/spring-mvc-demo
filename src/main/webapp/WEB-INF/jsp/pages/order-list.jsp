<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="app">
    <h2>訂單列表</h2>
    <table class="uk-table" border="1">
        <thead>
            <tr>
                <th>訂單編號</th>
                <th>訂單建立時間</th>
                <th>使用者名稱</th>
                <th>電話</th>
                <th>地址</th>
                <th>總價格</th>
                <th> </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orderInfos}" var="orderInfo">
                <tr>
                    <jsp:useBean id="ourDate" class="java.util.Date"/>
                    <jsp:setProperty name="ourDate" property="time" value="${orderInfo.createdTime * 1000}"/>
                    <td><c:out value="${fn:escapeXml(orderInfo.id)}"/></td>
                    <td><fmt:formatDate value="${ourDate}" pattern="yyyy-MM-dd H:m:s"/></td>
                    <td><c:out value="${fn:escapeXml(orderInfo.accountName)}"/></td>
                    <td><c:out value="${fn:escapeXml(orderInfo.phone)}"/></td>
                    <td><c:out value="${fn:escapeXml(orderInfo.address)}"/></td>
                    <td><c:out value="${fn:escapeXml(orderInfo.total)}"/></td>
                    <td>
                        <button class="uk-button uk-button-primary uk-button-small" @click="showDetail(<c:out value="${orderInfo.id}"/>)">詳細</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div id="orderDetailModal" uk-modal>
        <div class="uk-modal-dialog">
            <button class="uk-modal-close-default" type="button" uk-close></button>
            <div class="uk-modal-header">
                <h2 class="uk-modal-title">訂單商品</h2>
            </div>
            <div class="uk-modal-body">
                <ol style='list-style-type:square;'>
                  <li v-for="orderItem in orderItems">{{ orderItem.name }} (\${{ orderItem.price }}) x {{ orderItem.amount }}</li>
                </ol>
                <p class="uk-text-right"><strong>總價：{{ orderTotalPrice }}</strong></p>
            </div>
        </div>
    </div>
</div>

<script src="/js/pages/order-list-app.js"></script>
