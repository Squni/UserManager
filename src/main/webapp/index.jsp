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


