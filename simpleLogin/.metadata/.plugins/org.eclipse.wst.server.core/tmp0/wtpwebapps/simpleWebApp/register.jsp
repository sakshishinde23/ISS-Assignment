<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function validateForm() {
            var username = document.forms["registerForm"]["username"].value;
            var password = document.forms["registerForm"]["password"].value;
            if (username == "" || password == "") {
                alert("Username and password must be filled out");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Register</h2>
        <form name="registerForm" action="Register" method="post" onsubmit="return validateForm()" class="mt-4">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
        <p class="text-danger mt-3">${errorMessage}</p>
    </div>
</body>
</html>
