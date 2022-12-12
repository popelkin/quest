<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.popelo.quest.domain.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="questRepository" value="${applicationScope.get('questRepository')}"/>
<c:set var="itemRepository" value="${applicationScope.get('itemRepository')}"/>
<c:set var="userRepository" value="${applicationScope.get('userRepository')}"/>
<div class="d-info">
    <h1>Информация</h1>
    <h4>Всего пользователей: <c:out value="${userRepository.count()}"/></h4>
    <hr/>
    <h1>Информация о вас</h1>
    <h4>Имя: <c:out value="${sessionScope.user.getUsername()}"/></h4>
    <h4>Игр: <c:out value="${sessionScope.user.getQuests()}"/></h4>
    <h4>Очков: <c:out value="${sessionScope.user.getPoints()}"/></h4>
</div>
<br>
<hr>