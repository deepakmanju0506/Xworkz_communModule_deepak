<%@ page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 400px;
            margin-top: 100px;
            padding: 20px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        body {
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>
    <header class="navbar navbar-expand-lg navbar-light bg-light px-3">
        <a class="navbar-brand" href="#">
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo" class="logo" height="40">
        </a>
        <div class="ms-auto">
            <a href="index" class="btn btn-primary me-2">HOME</a>
        </div>
    </header>

    <div class="container">
        <h2 class="text-center mb-4">Enter your Details</h2>
        <form action="signin" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" name="email" placeholder="Enter email" >
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="passwords" placeholder="Enter password">
            </div>
            <a href="forgotPassword"> Forgot Password</a>
            <button type="submit" class="btn btn-primary w-100">Submit</button>
        </form>
    </div>

</body>
</html>
