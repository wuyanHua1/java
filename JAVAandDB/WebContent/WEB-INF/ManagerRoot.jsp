<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>图书管理系统</title>
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
                <a class="navbar-brand" href="#"><i class="fa fa-gear"></i> <strong>图书管理</strong></a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i><strong><%=request.getParameter("userName") %></strong> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="Index.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
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
                     <li>
                        <a href="#page-delete"><i class="fa fa-table"></i>删除图书</a>
                    </li>
                    <li>
                        <a href="#page-insert"><i class="fa fa-qrcode"></i>添加图书</a>
                    </li>
                    <li>
                        <a href="#page-update"><i class="fa fa-bar-chart-o"></i>修改图书信息</a>
                    </li>
                    <li>
                        <a href="#page-LendandReturn"><i class="fa fa-bar-chart-o"></i>图书借还</a>
                    </li>
                    <li>
                        <a href="#page-Manager"><i class="fa fa-bar-chart-o"></i>管理员信息</a>
                    </li>
                    <li>
                        <a href="#page-insertManager"><i class="fa fa-user fa-fw"></i>添加管理员 </a>
                    </li>
                    <li>
                        <a href="#page-deleteManager"><i class="fa fa-user fa-fw"></i>删除管理员 </a>
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
	                     <div class="form-group">
		                     <input class="form-control" placeholder="书名/作者/编号">
		                     <button type="submit" class="btn btn-default">查询</button>
	                     </div>
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
                                            <th>Rendering engine</th>
                                            <th>Browser</th>
                                            <th>Platform(s)</th>
                                            <th>Engine version</th>
                                            <th>CSS grade</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                        </tr>
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
			<!--删除图书-->
			<div id="page-delete">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                           	 删除图书<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">
	                     
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
			<!--添加图书-->
			<div id="page-insert">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                            	添加图书<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">
	                     
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
			<!--修改图书信息-->
			<div id="page-update">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                            	修改图书信息<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">
	                     
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
			<!--图书借还-->
			<div id="page-LendandReturn">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                           	图书借还<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
			<!--管理员信息-->
			<div id="page-Manager">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                            	管理员信息<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
			<!--添加管理员-->
			<div id="page-insertManager">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                            	添加管理员<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">  
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
			<!--删除管理员-->
			<div id="page-deleteManager">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                            	删除管理员<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">  
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
        </div>
         <!-- /. PAGE WRAPPER  -->
          <footer><p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p></footer>
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!--datatable script-->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
                });
    </script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

   
</body>
</html>
