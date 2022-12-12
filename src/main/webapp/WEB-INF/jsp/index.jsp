<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<div class="jumbotron">
    <h1 class="display-4">Пролог</h1>
    <p class="lead">
        Ты стоишь в космическом порту и готов подняться на борт своего корабля.<br />
        Разве ты не об этом мечтал?<br />
        Стать капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием.<br />
        Так что вперед!<br />
    </p>
    <hr class="my-4">
    <h1 class="display-4">Знакомство с экипажем</h1>
    <p>
        Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:<br />
        &mdash; Здравствуйте, командир!<br />
        Я Зинаида Матвеевна Шпунсель &mdash; ваша помощница.<br />
        Видите? Там в углу пьет кофе наш штурман &mdash; сержант Перегарный Шлейф.<br />
        Под штурвалом спит наш бортмеханик &mdash; Синий Дринкинс, а фотографирует его Артур Пирожков &mdash; наставит мужу рожков.<br />
        А как обращаться к вам?<br />
    </p>
    <form class="form-inline" action="${pageContext.request.contextPath}/entrance" method="post">
        <div class="form-group row">
            <input <%-- @todo required --%> type="text" class="form-control" id="name" placeholder="Иван Глушко" name="username" value="">
        </div>
        <button type="submit" class="btn btn-primary mb-2" style="margin-left: 20px;">Поехали!</button>
    </form>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>