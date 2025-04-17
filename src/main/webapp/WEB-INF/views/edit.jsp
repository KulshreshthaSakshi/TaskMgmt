<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Note</title>
  <%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container">
  <%@include file="navbar.jsp" %>
  <h1>Edit your note</h1>
  <br>

  <form action="${pageContext.request.contextPath}/update" method="post">
    <input type="hidden" name="noteId" value="${note.ID}" />

    <div class="form-group mb-3">
      <label for="title">Note Title</label>
      <input required name="title" type="text" class="form-control"
             id="title" placeholder="Enter title" value="${note.title}" />
    </div>

    <div class="form-group">
      <label for="content">Note Content</label>
      <textarea name="content" required id="content" class="form-control" style="height:300px">
        ${note.content}
      </textarea>
    </div>

    <label for="eveDate" class="col-sm-1 col-form-label">Event Date</label>
    <div class="col-sm-3">
      <input type="date" name="eveDate" class="form-control"
             required value="${note.eventDate}" min="${pageContext.request.contextPath}/today" />
    </div>

    <label for="eveTime" class="col-sm-1 col-form-label">Event Time</label>
    <div class="col-sm-3">
      <input type="time" name="eveTime" class="form-control" required value="${note.time}" />
    </div>

    <div class="container text-center mt-3">
      <button type="submit" class="btn btn-success">Save your note</button>
    </div>
  </form>
</div>
</body>
</html>
