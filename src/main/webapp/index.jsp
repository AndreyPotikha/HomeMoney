<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 13.02.18
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>Sing in</title>

   <title>Sing in</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
</head>
<body>

<div class = "container">
    <div class="wrapper">
        <form action="/login" method="post" name="Login_Form" class="form-signin">
            <h3 class="form-signin-heading">Добро пожаловать в вашу домашнюю бухгалтерию</h3>
            <hr class="colorgraph"><br>

            <input type="email" class="form-control" name="email" placeholder="Ваш e-mail" required="" autofocus=""/>
            <input type="password" class="form-control" name="password" placeholder="Пароль" required=""/>

            <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Войти</button>
               <a href="new_registration.jsp">Регистрация</a>
               <br>
               <a href="reset_password.jsp">Забыли пароль?</a>
        </form>
    </div>
</div>

</body>
</html>

