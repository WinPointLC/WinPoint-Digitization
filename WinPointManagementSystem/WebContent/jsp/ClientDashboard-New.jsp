<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" type="text/css">
  <title>DashBoard</title>
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
  <link rel="stylesheet" href="../assets/css/dashstyle.css">
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
					background: #e0e0eb;
					color: black;
				}
				
				.btn-clr{
					background:#000080;
				}
	</style>
  
   <link href="../css/employee_new_2.css" rel="stylesheet" />
  <!-- <link href="../MaterialKitHomePage/assets/css/material-kit.css?v=2.0.5" rel="stylesheet" /> -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/WinPointScripts.js"></script>
   <script>
<c:import url="/CourseFeedbackServlet" />
       <c:set var="feedbackQuestionsList" value="${requestScope.feedbackQuestionsList}" />
       <c:import url="/ClientDashboardServlet" />
       <c:set var="studentCourseDetails" value="${requestScope.studentCourseDetailsList}" />
       <c:set var="studentGACourseDetails" value="${requestScope.studentGACourseDetailsList}" />

 /* var data;
  var userProfile1;
  var strResJSON;
  $(document).ready(function(){
    var searchString = window.location.search.substring(1);
    //alert("SearchString = " + searchString);
    var arr = searchString.split('&');
    // alert("arra = " + arr);
    data= arr[0].split('=')[1];
    //alert("data = " + data);
    //var studentJson = eval('(' + data + ')');
    //alert("Student Id = " + studentJson.id);
    var userProfile = decodeURIComponent(data);

    //alert("Client is " + userProfile);
    //var student1 = new Gson().fromJson(student, Student);
    userProfile1 =  eval('(' + userProfile + ')');
    document.getElementById('welcome').textContent = userProfile1.firstName + " " + userProfile1.lastName;
    //alert("Client is " + userProfile1.userId + ":" + userProfile1.firstName + " " + userProfile1.lastName);
    //alert("Photo Location is " + userProfile1.photoLocation);
    //document.getElementById("photoId").src = userProfile1.photoLocation;
    //var recieved_json = $.parseJSON(student);
    // alert(received_json);
    //Set session variables
    //var username = arr[1].split('=')[1];
    //var password = arr[2].split('=')[1];
    //alert("username=" + username + "password = " + password);
    //document.getElementById('username').value = username;
    //document.getElementById('password').value = password;
    strResJSON = JSON.stringify(userProfile1);


      });*/

 /* var mydata = {
        userId : userProfile1.userId
        };
      $.ajax({
          type: 'POST',
          url: '/OnlineEvaluationSystem/CommonController?action=ClientDashboardServlet',
          data: JSON.stringify(mydata),
          dataType: 'json',
          contentType: 'application/json; charset=utf-8',
          traditional: true,
          success: function (jsonObj) {
            alert("Success from LoginForm");
            var responseJson1 = jsonObj[0];
            //var responseJson2 = jsonObj[1];

            /* Start- Code for ArrayList from servlet */
            /*var streamList = responseJson2[0];
            var courseTypeList = responseJson2[1];
            for(i=0; i<streamList.length; i++){
            alert("streamList = " + streamList[i].streamName);
          }
          for(i=0; i<courseTypeList.length; i++){
          alert("courseTypeList = " + courseTypeList[i].courseTypeName);
        } */
        /* End- Code for ArrayList from servlet */

  /*          var studentcourseDetailsList=jsonObj[1];
        alert(studentcourseDetailsList);
            for(i=0; i<studentcourseDetailsList.length; i++){
            alert(studentcourseDetailsList[i].courseName)
            }
      },
      error: function(){
        alert("Error");
        //document.getElementById("error").innerHTML = "Invalid email or password";
      }

      });
*/
  function sendToCourseRegistrationPage(){
  $.ajax({
        type: 'POST',
        url: servletURL + 'OnlineEvaluationServlet?isReg=1',
        data: JSON.stringify(1),
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        traditional: true,
        success: function (jsonObj) {
          //alert("Success from LoginForm");
          var responseJson1 = jsonObj[0];
          var responseJson2 = jsonObj[1];

          /* Start- Code for ArrayList from servlet */
          var streamList = responseJson2[0];
          var courseTypeList = responseJson2[1];
         /* for(i=0; i<streamList.length; i++){
             alert("streamList = " + streamList[i].streamName);
          }*/
          var streamJson=jsonObj[1];
          var courseTypeJson=jsonObj[2];
          var locationJson = eval('(' + responseJson1 + ')');
          if (locationJson.success) {
            var streamJSON = JSON.stringify(streamJson);
            //alert(streamJSON);
            var courseTypeJSON = JSON.stringify(courseTypeJson);
            //alert(courseTypeJSON);
            // alert("studentEmail : " + responseJson2.email);
            // alert(locationJson.location);

            // window.location.href = locationJson.location + "?varid=" + encodeURIComponent(streamJSON) + encodeURIComponent(courseTypeJSON)+ encodeURIComponent('${studentCourseDetails}') + encodeURIComponent('${studentGACourseDetails}') +"&username=" + "Anjali" +"&password=" + "Anjali";

            // window.location.href = locationJson.location + "?varid=" + streamJSON + courseTypeJSON +"&username=" + "Anjali" +"&password=" + "Anjali";
            //window.location.href = locationJson.location + "?varid=" + encodeURIComponent(streamJSON) +"&username=" + "Anjali" +"&password=" + "Anjali";
           var source2 = encodeURIComponent(streamJSON) + encodeURIComponent(courseTypeJSON)+ encodeURIComponent('${studentCourseDetails}') + encodeURIComponent('${studentGACourseDetails}');
           //alert("source2 = " + source2);
           var iframe_ele2 = document.getElementById("CourseRegistration-frame");
           iframe_ele2.src = iframe_ele2.src + source2;
          } else {
            $('#ajaxGetUserServletResponse').text(responseText);
          }
        },
        error: function(){
          //alert("Error");
          document.getElementById("error").innerHTML = "Cannot load client dashboard";
        }

      });
  //window.location.href = "/OnlineEvaluationSystem/jsp/CourseRegistration.jsp?varid="+ data;
  }
  // function sendToUserProfile(){
  // //var userProfileJSON = JSON.stringify(userProfile);
  // window.location.href = "/OnlineEvaluationSystem/jsp/User.jsp?varid="+ encodeURIComponent(strResJSON);
  //   //encodeURIComponent(strResJSON);
  // }
  /*function sendToUserAnalytics(){
    //var studentCourseDetails = '<c:out value="${studentCourseDetails}"/>';

    //alert('${studentCourseDetails}');
    //alert('${studentGACourseDetails}');
     window.location.href = jspURL + "Analytics.jsp?varid="+ encodeURIComponent('${studentCourseDetails}') + encodeURIComponent('${studentGACourseDetails}');
      //encodeURIComponent(strResJSON);
  }
  function sendToUserFeedback(){
    //var studentCourseDetails = '<c:out value="${studentCourseDetails}"/>';

    //alert('${studentCourseDetails}');
    //alert('${studentGACourseDetails}');
    // window.location.href = jspURL + "Analytics.jsp?varid="+ encodeURIComponent('${studentCourseDetails}') + encodeURIComponent('${studentGACourseDetails}');
     window.location.href = jspURL + "CourseFeedbackForm.jsp"
      //encodeURIComponent(strResJSON);
  }*/
  function sendToMainCoursePage(){
    $.ajax({
      type: 'POST',
      url: servletURL + 'OnlineEvaluationServlet?isReg=0',
      data: JSON.stringify(userProfile),
      dataType: 'json',
      contentType: 'application/json; charset=utf-8',
      traditional: true,
      success: function (jsonObj) {
        //alert("Success from LoginForm");
        var responseJson1 = jsonObj[0];
        var responseJson2 = jsonObj[1];

        /* Start- Code for ArrayList from servlet */
        var streamList = responseJson2[0];
        var courseTypeList = responseJson2[1];
    /*    for(i=0; i<streamList.length; i++){
        alert("streamList = " + streamList[i].streamName);
      }
      for(i=0; i<courseTypeList.length; i++){
      alert("courseTypeList = " + courseTypeList[i].courseTypeName);
    } */
    /* End- Code for ArrayList from servlet */

    var streamJson=jsonObj[1];
    var courseTypeJson=jsonObj[2];
    var locationJson = eval('(' + responseJson1 + ')');
    if (locationJson.success) {
      var streamJSON = JSON.stringify(streamJson);
      //alert(streamJSON);
      var courseTypeJSON = JSON.stringify(courseTypeJson);
      //alert(courseTypeJSON);
      //alert("studentEmail : " + responseJson2.email);
      // window.location.href = locationJson.location + "?varid=" + encodeURIComponent(streamJSON) + encodeURIComponent(courseTypeJSON) +"&username=" + "Anjali" +"&password=" + "Anjali";
      var source3 = encodeURIComponent(streamJSON) + encodeURIComponent(courseTypeJSON) +"&username=" + "Anjali" +"&password=" + "Anjali";
      // alert("source3 = " + source3);
      var iframe_ele3 = document.getElementById("MainCoursePage-frame");
      iframe_ele3.src = iframe_ele3.src + source3;

      //window.location.href = locationJson.location + "?varid=" + streamJSON + courseTypeJSON +"&username=" + "Anjali" +"&password=" + "Anjali";
      //window.location.href = locationJson.location + "?varid=" + encodeURIComponent(streamJSON) +"&username=" + "Anjali" +"&password=" + "Anjali";


    } else {
      $('#ajaxGetUserServletResponse').text(responseText);
    }
  },
  error: function(){
    //alert("Error");
    document.getElementById("error").innerHTML = "Invalid email or password";
  }

});
//window.location.href = "/OnlineEvaluationSystem/jsp/MainCoursePage.jsp?varid="+ encodeURIComponent(strResJSON);
}
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
       // alert("You are in error function of LogoutAjax call ");
      }
    });

}
</script>
</head>

  <body>
	<body>
  <c:forEach var="studentCourseDetail" items= "${studentCourseDetails}" varStatus="i">
    <script>
      //alert(studentCourseDetail);
    </script>
  </c:forEach>

    <div class="sidebar" data-color="purple" data-background-color="white">
      <!--
      Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

      Tip 2: you can also add an image using data-image tag
    -->
    <div class="logo">
      <a href="http://www.winpointlc.com" class="simple-text logo-normal">
        WinPoint
      </a>
    </div>
    <div class="sidebar-wrapper">
      <ul class="nav">
        <li class="nav-item active" id="user-dash">
          <a class="nav-link" id="client-link" >
            <i class="material-icons">dashboard</i>
            <p>User Dashboard</p>
          </a>
        </li>
        <!-- <a class="nav-link" href="javascript:sendToUserProfile()" onclick="User_link();"> -->
        <!-- <li class="nav-item">
          <a class="nav-link" href="#" onclick="User_link();">
            <i class="material-icons">person</i>
            <p>User Profile</p>
          </a>
        </li> -->

    <li id="course-reg">
          <%-- <a class="nav-link" href="javascript:sendToCourseRegistrationPage()"> --%>
            <a class="nav-link" href="#" onclick="CourseRegistration_link();" >
            <i class="material-icons">computer</i>
            <p>Course Registration</p>
          </a>
        </li>
        <li id="main-course">
          <%-- <a class="nav-link" href="javascript:sendToMainCoursePage()"> --%>
            <a class="nav-link" href="#" onclick="MainCourse_link();">
            <i class="material-icons">computer</i>
            <p>Online Evaluation System</p>
          </a>
        </li>
        <li id="analytics-link">
          <%-- <a class="nav-link" href="javascript:sendToUserAnalytics()"> --%>
            <a class="nav-link" href="#" onclick="Analytics_link();">
            <i class="material-icons">assessment</i>
            <p>Analytics</p>
          </a>
        </li>
        <li id="res-link">
          <%-- <a class="nav-link"  disabled="disabled" onclick="Result_link();"> --%>
              <a class="nav-link" >
            <i class="material-icons">subject</i>
            <p>Result</p>
          </a>
        </li>
		
		<!--<li id="paper-analysis">
			<a class="nav-link" href="#" onclick="Paper_link();">
            <i class="material-icons" >subject</i>
            <p>Paper Analysis</p>
          </a>
        </li>-->
       <%-- <li>
            <a class="nav-link" href="#" onclick="FeedbackForm_link();">
            <i class="material-icons">assessment</i>
            <p>Feedback</p>
          </a>
        </li>-->

        <%-- <li>
          <a class="nav-link" href="#" onclick="Settings_link();">
            <i class="material-icons">settings</i>
            <p>Settings</p>
          </a>
        </li> --%>
        <!-- your sidebar here -->
      </ul>
    </div>
  </div>
  <div class="main-panel">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
      <div class="container-fluid">
        <div class="navbar-wrapper">
          <a class="navbar-brand" href="#pablo" id="navbar-brand">Dashboard</a>
          <img id="photoId" />
        </div>
           <div class="collapse navbar-collapse justify-content-end" style="margin-left:60%;">
            
            <ul class="navbar-nav">
              <li class="nav-item">
                <!--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#mymodal">
  Launch demo modal
</button>-->
<button  id="btn-mod" onclick="checkNotification()">
<a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="modal" data-target="#mymodal" >
                  <i class="material-icons">campaign</i>
                  <span class="notification" id="notiFy"></span>
                 
                </a>
               </button>
              </li>   
              </ul></div>  
        <p id="welcome" style=" text-transform: uppercase;"></p >
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
                <a class="dropdown-item" href="#" onclick="User_link();">Profile</a>
                <a class="dropdown-item" href="#" onclick="Settings_link();">Settings</a>
                <div class="dropdown-divider"></div>
                <!-- giving ajax call to Logout Link -->
                <a class="dropdown-item" onclick="LogoutSession();">Log out</a>
              </div>
              <!-- your navbar here -->
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->


      <div class="content" >
        <div class="container-fluid">
           <div id="marquee">
        <marquee><div class="tim-typo">
                   <p class="text-primary">
                      Due to some reasons tomorrow will be a holiday. </p>
                  </div>
        </marquee>
      </div> 

      <div id="Tech-content"> 
      <div class="row">
            <div class="col-lg-12 col-md-12">
              <div class="card">
                <div class="card-header card-header-tabs card-header-primary">
                  <div class="nav-tabs-navigation">
                    <div class="nav-tabs-wrapper">
                     
                      <ul class="nav nav-tabs" data-tabs="tabs" id="nav-tab"><!-- technical stream -->
                        
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <div id="drop11" class="dropdown drop1" id="dropcourse" ><!-- drop down  for category -->
                      
                  </div>
                </div>
              </div>
            
              <div class="card">
                <!-- content -->
                 <div id="crd">
                 </div>
                                <h3 id="attendance" style="text-align: center;font-weight: bold;">Attendance</h3>
                      <div class="chart-container" >
                          <canvas id="myChart"></canvas>
                      </div>  

                    
              </div>
       </div>   
    </div>

    </div>
</div>






      <!-- Adding Iframes here  -->
<div class="iframes" id="iframediv">
</div>



      <script type="text/javascript">
        // var source = "User.jsp?varid="+ data;
        // string Url = "User.jsp?varid=data";
        // User-frame.Attributes["src"] = Server.HtmlDecode(Url);

        //New Method
        // function loaddata() {
        // document.getElementById('User-frame').src='/OnlineEvaluationSystem/jsp/User.jsp?varid='+ data;
        // }

        // function loaddataAnalytics() {
        // document.getElementById('Analytics-frame').src='/OnlineEvaluationSystem/jsp/Analytics.jsp?varid='+ data;
        // }

      </script>
      <!-- End of Iframes -->
      <!-- Footer -->
      <footer class="footer">
        <div class="container-fluid">
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
            <a href="http://www.winpointlc.com" target="_blank">WinPoint Team</a> for a better education.
          </div>
          <!-- your footer here -->
        </div>
      </footer>
       </div>
     </div> 



       <!-- modadl 1 : global announcement -->
<div class="modal fade" id="mymodal" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Announcements!!!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <p id="mod-body">You have an announcement</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="notification()">OK</button>
     
      </div>
    </div>
  </div>
</div>

<!--Paper Analysis modal start-->
		<div class="modal fade" id="mymodal_pa" style="margin-left:-500px;" >
			<div class="modal-dialog" role="document" style="width:1000px;">
				<div class="modal-content" style="width:1000px;">
					<div class="modal-header">
						<h2 id="modal-title" class="modal-title" tabindex="0">PAPER ANALYSIS</h2>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						 
							<div id="test-info" class="row" style="margin-left:50px; width:870px;" ></div><br>
							<p style="margin-left:400px;">TOPIC WISE ANALYSIS</p>
							<div id="bar-chart" style="margin-left:300px;width:200px;height:300px;margin-top:30px"></div><br>
							<div id="questions" style="margin-left:-110px; width:150px;"></div>
					</div>						 
				</div>
			</div>
		</div>
<!--Paper Analysis modal end-->

<!-- modal 2: batch announcment -->


<div class="modal fade" id="mymodal2" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">This is Batch wise Announcement</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <p id="mod-body">You have an announcement</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="notification()">OK</button>
     
      </div>
    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade bd-example-modal-lg" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg " role="document">
    <div class="modal-content">
      <div class="card card-signup card-plain">
      <div class="modal-header">
        <div class="card-header card-header-primary text-center" id="head-mod">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                      <i class="material-icons">clear</i>
                    </button>

                    <h4 class="card-title">Feed back</h4>
                    
                  </div>
       
      </div>
      <div class="modal-body">
         <p >Following are some statements regarding the course. Rate your degree of concurrence with each of these statements on a scale of (1) to (5), where<br>
                  (1)Strongly Disagree, (2) Disagree, (3)Cant say/Neutral, (4)Agree, (5)Strongly Agree</p>
                  <!--   <form  name="myForm"  id="" >-->
                
                <div class="card-body">
                  <div class="table-responsive" id="feedbackFormCard">
                    
     
                  </div>
                 </div>

    </div>
  </div>
</div>

  <script type="text/javascript">
  var frame;
  var Analyticsframe;
  var userframe;
  var feedbackframe
  var resultframe;
  var courseframe;
  var courseId;


  function Removeframes() {
    if (Analyticsframe!=null) {
      Analyticsframe.parentNode.removeChild(Analyticsframe);
      Analyticsframe=null;
    }
     if (userframe!=null) {
      userframe.parentNode.removeChild(userframe);
      userframe=null;
    }
       if (resultframe!=null) {
        resultframe.parentNode.removeChild(resultframe);
        resultframe=null;
      }
     if (courseframe!=null) {
      courseframe.parentNode.removeChild(courseframe);
      courseframe=null;
    }
     if (frame!=null) {
      frame.parentNode.removeChild(frame);
      frame=null;
    }
  }

    document.getElementById('client-link').onclick=function () {
       document.getElementById('user-dash').className="nav-item active"
         document.getElementById('analytics-link').className=" "
          document.getElementById('course-reg').className=" "
             document.getElementById('main-course').className=" ";
               document.getElementById('res-link').className=" "

      document.getElementById('Tech-content').style.display="block";
     // document.getElementById('myCan').style.display="block";
       //document.getElementById('myChart').style.display="block";

      if(resultframe!=null){
        document.getElementById('Result-frame').style.display="none";
      }
      else if(courseframe!=null){
        document.getElementById('CourseRegistration-frame').style.display="none";
      }
      else if(frame!=null){
        document.getElementById('MainCoursePage-frame').style.display="none";
      }
      else if(Analyticsframe!=null){
        document.getElementById('Analytics-frame').style.display="none";
      }
      else if(userframe!=null){
        document.getElementById('User-frame').style.display="none";
      }
      else if(feedbackframe!=null){
          document.getElementById('User-frame').style.display="none";
        }
      else{
      }

    };

    function Analytics_link() {
    
      Removeframes();
        document.getElementById('analytics-link').className="nav-item active";
        document.getElementById('user-dash').className=" ";
        document.getElementById('course-reg').className=" ";
        document.getElementById('main-course').className=" ";
        document.getElementById('res-link').className=" ";

      Analyticsframe = document.createElement('iframe');
      Analyticsframe.setAttribute('src',jspURL + "Analytics.jsp?varid=");
      Analyticsframe.setAttribute('width', 1080);
      Analyticsframe.setAttribute('height', 1000);
      Analyticsframe.id = 'Analytics-frame';
      Analyticsframe.setAttribute('style',"margin-top:3%;");
      document.getElementById('iframediv').appendChild(Analyticsframe);

      var source = encodeURIComponent('${studentCourseDetails}') + encodeURIComponent('${studentGACourseDetails}');
      var iframe_ele = document.getElementById("Analytics-frame");
      iframe_ele.src = iframe_ele.src + source;
      ShowHideAnalytics();
    }
    function ShowHideAnalytics() {

      document.getElementById('Tech-content').style.display="none";
     // document.getElementById('myChart').style.display="none";
      document.getElementById('Analytics-frame').style.display="block";
      if(document.getElementById('Result-frame')!=null){
        document.getElementById('Result-frame').style.display="none";
      }
       if(document.getElementById('CourseRegistration-frame')!=null){
        document.getElementById('CourseRegistration-frame').style.display="none";
      }
       if(document.getElementById('MainCoursePage-frame')!=null){
        document.getElementById('MainCoursePage-frame').style.display="none";
      }
       if(document.getElementById('User-frame')!=null){
        document.getElementById('User-frame').style.display="none";
      }

    }


    function User_link() {
      Removeframes();
      userframe = document.createElement('iframe');
     userframe.setAttribute('src',jspURL + "User.jsp?varid=");
     userframe.setAttribute('width', 1100);
     userframe.setAttribute('height', 1000);
     userframe.id = 'User-frame';
     //userframe.setAttribute('style',"margin-top:10%;");
     document.getElementById('iframediv').appendChild(userframe);
  //alert("User_link" + strResJSON);
     var source2 = encodeURIComponent(strResJSON);
   //  alert("User_link source2 = " + source2);
     var iframe_ele2 = document.getElementById("User-frame");
     iframe_ele2.src = iframe_ele2.src + source2;
     ShowHideUser();
    }
    function ShowHideUser() {
      document.getElementById('Tech-content').style.display="none";
      //document.getElementById('GA-content').style.display="none";
      document.getElementById('User-frame').style.display="block";
      if(document.getElementById('Result-frame')!=null){
        document.getElementById('Result-frame').style.display="none";
      }
       if(document.getElementById('CourseRegistration-frame')!=null){
        document.getElementById('CourseRegistration-frame').style.display="none";
      }
       if(document.getElementById('MainCoursePage-frame')!=null){
        document.getElementById('MainCoursePage-frame').style.display="none";
      }
       if(document.getElementById('Analytics-frame')!=null){
        document.getElementById('Analytics-frame').style.display="none";
      }

    }
    function FeedbackForm_link(){
      Removeframes();
        feedbackframe = document.createElement('iframe');
        feedbackframe.setAttribute('src',jspURL + "CourseFeedbackForm.jsp?varid=");
        feedbackframe.setAttribute('width', 1100);
        feedbackframe.setAttribute('height', 1000);
        feedbackframe.id = 'Feedback-frame';
       // feedbackframe.setAttribute('style',"margin-top:10%;");
        document.getElementById('iframediv').appendChild(feedbackframe);

        ShowHideFeedback();
    }
    function ShowHideFeedback() {
        document.getElementById('Tech-content').style.display="none";
        //document.getElementById('GA-content').style.display="none";
        document.getElementById('Feedback-frame').style.display="block";
        if(document.getElementById('Result-frame')!=null){
          document.getElementById('Result-frame').style.display="none";
        }
         if(document.getElementById('CourseRegistration-frame')!=null){
          document.getElementById('CourseRegistration-frame').style.display="none";
        }
         if(document.getElementById('MainCoursePage-frame')!=null){
          document.getElementById('MainCoursePage-frame').style.display="none";
        }
         if(document.getElementById('Analytics-frame')!=null){
          document.getElementById('Analytics-frame').style.display="none";
        }

    }
    function Result_link() {
      Removeframes();
       document.getElementById('res-link').className="nav-item active"
      document.getElementById("user-dash").className=" ";
      document.getElementById('analytics-link').className=" "
      document.getElementById('course-reg').className=" "
      document.getElementById('main-course').className=" "
      resultframe = document.createElement('iframe');
      resultframe.setAttribute('src','StudentResult.jsp');
      resultframe.setAttribute('width', 1100);
      resultframe.setAttribute('height', 1000);
      resultframe.id = 'Result-frame';
     resultframe.setAttribute('style',"margin-top:3%;");
      document.getElementById('iframediv').appendChild(resultframe);
      ShowHideResult();

    }
    function ShowHideResult() {
      document.getElementById('Tech-content').style.display="none";
      //document.getElementById('GA-content').style.display="none";
      document.getElementById('Result-frame').style.display="block";
      if(document.getElementById('Analytics-frame')!=null){
        document.getElementById('Analytics-frame').style.display="none";
      }
       if(document.getElementById('CourseRegistration-frame')!=null){
        document.getElementById('CourseRegistration-frame').style.display="none";
      }
       if(document.getElementById('MainCoursePage-frame')!=null){
        document.getElementById('MainCoursePage-frame').style.display="none";
      }
       if(document.getElementById('User-frame')!=null){
        document.getElementById('User-frame').style.display="none";
      }
       if(document.getElementById('Feedback-frame')!=null){
           document.getElementById('Feedback-frame').style.display="none";
         }
    }


    function CourseRegistration_link() {
     
      Removeframes();
       document.getElementById('course-reg').className="nav-item active";
        document.getElementById('user-dash').className=" ";
         document.getElementById('analytics-link').className=" ";
        
             document.getElementById('main-course').className=" ";
               document.getElementById('res-link').className=" ";
      courseframe = document.createElement('iframe');
      courseframe.setAttribute('src', jspURL + "CourseRegistration.jsp?varid=");
      courseframe.setAttribute('width', 1100);
      courseframe.setAttribute('height', 1000);
      courseframe.id = 'CourseRegistration-frame';
      courseframe.setAttribute('style',"margin-top:3%;");
      document.getElementById('iframediv').appendChild(courseframe);
      sendToCourseRegistrationPage();
      ShowHideCourse();
    }
    function ShowHideCourse() {
      document.getElementById('Tech-content').style.display="none";
   // document.getElementById('myCan').style.display="none";
      document.getElementById('CourseRegistration-frame').style.display="block";
      if(document.getElementById('Result-frame')!=null){
        document.getElementById('Result-frame').style.display="none";
      }
       if(document.getElementById('Analytics-frame')!=null){
        document.getElementById('Analytics-frame').style.display="none";
      }
       if(document.getElementById('MainCoursePage-frame')!=null){
        document.getElementById('MainCoursePage-frame').style.display="none";
      }
       if(document.getElementById('User-frame')!=null){
        document.getElementById('User-frame').style.display="none";
      }
       if(document.getElementById('Feedback-frame')!=null){
           document.getElementById('Feedback-frame').style.display="none";
         }
    }
	
	function Paper_link() {
     
      Removeframes();
	  document.getElementById('paper-analysis').className="nav-item active";
      document.getElementById('course-reg').className="";
      document.getElementById('user-dash').className=" ";
      document.getElementById('analytics-link').className=" ";
      document.getElementById('main-course').className=" ";
      document.getElementById('res-link').className=" ";
	  
      paperframe = document.createElement('iframe');
      paperframe.setAttribute('src', jspURL + "Paper_Analysis.jsp?varid=");
      paperframe.setAttribute('width', 1100);
      paperframe.setAttribute('height', 1000);
      paperframe.id = 'PaperAnalysis-frame';
      paperframe.setAttribute('style',"margin-top:3%;");
      document.getElementById('iframediv').appendChild(paperframe);
      
      ShowHidePaper();
    }
    function ShowHidePaper() {
      document.getElementById('Tech-content').style.display="none";
  
      document.getElementById('PaperAnalysis-frame').style.display="block";
     
      if(document.getElementById('Result-frame')!=null){
        document.getElementById('Result-frame').style.display="none";
      }
	  
	  if(document.getElementById('CourseRegistration-frame')!=null){
        document.getElementById('CourseRegistration-frame').style.display="none";
      }
       if(document.getElementById('Analytics-frame')!=null){
        document.getElementById('Analytics-frame').style.display="none";
      }
       if(document.getElementById('MainCoursePage-frame')!=null){
        document.getElementById('MainCoursePage-frame').style.display="none";
      }
       if(document.getElementById('User-frame')!=null){
        document.getElementById('User-frame').style.display="none";
      }
       if(document.getElementById('Feedback-frame')!=null){
           document.getElementById('Feedback-frame').style.display="none";
         }
    }


    function MainCourse_link() {
     
      Removeframes();
       document.getElementById('main-course').className="nav-item active";
        document.getElementById('user-dash').className=" ";
         document.getElementById('analytics-link').className=" ";
          document.getElementById('course-reg').className=" ";
            
               document.getElementById('res-link').className=" ";
      frame  = document.createElement('iframe');
      frame.setAttribute('src', jspURL + "MainCoursePage.jsp?varid=");
      frame.setAttribute('width', 1100);
      frame.setAttribute('height', 1000);
      frame.id = 'MainCoursePage-frame';
    frame.setAttribute('style',"margin-top:3%;");
      document.getElementById('iframediv').appendChild(frame);
      sendToMainCoursePage();
      ShowHideMain();
      }

      function ShowHideMain() {
        document.getElementById('Tech-content').style.display="none";
        //document.getElementById('myCan').style.display="none";
        document.getElementById('MainCoursePage-frame').style.display="block";
        if(document.getElementById('Result-frame')!=null){
          document.getElementById('Result-frame').style.display="none";
        }
         if(document.getElementById('CourseRegistration-frame')!=null){
          document.getElementById('CourseRegistration-frame').style.display="none";
        }
         if(document.getElementById('Analytics-frame')!=null){
          document.getElementById('Analytics-frame').style.display="none";
        }
         if(document.getElementById('User-frame')!=null){
          document.getElementById('User-frame').style.display="none";
        }
         if(document.getElementById('Feedback-frame')!=null){
             document.getElementById('Feedback-frame').style.display="none";
           }
      }

  </script>
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
  
function getStreamId(stream_id){
        streamId = stream_id;
        var streamElem = document.getElementById(streamId + 'a');
        var elem;
        for(i=0; i<streamList.length; i++){
          elem = document.getElementById(streamList[i].streamId + 'a');
           elem.className = 'nav-link';
        }
        streamElem.className = 'nav-link active';
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
              // displayStreamCourses(courseTypesList[0].courseTypeId,courseTypesList[0].courseTypeName)
             // alert(courseTypesList.length);
              //var strResJSON = JSON.stringify(responseJson);
            
            elem = document.getElementById('dropdownMenu');
            if(elem != null){
              elem.parentNode.removeChild(elem);
            }
            var elem = document.getElementById('dropdownMenuButton');
            elem.parentNode.removeChild(elem);
            var btn = document.createElement('button');
            btn.className='btn btn-secondary dropdown-toggle';
            btn.id='dropdownMenuButton';
            btn.setAttribute('data-toggle', "dropdown");
            btn.setAttribute('aria-haspopup', "true");
            btn.setAttribute('aria-expanded',"false");
            if(streamId==1){
           btn.textContent=courseTypesList[0].courseTypeName;}
           else{
            btn.textContent="Course Category";
           }
          document.getElementById('drop11').appendChild(btn);
          var dropdownMenu = document.createElement('div');
          dropdownMenu.className='dropdown-menu';
          dropdownMenu.id='dropdownMenu';
          dropdownMenu.setAttribute('aria-labelledby',"dropdownMenuButton");
            for(i=0; i<courseTypesList.length; i++){
                  var dropanchor = document.createElement('a');
                  dropanchor.className='dropdown-item';
                  dropanchor.setAttribute('href',"#");
                  dropanchor.id=courseTypesList[i].courseTypeId;
                  courseTypeName = (courseTypesList[i].courseTypeName).toUpperCase();
                  dropanchor.textContent=courseTypeName;
                  dropanchor.setAttribute('onclick',"displayStreamCourses(this.id, this.textContent)");
                  dropdownMenu.appendChild(dropanchor);
                  
                }

              document.getElementById('drop11').appendChild(dropdownMenu);
            },
            error: function(){
              alert("Error");
              //document.getElementById("error").innerHTML = "Invalid email or password";
            }


          });
        
      }
function displayStreamCourses(courseType_id, courseTypeName ){
       courseTypeId = courseType_id;
       document.getElementById('dropdownMenuButton').textContent = courseTypeName;
        var myData = {
          //userId: userProfile.userId,
          streamId: streamId,
          courseTypeId: courseTypeId
        };

        $.ajax({
          type: 'POST',
          url: servletURL + 'StreamCourseTypeUserCoursesServlet',
          data: JSON.stringify(myData),
          dataType: 'json',
          contentType: 'application/json; charset=utf-8',
          traditional: true,
          success: function (jsonObj) {
          document.getElementById('crd').style.display="block";
          var responseJson=jsonObj[0];
          var strResJSON = JSON.stringify(responseJson);
          var elem = document.getElementById('courselist');
          if(elem != null){
              elem.parentNode.removeChild(elem);
            }
            document.getElementById('crd').innerHTML=" ";
            var row  =document.createElement('div');
            row.className="row";
            row.id="courseList";
for(var j=0 ; j<responseJson.length; j++){
  var col1 = document.createElement('div');
    col1.className="col-lg-5 col-md-5 col-sm-5";
    var card = document.createElement('div');
    card.className="card card-stats";
    var cardheader = document.createElement('div');
    cardheader.className="card-header  card-header-icon";
    var cardHeading = document.createElement('div');
    cardHeading.className="card-heading";
    var h2 = document.createElement('h2');
    h2.className="card-title";
    h2.textContent = responseJson[j].courseName;
    cardHeading.appendChild(h2);
    var s1= document.createElement('p');
    s1.className="card-title";
    s1.textContent = 'Start Date:'+" "+ responseJson[j].batchDetails.startDate;
    var e1= document.createElement('p');
     e1.className="card-title";
    e1.textContent = 'End Date:'+" "+ responseJson[j].batchDetails.endDate;
    var cardIcon = document.createElement('div');
    cardIcon.className="card-icon";
    cardIcon.setAttribute('style',"padding: 0px;");
    var img = document.createElement('img');
    img.setAttribute('src',responseJson[j].logoLocation);
    img.setAttribute('style', "width:90px;height:90px;");
    cardIcon.appendChild(img);
    var p1 = document.createElement('p');
    p1.className="card-title";
    p1.textContent = 'Batch Name:\n'+" "+responseJson[j].batchDetails.batchName;
    var p2 = document.createElement('p');
    p2.className="card-title";
    p2.textContent = 'Faculty:'+" "+  responseJson[j].batchDetails.facultyName.toUpperCase();
    p2.textContent = 'Faculty:\n'+" "+  responseJson[j].batchDetails.facultyName.toUpperCase();
    var p3 = document.createElement('p');
    p3.className="card-title";
    p3.textContent = 'Marks Obtained : '+" "+ responseJson[j].courseAggr;
	
	 var a_pa  = document.createElement('a');
	a_pa.textContent = 'Go To Paper Analysis';
	a_pa.className="modal-btn card-link";
	
	alert("TEST ATTEMPTED:  " + responseJson[j].testAttempt);
	
	if(responseJson[j].testAttempt==1)
	{
		a_pa.className="modal-btn card-link";
	}
	else
	{
		a_pa.className="modal-btn card-link disabled-link";
	}
		
	a_pa.id="pa-link"+(j+1);
	a_pa.setAttribute('course-id',responseJson[j].courseId);
	a_pa.setAttribute('onclick',"getTestDetails(this.getAttribute('course-id'))");
	a_pa.setAttribute('data-toggle',"modal");
	a_pa.setAttribute('data-target',"#mymodal_pa");
	
    var h3 = document.createElement('h3');
    var cardfooter = document.createElement('div');
    cardfooter.className="card-footer";
    var stats =document.createElement('div');
    stats.className="stats";
    var blink = document.createElement('div');
    var h4 = document.createElement('h4');
    if(responseJson[j].dueAmount==0){
        h4.textContent="Amount due:INR"+" "+ responseJson[j].dueAmount;}
    else{
         h4.className="blinking";
         h4.textContent="Amount due:INR"+" "+ responseJson[j].dueAmount;}
    var button=document.createElement('button');
    button.id="modal-btn";
    button.onclick= function() {checkNotification()};
    var a_ann=document.createElement('a');
    a_ann.className="modal-btn";
    a_ann.setAttribute('data-toggle',"modal");
    a_ann.setAttribute('data-target',"#mymodal2");
    var img = document.createElement('img');
    img.className="card-icon"
    img.setAttribute('src','../assets/img/announcement.jpg');
    img.setAttribute('style', "width:30px;height:30px;");
    a_ann.appendChild(img);
    button.appendChild(a_ann)
    var button2=document.createElement('button');
    button2.id="modal-btn2";
    var a_feed=document.createElement('a');
    a_feed.id="feedbackFormLink"
    a_feed.className="modal-btn";
    a_feed.setAttribute("onclick", "openModal(" + responseJson[j].courseId + ")");
    var img_feed = document.createElement('img');
    img_feed.className="card-icon"
    img_feed.setAttribute('src','../assets/img/feed2.jpg');
    img_feed.setAttribute('style', "width:30px;height:30px;");
    a_feed.appendChild(img_feed);
    button2.appendChild(a_feed)
    if(responseJson[j].isFeedbackGiven=="YES"){
     // a_feed.removeAttr('onclick');
     document.getElementById('feedbackFormLink').disabled=true;
  }
    cardheader.appendChild(cardHeading); 
    cardheader.appendChild(s1); 
    cardheader.appendChild(e1);        
    cardheader.appendChild(cardIcon);
    cardheader.appendChild(p1);
    cardheader.appendChild(p2);
    cardheader.appendChild(p3);
	cardheader.appendChild(a_pa);
    cardheader.appendChild(h3);
    card.appendChild(cardheader);
    blink.appendChild(h4);
    stats.appendChild(blink);
    cardfooter.appendChild(stats);
    cardfooter.appendChild(button);
    cardfooter.appendChild(button2);
    card.appendChild(cardfooter);
    col1.appendChild(card);
    row.appendChild(col1);
    document.getElementById('crd').appendChild(row);

} 
    myChart.data.labels=[];
    myChart.data.datasets[0].data=[];
     
for(var j=0 ; j<responseJson.length; j++){

    myChart.data.labels.push(responseJson[j].courseName);
    myChart.data.datasets[0].data.push(responseJson[j].percentageAttendance);
        }
  myChart.update();}
});
}

 /*function displayTests(course_id){
	 
	courseId=course_id;

	var myData = {
		courseId:courseId
	};
	$.ajax({
		type: 'POST',
		url: servletURL + 'PaperAnalysisServlet',
		data: JSON.stringify(myData),
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		traditional: true,
		success: function (jsonObj) {
		
			testList=jsonObj[0];
			alert("GOT TESTS");
			
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
				anchor4.setAttribute('onclick', "getTestId(this.id)");
				document.getElementById('test-dropdown').appendChild(anchor4);
			}
			  
		},
		error: function(){
			alert("Error");
			//document.getElementById("error").innerHTML = "Invalid email or password";
		}

	});
	 
 }*/

 function openModal(course_Id){
        var feedbackcourseId=course_Id;
        $('#exampleModalLong').modal("show");
        openFeedbackForm(feedbackcourseId);
  }


  function openFeedbackForm(course_Id){
         var courseId=course_Id;
         var k=1;
         var srNumb=0;
         var srNumbTheory=0;
         var feedbackQuestionsList= eval('(' + '${feedbackQuestionsList}' + ')');
         var formElem = document.getElementById(courseId);
          	if(formElem!=null){
          		formElem.parentNode.removeChild(formElem);
          	}
          var form=document.createElement('form');
          form.id=courseId;
          form.setAttribute('name','myForm');
          form.setAttribute('onsubmit','sendUserFeedback(this.id)');
          var mainDiv=document.createElement('div');
          var tab=document.createElement('table');
          tab.className="table";
          tab.id="feedbackFormTable"
          var thead=document.createElement('thead');
          thead.className="text-primary";
          var th1=document.createElement('th');
          th1.textContent="SR";
          var th2=document.createElement('th');
          th2.className="col2";
          th2.textContent="STATEMENT";
          var th3=document.createElement('th');
          th3.textContent="SCORE";
          thead.appendChild(th1);
          thead.appendChild(th2);
          thead.appendChild(th3);
          tab.appendChild(thead)
        for(var i=0;i<feedbackQuestionsList.length;i++){

        	if(feedbackQuestionsList[i].feedbackQuestionTypeId==1){
            srNumb++;
            var tr = document.createElement('tr');
             var td1= document.createElement('td');
             td1.id=(i+1)+"R";
             td1.textContent= srNumb;
             var td2= document.createElement('td');
             td2.textContent= feedbackQuestionsList[i].feedbackQuestion;
              var td3= document.createElement('td');
            var name= "inlineRadioOptions"+k;
         if(feedbackQuestionsList[i].feedbackQuestionId==17){
              var div=document.createElement('div');
                div.className="form-check form-check-radio form-check-inline";
                var label=document.createElement('label');
                label.textContent="YES";
                var input=document.createElement('input');
                input.setAttribute('type','radio');
                input.setAttribute('name',name);
                input.setAttribute('value',"YES");
                input.setAttribute('required','required')
                label.appendChild(input);
                div.appendChild(label);
                td3.appendChild(div);
                var div=document.createElement('div');
                div.className="form-check form-check-radio form-check-inline";
                var label=document.createElement('label');
                label.textContent="NO";
                var input_1=document.createElement('input');
                input_1.setAttribute('type','radio');
                input_1.setAttribute('name',name);
                input_1.setAttribute('value','NO');
                input_1.setAttribute('required','required')
                label.appendChild(input_1);
                div.appendChild(label);
                td3.appendChild(div);
              }
              else{
              for(var j=1;j<6;j++){

                var div=document.createElement('div');
                div.className="form-check form-check-radio form-check-inline";
                var label=document.createElement('label');
                label.textContent=j;
                var input=document.createElement('input');
                input.setAttribute('type','radio');
                input.setAttribute('name',name);
                input.setAttribute('value',j);
                input.setAttribute('required','required')
                label.appendChild(input);
                div.appendChild(label);
                td3.appendChild(div);
              }
        }
              k++;
           
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tab.appendChild(tr);
           
        }
        else if(feedbackQuestionsList[i].feedbackQuestionTypeId==2){
          srNumbTheory++;
            var div1=document.createElement('div');
            div1.textContent= srNumbTheory+" "+ feedbackQuestionsList[i].feedbackQuestion;
            var div2 =document.createElement('div');
            div2.className="form-group form-file-upload form-file-simple";
            var input1=document.createElement('input');
            input1.className="form-control inputFileVisible";
            input1.id=feedbackQuestionsList[i].feedbackQuestionId +"A";
            input1.setAttribute('type','text');
            input1.setAttribute('placeholder','Answer');
            input.setAttribute('required','required');
            div2.appendChild(input1);
            mainDiv.appendChild(div1);
            mainDiv.appendChild(div2);


         }
        }
            var divButton=document.createElement('div');
            divButton.className="btn-submit";
            var submitButton=document.createElement('button')
            submitButton.className="btn btn-primary";
            submitButton.id="formSubmitButton";
            submitButton.textContent="SUBMIT";
            divButton.appendChild(submitButton);
            form.appendChild(tab);
            form.appendChild(mainDiv);
            form.appendChild(divButton);
            document.getElementById('feedbackFormCard').appendChild(form);
}
function sendUserFeedback(course_Id){
	 
      var courseId=course_Id;
      event.preventDefault();
      var feedbackQuestionsList= eval('(' + '${feedbackQuestionsList}' + ')');
      var responseList=[];
      var table = document.getElementById('feedbackFormTable');
      var rows = table.getElementsByTagName('tr');
      var k=1;
      for(var i=0;i<rows.length;i++){
      var checkboxName= "inlineRadioOptions"+k;
      var checkBoxes= document.getElementsByName(checkboxName);
      for(var j = 0; j <checkBoxes.length; j++){
       if(checkBoxes[j].checked){
         var response=checkBoxes[j].value;}
       }
  responseList.push(response); 
  k++
}
 for(var i=0;i<feedbackQuestionsList.length;i++){
  if(feedbackQuestionsList[i].feedbackQuestionTypeId==2){
    var theoryAnswerId=feedbackQuestionsList[i].feedbackQuestionId+"A";
    var responseTheory= document.getElementById(theoryAnswerId).value;
    responseList.push(responseTheory); 
}
 }
    var feedbackFormResponse=[];
    for(var i=0;i<feedbackQuestionsList.length;i++){
        var feedbackObj={
          courseId:courseId,
          feedbackId:feedbackQuestionsList[i].feedbackQuestionId,
          studentResponse:responseList[i]

        }
        feedbackFormResponse.push(feedbackObj);
      }
        $.ajax({
            type: 'POST',
            url: servletURL + 'CourseFeedbackServlet',
            data: JSON.stringify(feedbackFormResponse),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            traditional: true,
            success: function (jsonObj) {
              alert("sucess ajax call in sendUserFunction")
              
            },
            error: function(){
              alert("Error");
              exampleModalLong
              //document.getElementById("error").innerHTML = "Invalid email or password";
            }});
        
        alert("Feedback Submitted");
        $('#exampleModalLong').modal('hide');
    

    }

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
  
  <script>
	
	function getTestDetails(course_id){
			
		courseId=course_id;
		
		google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawChart2);
			
		var myData = {
			courseId:courseId
		};
		$.ajax({
			type: 'POST',
			url: servletURL + 'PaperAnalysisServlet',
			data: JSON.stringify(myData),
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			traditional: true,
			success: function (jsonObj) {
			
				questionsList=jsonObj;
				alert("Questions List" + questionsList);
				
				var elem = document.getElementById('btn-score');
				if(elem!=null){
					elem.parentNode.removeChild(elem);
				}
					
				var btn_score=document.createElement('button');
				btn_score.setAttribute('type','button');
				btn_score.id="btn-score";
				btn_score.className="btn btn-clr col";
				//btn_score.setAttribute('style','width:180px;margin-left:50px;');
				btn_score.textContent="Your Score";
				var score_span=document.createElement('span');
				score_span.className="chip primary";
				//score_span.textContent=20;
				score_span.textContent=questionsList.marksReceived;
				btn_score.appendChild(score_span);
				document.getElementById('test-info').appendChild(btn_score);
				
				var elem = document.getElementById('btn-total-score');
				if(elem!=null){
					elem.parentNode.removeChild(elem);
				}
				
				var btn__total_score=document.createElement('button');
				btn__total_score.setAttribute('type','button');
				btn__total_score.id="btn-total-score";
				btn__total_score.className="btn btn-clr col";
				//btn__total_score.setAttribute('style','width:180px;margin-left:250px;margin-top:-30px;');
				btn__total_score.textContent="Total Marks";
				var total_score_span=document.createElement('span');
				total_score_span.className="chip primary";
				//total_score_span.textContent=30;
				total_score_span.textContent=questionsList.totalMarksOutOf;
				btn__total_score.appendChild(total_score_span);
				document.getElementById('test-info').appendChild(btn__total_score);
				
				var elem = document.getElementById('btn-attempted');
				if(elem!=null){
					elem.parentNode.removeChild(elem);
				}
				
				var btn_attempted=document.createElement('button');
				btn_attempted.setAttribute('type','button');
				btn_attempted.id="btn-attempted";
				btn_attempted.className="btn btn-clr col";
				//btn_attempted.setAttribute('style','width:220px;margin-left:20px;');
				btn_attempted.textContent="Questions Attempted";
				var attempt_span=document.createElement('span');
				attempt_span.className="chip primary";
				attempt_span.textContent=30;
				btn_attempted.appendChild(attempt_span);
				document.getElementById('test-info').appendChild(btn_attempted);
				
				var elem = document.getElementById('btn-ques');
				if(elem!=null){
					elem.parentNode.removeChild(elem);
				}
				
				var btn_ques=document.createElement('button');
				btn_ques.setAttribute('type','button');
				btn_ques.id="btn-ques";
				btn_ques.className="btn btn-clr col";
				//btn_ques.setAttribute('style','width:200px;margin-left:20px;');
				btn_ques.textContent="Total Questions";
				var ques_span=document.createElement('span');
				ques_span.className="chip primary";
				//ques_span.textContent=30;
				ques_span.textContent=questionsList.totalQuestions;
				btn_ques.appendChild(ques_span);
				document.getElementById('test-info').appendChild(btn_ques);
				
				var div_questions=document.createElement('div');
				div_questions.id = "div-ques";
				
				var elem = document.getElementById('div-ques');
				if(elem!=null){
					elem.parentNode.removeChild(elem);
				}
			
				for(var i=0;i<questionsList.userTestResponses.length;i++){
					
					//alert("Question count: " + (i+1));
				
					//var div_questions=document.createElement('div');
					//div_questions.id = "div-ques";
					/*
					var elem = document.getElementById('div-ques');
					if(elem!=null){
						elem.parentNode.removeChild(elem);
					}
					*/
					var question_col=document.createElement('div');
					question_col.className="col-md-6";
					
					var ques_card=document.createElement('div');
					ques_card.className="card";
					ques_card.setAttribute('style',"width:920px; margin-left:120px;");
					
					var ques_card_body=document.createElement('div');
					ques_card_body.className="card-body";
					ques_card_body.setAttribute('style',"margin-left:30px");
					
					var status = document.createElement('p');
					if(questionsList.userTestResponses[i].isCorrect==1)
					{
						status.setAttribute('style',"color:green; font-weight:bolder;");
						status.textContent="CORRECT";
					}
					else if(questionsList.userTestResponses[i].isCorrect==0)
					{
						status.setAttribute('style',"color:red; font-style:bold;");
						status.textContent="WRONG";
					}
					//status.textContent=questionsList.userTestResponses[i].isCorrect;
					ques_card_body.appendChild(status);
					
					//alert("Question No: " + questionsList.userTestResponses[i].questionNo);
					var question = document.createElement('pre');
					question.textContent=questionsList.userTestResponses[i].questionNo+". " + questionsList.userTestResponses[i].question;
					question.setAttribute('style','font-family:Arial, Helvetica, sans-serif;font-size:14px');
					ques_card_body.appendChild(question);
						
					var options_div=document.createElement('div');
					options_div.id="div-options";
					//options_div.setAttribute('style',"margin-left:425px; position:relative; margin-top:-150px;");
					//div_options.appendChild(options_div);
					
					var span_alpha=document.createElement('span');
				    span_alpha.textContent='A ';	
					var radio_1=document.createElement('div');
					radio_1.className="form-check form-check-radio disabled";
					var label_1=document.createElement('label');
					label_1.className="form-check-label";
					var input_1=document.createElement('input');
					input_1.className="form-check-input";
					input_1.setAttribute('type',"radio");
					input_1.setAttribute('disabled',true);
					//label_1.textContent=1;
					label_1.textContent=questionsList.userTestResponses[i].option1;
					label_1.appendChild(input_1);
					var span=document.createElement('span');
					span.className="circle";
					var inner_span=document.createElement('span');
					inner_span.className="check";
					span.appendChild(inner_span);
					label_1.appendChild(span);
					radio_1.appendChild(span_alpha);
					radio_1.appendChild(label_1);
					options_div.appendChild(radio_1);
					
					var span_alpha=document.createElement('span');
				    span_alpha.textContent='B ';		
					var radio_1=document.createElement('div');
					radio_1.className="form-check form-check-radio disabled";
					var label_1=document.createElement('label');
					label_1.className="form-check-label";
					var input_1=document.createElement('input');
					input_1.className="form-check-input";
					input_1.setAttribute('type',"radio");
					input_1.setAttribute('disabled',true);
					//label_1.textContent=2;
					label_1.textContent=questionsList.userTestResponses[i].option2;
					label_1.appendChild(input_1);
					var span=document.createElement('span');
					span.className="circle";
					var inner_span=document.createElement('span');
					inner_span.className="check";
					span.appendChild(inner_span);
					label_1.appendChild(span);
					radio_1.appendChild(span_alpha);
					radio_1.appendChild(label_1);
					options_div.appendChild(radio_1);
					
					
					var span_alpha=document.createElement('span');
				    span_alpha.textContent='C ';	
					var radio_1=document.createElement('div');
					radio_1.className="form-check form-check-radio disabled";
					var label_1=document.createElement('label');
					label_1.className="form-check-label";
					var input_1=document.createElement('input');
					input_1.className="form-check-input";
					input_1.setAttribute('type',"radio");
					input_1.setAttribute('disabled',true);
					//label_1.textContent=3;
					label_1.textContent=questionsList.userTestResponses[i].option3;
					label_1.appendChild(input_1);
					var span=document.createElement('span');
					span.className="circle";
					var inner_span=document.createElement('span');
					inner_span.className="check";
					span.appendChild(inner_span);
					label_1.appendChild(span);
					radio_1.appendChild(span_alpha);
					radio_1.appendChild(label_1);
					options_div.appendChild(radio_1);
					
					var span_alpha=document.createElement('span');
				    span_alpha.textContent='D ';		
					var radio_1=document.createElement('div');
					radio_1.className="form-check form-check-radio disabled";
					var label_1=document.createElement('label');
					label_1.className="form-check-label";
					var input_1=document.createElement('input');   
					input_1.className="form-check-input";
					input_1.setAttribute('type',"radio");
					input_1.setAttribute('disabled',true);
					//label_1.textContent="Compilation Error";
					label_1.textContent=questionsList.userTestResponses[i].option4;
					label_1.appendChild(input_1);
					var span=document.createElement('span');
					span.className="circle";
					var inner_span=document.createElement('span');
					inner_span.className="check";
					span.appendChild(inner_span);
					label_1.appendChild(span);
					radio_1.appendChild(span_alpha);
					radio_1.appendChild(label_1);
					options_div.appendChild(radio_1);
					
					ques_card_body.appendChild(options_div);
					
					var your_ans = document.createElement('p');
					your_ans.textContent="Your Answer : "+ questionsList.userTestResponses[i].selectedOption;
					ques_card_body.appendChild(your_ans);
					
					var correct_ans = document.createElement('p');
					correct_ans.textContent="Correct Answer : "+ questionsList.userTestResponses[i].correctOption;
					ques_card_body.appendChild(correct_ans);
					
					var explain = document.createElement('p');
					explain.textContent="Explanation : "+ questionsList.userTestResponses[i].explanation;
					ques_card_body.appendChild(explain);
					
					var diff_topic=document.createElement('pre');
					diff_topic.textContent="Topic : " + questionsList.userTestResponses[i].TopicName + "            Difficulty Level : " +  questionsList.userTestResponses[i].DifficultyLevelName;
					diff_topic.setAttribute('style','font-family:Arial, Helvetica, sans-serif;font-size:14px');
					ques_card_body.appendChild(diff_topic);
					
					ques_card.appendChild(ques_card_body);
					question_col.appendChild(ques_card);
					div_questions.appendChild(question_col);
					document.getElementById('questions').appendChild(div_questions);
					
					
				}
				  
			},
			error: function(){
				alert("Error");
				//document.getElementById("error").innerHTML = "Invalid email or password";
			}

		});
			
				
	}
	
	function drawChart2() {

 	 var myData = {
	     			courseId: courseId
    	    	  };
			$.ajax({
				type: 'POST',
				url: servletURL + 'AnalyticsServlet?getInfoParam=topicDetails&view=ClientDash',
				data: JSON.stringify(myData),
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				traditional: true,
				success: function (jsonObj) {
					//alert("Success from AnalyticsForm");
					var responseJson1=jsonObj[0], responseJson2=jsonObj[1];

					

				  var topicArray = [];// = [['Course', 'Marks'],['C', 10],['DS', 40],['Java', 70]];
				  var topicHeader = ['TopicName', 'TopicwiseMarks'];
				  topicArray.push(topicHeader);
				  for(var i=0; i<responseJson2.length; i++){
					// alert(studentCourseDetailsList.courseName);
					var topicData = [responseJson2[i].topicName , responseJson2[i].topicwiseNumberOfCorrectAns];
					topicArray.push(topicData);
				  }

				  // alert("topicArray: "+  topicArray);
				  var data = new google.visualization.arrayToDataTable(topicArray);

							var options = {
									legend: { position: 'none'},
									title: 'Your Topicwise score in Evaluations',
									 width: 400,
									 height: 300,
							};
							var chart = new google.charts.Bar(document.getElementById('bar-chart'));
							chart.draw(data, options);
						},
						error: function(){
							//alert("Error");
							document.getElementById("error").innerHTML = "Invalid email or password";
						}

			});

}
</script>
  
  <script>
  $(document).ready(function() {
    // Javascript method's body can be found in assets/js/demos.js
    md.initDashboardPageCharts();
  });

  </script>
  <script>
var data;
var userProfile;
var streamList;
var myChart;
function mainUserFunction(){
//	alert("this is mainUserFunction");
	var searchString = window.location.search.substring(1);
  var arr = searchString.split('&');
  var data= arr[0].split('=')[1];
  var decodedData = decodeURIComponent(data);
  //alert(decodedData);
  var data1 = decodedData.substring(0, decodedData.indexOf('}')+1);
  //alert(data1);
  userProfile =  eval('(' + data1 + ')');
  var data2 = decodedData.substring(decodedData.indexOf('}')+1, decodedData.length);
  //alert(data2);
  streamList = eval('(' + data2 + ')');
 // alert(streamList[0].streamName);
  document.getElementById('welcome').textContent = userProfile.firstName + " " + userProfile.lastName;
  // Javascript method's body can be found in ../assets/js/demos.js
    md.initDashboardPageCharts();
    strResJSON = JSON.stringify(userProfile);
var streamId = 1;
var courseTypeId = 1;
var courseTypeName = "";
var chartCourseName = [];
var chartData= [];
var ctx = document.getElementById('myChart').getContext('2d');
myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels:[],
        datasets: [{
            label: 'Attendance in %',
            data:[],
            backgroundColor:" rgb(142, 36, 170,0.4 )",
           borderColor: ' rgb(142 36 170)',
            borderWidth: 3
           
        }]
    },
    
    options: {
        scales: { 
          xAxes: [{
             barPercentage:0.2

                
            }],
            yAxes: [{
                ticks: {
                    beginAtZero: true,
                    max:100,
                  callback: function(value) {
               return value + "%"
           }
       },
       scaleLabel: {
           display: true,
           labelString: "Percentage"
       }
                
            }]

        }
    }
});

var searchString = window.location.search.substring(1);

  var arr = searchString.split('&');
  var data= arr[0].split('=')[1];
  var decodedData = decodeURIComponent(data);
  var data1 = decodedData.substring(0, decodedData.indexOf('}')+1);
  userProfile =  eval('(' + data1 + ')');
  document.getElementById('welcome').textContent = userProfile.firstName + " " + userProfile.lastName;
  var data2 = decodedData.substring(decodedData.indexOf('}')+1, decodedData.length);
  streamList = eval('(' + data2 + ')');
    
            for(i=0; i<streamList.length; i++){
              var div1 = document.createElement('div');
              div1.id="tab-div";
              var li = document.createElement('li');
              li.className='nav-item';
              li.id = streamList[i].streamId + 'l';

              var anchor =document.createElement('a');
              anchor.setAttribute('href',"#Profile");
              anchor.setAttribute('data-toggle',"tab");
              anchor.className='nav-link ';
              anchor.id = streamList[i].streamId + 'a';
              anchor.textContent=streamList[i].streamName;
              li.id = streamList[i].streamId;
              li.appendChild(anchor);
              li.setAttribute('onclick', "getStreamId(this.id)");
              div1.appendChild(li);
              document.getElementById("nav-tab").appendChild(div1);
            }
            
            var streamElem = document.getElementById(streamList[0].streamId + 'a');
            streamElem.className='nav-link active';
            var drop1 = document.getElementsByClassName('drop1');
            var btn = document.createElement('button');
            btn.className='btn btn-secondary dropdown-toggle';
            btn.id='dropdownMenuButton';
            btn.setAttribute('data-toggle', "dropdown");
            btn.setAttribute('aria-haspopup', "true");
            btn.setAttribute('aria-expanded',"false");
            btn.textContent="Course Category";
            document.getElementById('drop11').appendChild(btn);
            var dropdownMenu = document.createElement('div');
            dropdownMenu.className='dropdown-menu';
            dropdownMenu.id='dropdownMenu';
            dropdownMenu.setAttribute('aria-labelledby',"dropdownMenuButton");
            document.getElementById('drop11').appendChild(dropdownMenu);
getStreamId(streamList[0].streamId);
displayStreamCourses(courseTypeId, courseTypeName);

}


$(document).ready(function() {
	mainUserFunction();
  
});

</script>
</body>

</html>
