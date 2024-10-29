<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }
        h1 {
            color: #00796b;
            margin-bottom: 20px;
        }
        a {
            display: block;
            margin: 10px 0;
            padding: 15px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 25px;
            transition: background-color 0.3s, transform 0.3s;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        a:hover {
            background-color: #45a049;
            transform: translateY(-3px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }
        hr {
            border: none;
            height: 1px;
            background-color: #ccc;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <% String username = (String) session.getAttribute("username"); %>
        <h1>Login success, <%= username %>!</h1>
        <a href="CarDetails.html">Enter the car details</a>
        <a href="EditCarDetails.html">Edit the car details</a>
        <hr>
        <a href="ServiceRequest.html">Request for car service</a>
        <hr>
        <a href="ServiceStatus.html">Check service status</a>
    </div>
</body>
</html>
