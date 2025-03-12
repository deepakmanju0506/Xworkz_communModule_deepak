<%@ page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Signup Module</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <style>
    body {
      background-color: #f8f9fa;
    }
    header {
      display: flex;
      background-color: #a3d9c9;
      align-items: center;
      justify-content: space-between;
      padding: 10px 20px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .logo {
      height: 50px;
    }
    .container {
      max-width: 500px;
      margin: 50px auto;
      padding: 20px;
      background: #fff;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .form-control {
      margin-bottom: 15px;
    }

    #dropdown {
        width: 200px;
        padding: 8px;
        font-size: 16px;
        border: 2px solid #4CAF50;
        border-radius: 5px;
        background-color: #f8f9fa;
        color: #333;
        cursor: pointer;
    }

    #dropdown:hover {
        border-color: #45a049;
    }

    #dropdown:focus {
        outline: none;
        border-color: #007bff;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
    }

    #dropdown option {
        background-color: #ffffff;
        color: #333;
        padding: 5px;
    }
    .btn-primary {
      background-color: #007bff; /* Primary blue */
      border: none;
      color: white;
      padding: 10px 15px;
      font-size: 16px;
      font-weight: bold;
      text-align: center;
      border-radius: 5px;
      transition: background-color 0.3s ease;
    }

    .btn-primary:hover {
      background-color: #0056b3; /* Darker blue */
    }

    .w-100 {
      width: 100%;
    }

    .mt-3 {
      margin-top: 1rem;
    }

  </style>
</head>
<body>

  <header class="navbar navbar-expand-lg navbar-light bg-light px-3">
    <a class="navbar-brand" href="#">
      <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo" class="logo">
    </a>
    <div class="ms-auto">
      <a href="index" class="btn btn-primary me-2">HOME</a>
      <a href="signin" class="btn btn-outline-primary">Sign In</a>
    </div>
  </header>

  <div class="container">
    <h2 class="text-center mb-4">Update your Details</h2>
    <form action="updateUser" method="post">
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-user"></i></span>
        <input type="text" class="form-control" name="userName" placeholder="Enter your username" value="${dto.userName}">

      </div>
      <div class="input-group">
        <input type="hidden" class="form-control" name="loginID" placeholder="Enter your login ID" value="${dto.loginID}" >

      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-envelope"></i></span>
        <input type="text" class="form-control" name="email" placeholder="Enter your email" value="${dto.email}" readonly>

      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-phone"></i></span>
        <input type="text" class="form-control" name="phoneNo" placeholder="Enter your phone number" value="${dto.phoneNo}">

      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-lock"></i></span>
        <input type="password" class="form-control" name="passwords" placeholder="Enter your password"  >

      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-lock"></i></span>
        <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm your password" required>
      </div>
      <select id="dropdown" name="location">
                    <c:forEach items="${list}" var="loc">
                                     <option value="${loc}">${loc}</option>
                                   </c:forEach>
                  </select>
      <div class="mb-3">
      <input type="hidden" name="gender" value="${dto.gender}">
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-birthday-cake"></i></span>
        <input type="text" class="form-control" name="age" placeholder="Enter your age" value="${dto.age}" >

      </div>
      <div class="input-group">
        <input type="hidden" class="form-control" name="doB" value="${dto.doB}">
      </div>

      <button type="submit" class="btn btn-primary w-100 mt-3">Update</button>
    </form>
  </div>

</body>
</html>
