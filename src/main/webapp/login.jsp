<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login – DriveSchool</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="login-page">
    <div class="login-card">
        <div class="login-logo">
            <div class="icon">🚗</div>
            <h2>DriveSchool</h2>
            <p>Sign in to your account</p>
        </div>

        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger">⚠️ <%= request.getAttribute("error") %></div>
        <% } %>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label class="form-label">Username</label>
                <input type="text" name="username" class="form-control" required placeholder="Enter your username" autofocus>
            </div>
            <div class="form-group">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" required placeholder="Enter your password">
            </div>
            <button type="submit" class="btn btn-primary" style="width:100%;justify-content:center;padding:11px;">
                Sign In →
            </button>
        </form>

        <p style="text-align:center;margin-top:20px;color:#64748b;font-size:13px;">
            New student?
            <a href="${pageContext.request.contextPath}/register" style="color:#2563eb;font-weight:600;">Register here</a>
        </p>
    </div>
</div>
</body>
</html>
