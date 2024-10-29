<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Service Status Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #00796b;
            font-size: 36px;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #333333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Service Status</h1>
        <p>Your service status: <%= session.getAttribute("SStatus") %></p>
    </div>
</body>
</html>
