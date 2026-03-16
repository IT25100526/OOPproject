<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.drivingschool.model.UserAccount" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard – Driving School</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body class="bg-light">

<%@ include file="navbar.jsp" %>

<%
    UserAccount user = (UserAccount) session.getAttribute("loggedUser");
    if (user == null) { response.sendRedirect(request.getContextPath() + "/login"); return; }
%>

<div class="container py-5">
    <h3 class="mb-1 fw-bold">Welcome, <%= user.getUsername() %> 👋</h3>
    <p class="text-muted mb-4">Role: <span class="badge bg-primary"><%= user.getRole() %></span></p>

    <div class="row g-4">
        <!-- Students -->
        <div class="col-md-3">
            <div class="card text-white bg-primary shadow-sm h-100">
                <div class="card-body text-center">
                    <h2 class="display-5 fw-bold">🎓</h2>
                    <h6 class="card-title">Manage Students</h6>
                    <a href="${pageContext.request.contextPath}/register?action=list"
                       class="btn btn-light btn-sm mt-2">View All</a>
                </div>
            </div>
        </div>
        <!-- Schedules -->
        <div class="col-md-3">
            <div class="card text-white bg-success shadow-sm h-100">
                <div class="card-body text-center">
                    <h2 class="display-5 fw-bold">📅</h2>
                    <h6 class="card-title">Lesson Schedules</h6>
                    <a href="${pageContext.request.contextPath}/schedule?action=list"
                       class="btn btn-light btn-sm mt-2">View All</a>
                </div>
            </div>
        </div>
        <!-- Instructors -->
        <div class="col-md-3">
            <div class="card text-white bg-warning shadow-sm h-100">
                <div class="card-body text-center">
                    <h2 class="display-5 fw-bold">🧑‍🏫</h2>
                    <h6 class="card-title">Instructors</h6>
                    <a href="${pageContext.request.contextPath}/instructor?action=list"
                       class="btn btn-light btn-sm mt-2">View All</a>
                </div>
            </div>
        </div>
        <!-- Payments -->
        <div class="col-md-3">
            <div class="card text-white bg-danger shadow-sm h-100">
                <div class="card-body text-center">
                    <h2 class="display-5 fw-bold">💳</h2>
                    <h6 class="card-title">Payments</h6>
                    <a href="${pageContext.request.contextPath}/payment"
                       class="btn btn-light btn-sm mt-2">View All</a>
                </div>
            </div>
        </div>
    </div>

    <% if ("Admin".equals(user.getRole())) { %>
    <div class="mt-5">
        <h5 class="text-muted">Quick Actions</h5>
        <div class="d-flex gap-2 flex-wrap mt-2">
            <a href="${pageContext.request.contextPath}/register" class="btn btn-outline-primary">+ New Student</a>
            <a href="${pageContext.request.contextPath}/schedule"  class="btn btn-outline-success">+ Book Lesson</a>
            <a href="${pageContext.request.contextPath}/instructor" class="btn btn-outline-warning">+ Add Instructor</a>
        </div>
    </div>
    <% } %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
