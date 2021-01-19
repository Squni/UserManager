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