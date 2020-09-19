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
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
            <!-- own CSS -->
            <link rel="stylesheet" href="../css/Dashboard.css">
            <link rel="stylesheet" href="../css/EmployeeDashboard.css">
			<style>
				.chip{
					padding: 8px 10px;
					border-radius: 10px;
					font-weight: 600;
					font-size: 12px;
					box-shadow: 0 2px 5px rgba(0,0,0,.25);
					margin: 0 10px;
					width:100px;
					cursor: pointer;
				}

				.chip.primary{
					background: #2F4058;
					color: whitesmoke;
				}
			</style>
			
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/WinPointScripts.js"></script>
   
  </head>

  <body>
    <!-- Paper Analysis content -->
    <div class="container-fluid" id="all-user-content">
      <div class="row">
        <div class="col-md-12">
          <div class="card card-plain">
		  
		   <div class="row row-header-1">
        <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 col-header-1">
          <div class="Rule-content-1">
            <div class="card card-plain">
              <div class="card card-header card-header-primary" >
                <h3 class="card-title text-align mr-auto ml-auto">Paper Analysis</h3>
              </div>
            </div>
          </div>
        </div>
      </div>
            
			<div class="card-body">
          
            <div class="row">
              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown">
                    <button style ="margin-left:40px; width:200px;" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonStream" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Stream
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="stream-dropdown">

                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown" id='drop11'>
                    <button style ="margin-left:40px; width:200px;" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCourseType" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Course Type
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="coursetype-dropdown">

                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown">
                    <button style ="margin-left:40px; width:200px;" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCourse" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Course
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="course-dropdown">

                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown">
                    <button style ="margin-left:40px; width:200px;" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonBatch" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Test
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="test-dropdown">

                    </div>
                  </div>
                </div>
               </div>
              </div>
			</div>
		<br>
		<div id="test-info">
		
		</div><br>
		<div class="table-responsive" id="table-users">
		    
        </div>
          </div>
        </div>

      </div>
    </div>
	
	

    <!-- End of Paper Analysis content  -->
	<!--   Core JS Files   -->
	<script src="../assets/js/core/jquery.min.js"></script>
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
	
	<script type="text/javascript">
   <!-- Js for Paper Analysis  -->
		
		<c:import url="/StreamListServlet" />
		<c:set var="streamlist" value="${requestScope.streamList}" />
		
		
		var streamList;
		var streamId;
		var courseTypeId;
		var courseId;
		var batchId;
		
		streamList = eval('(' + '${streamlist}' + ')');
				
		//alert("From AllUser streamList.length = "+streamList.length);
		for (var i = 0; i < streamList.length; i++) {
			var anchor = document.createElement('a');
			anchor.className="dropdown-item";
			anchor.setAttribute('href', "#");
			anchor.id = streamList[i].streamId;
			//alert(streamList[i]);
			anchor.textContent = streamList[i].streamName.toUpperCase().replace("_"," ");
			//anchor.textContent = streamList[i];
			//alert("From AllUser Stream Name  " + streamList[i].streamName);
			anchor.setAttribute('onclick', "getStreamId(this.id)");
			document.getElementById('stream-dropdown').appendChild(anchor);
		}
		
		var streamElem;
		function getStreamId(stream_id){
			streamId = stream_id;
			
			streamElem = document.getElementById(streamId);
			
			document.getElementById('dropdownMenuButtonStream').textContent = streamElem.textContent;
			
			document.getElementById('dropdownMenuButtonCourseType').textContent = 'Select Course Type ';
			document.getElementById('dropdownMenuButtonCourse').textContent = 'Select Course ';
			document.getElementById('dropdownMenuButtonBatch').textContent = 'Select Batch ';
						
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
					courseTypeList=jsonObj[0];
					
					var courseTypeDropDown=document.getElementById('coursetype-dropdown');
					while (courseTypeDropDown.hasChildNodes()) {  
						courseTypeDropDown.removeChild(courseTypeDropDown.firstChild);
					}
	
					//alert("courseTypeList.length = "+courseTypeList.length);
					for (var i = 0; i < courseTypeList.length; i++) {
						var anchor2 = document.createElement('a');
						anchor2.className="dropdown-item";
						anchor2.setAttribute('href', "#");
						anchor2.id = courseTypeList[i].courseTypeId + 'CT';
						//alert("courseType Name  " + courseTypeList[i].courseTypeName);
						anchor2.textContent = courseTypeList[i].courseTypeName.toUpperCase().replace("_"," ");
						anchor2.setAttribute('onclick', "getCourseTypeId(this.id)");
						document.getElementById('coursetype-dropdown').appendChild(anchor2);
					}
					//document.getElementById('coursetype-dropdown-div').appendChild(dropdownMenu_coursetype);
					  //var elem = document.getElementById('dropdownMenuButtonCourseType');
						//elem.parentNode.removeChild(elem);
				},
				error: function(){
					alert("Error");
					//document.getElementById("error").innerHTML = "Invalid email or password";
				}

			});
		}
		
		var courseTypeElem;
		var coursesList;

		function getCourseTypeId(courseType_id){
			courseTypeId = courseType_id.substring(0, courseType_id.length-2);
			
			courseTypeElem = document.getElementById(courseType_id);
			
			document.getElementById('dropdownMenuButtonCourseType').textContent = courseTypeElem.textContent;

			var myData = {
				streamId: streamId,
				courseTypeId:courseTypeId
			};
			$.ajax({
				type: 'POST',
				url: servletURL + 'StreamCourseTypeCoursesServlet',
				data: JSON.stringify(myData),
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				traditional: true,
				success: function (jsonObj) {
					coursesList=jsonObj[0];
					
					var courseDropDown=document.getElementById('course-dropdown');
					while (courseDropDown.hasChildNodes()) {  
						courseDropDown.removeChild(courseDropDown.firstChild);
					}
					
					//alert("coursesList.length = "+coursesList.length);
					for (var i = 0; i < coursesList.length; i++) {
						var anchor4 = document.createElement('a');
						anchor4.className="dropdown-item";
						anchor4.setAttribute('href', "#");
						anchor4.id = coursesList[i].courseId + 'C';
						anchor4.textContent = coursesList[i].courseName.toUpperCase().replace("_"," ");
						//alert("course Name  " + coursesList[i].courseName);
						anchor4.setAttribute('course_index', i);
						anchor4.setAttribute('onclick', "getCourseId(this.id,this.getAttribute('course_index'))");
						document.getElementById('course-dropdown').appendChild(anchor4);
					}
					//document.getElementById('course-dropdown-div').appendChild(dropdownMenu_course);
					  /*var elem = document.getElementById('dropdownMenuButtonCourseType');
						elem.parentNode.removeChild(elem);*/
				},
				error: function(){
					alert("Error");
					//document.getElementById("error").innerHTML = "Invalid email or password";
				}

			});
		}
		
		
		var courseElem;
		
		function getCourseId(course_id){
			courseId = course_id.substring(0, course_id.length - 1);
			courseElem = document.getElementById(course_id);
			
			document.getElementById('dropdownMenuButtonCourse').textContent = courseElem.textContent;
			
			var myData = {
				courseId:courseId
			};
			$.ajax({
				type: 'POST',
				url: servletURL + 'StreamCourseTypeCoursesServlet',
				data: JSON.stringify(myData),
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				traditional: true,
				success: function (jsonObj) {
					testList=jsonObj[0];
					
					var testDropDown=document.getElementById('test-dropdown');
					while (testDropDown.hasChildNodes()) {  
						testDropDown.removeChild(testDropDown.firstChild);
					}
					
					for (var k = 0; k < testList.length; k++) {
						var anchor4 = document.createElement('a');
						anchor4.className="dropdown-item";
						anchor4.setAttribute('href', "#");
						anchor4.textContent = testList[k].courseName.toUpperCase().replace("_"," ");
					    anchor4.id=testList[i].testId + 'T';
						anchor4.setAttribute('onclick', "getTestId()");
					    document.getElementById('test-dropdown').appendChild(anchor4);
					}
					  
				},
				error: function(){
					alert("Error");
					//document.getElementById("error").innerHTML = "Invalid email or password";
				}

			});
		}
		
		
		function getTestId(){
		
			var btn_score=document.createElement('button');
			btn_score.setAttribute('type','button');
			btn_score.className="btn btn-info";
			btn_score.setAttribute('style','width:180px;margin-left:0px;');
			btn_score.textContent="Your Score";
			var score_span=document.createElement('span');
			score_span.className="chip primary";
			score_span.textContent=20;
			btn_score.appendChild(score_span);
			document.getElementById('test-info').appendChild(btn_score);
			
			var btn__total_score=document.createElement('button');
			btn__total_score.setAttribute('type','button');
			btn__total_score.className="btn btn-info";
			btn__total_score.setAttribute('style','width:180px;margin-left:50px;');
			btn__total_score.textContent="Total Marks";
			var total_score_span=document.createElement('span');
			total_score_span.className="chip primary";
			total_score_span.textContent=30;
			btn__total_score.appendChild(total_score_span);
			document.getElementById('test-info').appendChild(btn__total_score);
			
			var btn_attempted=document.createElement('button');
			btn_attempted.setAttribute('type','button');
			btn_attempted.className="btn btn-info";
			btn_attempted.setAttribute('style','width:220px;margin-left:50px;');
			btn_attempted.textContent="Questions Attempted";
			var attempt_span=document.createElement('span');
			attempt_span.className="chip primary";
			attempt_span.textContent=30;
			btn_attempted.appendChild(attempt_span);
			document.getElementById('test-info').appendChild(btn_attempted);
			
			var btn_ques=document.createElement('button');
			btn_ques.setAttribute('type','button');
			btn_ques.className="btn btn-info";
			btn_ques.setAttribute('style','width:200px;margin-left:50px;');
			btn_ques.textContent="Total Questions";
			var ques_span=document.createElement('span');
			ques_span.className="chip primary";
			ques_span.textContent=30;
			btn_ques.appendChild(ques_span);
			document.getElementById('test-info').appendChild(btn_ques);
		
			var testList = [

				{
					
					"Question":"efg",
					"Status":"correct",
					"Your_Answer":"vit",
					"Correct_Answer":"vit",
					"Explanantion":"JS,CPP"
					
				},
				{
					
					"Question":"efg",
					"Status":"wrong",
					"Your_Answer":"vit",
					"Correct_Answer":"abcd",
					"Explanantion":"C,CPP"
					
				},
				{
					
					"Question":"efg",
					"Status":"correct",
					"Your_Answer":"vit",
					"Correct_Answer":"vit",
					"Explanantion":"DS,C"
				}

			]
			
			var counter;
			
			var fields = ['Question','Status','Your Answer','Correct Answer','Explanantion']
			
			var elem = document.getElementById('test-details');
			if(elem!=null){
				elem.parentNode.removeChild(elem);
			}
			
			var table = document.createElement('table');
			table.className="table table-hover";
			table.id="test-details";
			var thead = document.createElement('thead');
			
			var th0 = document.createElement('th');
		    th0.textContent = 'Question No.';
			thead.appendChild(th0);
			
			for(var i=0;i<fields.length;i++)
			{
				var th1 = document.createElement('th');
				th1.textContent = fields[i];
				thead.appendChild(th1);
			}
			
			table.appendChild(thead);
			
			var tbody = document.createElement('tbody');
			
			for(var i=0;i<testList.length;i++){
			
				counter=i+1;
				
				var tr = document.createElement('tr');
			    var td0 = document.createElement('td');
			    td0.textContent = counter;
			    var td1 = document.createElement('td');
			    td1.textContent = testList[i].Question;
			    var td2 = document.createElement('td');
			    td2.textContent = testList[i].Status;
			    var td3 = document.createElement('td');
			    td3.textContent = testList[i].Your_Answer;
			    var td4 = document.createElement('td');
			    td4.textContent = testList[i].Correct_Answer;
			    var td5 = document.createElement('td');
			    td5.textContent = testList[i].Explanantion;
			   
			    tr.appendChild(td0);
			    tr.appendChild(td1);
			    tr.appendChild(td2);
			    tr.appendChild(td3);
			    tr.appendChild(td4);
			    tr.appendChild(td5);
			  
				
                tbody.appendChild(tr);
			}
			table.appendChild(tbody);
			
			document.getElementById('table-users').appendChild(table);
			
			
		}
  </script>
	
	

  </body>
