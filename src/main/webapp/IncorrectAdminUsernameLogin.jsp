<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
incorrect  username
 <form action="/Car-Service-System/AdminLogin">
        <table>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="adminusername" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="adminpassword" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Login" /></td>
            </tr>
        </table>
    </form>
</body>
</html>