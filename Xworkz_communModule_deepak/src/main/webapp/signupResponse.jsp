<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Success Page</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
            <style>
                .container {
                    max-width: 400px;
                    margin-top: 100px;
                    padding: 20px;
                    background: #ffffff;
                    border-radius: 10px;
                    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
                    text-align: center;
                }
                body {
                    background-color: #f8f9fa;
                }
            </style>
        </head>
        <body>
            <div class="container">
                <img src="https://img.icons8.com/?size=96&id=63312&format=png" alt="logo" height="80">
                <h2 class="mt-3">Success!</h2>
                <p>Your SignUp was completed successfully.</p>
                <a href="index" class="btn btn-primary">Go to Home</a>
            </div>
        </body>
        </html>
