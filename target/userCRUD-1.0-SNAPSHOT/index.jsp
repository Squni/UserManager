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

<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
            <div class="sidebar-brand-text mx-3">userCRUD</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <c:if test="${permission != null}">
        <li class="nav-item active">
            <a class="nav-link" href="/users/list">
                <i class="fas fa-fw fa-list"></i>
                <span>Show all users</span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/users/search"> <!--TODO: Search servlet-->
                <i class="fas fa-fw fa-search"></i>
                <span>Search user</span></a>
        </li>
        </c:if>
        <li class="nav-item active">
            <a class="nav-link" href="/logout">
                <i class="fas fa-fw fa-sign-out-alt"></i>
                <span>Logout</span></a>
        </li>
        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

            </nav>
            <!-- End of Topbar -->
            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Home page</h1>
                    <c:if test="${permission != null}">
                    <a href="/users/add" class="d-none d-lg-inline-block btn btn-lg btn-success shadow-lg"><i
                            class="fas fa-check text-white-50"></i> Create user</a>
                    </c:if>
                </div>
            </div>
            <!-- End of Container Fluid -->
            <div class="card-body">
                <table class="table table-hover">
                    <tr>
                        <th>Id</th>
                        <td>${showUser.id}</td>
                    </tr>
                    <tr>
                        <th>User name</th>
                        <td>${showUser.userName}</td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>${showUser.email}</td>
                    </tr>

                </table>
            </div>
        </div>
        <!-- End of Main Content -->

        <!-- End of Main Content -->
        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->


