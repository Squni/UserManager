<%@include file="/user/header.jsp" %>
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
<%@include file="/user/footer.jsp" %>


