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
    <a href="/users/list" class="d-none d-lg-inline-block btn btn-lg btn-success shadow-lg"><i
            class="fas fa-check text-white-50"></i> Users list</a>
</div>

<c:if test="${cannotEdit != null}"><font color="red">${cannotEdit}<br/><br/></font></c:if>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="mb-0 font-weight-bold text-primary">Edit user</h6>
    </div>
    <div class="col-lg-6 ">
        <table class="card-body table table-bordered">
            <form role="form" method="post">
                <div class="form-group">
                    <br/>
                    <input class="form-control" type="hidden" name="id" value="${editUser.id}">
                    <input class="form-control" type="hidden" name="password" value="${editUser.password}">
                    <label>Username: </label>
                    <input class="form-control" required="required" type="text" name="userName" value="${editUser.userName}"
                           placeholder="${editUser.userName}"
                           pattern="[A-Za-z0-9]{5,20}">
                    <br/>
                    <label>Email: </label>
                    <input class="form-control" required="required" type="email" name="email" value="${editUser.email}"
                           placeholder="${editUser.email}">
                    <br/>
                    <label>New password: </label>
                    <input class="form-control" type="password" name="newPassword"
                           placeholder="8-20 characters" pattern="[A-Za-z0-9]{8,20}">
                    <br/>
                    <label>Confirm password: </label>
                    <input class="form-control" type="password" name="passwordConf">
                    <br/>
                    <input class="btn-success btn" type="submit" value="Submit" >
                </div>
            </form>
        </table>
    </div>
    <p><c:if test="${userEdited != null}"><font color="#adff2f">${userEdited}<br/><br/></font></c:if></p>

</div>
<!-- End of Main Content -->
<%@include file="/user/footer.jsp" %>