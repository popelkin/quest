<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<div class="jumbotron">
    <h1 class="display-4">Ошибка</h1>
    <p class="lead">
        <c:if test="${!message.equals(\"\")}">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </c:if>
    </p>
    <a role="button" href="#" onclick="history.back();" class="btn btn-primary mb-2">&larr; назад</a>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>