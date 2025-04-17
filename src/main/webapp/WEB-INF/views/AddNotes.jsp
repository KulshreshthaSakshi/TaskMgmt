<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@ include file="all_js_css.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ADD NOTES</title>
    <link rel="stylesheet" href="css/AddNotesStyle.css">
</head>
<body>
    <div class="container">
        <%@ include file="navbar.jsp" %>

        <h1>ADD NOTE DETAILS</h1>

        <form action="addNote" method="post">
            <input type="hidden" name="email" value="${sessionScope.email}" />

            <div class="mb-3">
                <label for="title" class="form-label">Note Title</label>
                <input type="text" name="title" class="form-control" id="title" placeholder="Enter Title Here" required />
            </div>

            <div class="mb-3">
                <label for="content" class="form-label">Note Content</label>
                <textarea id="content" name="content" placeholder="Enter content" class="form-control" style="height:300px;" required></textarea>
            </div>

            <div class="row mb-3">
                <div class="col-sm-1"></div>
                <label for="eveDate" class="col-sm-1 col-form-label">Event Date</label>
                <div class="col-sm-3">
                    <input type="date" name="eveDate" class="form-control" required
                           min="<%= java.time.LocalDate.now() %>" />
                </div>
                <div class="col-sm-2"></div>
                <label for="eveTime" class="col-sm-1 col-form-label">Event Time</label>
                <div class="col-sm-3">
                    <input type="time" name="eveTime" class="form-control" required />
                </div>
            </div>

            <div class="container text-center">
                <button type="submit" class="btn btn-primary">ADD</button>
                <button type="button" class="btn btn-dark" id="click_to_convert">Voice to Text</button>
            </div>
        </form>
    </div>

    <script src="js/voice.js"></script>
</body>
</html>
