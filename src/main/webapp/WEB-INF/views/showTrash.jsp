<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.TaskMgmt.entity.TrashNote" %>
<%@ include file="header.jsp" %>
<%@ include file="all_js_css.jsp" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Trash Notes | Note Taker</title>
  <link rel="stylesheet" href="css/AddNotesStyle.css">
</head>
<body>

<div class="container">
  <%@ include file="navbar.jsp" %>

  <br>
  <h1 class="text-uppercase">All Trash Notes</h1>

  <div class="row">
    <div class="col-12">

      <%
        List<TrashNote> trashNotes = (List<TrashNote>) request.getAttribute("trashNotes");

        if (trashNotes == null || trashNotes.isEmpty()) {
      %>
        <div class="alert alert-info text-center">
          No notes in trash.
        </div>
      <%
        } else {
          for (TrashNote note : trashNotes) {
      %>
        <div class="card mt-3">
          <img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="icons/trashnote.svg" alt="Trash Icon">
          <div class="card-body px-5">
            <h5 class="card-title"><%= note.getTitle() %></h5>
            <p>Delete Date: <b class="text-primary"><%= note.getDelDate() %></b></p>

            <div class="container text-center mt-2">
              <a href="deleteTrashNote?note_id=<%= note.getID() %>" class="btn btn-danger">Delete</a>
              <a href="restore?note_id=<%= note.getID() %>" class="btn btn-primary">Restore</a>
            </div>
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
