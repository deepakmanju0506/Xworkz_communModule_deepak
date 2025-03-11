<%@ page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>forgot Password</title>
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
      <input type="text" name="email" placeholder="Enter your Mail id">
      <input type="password" name="password" placeholder="Enter your new password">
      <input type="password" name="confirmPassword" placeholder="Enter your confirmPassword">
      <input typee="submit" name="Update" value="Update Password">

</body>
</html>