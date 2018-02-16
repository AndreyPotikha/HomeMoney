<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 14.02.18
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>

<div class = "container">
    <div class="wrapper">
        <form action="/registration" method="post" name="Login_Form" class="form-signin">
            <h3 class="form-signin-heading">Форма регестрации</h3>
            <hr class="colorgraph"><br>

            <input type="email" class="form-control" name="email" placeholder="Ваш e-mail" required="" autofocus="" />
            <input type="password" class="form-control" name="password" placeholder="Пароль" required=""/>
            <input type="password" class="form-control" name="submit_password" placeholder="Подтвердите пароль" required=""/>

            <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Зарегистрироваться</button>
        </form>
    </div>
</div>


</body>
</html>
