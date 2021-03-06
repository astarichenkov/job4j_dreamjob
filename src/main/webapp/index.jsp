<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.store.MemStore" %>
<%@ page import="ru.job4j.dream.model.Post" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <title>Работа мечты</title>
</head>
<body>
<div class="container">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/index.do">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Вакансии</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Кандидаты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Добавить вакансию</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.jsp">Добавить кандидата</a>
            </li>
            <c:if test="${user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/logout.do"><c:out value="${user.name}"/> |
                        Выйти</a>
                </li>
            </c:if>
        </ul>
    </div>
    <div class="container pt-3">
        <div class="row">
            <div class="card" style="width: 100%">
                <div class="card-header">
                    Вакансии за сегодя
                </div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                        <th scope="col">#</th>
                        <th scope="col">Название</th>
                        <th scope="col">Описание</th>
                        <th scope="col">Дата</th>
                        </thead>
                        <tbody>
                        <c:forEach var="post" items="${posts}">
                            <tr>
                                <td>
                                    <a href='<c:url value="/index.jsp"/>'>
                                        <i class="fa fa-edit mr-3"></i>
                                    </a>
                                    <c:out value="${post.id}"/>
                                </td>
                                <td>
                                    <c:out value="${post.name}"/>
                                </td>
                                <td>
                                    <c:out value="${post.description}"/>
                                </td>
                                <td>
                                    <c:out value="${post.formattedDate}"/>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="container pt-3">

        <div class="row">
            <div class="card" style="width: 100%">
                <div class="card-header">
                    Кандидаты за сегодня
                </div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Имя</th>
                            <th scope="col">Город</th>
                            <th scope="col">Фото</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${candidates}" var="can">
                            <tr>
                                <td>
                                    <a href='<c:url value="/candidate/edit.jsp?id=${can.id}"/>'>
                                        <i class="fa fa-edit mr-2"></i>
                                    </a>
                                    <a href='<c:url value="/candidate/remove?id=${can.id}"/>'>
                                        <i class="fa fa-times mr-2"></i>
                                    </a>
                                    <c:out value="${can.id}"/>
                                </td>
                                <td>
                                    <c:out value="${can.name}"/>
                                </td>
                                <td>
                                    <c:out value="${can.city}"/>
                                </td>
                                <td>
                                    <img src="<c:url value='/download?id=${can.id}'/>" width="100px" height="100px"/>
                                    <br>
                                    <a href='<c:url value="/candidate/photo-upload.do?id=${can.id}"/>'>
                                        <i class="fa fa-user-plus mr-2"></i>
                                    </a>
                                    <a href='<c:url value="/candidate/photo-remove.do?id=${can.id}"/>'>

                                        <i class="fa fa-times mr-2"></i>
                                    </a>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>