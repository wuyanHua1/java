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
                        <i class="fa fa-user fa-fw"></i><strong><%=request.getParameter("userID") %></strong> <i class="fa fa-caret-down"></i>
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
                        <a href="#page-Manager"><i class="fa fa-bar-chart-o"></i>修改密码</a>
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
                             	<p>图书信息</p>
                             	<form role="form">
                        			<button type="button" class="btn btn-primary" id="BookSearchFileDownload">下载表格</button>
                        		</form>
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
                                    <!-- 使用ajax和服务器请求填入搜索结果 -->
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
                     	<br/>
	                    <div class="col-lg-6">
		                     <form role="form" id="deleteBookForm">
                                   <div class="" id="deleteBookIDClass">
                                        <label class="control-label" for="inputSuccess">输入图书编号</label>
                                        <br/>
                                           <input type="text" class="form-control" id="deleteBookIDValues">
                                           <span id="DeleteBookalert"></span>
                                   </div>
                                   <br/>
                                   <!-- "form-group has-error" form-group has-success-->
                                   <button type="button" class="btn btn-primary" id="deleteBookButton">确认删除</button>
                             </form>
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
	                     <form role="form" id="InsertBookForm">
                                   <div>
                                        <label class="control-label">图书名</label>
                                        <br/>
                                           <input type="text" class="form-control" id="InsertBookNameValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">图书出版商</label>
                                        <br/>
                                           <input type="text" class="form-control" id="InsertBookPublisherValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">图书类别</label>
                                        <br/>
                                           <input type="text" class="form-control" id="InsertBookTypeValues">
                                   </div>
                                   <br/>
                                   <!-- "form-group has-error" form-group has-success-->
                                   <button type="button" class="btn btn-primary" id="InsertBookButton">确认添加</button>
                         </form>
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
	                     <form role="form" id="UpdateBookForm">
	                     			<div>
                                        <label class="control-label">图书编号</label>
                                        <br/>
                                           <input type="text" class="form-control" id="UpdateBookIDValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">图书名</label>
                                        <br/>
                                           <input type="text" class="form-control" id="UpdateBookNameValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">图书出版商</label>
                                        <br/>
                                           <input type="text" class="form-control" id="UpdateBookPublisherValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">图书类别</label>
                                        <br/>
                                           <input type="text" class="form-control" id="UpdateBookTypeValues">
                                   </div>
                                   <br/>
                                   <!-- "form-group has-error" form-group has-success-->
                                   <button type="button" class="btn btn-primary" id="UpdateBookButton">确认修改</button>
                         </form>
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
                    	<h2>借书</h2>
                    	<br/>
	                     <form role="form" id="LendBookForm">
	                     			<div>
                                        <label class="control-label">图书编号</label>
                                        <br/>
                                           <input type="text" class="form-control" id="LendBookIDValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">读者编号</label>
                                        <br/>
                                           <input type="text" class="form-control" id="LendReaderIDValues">
                                   </div>
                                   <br/>
                                   <!-- "form-group has-error" form-group has-success-->
                                   <button type="button" class="btn btn-primary" id="LendBookButton">确认借出</button>
                         </form>
                         <br/>
                         <h2>还书</h2>
                         <br/>
	                     <form role="form" id="UpdateBookForm">
	                     			<div>
                                        <label class="control-label">图书编号</label>
                                        <br/>
                                           <input type="text" class="form-control" id="ReturnBookIDValues">
                                   </div>
                                   <br/>
                                   <!-- "form-group has-error" form-group has-success-->
                                   <button type="button" class="btn btn-primary" id="ReturnBookButton">确认还书</button>
                         </form>
	                </div>
             	</div>
                <!-- /. ROW  -->
			</div>
			<!--修改密码-->
			<div id="page-Manager">
			 	<div class="row">
                    	<div class="col-md-12">
	                        <h1 class="page-header">
	                            	修改密码<!-- <small>Create new page.</small>-->
	                        </h1>
                     	</div>
                    <div class="col-lg-6">
                    <form role="form" id="ResetPasswordForm">
                    				<div>
                                        <label class="control-label">管理员用户ID</label>
                                        <br/>
                                           <input type="text" readonly class="form-control" id="ManagerIDValues" value="<%=request.getParameter("userID") %>">
                                   </div>
                                   
	                     			<div>
                                        <label class="control-label">旧密码</label>
                                        <br/>
                                           <input type="password" class="form-control" id="OlderPasswordValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">新密码</label>
                                        <br/>
                                           <input type="password" class="form-control" id="NewPasswordValues">
                                   </div>
                                   <br/>
                                   <div>
                                        <label class="control-label">确认新密码</label>
                                        <br/>
                                           <input type="password" class="form-control" id="AgainNewPasswordValues">
                                   </div>
                                   <br/>
                                   <!-- "form-group has-error" form-group has-success-->
                                   <button type="button" class="btn btn-primary" id="ResetPasswordButton">确认修改</button>
                         </form>
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
