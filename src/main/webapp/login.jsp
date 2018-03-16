<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css" type="text/css" />
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="POST">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" value="${param.username}" />

        <label for="password">Password</label>
        <input type="password" name="password" id="password" />

        <label for="submit"><label>
        <input type="submit" id="submit" value="Login" />
    </form>
</body>
</html>