<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Common_Module</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #d6f6ed;
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
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 100vh;
      text-align: center;
    }

    .container img {
      width: 50%;
      height: auto;
      margin-bottom: 20px;
    }

    h2 {
      font-size: 24px;
      font-weight: bold;
      color: #333;
      text-align: center;
      margin-top: 10px;
    }
  </style>
</head>

<body>
  <header class="navbar navbar-expand-lg navbar-light bg-light px-3">
    <a class="navbar-brand" href="#">
      <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo" class="logo">
    </a>
    <div class="ms-auto">
          <a href="signup" class="btn btn-primary me-2">Sign Up</a>
          <a href="signin" class="btn btn-outline-primary">Sign In</a>
    </div>
  </header>

  <div class="container">
    <img src="https://x-workz.in/static/media/coding_img.bef297f81da57125500a.png" alt="logo">
  </div>
  <h2>FREE 1 months class for any Graduates</h2>
</body>

</html>