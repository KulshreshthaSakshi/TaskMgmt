<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.TaskMgmt.entity.Note" %>
<%@ include file="header.jsp" %>
<%@ include file="all_js_css.jsp" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>View Note | Note Taker</title>
  <link rel="stylesheet" href="css/AddNotesStyle.css">
</head>
<body>

<div class="container">
  <%@ include file="navbar.jsp" %>

  <br>
  <h1 class="text-uppercase">View Note</h1>

  <div class="row">
    <div class="col-12">

      <%
        Note note = (Note) request.getAttribute("note");

        if (note == null) {
      %>
        <div class="alert alert-danger text-center">
          Note not found or invalid note ID!
        </div>
      <%
        } else {
      %>
        <div class="card mt-3">
          <img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="img/notepad.png" alt="Notepad Icon">
          <div class="card-body px-5">
            <h5 class="card-title"><%= note.getTitle() %></h5>
            <p class="card-text"><%= note.getContent() %></p>
            <p>Add Date: <b class="text-primary"><%= note.getAddDate() %></b></p>
            <p>Event Date: <b class="text-primary"><%= note.getEventDate() %></b></p>
            <p>Event Time: <b class="text-primary"><%= note.getTime() %></b></p>

            <div class="container text-center mt-2">
              <a href="calendar" class="btn btn-primary">Back</a>
            </div>
          </div>
        </div>
      <%
        }
      %>

    </div>
  </div>
</div>

</body>
</html>
