<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container text-center mt-5">
        <h2>Welcome, ${username}</h2>
        <form action="Logout" method="post" class="mt-4">
            <button type="submit" class="btn btn-primary">Logout</button>
        </form>
    </div>
</body>
</html>
