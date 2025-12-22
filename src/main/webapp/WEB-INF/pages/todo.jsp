<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> todo</title>
</head>
<body>

<div class="header-buttons">
    <form action="/todo" method="get">
        <button type="submit">Primary</button>
    </form>
    <form action="/todo" method="get">
        <button type="button">Primary</button>
    </form>
</div>
<div class="input-task">
    <form action="/tasks" method="post">
        <input type="text" name="task" placeholder="Enter your task" required>
        <button type="submit">Add task</button>
    </form>
</div>
<div>
    <c:if test="${not empty username}">
        <div class="welcome-message">
            <h1>Hello ${username}!</h1>
        </div>
    </c:if>
    <c:if test="${empty username}">
        <div class="welcome-message">
            <h1>Hello Guest!</h1>
        </div>
    </c:if>
</div>
<div>
    <h1>Tasks:</h1>
    <h4>
        <c:if test="${tasks==null||tasks.isEmpty()}">
            <div class="welcome-message">
                <h1>No Tasks!</h1>
            </div>
        </c:if>
    </h4>
</div>
<ol>
    <c:forEach items ="${tasks}" var="task">
        <li>${task}</li>
    </c:forEach>
</ol>
<div>
    <form>

    </form>
</div>
</body>
</html>