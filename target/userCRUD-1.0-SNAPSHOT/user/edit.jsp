<%@include file="/user/header.jsp" %>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">userCRUD</h1>
    <a href="/users/list" class="d-none d-lg-inline-block btn btn-lg btn-success shadow-lg"><i
            class="fas fa-check text-white-50"></i> Users list</a>
</div>

<div style="color:Red"><c:if test="${cannotEdit != null}">${cannotEdit}<br/><br/></c:if></div>
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