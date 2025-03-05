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
  </style>
</head>
<body>

  <header class="navbar navbar-expand-lg navbar-light bg-light px-3">
    <a class="navbar-brand" href="#">
      <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo" class="logo">
    </a>
    <div class="ms-auto">
      <a href="index" class="btn btn-primary me-2">HOME</a>
      <a href="signiIn.jsp" class="btn btn-outline-primary">Sign In</a>
    </div>
  </header>

  <div class="container">
    <h2 class="text-center mb-4">Signup</h2>
    <form action="signup" method="post">
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-user"></i></span>
        <input type="text" class="form-control" name="name" placeholder="Enter your username" required>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-id-badge"></i></span>
        <input type="text" class="form-control" name="loginID" placeholder="Enter your login ID" required>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-envelope"></i></span>
        <input type="email" class="form-control" name="email" placeholder="Enter your email" required>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-phone"></i></span>
        <input type="text" class="form-control" name="phoneNo" placeholder="Enter your phone number" required>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-lock"></i></span>
        <input type="password" class="form-control" name="password" placeholder="Enter your password" required>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-lock"></i></span>
        <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm your password" required>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
        <input type="text" class="form-control" name="location" placeholder="Enter your location" required>
      </div>
      <div class="mb-3">
        <label class="form-label">Gender:</label>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="gender" value="male" required>
          <label class="form-check-label">Male</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="gender" value="female" required>
          <label class="form-check-label">Female</label>
        </div>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-birthday-cake"></i></span>
        <input type="text" class="form-control" name="age" placeholder="Enter your age" required>
      </div>
      <div class="input-group">
        <span class="input-group-text"><i class="fas fa-calendar"></i></span>
        <input type="date" class="form-control" name="dob" required>
      </div>
      <button type="submit" class="btn btn-primary w-100 mt-3">Submit</button>
    </form>
  </div>

</body>
</html>
