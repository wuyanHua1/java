<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>图书查找系统</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper"  data-spy="scroll" data-target="#myScroll" data-offset="20">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><i class="fa fa-gear"></i> <strong>图书查询系统</strong></a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a href="Login.jsp" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i><strong>登录</strong>
                    </a>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav id="myScroll" class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a class="active-menu" href="#page-search"><i class="fa fa-fw fa-file"></i> 查找图书信息</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
        	<!--查找图书-->
            <div id="page-search">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            	查找图书<!-- <small>Create new page.</small>-->
                        </h1>
                     </div>
                     <div class="col-lg-6">
	                     <form role="form">
		                     <div class="form-group input-group">
			                     <input class="form-control" placeholder="书名" id="Search">
			                     <span class="input-group-btn">
	                                   <button class="btn btn-default" type="button" id="SearchButton"><i class="fa fa-search"></i></button>
	                             </span>
		                     </div>
		                 </form>
	                 </div>
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             	图书信息
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>书籍编号</th>
                                            <th>书名</th>
                                            <th>类别</th>
                                            <th>出版商</th>
                                            <th>状态</th>
                                        </tr>
                                    </thead>
                                    <tbody id="SearchTable">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--End Advanced Tables -->
             	</div>
             </div>
                <!-- /. ROW  -->
			</div>
     	</div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <script type="text/javascript" src="js/AJAX.js"></script>
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
    </div>
   
</body>
</html>
