<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Login Page</title>
<style>
   
    .main {
        width: 300px; /* adjust the width to your liking */
        margin: 40px auto; /* center align the form */
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
</style>
</head>
<body>
    <div class="main">
        <h1>Login Page</h1>
        <h3>Enter your login credentials</h3>
        <form action="LoginServlet" method="post">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username">
            </div>
            <p></p>
            <div>
                <label for="pass">Password:</label>
                <input type="password" id="pass" name="password" >
            </div>

            <input type="submit" value="Sign in">
        </form>
    </div>
</body>
</html>