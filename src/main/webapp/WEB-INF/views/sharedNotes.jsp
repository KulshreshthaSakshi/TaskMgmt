<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.TaskMgmt.entity.SharedNote" %>
<%@ include file="header.jsp" %>
<%@ include file="all_js_css.jsp" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>All Shared Notes | Note Taker</title>
  <link rel="stylesheet" href="css/AddNotesStyle.css">
</head>
<body>

<div class="container">
  <%@ include file="navbar.jsp" %>

  <br>
  <h1 class="text-uppercase">All Shared Notes</h1>

  <div class="row">
    <div class="col-12">

      <%
        List<SharedNote> sharedNotes = (List<SharedNote>) request.getAttribute("sharedNotes");
        if (sharedNotes == null || sharedNotes.isEmpty()) {
      %>
        <div class="alert alert-info text-center">
          No shared notes found!
        </div>
      <%
        } else {
          for (SharedNote note : sharedNotes) {
      %>

        <div class="card mt-3">
          <img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="icons/shareNote.svg" alt="Share Icon">
          <div class="card-body px-5">
            <h5 class="card-title"><%= note.getTitle() %></h5>
            <p>Shared By: <b class="text-primary"><%= note.getUser().getEmail() %></b></p>
            <p>Add Date: <b class="text-primary"><%= note.getAddDate() %></b></p>
            <p>Event Date: <b class="text-primary"><%= note.getEventDate() %></b></p>
            <p>Event Time: <b class="text-primary"><%= note.getTime() %></b></p>
            <p class="card-text"><%= note.getContent() %></p>
          </div>
        </div>

      <%
          }
        }
      %>

    </div>
  </div>
</div>

</body>
</html>
