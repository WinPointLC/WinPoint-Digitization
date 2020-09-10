<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

	<head>
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" type="text/css">
	  <title>Employee Dashboard</title>
	  <!-- Required meta tags -->
	  <meta charset="utf-8">
	  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	  <!--     Fonts and icons     -->
	  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	  <link rel="stylesheet" href="../assets/css/fontawesome.min.css">
	  <!-- Material Kit CSS -->
	  <link href="../assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet"/>
	  <!-- own CSS -->
	  <link href="../css/employee_new_2.css" rel="stylesheet" />
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	  <link rel="stylesheet" href="../assets/css/magnific-popup.css" media="screen" />
	  <!--<script>
		 <c:import url="/FeeDetailsServlet" />
		 <c:set var="unpaidStudentsList" value="${requestScope.unpaidStudentsList}" />
	  </script>-->
	  <SCRIPT src="http://java.com/js/dtjava.js"></SCRIPT>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/js/WinPointScripts.js"></script>

	</head>

	<body>
		<div class="wrapper ">
		<!--Sidebar-->
			<div class="sidebar" data-color="purple" data-background-color="white">
				<div class="logo">
				  <a href="http://www.winpointlc.com" class="simple-text logo-normal">
					WinPoint
				  </a>
				</div>
				<div class="sidebar-wrapper">
					<ul class="nav">
						<li class="nav-item active  ">
						  <a class="nav-link" id="Employee-link">
							<i class="material-icons">dashboard</i>
							<p> Employee Dashboard</p>
						  </a>
						</li>
						<li class="nav-item">
						  <a class="nav-link" id="add-new-user-link">
							<i class="material-icons">person</i>
							<p>Add new User</p>
						  </a>
						</li>

						<li class="nav-item">
						  <a class="nav-link" id="all-user-link">
							<i class="material-icons">group</i>
							<p>All User's</p>
						  </a>
						</li>
						<li>
						  <a class="nav-link" id="add-new-question-link">
							<i class="material-icons">computer</i>
							<p>Add Questions</p>
						  </a>
						</li>
						<li>
						  <a class="nav-link" href="#" id="fee-register-link">
							<i class="material-icons">attach_money</i>
							<p>Fee Registeration Page</p>
						  </a>
						</li>
						<li>
						  <a class="nav-link" href="#" id="entities-link">
							<i class="material-icons">table_chart</i>
							<p>Add Entity</p>
						  </a>
						</li>
						<li>
						  <a class="nav-link" href="#" id="revenue-tracker-link">
							<i class="material-icons">local_atm</i>
							<p>Revenue Tracker</p>
						  </a>
						</li>
						
					</ul>
				</div>
			</div>
		
		<div class="main-panel">
		<!-- Navbar -->
			<nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<div class="container-fluid">
					<div class="navbar-wrapper">
					  <a class="navbar-brand" href="#pablo">Dashboard</a>
					  <img id="photoId" />
					</div>
					<p id="welcome" style="margin-left:60%; text-transform: uppercase;"></p>
					<button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
					  <span class="sr-only">Toggle navigation</span>
					  <span class="navbar-toggler-icon icon-bar"></span>
					  <span class="navbar-toggler-icon icon-bar"></span>
					  <span class="navbar-toggler-icon icon-bar"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-end">
						<ul class="navbar-nav">
						<li class="nav-item dropdown">
						  <a class="nav-link" href="#pablo" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="material-icons">person</i>
							<p class="d-lg-none d-md-block">
							  Account
							</p>
						  </a>
						  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
							<a class="dropdown-item" href="#" id="user-link">Profile</a>
							<a class="dropdown-item" href="#">Settings</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#" onclick="LogoutSession()">Log out</a>
						  </div>
						  

						</ul>
					</div>
				</div>
			</nav><br><br>
		<!-- End Navbar -->
		
		  
		<div class="content" id="main-content">
			<div class="wrapper" id="d1">
				<div class="content">
				 
					<div id="top_bar">
						<div id="not"><a data-mfp-src="#mymodal_notif" class="modal-btn">ADD NOTIFICATION</a><i class="material-icons d_d" >notification_important</i></div><br>
						<div id="rec"><a>Recent Courses</a><i class="material-icons d_d">arrow_drop_down</i><br></div>
						<div id="cp"><a data-mfp-src="#mymodal" class="modal-btn card-link disabled-link" id="cp-link">Course Participation</a><br></div>
					</div>
					<div id="top-bar"></div>
					<div class="inner-Tech-content" id="Tech-cards"></div>

					<!--Participants graph Modal start-->
					<div id="mymodal" class="mfp-hide modal_styling" role="dialog" aria-labelledby="modal-title" aria-describedby="modal-content">
	 
						<h2 id="modal-title" class="modal-title" tabindex="0">Courses Participation Graph</h2><br>
						
						<div id="modal-content">

							<div style="height:500px; width:500px;">
								<canvas id="barChart_part"></canvas>
							</div>

						</div>
					</div>
					<!--Participants graph Modal end-->

					<!--Notification modal start  -->
					<div id="mymodal_notif" class="mfp-hide modal_styling" role="dialog" aria-labelledby="modal-title" aria-describedby="modal-content">
	 
						<h2 id="modal-title" class="modal-title-notif" tabindex="0">Add Notification</h2><br>
						
						<div id="modal-content">

							<div class="form-group">
								<label for="exampleFormControlTextarea1">Enter Notification message</label>
								<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
							</div>

							<div class="form-group form-file-upload form-file-multiple">
								<input type="file" multiple="" class="inputFileHidden">
								<div class="input-group">
									<input type="text" class="form-control inputFileVisible" placeholder="Choose File">
									<span class="input-group-btn">
										<button type="button" class="btn btn-fab btn-round btn-primary" >
											<i class="material-icons" >attach_file</i>
										</button>
									</span>
								</div>
							</div>
							<center>
								<button type="button" class="btn btn-primary">Submit</button>
							</center>

						</div>
					</div>
					<!--Notification modal end-->

					<!--Marks graph modal start-->
					<div class="modal fade" id="mymodal_marks_graph" >
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h2 id="modal-title" class="modal-title-marks" tabindex="0">Marks of Students</h2>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div style="height:500px; width:500px;">
									<canvas id="barChart"></canvas>
								</div>
							</div>
						</div>
					</div>
					<!--Marks graph modal end-->

					<!--Fees modal start-->
					<div class="modal fade" id="mymodal_fees_try" >
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h2 id="modal-title" class="modal-title" tabindex="0">Fees Status of Students</h2>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									  <div id="student-fees-try"></div>
								</div>						 
							</div>
						</div>
					</div>
					<!--Fees modal end-->

					<!--Attendance modal start-->
					<div class="modal fade" id="mymodal_attendance" >
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h2 id="modal-title" class="modal-title" tabindex="0">Attendance of Students</h2>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div id="student-attendance"></div>
								</div>
								  
							</div>
						</div>
					</div>
					<!--Attendance modal end-->

					<!--Marks table modal start  -->
					<div class="modal fade" id="mymodal_marks_try" >
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h2 id="modal-title" class="modal-title-marks" tabindex="0">Marks of Students</h2>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div id="student-marks"></div>
								</div>
							</div>
						</div>
					</div>
					<!--Marks table modal end -->
					<footer class="footer">
						<div class="container-fluid footer" >
							<nav class="float-left">
							  <ul>
								<li>
								  <a href="https://www.winpointlc.com">
									WinPoint
								  </a>
								</li>
							  </ul>
							</nav>
							<div class="copyright float-right">
							  &copy;
							  <script>
								 document.write(new Date().getFullYear())
							  </script>, made with <i class="material-icons">favorite</i> by
							  <a href="https://www.winpointlc.com" target="_blank">WinPoint Team</a> for a better education.
							</div>
							
						</div>
					</footer>

				</div>
			</div>
		</div> 
		  
		<!-- including all the jsp's  -->
		<div class="Include-jsp" id="iframediv">
			<iframe src="FeeRegistrationPage-New.jsp" width="1000" height="700" id="Fee-jsp"></iframe>
			<iframe src="AllUser.jsp" width="1000" height="700" id="AllUser-jsp"></iframe>
			<iframe src="AddNewUser.jsp" width="1000" height="700" id="AddNewUser-jsp"></iframe>
			<iframe src="AddNewQuestion.jsp" width="1000" height="700" id="AddNewQuestion-jsp"></iframe>
			<iframe src="Entities.jsp" width="1000" height="700" id="Entities-jsp"></iframe>
		
		
		<!-- Script for showing and hiding Jsp  -->
		<script type="text/javascript">
			var userframe;
		 
			document.getElementById('Fee-jsp').style.display="none";
			document.getElementById('AllUser-jsp').style.display="none";
			document.getElementById('AddNewUser-jsp').style.display="none";
			document.getElementById('AddNewQuestion-jsp').style.display="none";
			document.getElementById('Entities-jsp').style.display="none";
		  
			var elem = document.getElementById('User-frame');
			if(elem != null){
				elem.parentNode.removeChild(elem);
			} 
		   
			document.getElementById('Employee-link').onclick=function () {
				document.getElementById('main-content').style.display = "block";
				document.getElementById('AddNewQuestion-jsp').style.display = "none";
				document.getElementById('AddNewUser-jsp').style.display = "none";
				document.getElementById('AllUser-jsp').style.display = "none";
				document.getElementById('Fee-jsp').style.display = "none";
				document.getElementById('Entities-jsp').style.display="none";
			
		   
				var elem = document.getElementById('User-frame');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
			};
			
			document.getElementById('all-user-link').onclick=function() {
				document.getElementById('AllUser-jsp').style.display = "block";
				document.getElementById('main-content').style.display = "none";
				document.getElementById('AddNewQuestion-jsp').style.display="none";
				document.getElementById('AddNewUser-jsp').style.display = "none";
				document.getElementById('Fee-jsp').style.display = "none";
				document.getElementById('Entities-jsp').style.display="none";
			
				var elem = document.getElementById('User-frame');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
			};

			document.getElementById('add-new-user-link').onclick=function() {
				document.getElementById('AddNewUser-jsp').style.display = "block";
				document.getElementById('AllUser-jsp').style.display = "none";
				document.getElementById('main-content').style.display = "none";
				document.getElementById('AddNewQuestion-jsp').style.display="none";
				document.getElementById('Fee-jsp').style.display = "none";
				document.getElementById('Entities-jsp').style.display="none";
		 
				var elem = document.getElementById('User-frame');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
			};

			document.getElementById('add-new-question-link').onclick=function() {
				document.getElementById('AddNewQuestion-jsp').style.display="block";
				document.getElementById('Fee-jsp').style.display = "none";
				document.getElementById('AddNewUser-jsp').style.display = "none";
				document.getElementById('AllUser-jsp').style.display = "none";
				document.getElementById('main-content').style.display = "none";
				document.getElementById('Entities-jsp').style.display="none";

				var elem = document.getElementById('User-frame');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
		 
			};

			document.getElementById('user-link').onclick=function() {
				document.getElementById('AddNewQuestion-jsp').style.display="none";
				document.getElementById('Fee-jsp').style.display = "none";
				document.getElementById('AddNewUser-jsp').style.display = "none";
				document.getElementById('AllUser-jsp').style.display = "none";
				document.getElementById('main-content').style.display = "none";
				document.getElementById('Entities-jsp').style.display="none";
			 
				userframe = document.createElement('iframe');
				userframe.setAttribute('src',jspURL + "User.jsp?varid=");
				userframe.setAttribute('width', 1100);
				userframe.setAttribute('height', 1000);
				userframe.id = 'User-frame';
				userframe.setAttribute('style',"margin-top:10%;");
				document.getElementById('iframediv').appendChild(userframe);
				var source2 = encodeURIComponent(strResJSON);
				var iframe_ele2 = document.getElementById("User-frame");
				iframe_ele2.src = iframe_ele2.src + source2;
			};

			document.getElementById('fee-register-link').onclick=function() {
		 
				document.getElementById('Fee-jsp').style.display = "block";
				document.getElementById('AddNewUser-jsp').style.display = "none";
				document.getElementById('AllUser-jsp').style.display = "none";
				document.getElementById('main-content').style.display = "none";
				document.getElementById('AddNewQuestion-jsp').style.display="none";
				document.getElementById('Entities-jsp').style.display="none";
		 
				var elem = document.getElementById('User-frame');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
		  

			};
			
			document.getElementById('entities-link').onclick=function() {
		 
				
				document.getElementById('Entities-jsp').style.display="block";
				document.getElementById('Fee-jsp').style.display = "none";
				document.getElementById('AddNewUser-jsp').style.display = "none";
				document.getElementById('AllUser-jsp').style.display = "none";
				document.getElementById('main-content').style.display = "none";
				document.getElementById('AddNewQuestion-jsp').style.display="none";
		 
				var elem = document.getElementById('User-frame');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
		  

			};

			document.getElementById('revenue-tracker-link').onclick=function() {
			
				document.getElementById('Fee-jsp').style.display = "none";
				document.getElementById('AddNewUser-jsp').style.display = "none";
				document.getElementById('AllUser-jsp').style.display = "none";
				document.getElementById('main-content').style.display = "none";
				document.getElementById('AddNewQuestion-jsp').style.display="none";
				document.getElementById('Entities-jsp').style.display="none";
				
				var elem = document.getElementById('User-frame');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
			
			};
		
		</script>

		<!--   Core JS Files   -->
		<script src="../assets/js/core/jquery.min.js" type="text/javascript"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="../assets/js/jquery.magnific-popup.min.js"></script>
		<script src="../assets/js/core/popper.min.js"></script>
		<script src="../assets/js/core/bootstrap-material-design.min.js"></script>
		<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
		<!-- Plugin for the momentJs  -->
		<script src="../assets/js/plugins/moment.min.js"></script>
		<!--  Plugin for Sweet Alert -->
		<script src="../assets/js/plugins/sweetalert2.js"></script>
		<!-- Forms Validations Plugin -->
		<script src="../assets/js/plugins/jquery.validate.min.js"></script>
		<!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
		<script src="../assets/js/plugins/jquery.bootstrap-wizard.js"></script>
		<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
		<script src="../assets/js/plugins/bootstrap-selectpicker.js"></script>
		<!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
		<script src="../assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
		<!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
		<script src="../assets/js/plugins/jquery.dataTables.min.js"></script>
		<!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
		<script src="../assets/js/plugins/bootstrap-tagsinput.js"></script>
		<!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
		<script src="../assets/js/plugins/jasny-bootstrap.min.js"></script>
		<!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
		<script src="../assets/js/plugins/fullcalendar.min.js"></script>
		<!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
		<script src="../assets/js/plugins/jquery-jvectormap.js"></script>
		<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
		<script src="../assets/js/plugins/nouislider.min.js"></script>
		<!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
		<!-- Library for adding dinamically elements -->
		<script src="../assets/js/plugins/arrive.min.js"></script>
		<!--  Google Maps Plugin    -->
		<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
		<!-- Chartist JS -->
		<script src="../assets/js/plugins/chartist.min.js"></script>
		<!--  Notifications Plugin    -->
		<script src="../assets/js/plugins/bootstrap-notify.js"></script>
		<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
		<script src="../assets/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
		<!-- Material Dashboard DEMO methods, don't include it in your project! -->
		<script src="../assets/demo/demo.js"></script>
			
		<script>
			$('.form-file-simple .inputFileVisible').click(function() {
				$(this).siblings('.inputFileHidden').trigger('click');
			});

			$('.form-file-simple .inputFileHidden').change(function() {
				var filename = $(this).val().replace(/C:\\fakepath\\/i, '');
				$(this).siblings('.inputFileVisible').val(filename);
			});

			$('.form-file-multiple .inputFileVisible, .form-file-multiple .input-group-btn').click(function() {
				$(this).parent().parent().find('.inputFileHidden').trigger('click');
				$(this).parent().parent().addClass('is-focused');
			});

			$('.form-file-multiple .inputFileHidden').change(function() {
				var names = '';
				for (var i = 0; i < $(this).get(0).files.length; ++i) {
					if (i < $(this).get(0).files.length - 1) {
						names += $(this).get(0).files.item(i).name + ',';
					} 
					else {
						names += $(this).get(0).files.item(i).name;
					}
				}
				$(this).siblings('.input-group').find('.inputFileVisible').val(names);
			});

			$('.form-file-multiple .btn').on('focus', function() {
				$(this).parent().siblings().trigger('focus');
			});

			$('.form-file-multiple .btn').on('focusout', function() {
				$(this).parent().siblings().trigger('focusout');
			});

		</script>

		<script>  
			var streamId = 1;
			var courseTypeId = 1;
			var courseTypeName = "";
			
			var searchString = window.location.search.substring(1);
			var arr = searchString.split('&');
			var data= arr[0].split('=')[1];
			var decodedData = decodeURIComponent(data);
			var data1 = decodedData.substring(0, decodedData.indexOf('}')+1);
			userProfile =  eval('(' + data1 + ')');
			var data2 = decodedData.substring(decodedData.indexOf('}')+1, decodedData.length);
			streamList = eval('(' + data2 + ')');
			
			nav=document.createElement('nav');
			nav.id="tech";
			nav.className="navbar navbar-expand-lg navbar-absolute  sticky-top navbar-light bg-primary";
			div1=document.createElement('div');
			div1.className="container";

			var btn = document.createElement('button');
			btn.className='navbar-toggler';
			btn.setAttribute('type', "button");
			btn.setAttribute('data-toggle', "collapse");
			btn.setAttribute('data-target', "#navbarNav");
			btn.setAttribute('aria-controls',"navbarNav");
			btn.setAttribute('aria-expanded', "false");
			btn.setAttribute('aria-label',"Toggle navigation");

			var sp1 = document.createElement('span');
			var sp2 = document.createElement('span');
			var sp3 = document.createElement('span');
			sp1.className="navbar-toggler-bar navbar-kebab";
			sp2.className="navbar-toggler-bar navbar-kebab";
			sp3.className="navbar-toggler-bar navbar-kebab";
			btn.appendChild(sp1);
			btn.appendChild(sp2);
			btn.appendChild(sp3);

			div1.appendChild(btn);

			div2=document.createElement('div');
			div2.className="collapse navbar-collapse";
			div2.id="navbarNav";

			ul=document.createElement('ul')
			ul.className="navbar-nav";
			ul.id="navbarNav_1";
			
			li_1=document.createElement('li');
			li_1.className="nav-item";
			
			for(i=0;i<streamList.length;i++)
			{
				li_1=document.createElement('li');
				li_1.className="nav-item";
				li_1.id=streamList[i].streamId ;
				li_1.setAttribute('onclick', "getstream(this.id)");
				a_1=document.createElement('a');
			
				a_1.className="nav-link active";
				a_1.id=streamList[i].streamId + 'a';
				a_1.textContent=streamList[i].streamName.toUpperCase().replace("_"," ");

				li_1.appendChild(a_1);
				ul.appendChild(li_1);
			}
			  
			div2.appendChild(ul);
			div1.appendChild(div2);
			nav.appendChild(div1);
			document.getElementById('top-bar').appendChild(nav);
			
			var streamElem = document.getElementById(streamList[0].streamId);
			streamElem.className='nav-item active stream';

			var div3=document.createElement('div');
			div3.className="col-md-6";
			var div_cd=document.createElement('div');
			div_cd.className="card";
			div_cd.id="card_body";
			var div_cb=document.createElement('div');
			div_cb.className="card-body";
			div_cb.id="card_con";

			var dropdown = document.createElement('div');
			dropdown.className="dropdown";
			dropdown.id="drop-down";
			
			div_cb.appendChild(dropdown);
			div_cd.appendChild(div_cb);
			div3.appendChild(div_cd);
			document.getElementById('top-bar').appendChild(div3);
		  
			getstream(streamList[0].streamId);
			displayStreamCourses(courseTypeId, courseTypeName);
		   

			function getstream(stream_id){
				streamId = stream_id; 
				var elem = document.getElementById('dropdownMenu_1');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
				var elem = document.getElementById('dropdownMenuButton_1');
				if(elem != null){
					elem.parentNode.removeChild(elem);
				} 
				var prevElem = document.getElementsByClassName("nav-item active stream");
				prevElem.className='nav-item';
				var i;
				for (i = 0; i < prevElem.length; i++) {
					prevElem[i].className='nav-item';
				} 
				var streamElem = document.getElementById(streamList[streamId-1].streamId);
				streamElem.className='nav-item active stream';
				 
				var myData = {
					streamId: streamId
				};
				
				$.ajax({
					type: 'POST',
					url: servletURL + 'StreamCourseTypeServlet',
					data: JSON.stringify(myData),
					dataType: 'json',
					contentType: 'application/json; charset=utf-8',
					traditional: true,
					success: function (jsonObj) {
						var courseTypesList=jsonObj[0];

						var btn = document.createElement('button');
						btn.className='btn btn-secondary dropdown-toggle';
						btn.id='dropdownMenuButton_1';
						btn.setAttribute('data-toggle', "dropdown");
						btn.setAttribute('aria-haspopup', "true");
						btn.setAttribute('aria-expanded',"false");
						btn.textContent="Course Type";
						document.getElementById('drop-down').appendChild(btn);
					 
						var dropdownMenu = document.createElement('div');
						dropdownMenu.className='dropdown-menu';
						dropdownMenu.id='dropdownMenu_1';
						dropdownMenu.setAttribute('aria-labelledby',"dropdownMenuButton");
						
						for(i=0; i<courseTypesList.length; i++)
						{
						   var dropanchor = document.createElement('a');
						   dropanchor.className='dropdown-item';
						   dropanchor.id=courseTypesList[i].courseTypeId;
						   courseTypeName = (courseTypesList[i].courseTypeName).toUpperCase();
						   dropanchor.textContent=courseTypeName;
						   dropanchor.setAttribute('onclick',"displayStreamCourses(this.id, this.textContent)");
						   dropdownMenu.appendChild(dropanchor);
						} 

						document.getElementById('drop-down').appendChild(dropdownMenu);
					  
					  
					}
				  
				});
				  
			}		
				
			function displayStreamCourses(courseType_id, courseTypeName ){
				
				courseTypeId = courseType_id;
				document.getElementById('dropdownMenuButton_1').textContent = courseTypeName;

				var myData = {
				  streamId: streamId,
				  courseTypeId: courseTypeId
				};
				$.ajax({
					type: 'POST',
					url: servletURL + 'StreamCourseTypeCoursesServlet',
					data: JSON.stringify(myData),
					dataType: 'json',
					contentType: 'application/json; charset=utf-8',
					traditional: true,
					success: function (jsonObj) {
				  
						var responseJson=jsonObj[0];
					  
						var elem = document.getElementById('courseList');
						if(elem != null){
							elem.parentNode.removeChild(elem);
						}
						
						var sheet = document.createElement('style')
						sheet.innerHTML = ".modal-title-marks{margin-left:80px; color: #8d0599!important;}";
						document.body.appendChild(sheet);

						var sheet_1 = document.createElement('style')
						sheet_1.innerHTML = ".modal-title{margin-left:40px; color: #8d0599!important;}";
						document.body.appendChild(sheet_1);
						
						var sheet_icon = document.createElement('style')
						sheet_icon.innerHTML = "#marks-icon{margin-top:-25px;}";
						document.body.appendChild(sheet_icon);
						
						var row = document.createElement('div');
						row.className="row course_cards";
						row.id="courseList";
						
						var part_data = new Array();
						var course_labels = new Array();

						for(var i=0; i<responseJson.length; i++){
							
							var total_no_part = 0;
							for (var k = 0; k < responseJson[i].batchNameList.length; k++){
								var batchName = responseJson[i].batchNameList[k].split("/");
								total_no_part=total_no_part+Number(batchName[2]);	
							 
							}
							
							part_data.push(total_no_part);

							var column = document.createElement('div');
							column.className="col";

							var col1 = document.createElement('div');
							col1.className="course_card";
							
							
							var card = document.createElement('div');
							card.className="card";
								
							var cardheader = document.createElement('div');
							cardheader.className="card-header";
							
							var img = document.createElement('img');
							img.setAttribute('src',responseJson[i].iconLocation);
							img.className="course_logo";
							cardheader.appendChild(img);

							var h4 = document.createElement('h4');
							h4.textContent = responseJson[i].courseName;
							h4.className = "text-right";
							cardheader.appendChild(h4);
							course_labels.push(responseJson[i].courseName);

							var b = document.createElement('b');
							h4.appendChild(b);

							var h4_cp = document.createElement('h4');
							h4_cp.className = "card-title text-right";
							h4_cp.textContent = 'Course Participants'
							cardheader.appendChild(h4_cp);

							var h1 = document.createElement('h1');
							h1.className = "category text-right";
							h1.textContent = total_no_part;
							cardheader.appendChild(h1);
							card.appendChild(cardheader);

							var cardBody = document.createElement('div');
							cardBody.className="card-body";
							var hr = document.createElement('hr');
							hr.id="hr1";
							cardBody.appendChild(hr);

							var dropdown = document.createElement('div');
							dropdown.className="dropdown";
							var button = document.createElement('button');
							button.className="btn btn-secondary dropdown-toggle";
							button.id="dropdown-menuButton-batches"+(i+1);
							button.setAttribute('data-toggle',"dropdown");
							button.setAttribute('aria-haspopup', "true");
							button.setAttribute('aria-expanded', "false");
							button.textContent = 'SELECT BATCH';

							var dropdownmenu = document.createElement('div');
							dropdownmenu.className="dropdown-menu";
							dropdownmenu.id="dropdown-menu-batches";
							dropdownmenu.setAttribute('aria-labelledby',"dropdownMenuButton");
							
							for (var k = 0; k < responseJson[i].batchNameList.length; k++) {
								var anchor  = document.createElement('a');
								anchor.className="dropdown-item";
								
								var batchName = responseJson[i].batchNameList[k].split("/");
								anchor.textContent = batchName[1];
								anchor.id=batchName[0];
								
								anchor.setAttribute('np', batchName[2]);
								anchor.setAttribute('cardId', i+1);
								anchor.setAttribute('onclick',"getBatchInfo(this.id,this.getAttribute('np'),this.textContent,this.getAttribute('cardId'))");
								dropdownmenu.appendChild(anchor);	
							}
							
							dropdown.appendChild(dropdownmenu);
							dropdown.appendChild(button);
							cardBody.appendChild(dropdown);

							var br  = document.createElement('br');
							cardBody.appendChild(br);
							
							var batchInfo  = document.createElement('div');
							batchInfo.id="c"+(i+1);
							cardBody.appendChild(batchInfo);

							var a_mrks  = document.createElement('a');
							a_mrks.className="modal-btn card-link disabled-link";
							a_mrks.id="marks-link"+(i+1);
							a_mrks.textContent = 'See Course Marks';
							a_mrks.setAttribute('onclick',"getMarks(batchId)");
							a_mrks.setAttribute('data-toggle',"modal");
							
							a_mrks.setAttribute('data-target',"#mymodal_marks_try");
							cardBody.appendChild(a_mrks);
							
							var icon_marks = document.createElement('div');
							icon_marks.className="card-icon d_d g_icon modal-btn";
							var img = document.createElement('img');
							img.setAttribute('src','../assets/img/analytics.png');
							img.setAttribute('style', "width:20px;height:20px;");
							icon_marks.appendChild(img);
							icon_marks.setAttribute('data-toggle',"modal");
							icon_marks.setAttribute('data-target',"#mymodal_marks_graph");
							cardBody.appendChild(icon_marks);

							var br1  = document.createElement('br');
							cardBody.appendChild(br1);
								
							var a_sub  = document.createElement('a');
							a_sub.textContent = 'View Submissions';
							a_sub.className = "disabled-link";
							cardBody.appendChild(a_sub);

							var br2  = document.createElement('br');
							cardBody.appendChild(br2);
							
							var a_att  = document.createElement('a');
							a_att.textContent = 'View Attendance';
							a_att.className="modal-btn card-link disabled-link";
							a_att.setAttribute('onclick',"getAttendance(batchId)");
							a_att.setAttribute('data-toggle',"modal");
							a_att.id="att-link"+(i+1);
							a_att.setAttribute('data-target',"#mymodal_attendance");
							cardBody.appendChild(a_att);

							var br3  = document.createElement('br');
							cardBody.appendChild(br3);
							
							var a_fee  = document.createElement('a');
							a_fee.textContent = 'Check Fee Status';
							a_fee.setAttribute('onclick',"getFeesInfo(batchId)");
							a_fee.className="modal-btn card-link disabled-link";
							a_fee.id="fee-link"+(i+1);
							a_fee.setAttribute('data-toggle',"modal");
							a_fee.setAttribute('data-target',"#mymodal_fees_try");
							cardBody.appendChild(a_fee);

							var br4  = document.createElement('br');
							cardBody.appendChild(br4);

							var a_ann  = document.createElement('a');
							a_ann.className="modal-btn";
							a_ann.className = "disabled-link";
							a_ann.setAttribute('data-mfp-src',"#mymodal_notif");
							
							var icon_ann = document.createElement('div');
							icon_ann.className="card-icon d_d g_icon";
							icon_ann.id="ann";
							var img = document.createElement('img');

							img.setAttribute('src','../assets/img/volume_up.png');
							img.setAttribute('style', "width:20px;height:20px;");
							icon_ann.appendChild(img);
							cardBody.appendChild(icon_ann);

							a_ann.textContent = 'Add Announcement';
							cardBody.appendChild(a_ann);

							card.appendChild(cardBody);
							col1.appendChild(card);
							
							column.appendChild(col1);
							row.appendChild(column);
							document.getElementById('Tech-cards').appendChild(row);

						}
						
						document.getElementById('cp-link').className="modal-btn card-link";
						var ctx_part = document.getElementById("barChart_part").getContext('2d');
						var myChart = new Chart(ctx_part, {
							type: 'bar',
							data: {
								labels: course_labels,
								datasets: [{
									label: 'Course Participants',
									data: part_data,
									backgroundColor:  "rgba(54, 162, 235, 0.2)",
									borderWidth: 3
								   
								}]
							},
							options: {
								scales: { 
								xAxes: [{
									  barPercentage:0.3
										
									}],
									yAxes: [{
										ticks: {
											beginAtZero: true
										}
									}]
								}
							}
						});

				   
					},
					error: function(){
						alert("Error");
					}
				});
			}
			  
			function getBatchInfo(batch_id,batch_np,batch_name,card_id){
				batchId = batch_id; 
				document.getElementById('dropdown-menuButton-batches'+card_id).textContent=batch_name;
				var myData = {
					batchId: batchId
				};
				  
				$.ajax({
					type: 'POST',
					//url: servletURL + 'BatchDetailsServlet?batchInfoParam=batchDetails',
					url: servletURL + 'EntityServlet?entityInfoParam=CourseType',
					data: JSON.stringify(myData),
					dataType: 'json',
					contentType: 'application/json; charset=utf-8',
					traditional: true,
					success: function (jsonObj) {
						var batchDetails=jsonObj[0]; 
						
						document.getElementById('fee-link'+card_id).className="modal-btn card-link";
						document.getElementById('att-link'+card_id).className="modal-btn card-link";
						document.getElementById('marks-link'+card_id).className="modal-btn card-link";
						
						var elem = document.getElementById('batch-details'+card_id);
						if(elem != null){
							elem.parentNode.removeChild(elem);
						}
						var batch_details  = document.createElement('div');
						batch_details.id='batch-details'+card_id;
						
						var p_st_date  = document.createElement('div');
						var p_end_date  = document.createElement('div');
						var p_fac  = document.createElement('div');
						var p_np  = document.createElement('div');
						
						p_st_date.textContent='Start Date: ' + batchDetails.startDate;
						p_end_date.textContent='End Date: ' +  batchDetails.endDate;
						p_fac.textContent='Faculty: ' +  batchDetails.facultyName;
						p_np.textContent='No of Participants: ' + batch_np;
						
						batch_details.appendChild(p_st_date);
						batch_details.appendChild(p_end_date);
						batch_details.appendChild(p_fac);
						batch_details.appendChild(p_np);
						
						var br5  = document.createElement('br');
						batch_details.appendChild(br5);
						
						document.getElementById("c"+card_id).appendChild(batch_details);
							
					} 
				});
			}		
					  
			function getFeesInfo(batch_id){
				  
				batchId = batch_id; 
				 
				var myData = {
					batchId: batchId
				};
				$.ajax({
					type: 'POST',
					url: servletURL + 'BatchDetailsServlet?batchInfoParam=feeRecords',
					data: JSON.stringify(myData),
					dataType: 'json',
					contentType: 'application/json; charset=utf-8',
					traditional: true,
					success: function (jsonObj) {
						var feesDetails=jsonObj[0];
						
						var elem = document.getElementById('table-fees');
						if(elem != null){
									elem.parentNode.removeChild(elem);
						}
							
						var fees_table = document.createElement('table');
						fees_table.className = "table";
						fees_table.id = "table-fees";
						
						var r_head = document.createElement('tr');
						var h_1  = document.createElement('th');
						var h_2  = document.createElement('th');
						
						h_1.textContent="Student Name";
						h_2.textContent="Fees Paid";
						
						r_head.appendChild(h_1);
						r_head.appendChild(h_2);
							
						fees_table.appendChild(r_head);
						
						/*
						for(var i=0; i<feesDetails.length; i++){
								alert('NAME:' + feesDetails[i].name + 'FEES PAID:'+feesDetails[i].feeStatus);
						}
						*/
							
		
						for(var i=0; i<feesDetails.length; i++){
							
							var r_det  = document.createElement('tr');
							var det_1  = document.createElement('td');
							var det_2  = document.createElement('td');
						
							det_1.textContent=feesDetails[i].name;
							det_2.textContent=feesDetails[i].feeStatus;
							
							r_det.appendChild(det_1);
							r_det.appendChild(det_2);
						  
							 
						fees_table.appendChild(r_det);

						}

						document.getElementById('student-fees-try').appendChild(fees_table);
					} 
				});
					  
			}		
			  
			  
			function getAttendance(batch_id){
				  
				batchId = batch_id; 
				 
				var myData = {
					batchId: batchId
					
				};
				$.ajax({
					type: 'POST',
					url: servletURL + 'BatchDetailsServlet?batchInfoParam=attendance',
					data: JSON.stringify(myData),
					dataType: 'json',
					contentType: 'application/json; charset=utf-8',
					traditional: true,
					success: function (jsonObj) {
						var attendanceList=jsonObj[0];
						
						var elem = document.getElementById('table-attendance');
						if(elem != null){
							elem.parentNode.removeChild(elem);
						}
							
							
						var attendance_table = document.createElement('table');
						attendance_table.className = "table";
						attendance_table.id = "table-attendance";
										
						var r_head = document.createElement('tr');
						var h_1  = document.createElement('th');
						var h_2  = document.createElement('th');
							
						h_1.textContent="Student Name";
						h_2.textContent="Attendance";

						r_head.appendChild(h_1);
						r_head.appendChild(h_2);
							
						attendance_table.appendChild(r_head);
							
						for(var i=0; i<attendanceList.length; i++){
		
							var r_det  = document.createElement('tr');
							var det_1  = document.createElement('td');
							var det_2  = document.createElement('td');
								
							det_1.textContent=attendanceList[i][0];
							
							var present_count=0;
							var percent_att;
							
							for(var j=1; j<attendanceList[i].length; j++)
							{
								
									if(attendanceList[i][j]=='Present')
									{
										present_count++;
									}
							}
							percent_att=(present_count/(attendanceList[i].length-1))*100;
							
							det_2.textContent=percent_att;

							r_det.appendChild(det_1);
							r_det.appendChild(det_2);
								
							attendance_table.appendChild(r_det);
						}
							
						document.getElementById('student-attendance').appendChild(attendance_table);
					} 
				});
					  
			}		
			  
			function getMarks(batch_id){
				 
				batchId = batch_id; 
				 
				var myData = {
					batchId: batchId		
				};
				  
				$.ajax({
					type: 'POST',
					url: servletURL + 'BatchDetailsServlet?batchInfoParam=evaluation',
					data: JSON.stringify(myData),
					dataType: 'json',
					contentType: 'application/json; charset=utf-8',
					traditional: true,
					success: function (jsonObj) {
						var marksList=jsonObj[0];
					
						var elem = document.getElementById('table-marks');
						if(elem != null){
								elem.parentNode.removeChild(elem);
						}
						
						var marks_table = document.createElement('table');
						marks_table.className = "table";
						marks_table.id = "table-marks";
						
						var r_head = document.createElement('tr');
						var h_1  = document.createElement('th');
						var h_2  = document.createElement('th');
						
						h_1.textContent="Student Name";
						h_2.textContent="Marks";

						r_head.appendChild(h_1);
						r_head.appendChild(h_2);
						
						marks_table.appendChild(r_head);
						
						for(var i=0; i<marksList.length; i++){

							var r_det  = document.createElement('tr');
							var det_1  = document.createElement('td');
							var det_2  = document.createElement('td');
							
							det_1.textContent=marksList[i].fullName;
							det_2.textContent=marksList[i].marks;

							r_det.appendChild(det_1);
							r_det.appendChild(det_2);
							
							marks_table.appendChild(r_det);
						}
						
						document.getElementById('student-marks').appendChild(marks_table);
						
						var chartStudentName = new Array();
						var chartData= new Array();
						for(var j=0 ; j<marksList.length; j++){

						  chartStudentName.push(marksList[j].fullName);
						  chartData.push(marksList[j].marks);

						  }
						
						var ctx = document.getElementById("barChart").getContext('2d');
						var myChart = new Chart(ctx, {
							type: 'bar',
							data: {
								labels: chartStudentName,
								datasets: [{
									label: 'Marks of Students',
									data: chartData,
									backgroundColor: "#33AEEF",
									borderWidth: 3
								   
								}]
							},
							options: {
								scales: { 
									yAxes: [{
										ticks: {
											beginAtZero: true
										}
									}]
								}
							}
						});		
					} 
				});
			}		         
		</script>
		
		<script>
			$(document).ready(function() { 
				
				$('.modal-btn').magnificPopup({
					type:'inline',
					closeBtnInside:true,
					autoFocusLast: true,
					focus:".modal-title",
				});
			});
		</script>

		<script>
			$(document).ready(function() {
			  $().ready(function() {
				$sidebar = $('.sidebar');

				$sidebar_img_container = $sidebar.find('.sidebar-background');

				$full_page = $('.full-page');

				$sidebar_responsive = $('body > .navbar-collapse');

				window_width = $(window).width();

				fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

				if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
				  if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
					$('.fixed-plugin .dropdown').addClass('open');
				  }

				}

				$('.fixed-plugin a').click(function(event) {
				  // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
				  if ($(this).hasClass('switch-trigger')) {
					if (event.stopPropagation) {
					  event.stopPropagation();
					} else if (window.event) {
					  window.event.cancelBubble = true;
					}
				  }
				});

				$('.fixed-plugin .active-color span').click(function() {
				  $full_page_background = $('.full-page-background');

				  $(this).siblings().removeClass('active');
				  $(this).addClass('active');

				  var new_color = $(this).data('color');

				  if ($sidebar.length != 0) {
					$sidebar.attr('data-color', new_color);
				  }

				  if ($full_page.length != 0) {
					$full_page.attr('filter-color', new_color);
				  }

				  if ($sidebar_responsive.length != 0) {
					$sidebar_responsive.attr('data-color', new_color);
				  }
				});

				$('.fixed-plugin .background-color .badge').click(function() {
				  $(this).siblings().removeClass('active');
				  $(this).addClass('active');

				  var new_color = $(this).data('background-color');

				  if ($sidebar.length != 0) {
					$sidebar.attr('data-background-color', new_color);
				  }
				});

				$('.fixed-plugin .img-holder').click(function() {
				  $full_page_background = $('.full-page-background');

				  $(this).parent('li').siblings().removeClass('active');
				  $(this).parent('li').addClass('active');


				  var new_image = $(this).find("img").attr('src');

				  if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
					$sidebar_img_container.fadeOut('fast', function() {
					  $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
					  $sidebar_img_container.fadeIn('fast');
					});
				  }

				  if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
					var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

					$full_page_background.fadeOut('fast', function() {
					  $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
					  $full_page_background.fadeIn('fast');
					});
				  }

				  if ($('.switch-sidebar-image input:checked').length == 0) {
					var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
					var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

					$sidebar_img_container.css('background-image', 'url("' + new_image + '")');
					$full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
				  }

				  if ($sidebar_responsive.length != 0) {
					$sidebar_responsive.css('background-image', 'url("' + new_image + '")');
				  }
				});

				$('.switch-sidebar-image input').change(function() {
				  $full_page_background = $('.full-page-background');

				  $input = $(this);

				  if ($input.is(':checked')) {
					if ($sidebar_img_container.length != 0) {
					  $sidebar_img_container.fadeIn('fast');
					  $sidebar.attr('data-image', '#');
					}

					if ($full_page_background.length != 0) {
					  $full_page_background.fadeIn('fast');
					  $full_page.attr('data-image', '#');
					}

					background_image = true;
				  } else {
					if ($sidebar_img_container.length != 0) {
					  $sidebar.removeAttr('data-image');
					  $sidebar_img_container.fadeOut('fast');
					}

					if ($full_page_background.length != 0) {
					  $full_page.removeAttr('data-image', '#');
					  $full_page_background.fadeOut('fast');
					}

					background_image = false;
				  }
				});

				$('.switch-sidebar-mini input').change(function() {
				  $body = $('body');

				  $input = $(this);

				  if (md.misc.sidebar_mini_active == true) {
					$('body').removeClass('sidebar-mini');
					md.misc.sidebar_mini_active = false;

					$('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

				  } else {

					$('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

					setTimeout(function() {
					  $('body').addClass('sidebar-mini');

					  md.misc.sidebar_mini_active = true;
					}, 300);
				  }

				  // we simulate the window Resize so the charts will get updated in realtime.
				  var simulateWindowResize = setInterval(function() {
					window.dispatchEvent(new Event('resize'));
				  }, 180);

				  // we stop the simulation of Window Resize after the animations are completed
				  setTimeout(function() {
					clearInterval(simulateWindowResize);
				  }, 1000);

				});
			  });
			});
		</script>
		
		<script type="text/javascript">
			function LogoutSession() {
				$.ajax({
					url: servletURL + 'LogoutServlet',
					type: 'POST',
					dataType: 'json',
					contentType: 'application/json; charset=utf-8',
					traditional: true,
					success: function (jsonObj) {
						var responseJson1=jsonObj[0];
						var locationJson = eval('(' + responseJson1 + ')');
						window.location.href = locationJson.location;
					},
					error: function () {
						alert("You are in error function of LogoutAjax call ");
					}
				});

			}

		</script>
		
		<script>
			var data;
			var userProfile;
			var streamList;
			$(document).ready(function() {
				var searchString = window.location.search.substring(1);
				var arr = searchString.split('&');
				var data= arr[0].split('=')[1];
				var decodedData = decodeURIComponent(data);
				var data1 = decodedData.substring(0, decodedData.indexOf('}')+1);
				userProfile =  eval('(' + data1 + ')');
				var data2 = decodedData.substring(decodedData.indexOf('}')+1, decodedData.length);
				streamList = eval('(' + data2 + ')');
				document.getElementById('welcome').textContent = userProfile.firstName + " " + userProfile.lastName;
				md.initDashboardPageCharts();
				strResJSON = JSON.stringify(userProfile);
			});
		</script>

	</body>

</html>
