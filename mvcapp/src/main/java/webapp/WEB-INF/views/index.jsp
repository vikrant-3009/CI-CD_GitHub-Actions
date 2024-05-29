<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Calculator</title>
    </head>
    <body>
        <h1>Simple Calculator</h1>
        <form action="calculate" method="post">
            <label for="num1">Number 1:</label>
            <input type="text" id="num1" name="num1" required>
            <br>
            <label for="num2">Number 2:</label>
            <input type="text" id="num2" name="num2" required>
            <br>
            <label for="operation">Operation:</label>
            <select id="operation" name="operation">
            <option value="add">Add</option>
            <option value="subtract">Subtract</option>
            <option value="multiply">Multiply</option>
            <option value="divide">Divide</option>
            </select>
            <br>
            <button id="submit-btn" type="submit">Calculate</button>
        </form>
        <c:if test="${not empty error}">
        <p id="error" style="color:red">${error}</p>
        </c:if>
    </body>
</html>