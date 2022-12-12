<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.popelo.quest.domain.PointStatus" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<c:set var="pointRepository" value="${applicationScope.get('pointRepository')}"/>
<c:set var="currentId" value="${Integer.parseInt(param.p)}"/>
<c:set var="currentPoint" value="${pointRepository.getById(currentId)}"/>
<div class="d-scheme">
    <c:forEach items="${pointRepository.getAll()}" var="pointSet">
        <c:set var="point" value="${pointSet.getValue()}"/>
        <a class="
            d-${point.getId()}
            <c:if test="${point.getId() < currentId}">passed</c:if>
            <c:if test="${point.getId() == currentId}">active</c:if>
            <c:if test="${children.contains(point.getId())}">enabled</c:if>
            ${point.getStatus()}
        "
           href="${pageContext.request.contextPath}/point?p=${point.getId()}"
        >${point.getName()}</a>
    </c:forEach>
    <span class="s-1"></span>
    <span class="s-2"></span>
    <span class="s-3"></span>
    <span class="s-4"></span>
    <span class="s-5"></span>
    <span class="s-6"></span>
</div>

<c:if test="${currentPoint.getStatus() != PointStatus.DEFAULT}">
    <a class="btn btn-primary btn-lg btn-block a-restart" href="${pageContext.request.contextPath}/point?p=1">Начать заново</a>
</c:if>

<jsp:include page="blocks/info.jsp" />

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>