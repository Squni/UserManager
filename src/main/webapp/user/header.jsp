<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index.jsp">
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
            <div class="container-fluid">
