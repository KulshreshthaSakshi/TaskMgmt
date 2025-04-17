<%@include file="header.jsp" %>
<!doctype html>
<html lang="en">
  <head>
    
    <title>NOTE TAKER : HOME</title>
    
    <%@include file="all_js_css.jsp" %>
    <link rel="stylesheet" href="css/home.css">
  </head>
  <body>

  <div class="container">
  <%@include file="navbar.jsp" %>
    <br>
    <h1>USER PANEL</h1>
    <div class="user-panel">
        <div class="panel-square">
            <a href="add-note"><img src="icons/add-note.svg"></a><br>
            <a href="add-note">ADD NOTES</a>
        </div>
        <div class="panel-square">
            <a href="draw"><img src="icons/draw.svg"><br></a>
            <a href="draw">DRAW</a>
        </div>
        <div class="panel-square">
            <a href="publishNotes"><img src="icons/publish.svg"><br></a>
            <a href="publishNotes">SHARE NOTE TO ALL</a>
        </div>
        <div class="panel-square">
            <a href="all-notes"><img src="icons/note.svg"><br></a>
            <a href="all-notes">SEE ALL NOTES</a>
        </div>
        <div class="panel-square">
            <a href="calendar"><img src="icons/calendar.svg" ><br></a>
            <a href="calendar">CALENDAR</a>
        </div>
        <div class="panel-square">
            <a href="showTrash"><img src="icons/trash.svg" ><br></a>
            <a href="showTrash">TRASH</a>
        </div>
    </div>
</div>
  	
  </body>
</html>