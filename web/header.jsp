<%@page import="model.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%! User currentUser;%>
<%
    if (session.getAttribute("currentSessionUser") != null) {
        currentUser = (User) (session.getAttribute("currentSessionUser"));
    }
%>

<html class="no-js"> 
    <head>
        <meta charset="utf-8">
        <title>Circle</title>
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width" />

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/normalize.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/templatemo_misc.css">
        <link rel="stylesheet" href="css/templatemo_style.css">

        <script src="js/vendor/modernizr-2.6.2.min.js"></script>
    <body>

        <div class="bg-overlay"></div>

        <div class="container-fluid">
            <div class="row">

                <div class="col-md-4 col-sm-12">
                    <div class="sidebar-menu">

                        <div class="logo-wrapper">
                            <h1 class="logo">
                                <a rel="nofollow" href="http://localhost:8080/Circle/">
                                    <img src="images/logo.png" alt="Circle">
                                    <span class="banner">Tel-U Students Insurance Claim Online</span>
                                    <span>
                                        <% if (session.getAttribute("currentSessionUser") == null) {
                                                currentUser = null;
                                            } else {%>
                                        <%= currentUser.getUsername() + " | " + currentUser.getFullname()%>
                                        <%= currentUser.getEmail()%>
                                        <% }%>
                                    </span>
                                </a>
                            </h1>
                        </div> <!-- /.logo-wrapper -->

                        <div class="menu-wrapper">
                            <ul class="menu">
                                <li><a class="homebutton" href="#">Home</a></li>
                                <li><a class="show-0" href="#">Claim</a></li>
                                    <% if (session.getAttribute("currentSessionUser") == null) {%>
                                <li><a class="show-1" href="#">About</a></li>
                                <li><a class="show-2" href="#">Services</a></li>
                                <li><a class="show-3" href="#">Contact</a></li>
                                    <% } else {%>
                                <li><a rel="nofollow" href="Logout">Logout</a></li>
                                    <% }%>
                            </ul> <!-- /.menu -->
                            <a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
                        </div> <!-- /.menu-wrapper -->

                    </div> <!-- /.sidebar-menu -->
                </div> <!-- /.col-md-4 -->