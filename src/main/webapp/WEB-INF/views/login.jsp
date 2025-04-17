<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/LoginStyle.css">
    <link rel="icon" type="image/x-icon" href="icons/NotesAhoy.ico">
</head>
<body>

<section>
    <!-- Background animation spans -->
    <c:forEach begin="1" end="150" var="i">
        <span></span>
    </c:forEach>

    <div class="signin">
        <div class="content">
            <h2>Sign In</h2>
            <div class="form">
                <!-- Show error message if login fails -->
                <c:if test="${not empty error}">
                    <div style="color: red; text-align: center; margin-bottom: 10px;">
                        ${error}
                    </div>
                </c:if>

                <form action="login" method="post">
                    <div class="inputBox">
                        <input type="email" name="email" required>
                        <i>Username</i>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="password" required>
                        <i>Password</i>
                    </div>
                    <div class="links">
                        <a href="#">Forgot Password</a>
                        <a href="register">Signup</a>
                    </div>
                    <div class="inputBox">
                        <input type="submit" value="Login">
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>

</body>
</html>
