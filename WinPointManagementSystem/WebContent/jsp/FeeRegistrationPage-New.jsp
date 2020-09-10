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
            <link rel="stylesheet" href="../css/Dashboard.css">
              <link rel="stylesheet" href="../css/EmployeeDashboard.css">
                <script>
                <c:import url="/FeeDetailsServlet" />
                <c:set var="unpaidStudentsList" value="${requestScope.unpaidStudentsList}" />
                <c:import url="/StreamListServlet" />
			    <c:set var="streamLists" value="${requestScope.streamList}" />
                </script>
                <script type="text/javascript" src="${pageContext.request.contextPath}/js/WinPointScripts.js"></script>
              </head>

              <body>
                <!-- Fee Registration content -->
                <div class="container-fluid" id="fee-register-content">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="card card-plain">
                        <div class="card-header card-header-primary" style="margin-bottom: 3%">
                          <p><h4 class="card-title mt-0" style="display: inline;">FEE REGISTRATION FOR USER</h4>
                          
                            <form style="display: inline;padding-left: 60%">
                              <input type="text" placeholder="Search a user..." name="search">
                                <button type="submit"><i class="fa fa-search"></i></button>
                              </form>
                            </p>
                        </div>
                         <div class="row">
              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown">
                    <button style ="margin-left:50px;" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonStream" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCourseType" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCourse" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonBatch" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Batch
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="select-batch-dropdown">

                    </div>
                  </div>
                </div>
               </div>
              </div>
      </div>

    <div class="card-body" >
    	<p id="courseFeesdisplay"></p>
    	<div class="table-responsive" id='mainCardBody' >
    		
    	</div>
                         
                        </div>
                      </div>

                    </div>
                  </div>
                   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
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
  <!--  Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="../assets/js/plugins/bootstrap-selectpicker.js"></script>
  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="../assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
  <script src="../assets/js/plugins/jquery.dataTables.min.js"></script>
  <!--  Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
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
                   /*   <c:import url="/StreamListServlet" />
	<c:set var="streamlist" value="${requestScope.streamList}" />*/
		var streamList;
		var streamId;
		var courseTypeId;	
		
		
		streamList = eval('(' + '${streamlist}' + ')');
		//var streamList = ['Technical','SoftSkills','General Aptitude'];
		//alert("From AddNewQuestion streamList.length = "+streamList.length);
		for (var i = 0; i < streamList.length; i++) {
			var anchor = document.createElement('a');
			anchor.className="dropdown-item";
			anchor.setAttribute('href', "#");
			anchor.id = streamList[i].streamId;
			//alert(streamList[i]);
			anchor.textContent = streamList[i].streamName.toUpperCase().replace("_"," ");
			//anchor.textContent = streamList[i];
			//alert("From AddNewQuestion Stream Name  " + streamList[i].streamName);
			anchor.setAttribute('onclick', "getStreamId(this.id)");
			document.getElementById('stream-dropdown').appendChild(anchor);
		}
		
		var streamElem;
		function getStreamId(stream_id){
			streamId = stream_id;
			
			streamElem = document.getElementById(streamId);
			
			document.getElementById('dropdownMenuButtonStream').textContent = streamElem.textContent;
						
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
					//	alert(coursesList[i].courseFees);
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

					  /*var elem = document.getElementById('dropdownMenuButtonCourseType');
						elem.parentNode.removeChild(elem);*/
				},
				error: function(){
					alert("Error");
					//document.getElementById("error").innerHTML = "Invalid email or password";
				}

			});
		}
		
		function getCourseId(course_id,course_index){
			courseId = course_id.substring(0, course_id.length - 1);
			courseElem = document.getElementById(course_id);
			//alert(coursesList[courseId].courseFees);
			document.getElementById('courseFeesdisplay').innerHTML="Course Fees: "+coursesList[courseId].courseFees;
			
			document.getElementById('dropdownMenuButtonCourse').textContent = courseElem.textContent;
			
			var batchDropDown=document.getElementById('select-batch-dropdown');
			while (batchDropDown.hasChildNodes()) {  
				batchDropDown.removeChild(batchDropDown.firstChild);
			}
					
			for (var k = 0; k < coursesList[course_index].batchNameList.length; k++) {

				var anchor4 = document.createElement('a');
				anchor4.className="dropdown-item";
				anchor4.setAttribute('href', "#");
				var batchName = coursesList[course_index].batchNameList[k].split("/");
				//alert("Batch Name  " + batchName[1]);
			    anchor4.textContent = batchName[1];
				anchor4.id=batchName[0]+"B";
				anchor4.setAttribute('onclick', "getFeesInfo(this.id)");
			    document.getElementById('select-batch-dropdown').appendChild(anchor4);
			}
					
			/*
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
					coursesList=jsonObj[0];
					
					var batchDropDown=document.getElementById('select-batch-dropdown');
					while (batchDropDown.hasChildNodes()) {  
						batchDropDown.removeChild(batchDropDown.firstChild);
					}
					
					for (var k = 0; k < coursesList[i].batchNameList.length; k++) {
						var anchor4 = document.createElement('a');
						anchor4.className="dropdown-item";
						anchor4.setAttribute('href', "#");
						var batchName = coursesList[i].batchNameList[k].split("/");
						//alert("Batch Name  " + batchName[1]);
					    anchor4.textContent = batchName[1];
					    anchor4.id=batchName[0];
					   document.getElementById('select-batch-dropdown').appendChild(anchor4);
					}
					//document.getElementById('batch-dropdown-div').appendChild(dropdownMenu_batch);
					 
				},
				error: function(){
					alert("Error");
					//document.getElementById("error").innerHTML = "Invalid email or password";
				}

			});*/
		}

function getFeesInfo(batch_id){
		batchId = batch_id.substring(0, batch_id.length - 1); 
          alert("This is getFeesInfo Function");
          	batchElem = document.getElementById(batch_id);
         alert("streamid"+streamId);
         alert("courseTypeId"+courseTypeId);
         var userIndex=0;
         var dueAmount;
			
	document.getElementById('dropdownMenuButtonBatch').textContent = batchElem.textContent;
        
         
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
             var elem = document.getElementById('feeRegTable');
            if(elem != null){
                  elem.parentNode.removeChild(elem);
              }

              var table2 = document.createElement('table');
            	table2.id="feeRegTable"
                 table2.className="table";
                 var thead = document.createElement('thead');
                 thead.className="text-primary"
                  // var head = ['Sr.no','Username','Email','Address','Mobile No','Courses Done','Button1','Button2'];
                  var head2 = ['SR.no','Username','Remaining Fees','Paid','REGISTRATION'];
                  for (var i = 0; i < head2.length; i++) {
                    var th2 = document.createElement('th');
                    th2.textContent = head2[i];
                    thead.appendChild(th2);
                  }
                  table2.appendChild(thead);
                  for(i=0;i<feesDetails.length;i++){
                  	userIndex=i;
                  	alert(userIndex);
                  	 var myData2 = {
			         userId:feesDetails[i].userId,
			          streamId: streamId,
			          courseTypeId: courseTypeId
			      };
                 
                  $.ajax({
					          type: 'POST',
					          url: servletURL + 'StreamCourseTypeUserCoursesServlet',
					          data: JSON.stringify(myData2),
					          dataType: 'json',
					          contentType: 'application/json; charset=utf-8',
					          traditional: true,
					          success: function (jsonObj) {
						var responseJson=jsonObj[0];
						dueAmount=responseJson[userIndex].dueAmount;
					}

           
					});
              
                  alert("this is amount due"+" "+dueAmount);
                   var tr=document.createElement('tr')
                    var td1= document.createElement('td');
                     td1.textContent=i+1;
                     var td2= document.createElement('td');
                     td2.textContent=feesDetails[i].name;
                     var td3= document.createElement('td');
                     td3.textContent = dueAmount;
                     var td4 = document.createElement('td');
                    var paidbtn = document.createElement('button');
                    paidbtn.textContent = "Paid";
                    paidbtn.className="btn btn-primary";
                    paidbtn.setAttribute('onclick', "updateFeeStatus(${unpaidStudent.userId}, ${unpaidStudent.courseId}")
                  
                    td4.appendChild(paidbtn);
                    var td5  = document.createElement('td');
                    var btn12 = document.createElement('button');
                    btn12.className="btn btn-primary";
                    btn12.textContent ="Register";

                    td5.appendChild(btn12);

                     tr.appendChild(td1);

                    tr.appendChild(td2);

                    tr.appendChild(td3);

                    tr.appendChild(td4);

                    tr.appendChild(td5);
                    table2.appendChild(tr);
                      
                  }

 document.getElementById('mainCardBody').appendChild(table2);
                  
          } 
        });
            
      }  









                  //--------------------- start of Fee register script----------------------------
                  //creating table dynamically

                  //function getFeeRegistrationPage(){
                

                  </script>

                 
                  <script type="text/javascript">
               
                  </script>
                  <script type="text/javascript">
                  function updateFeeStatus(userId, courseId){
                    var myData = {
                      userId: userId,
                      courseId: courseId
                    };

                    $.ajax({
                      type: 'POST',
                      url: servletURL + 'FeeDetailsServlet',
                      data: JSON.stringify(myData),
                      dataType: 'json',
                      contentType: 'application/json; charset=utf-8',
                      traditional: true,
                      success: function (jsonObj) {
                        alert("success in updating the values");
                        document.getElementById(userId + '' + courseId).remove();
                      },
                      error: function(){
                        alert("Error in updating the fees");
                      }
                    });
                  }
                  </script>
                </body>
                </html>
