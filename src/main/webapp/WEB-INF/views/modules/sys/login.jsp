<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>登录页面</title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<%@include file="/WEB-INF/views/include/head.jsp"%>
		<%@include file="/WEB-INF/views/include/aceHead.jsp"%>
		<script type="text/javascript">
			jQuery(function($) {
				//忘记密码,和注册用户
				$(document).on('click', '.toolbar a[data-target]', function(e) {
					e.preventDefault();
					var target = $(this).data('target');
					$('.widget-box.visible').removeClass('visible');//hide others
					$(target).addClass('visible');//show target
				});
			});

				
			//更改背景主题
			jQuery(function($) {
					$('#btn-login-dark').on('click', function(e) {
						$('body').attr('class', 'login-layout');
						$('#id-text2').attr('class', 'white');
						$('#id-company-text').attr('class', 'blue');
						
						e.preventDefault();
					});
					$('#btn-login-light').on('click', function(e) {
						$('body').attr('class', 'login-layout light-login');
						$('#id-text2').attr('class', 'grey');
						$('#id-company-text').attr('class', 'blue');
						
						e.preventDefault();
					});
					$('#btn-login-blur').on('click', function(e) {
						$('body').attr('class', 'login-layout blur-login');
						$('#id-text2').attr('class', 'white');
						$('#id-company-text').attr('class', 'light-blue');
						
						e.preventDefault();
					});
				 
			});
			
			//登录
			jQuery(function($) {
				$("#loginBtn").click(function(){
					location.href = '${ctx}/doLogin';
				});
			});
			
		</script>
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i> 
									<span class="red">${fns:getConfig('productName')}</span>
									<span class="white" id="id-text2">系统</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; ${fns:getConfig('company')}</h4>
							</div>
	
							<div class="space-6"></div>
	
							<div class="position-relative">
								<div id="login-box"	class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i> 
												请输入用户信息
											</h4>
	
											<div class="space-6"></div>
	
											<form>
												<fieldset>
													<label class="block clearfix"> 
														<span class="block input-icon input-icon-right"> 
															<input type="text" class="form-control" placeholder="用户名" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label> 
													<label class="block clearfix"> 
														<span class="block input-icon input-icon-right">
														<input type="password" class="form-control" placeholder="密码" />
														<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
	
													<div class="space"></div>
	
													<div class="clearfix">
														<label class="inline"> 
															<input type="checkbox" class="ace" />
															<span class="lbl">记住登录</span>
														</label>
	
														<button id="loginBtn" type="button" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i> 
															<span class="bigger-110">登录</span>
														</button>
													</div>
	
													<div class="space-4"></div>
												</fieldset>
											</form>
	
											<div class="social-or-login center">
												<span class="bigger-110">其他登录方式</span>
											</div>
	
											<div class="space-6"></div>
	
											<div class="social-login center">
												<a class="btn btn-primary">
													<i class="ace-icon fa fa-facebook"></i>
												</a> 
												<a class="btn btn-info">
													<i class="ace-icon fa fa-twitter"></i>
												</a> 
												<a class="btn btn-danger">
													<i class="ace-icon fa fa-google-plus"></i>
												</a>
											</div>
										</div>
										<!-- /.widget-main -->
	
										<div class="toolbar clearfix">
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link"> 
													<i class="ace-icon fa fa-arrow-left"></i> 
													忘记密码
												</a>
											</div>
	
											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link"> 
													注册用户
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div>
									<!-- /.widget-body -->
								</div>
								<!-- /.login-box -->
								
								<!-- 忘记密码 -->
								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="ace-icon fa fa-key"></i> 
												重置密码
											</h4>
	
											<div class="space-6"></div>
											<p>请输入注册邮箱</p>
	
											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
														<input type="email" class="form-control" placeholder="邮箱" />
														<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
	
													<div class="clearfix">
														<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="ace-icon fa fa-lightbulb-o"></i>
															<span class="bigger-110">发送</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div>
										<!-- /.widget-main -->
	
										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
											返回登录
											<i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div>
									<!-- /.widget-body -->
								</div>
								<!-- /.forgot-box -->
	
								<!-- 用户注册 -->
								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i> 
												注册新用户
											</h4>
	
											<div class="space-6"></div>
											<p>请输入用户详细资料:</p>
	
											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="邮箱" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label> 
													<label class="block clearfix"> 
														<span class="block input-icon input-icon-right"> 
															<input type="text" class="form-control" placeholder="用户名" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<label class="block clearfix"> 
														<span class="block input-icon input-icon-right"> 
															<input type="password" class="form-control" placeholder="密码" /> 
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label> 
													<label class="block clearfix"> 
														<span class="block input-icon input-icon-right"> 
															<input type="password" class="form-control" placeholder="确认密码" /> 
															<i class="ace-icon fa fa-retweet"></i>
														</span>
													</label> 
													<label class="block"> 
														<input type="checkbox" class="ace" />
														<span class="lbl">
															同意
															<a href="#">"服务条款"</a>
														</span>
													</label>
	
													<div class="space-24"></div>
	
													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i> 
															<span class="bigger-110">重置</span>
														</button>
	
														<button type="button" class="width-65 pull-right btn btn-sm btn-success">
															<span class="bigger-110">注册</span> 
															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>
	
										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link"> 
											<i class="ace-icon fa fa-arrow-left"></i>
											返回注册
											</a>
										</div>
									</div>
									<!-- /.widget-body -->
								</div>
								<!-- /.signup-box -->
							</div>
							<!-- /.position-relative -->
							
							<!-- 选择主题 -->
							<div class="navbar-fixed-top align-right">
								<br /> &nbsp; <a id="btn-login-dark" href="#">黑色</a> 
								&nbsp; <span class="blue">/</span> &nbsp; <a id="btn-login-blur" href="#">灰暗</a>
								&nbsp; <span class="blue">/</span> &nbsp; <a id="btn-login-light" href="#">明亮</a> &nbsp; &nbsp; &nbsp;
							</div>
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.main-content -->
		</div>
		<!-- /.main-container -->
	
	</body>
</html>
