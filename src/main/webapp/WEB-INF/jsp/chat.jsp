<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
    </head>
    <body>
        <div align="center">
            <a href="chat?command=logout">Выход</a>

            <c:if test="${\"ADMIN\" == user.userType}">
                <a href="chat?command=show_adminpanel_page">Админ панель</a>
            </c:if>
            <!-- Главная страница Чата -->
        </div>

        <div align="center">
            <div style="width:500px;
                        height:700px;
                        border:1px solid #000;
                        ">
                    <c:forEach items="${listMessage}" var="users">
                        <c:out value = "${users.login} : ${users.message}"/><p>
                    </c:forEach>
            </div>
            <div>
                <form method="post" action="chat?command=user_send_message">
                    <input type="text" placeholder="Type your message..." name="message">
                    <button type="submit">Send your message</button>
                </form>
            </div>
            <div>
                <form method="post" action="chat?command=user_refresh_page">
                    <button type="submit">Refresh page</button>
                </form>
            </div>
        </div>
</body>
</html>