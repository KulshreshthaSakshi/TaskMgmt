<%@include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <h1 class="text-uppercase">Share Notes</h1>

    <div class="row">
      <div class="col-12">

        <c:choose>
          <c:when test="${empty notesToPublish}">
            <div class="alert alert-info text-center mt-4">
              No unshared notes found!
            </div>
          </c:when>
          <c:otherwise>
            <c:forEach var="note" items="${notesToPublish}">
              <div class="card mt-3">
                <img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="icons/publishNote.svg" alt="Publish Icon">
                <div class="card-body px-5">
                  <h5 class="card-title">${note.title}</h5>
                  <p>Add Date: <b class="text-primary">${note.addDate}</b></p>
                  <p>Event Date: <b class="text-primary">${note.eventDate}</b></p>
                  <p>Event Time: <b class="text-primary">${note.time}</b></p>

                  <div class="container text-center mt-2">
                    <a href="publish?note_id=${note.ID}" class="btn btn-primary">Publish</a>
                  </div>
                </div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>

      </div>
    </div>
  </div>
</body>
</html>
