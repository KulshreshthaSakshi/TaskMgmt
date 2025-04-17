<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.entity.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.example.service.NoteService" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Publish Notes | Note Taker</title>
  <link rel="stylesheet" href="css/AddNotesStyle.css">
  <%@include file="all_js_css.jsp" %>
</head>
<body>
  <div class="container">
    <%@include file="navbar.jsp" %>
    
    <br>
    <h1 class="text-uppercase">Publish Notes</h1>

    <div class="row">
      <div class="col-12">

        <%
          String email = (String) session.getAttribute("email");

          // Get the Spring ApplicationContext
          org.springframework.web.context.WebApplicationContext context = 
              WebApplicationContextUtils.getRequiredWebApplicationContext(application);

          NoteService noteService = context.getBean(NoteService.class);

          List<Note> notesToPublish = noteService.getPublishable(email);
        %>

        <%
          if (notesToPublish == null || notesToPublish.isEmpty()) {
        %>
            <div class="alert alert-info text-center mt-4">
              No unpublished notes found!
            </div>
        <%
          } else {
            for (Note note : notesToPublish) {
        %>
              <div class="card mt-3">
                <img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="icons/publishNote.svg" alt="Publish Icon">
                <div class="card-body px-5">
                  <h5 class="card-title"><%= note.getTitle() %></h5>
                  <p>Add Date: <b class="text-primary"><%= note.getAddDate() %></b></p>
                  <p>Event Date: <b class="text-primary"><%= note.getEventDate() %></b></p>
                  <p>Event Time: <b class="text-primary"><%= note.getTime() %></b></p>

                  <div class="container text-center mt-2">
                    <a href="PublishServlet?note_id=<%= note.getID() %>" class="btn btn-primary">Publish</a>
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
