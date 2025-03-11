<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>update</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            text-align: center;
        }

        header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #ffffff;
            padding: 10px 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand img {
            height: 40px;
        }

        .btn {
            padding: 10px 15px;
            text-decoration: none;
            font-weight: bold;
            border-radius: 5px;
        }

        .btn-primary {
            background-color: #007bff;
            color: white;
            border: none;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        div {
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        img {
            width: 100px;
            height: auto;
            margin-top: 10px;
        }

        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>


</head>

<body>

    <header class="navbar navbar-expand-lg navbar-light bg-light px-3">
        <a class="navbar-brand" href="#">
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo" class="logo"
                height="40">
        </a>

    </header>

    <div>

        <img src="https://cdn-icons-png.freepik.com/256/1324/1324120.png?ga=GA1.1.1037929384.1741591870&semt=ais_hybrid" alt="logo">
        <h2>${email}</h2>
    </div>
    <div>
        <a href="updateUser?email=${email}">update user</a>
    </div>
</body>

</html>