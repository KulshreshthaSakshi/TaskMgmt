<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ include file="all_js_css.jsp" %>
<%@ page import="com.example.TaskMgmt.entity.User" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Profile | Notes Ahoy</title>
  <link rel="stylesheet" href="css/userPanel.css">
</head>
<body>

<div class="container">
  <%@ include file="navbar.jsp" %>

  <div class="container mt-5">
    <h1 class="text-center text-uppercase">Edit Profile</h1>
    
    <%
      User user = (User) request.getAttribute("user");
      if (user != null) {
    %>
    <form action="updateUser" method="post" class="mt-4">

      <input type="text" id="first_name" name="first_name" value="<%= user.getFname() %>" required><br>

      <input type="text" id="last_name" name="last_name" value="<%= user.getLname() %>" required><br>

      <input type="email" id="email" name="email" value="<%= user.getEmail() %>" required readonly><br>

      <input type="text" name="otp" placeholder="Enter OTP if required"><br>

      <input type="submit" value="Update">
      <input type="reset" value="Reset">
    </form>
    <%
      } else {
    %>
      <div class="alert alert-danger text-center">User not found.</div>
    <%
      }
    %>

  </div>
</div>

</body>
</html>
