<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.02.2024
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Админ панель</title>
    <style>
        div {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <form method="post" action="chat?command=adminpanel">
        <button>
            <p style="text-align: center">
                <a href="chat?command=show_chat_page">Зайти в чат</a>
        </button>
    </form>
</div>
<div>
    <h3>Список пользователей</h3>
    <table>
        <tr>
            <th>login</th>
            <th>password</th>
            <th>userType</th>
            <th>online</th>
            <th>canWriteMessage</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.userType}</td>
                <td>${user.online}</td>
                <td>${user.writeMessages}</td>
            </tr>
        </c:forEach>
        <form method="post" action="chat?command=ban_unban_user_message">
            <input type="text" placeholder="Вкл/Выкл сообщения" name="loginInput">
            <button type="submit">Type</button>
        </form>
    </table>
</div>
</body>
</html>
