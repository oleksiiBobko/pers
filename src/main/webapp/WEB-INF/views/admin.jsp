<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="persApp">
<head>
    <meta charset="utf-8" />
    <title>AngularJS User Registration and Login Example</title>
    <link href="admin/app-content/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="admin/app-content/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="admin/app-content/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="admin/app-content/css/main.css" rel="stylesheet" type="text/css" />
<!--     <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" /> -->
    <link href="admin/app-content/app.css" rel="stylesheet" />
</head>
<body class="home" ng-app="persApp">
    <div class="jumbotron">
        <div class="container">
            <div class="col-sm-8 col-sm-offset-2">
                <div ng-class="{ 'alert': flash, 'alert-success': flash.type === 'success', 'alert-danger': flash.type === 'error' }" ng-if="flash" ng-bind="flash.message"></div>
                <div ng-view></div>
            </div>
        </div>
    </div>
    <div class="credits text-center">
        <p>
            <h4>footer</h4>
        </p>
    </div>

    <script type="text/javascript" src="admin/app-content/js/jquery.min.js"></script>
    <script type="text/javascript" src="admin/app-content/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="admin/app-content/js/angular.min.js"></script>
    <script type="text/javascript" src="admin/app-content/js/angular-route.min.js"></script>
    <script src="//code.angularjs.org/1.6.0/angular-cookies.min.js"></script>
 
    <script type="text/javascript" src="admin/app.js"></script>
 <!--    <script type="text/javascript" src="admin/app/route/route.js"></script> -->
    <script type="text/javascript" src="admin/app-services/user.service.js"></script>
 <!--    <script type="text/javascript" src="admin/app/controller/user.controller.js"></script> -->
    <script type="text/javascript" src="admin/app-services/authentication.service.js"></script>
    <script type="text/javascript" src="admin/app-services/flash.service.js"></script>
    <script type="text/javascript" src="admin/app-services/user.service.local-storage.js"></script>

    <!-- <script src="app-services/user.service.js"></script> -->

    <!-- Fake user service for demo that uses local storage -->

    <script src="admin/home/home.controller.js"></script>
    <script src="admin/login/login.controller.js"></script>
    <script src="admin/register/register.controller.js"></script>
</body>
</html>



<!-- <html> -->
<!-- <head> -->
<!-- <link href="admin/app-content/css/font-awesome.min.css" rel="stylesheet" type="text/css"/> -->
<!-- <link href="admin/app-content/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> -->
<!-- <link href="admin/app-content/css/bootstrap.css" rel="stylesheet" type="text/css" /> -->
<!-- <link href="admin/app-content/css/main.css" rel="stylesheet" type="text/css" /> -->

<!-- </head> -->
<!-- <body class="home" ng-app="persApp"> -->

<!-- <nav class="navbar navbar-default navbar-inverse" role="navigation"> -->
<!--   <div class="container-fluid"> -->
<!--     Brand and toggle get grouped for better mobile display -->
<!--     <div class="navbar-header"> -->
<!--       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> -->
<!--         <span class="sr-only">Toggle navigation</span> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--       </button> -->
<!--     </div> -->

<!--     Collect the nav links, forms, and other content for toggling -->
<!--     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> -->
<!--       <ul class="nav navbar-nav navbar-right"> -->
<!--         <li class="dropdown"> -->
<!--           <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a> -->
<!--             <ul id="login-dp" class="dropdown-menu"> -->
<!--                 <li> -->
<!--                      <div class="row"> -->
<!--                             <div class="col-md-12"> -->
<!--                                  <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav"> -->
<!--                                         <div class="form-group"> -->
<!--                                              <label class="sr-only" for="exampleInputEmail2">Email address</label> -->
<!--                                              <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required> -->
<!--                                         </div> -->
<!--                                         <div class="form-group"> -->
<!--                                              <label class="sr-only" for="exampleInputPassword2">Password</label> -->
<!--                                              <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required> -->
<!--                                              <div class="help-block text-right"><a href="">Forget the password ?</a></div> -->
<!--                                         </div> -->
<!--                                         <div class="form-group"> -->
<!--                                              <button type="submit" class="btn btn-primary btn-block">Sign in</button> -->
<!--                                         </div> -->
<!--                                         <div class="checkbox"> -->
<!--                                              <label> -->
<!--                                              <input type="checkbox"> keep me logged-in -->
<!--                                              </label> -->
<!--                                         </div> -->
<!--                                  </form> -->
<!--                             </div> -->
<!--                             <div class="bottom text-center"> -->
<!--                                 New here ? <a href="#"><b>Join Us</b></a> -->
<!--                             </div> -->
<!--                      </div> -->
<!--                 </li> -->
<!--             </ul> -->
<!--         </li> -->
<!--       </ul> -->
<!--     </div>/.navbar-collapse -->
<!--   </div>/.container-fluid -->
<!-- </nav> -->
<!--     <div class="container-fluid display-table"> -->
<!--         <div class="row display-table-row"> -->
<!--             <div class="col-md-2 col-sm-1 hidden-xs display-table-cell v-align box" id="navigation"> -->
<!--                 <div class="logo"> -->
<!--                     <a href="main"></a> -->
<!--                 </div> -->
<!--                 <div class="navi"> -->
<!--                     <ul> -->
<!--                         <li class="active"><a href="#!/home"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Home</span></a></li> -->
<!--                         <li><a href="#!/users"><i class="fa fa-calendar" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Users</span></a></li> -->
<!--                         <li><a href="#!/settings"><i class="fa fa-cog" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Setting</span></a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div class="col-md-10 col-sm-11 display-table-cell v-align"> -->
<!--                 <div class="row"> -->
<!--                     <header> -->
<!--                         <div class="col-md-7"> -->
<!--                             <nav class="navbar-default pull-left"> -->
<!--                                 <div class="navbar-header"> -->
<!--                                     <button type="button" class="navbar-toggle collapsed" data-toggle="offcanvas" data-target="#side-menu" aria-expanded="false"> -->
<!--                                         <span class="sr-only">Toggle navigation</span> -->
<!--                                         <span class="icon-bar"></span> -->
<!--                                         <span class="icon-bar"></span> -->
<!--                                         <span class="icon-bar"></span> -->
<!--                                     </button> -->
<!--                                 </div> -->
<!--                             </nav> -->
<!--                             <div class="search hidden-xs hidden-sm"> -->
<!--                                 <input type="text" placeholder="Search" id="search"> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </header> -->
<!--                 </div> -->
<!--                 <div class="user-dashboard"> -->
<!--                     <ng-view></ng-view> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->

<!-- <script type="text/javascript" src="admin/app-content/js/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="admin/app-content/js/bootstrap.min.js"></script> -->
<!-- <script type="text/javascript" src="admin/app-content/js/angular.min.js"></script> -->
<!-- <script type="text/javascript" src="admin/app-content/js/angular-route.min.js"></script> -->

<!-- <script type="text/javascript" src="admin/app/app.js"></script> -->
<!-- <script type="text/javascript" src="admin/app/route/route.js"></script> -->
<!-- <script type="text/javascript" src="admin/app/service/user.service.js"></script> -->
<!-- <script type="text/javascript" src="admin/app/controller/user.controller.js"></script> -->
<!-- </body> -->
<!-- </html> -->