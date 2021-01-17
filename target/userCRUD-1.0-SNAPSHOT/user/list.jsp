<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>userCRUD - Home page</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet">
    <link
            href="<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"/>"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">

</head>

<%@include file="/user/header.jsp" %>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">userCRUD</h1>
    <a href="/users/add" class="d-none d-lg-inline-block btn btn-lg btn-success shadow-lg"><i
            class="fas fa-check text-white-50"></i> Create user</a>
</div>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="mb-0 font-weight-bold text-primary">Users list</h6>
    </div>
    <div class="card-body">
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn-info btn-circle fas fa-info-circle" href="/users/show?id=${user.id}"></a>
                        <a class="btn-warning btn-circle fas fa-exclamation-triangle"
                           href="/users/edit?id=${user.id}"></a>
                        <a class="btn-circle btn-danger fas fa fa-trash"
                           href="/users/delete?id=${user.id}"></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<!-- End of Main Content -->
<%@include file="/user/footer.jsp" %>