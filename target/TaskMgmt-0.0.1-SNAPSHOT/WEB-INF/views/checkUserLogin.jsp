<!-- checkUserLogin.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Failed</title>
    <link rel="stylesheet" href="css/CheckLoginStyle.css">
</head>
<body style="background-image: url('img/img3.jpg');">
    <div class="header">
        <h1 style="text-align: center;">Invalid email or password</h1>
    </div>
    <div class="header1">
        <h2 style="text-align: center;">Credentials you entered do not match our records</h2>
    </div>
    <div class="button" style="text-align: center;">
        <button onclick="history.back()">Try Again</button>
    </div>
    <div class="header2">
        <h2 style="text-align: center;">Not a member? Sign up here:</h2>
    </div>
    <div class="button" style="text-align: center;">
        <a href="Register.jsp"><button>Sign Up</button></a>
    </div>
</body>
</html>
