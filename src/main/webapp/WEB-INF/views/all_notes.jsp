<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Notes: Note Taker</title>
    <link rel="stylesheet" href="css/AddNotesStyle.css">
    <%@ include file="all_js_css.jsp" %>
</head>
<body>
    <div class="container">
        <%@ include file="navbar.jsp" %>
        
        <br>
        <h1 class="text-uppercase">All Notes</h1>
        
        <div class="row">
            <div class="col-12">
                <c:forEach var="note" items="${notes}">
                    <div class="card mt-3">
                        <img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="img/notepad.png" alt="...">
                        <div class="card-body px-5">
                            <h5 class="card-title">${note.title}</h5>
                            <p class="card-text">${note.content}</p>
                            <p>Add Date: <b class="text-primary">${note.addDate}</b></p>
                            <p>Event Date: <b class="text-primary">${note.eventDate}</b></p>
                            <p>Event Time: <b class="text-primary">${note.time}</b></p>
                            <div class="container text-center mt-2">
                                <a href="deleteNote?note_id=${note.ID}" class="btn btn-danger">Delete</a>
                                <a href="edit?note_id=${note.ID}" class="btn btn-primary">Update</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
