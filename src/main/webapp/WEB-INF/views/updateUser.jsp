<!DOCTYPE html>
<html lang="en">
<head>
 <%@page import="com.example.TaskMgmt.repository.UserRepository" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Confirmation</title>
    <link rel="stylesheet" type="text/css" href="css/otp.css">
</head>
<body>
    <div class="container">
        <h1>ENTER OTP</h1>
        <div class="userInput">
            <form action="checkUpdateOTP" method="post" onsubmit="return combineOtp()">
                <input type="number" name="ist" id="ist" maxlength="1" onkeyup="clickEvent(this,'sec')" required autofocus>
                <input type="number" name="sec" id="sec" maxlength="1" onkeyup="clickEvent(this,'third')" required>
                <input type="number" name="third" id="third" maxlength="1" onkeyup="clickEvent(this,'fourth')" required>
                <input type="number" name="fourth" id="fourth" maxlength="1" required>
                <input type="hidden" name="otp" id="otp">
                <br>
                <center><button type="submit">CONFIRM</button></center>
            </form>
        </div>
    </div>

    <script>
      function clickEvent(current, nextId) {
          if (current.value.length === 1) {
              document.getElementById(nextId).focus();
          }
      }

      function combineOtp() {
          const otp = document.getElementById('ist').value +
                      document.getElementById('sec').value +
                      document.getElementById('third').value +
                      document.getElementById('fourth').value;
          document.getElementById('otp').value = otp;
          return true;
      }
    </script>
</body>
</html>
