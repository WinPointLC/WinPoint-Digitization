<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Admin Page
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" /> 
  <!--<link href="../MaterialKitHomePage/assets/css/material-kit.css?v=2.0.5" rel="stylesheet" />-->
  <!--<link rel="stylesheet" href="../css/AdminPage.css">-->
  
<!--   <script>alert(""+${pageContext.request.contextPath});</script>
 --><%--   <script type="text/javascript" src="${pageContext.request.contextPath}/js/WinPointScripts.js"></script>
 --%>  
 
 	  <script type="text/javascript" src="../js/WinPointScripts.js"></script>
 	
 
</head>
<body>
  <!-- Adding content of Admin Page -->
 
    <div class="AddNewUser-class" id="AddNewQuestion-jsp">
        <div class="row">
          <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
            <div class="card card-plain">
              <div class="card card-header card-header-primary main-head">
                <h3 class="text-align mr-auto ml-auto">Add Question</h3>
              </div>
            </div>
          </div>
        </div>

        <div class="card-body">
          <form>
            <div class="row">
              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonStream" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonEvaluationType" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Evaluation Type
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="Evaluation-dropdown">

                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonTopics" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Topics
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="topic-dropdown">

                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-3">
                <div class="form-group">
                  <label class="bmd-label-floating">Enter Total Marks</label>
                  <input type="number" class="form-control" id="totalMarks" required>
                </div>
              </div>
              <div class="col-md-3">
                <div class="stats">
                  <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonDiffLvl" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Select Difficulty level
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="diff-dropdown">

                    </div>
                  </div>
                </div>
              </div>

            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="form-group">
                  <label>Add a Question</label>
                  <div class="form-group">
                    <label></label>
                    <textarea class="form-control" rows="3" id="question" required></textarea>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <h4>Add Options</h4>
              </div>
            </div>
            <div class="inner-option" id="inner-opt-content">

            </div>

            <div class="row">
              <div class="col-md-4">
                <h4>Correct Options</h4>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <div class="form-group">
                  <label class="bmd-label-floating">Enter the Correct Option Number</label>
                  <input type="number" class="form-control" id="correctOptions" required>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <h4>Explanation for Answer</h4>
              </div>
            </div>

            <div class="row">
              <div class="col-md-12">
                <div class="form-group">
                  <label>Add Explanation</label>
                  <div class="form-group">
                    <label></label>
                    <textarea name="name" class="form-control" rows="3" id="explanation" required></textarea>
                  </div>

                </div>
              </div>
            </div>
            <button type="submit" class="btn btn-primary pull-right" onclick="addQuestion()">Save</button>
            <div class="clearfix"></div>
          </form>
        </div>
    </div>
 
  <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <script src="../assets/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
  
   <script type="text/javascript">   
        <c:import url="/StreamListServlet" />
		<c:set var="streamlist" value="${requestScope.streamList}" />
		var streamList;
		
		
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
			
			document.getElementById('dropdownMenuButtonCourseType').textContent = 'Select Course Type ';
			document.getElementById('dropdownMenuButtonCourse').textContent = 'Select Course ';
			document.getElementById('dropdownMenuButtonEvaluationType').textContent = 'Select Evaluation Type ';
			document.getElementById('dropdownMenuButtonTopics').textContent = 'Select Topics ';
			document.getElementById('dropdownMenuButtonDiffLvl').textContent = 'Select Difficulty level ';
			
						
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
						var anchor4 = document.createElement('a');
						anchor4.className="dropdown-item";
						anchor4.setAttribute('href', "#");
						anchor4.id = coursesList[i].courseId + 'C';
						anchor4.textContent = coursesList[i].courseName.toUpperCase().replace("_"," ");
						//alert("course Name  " + coursesList[i].courseName);
						anchor4.setAttribute('onclick', "getCourseId(this.id)");
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
		
		var topicsList;
		var courseElem;
		var evalElem;
		function getCourseId(course_id){
			courseId = course_id.substring(0, course_id.length - 1);
			courseElem = document.getElementById(course_id);
			
			document.getElementById('dropdownMenuButtonCourse').textContent = courseElem.textContent;

			//Current system supports only MCQs.
			var Evaluationlist = ['MCQ'];
			//for (var i = 0; i < Evaluationlist.length; i++) {
			var anchor3 = document.createElement('a');
			anchor3.className="dropdown-item";
			anchor3.setAttribute('href', "#");
			//anchor4.id = 1 + 'E';
			anchor3.textContent = Evaluationlist[0];
			document.getElementById('Evaluation-dropdown').appendChild(anchor3);
			//}
			  //evalElem = document.getElementById('1E');
			//anchor3.className = 'nav-link active';
			document.getElementById('dropdownMenuButtonEvaluationType').textContent = Evaluationlist[0];

			var myData = {
				courseId:courseId//.substring(0, courseId.length - 1)
			};
			$.ajax({
				type: 'POST',
				url: servletURL + 'CourseTopicsSelectServlet',
				data: JSON.stringify(myData),
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				traditional: true,
				success: function (jsonObj) {
					topicsList=jsonObj[0];
					
				    var topicDropDown=document.getElementById('topic-dropdown');
					while (topicDropDown.hasChildNodes()) {  
						topicDropDown.removeChild(topicDropDown.firstChild);
					}
					
				   // alert("topicsList.length = "+topicsList.length);
					for (var i = 0; i < topicsList.length; i++) {
						var anchor5 = document.createElement('a');
						anchor5.className="dropdown-item";
						anchor5.setAttribute('href', "#");
						anchor5.id = topicsList[i].topicId + 'T';
						anchor5.textContent = topicsList[i].topicName.toUpperCase().replace("_"," ");
						//alert("topic Name  " + topicsList[i].topicName);
						anchor5.setAttribute('onclick', "getTopicId(this.id)");
						document.getElementById('topic-dropdown').appendChild(anchor5);
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
		
		var topicId;
		var diffLevelsList;
		var topicElem;
		
		function getTopicId(topic_id){
			topicId = topic_id.substring(0, topic_id.length - 1);

			topicElem = document.getElementById(topic_id);
			
			document.getElementById('dropdownMenuButtonTopics').textContent = topicElem.textContent;
			var myData = {
					courseId:courseId
				  };
			$.ajax({
				type: 'POST',
				url: servletURL + 'DifficultyLevelServlet',
				data: JSON.stringify(myData),
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				traditional: true,
				success: function (jsonObj) {
					diffLevelsList=jsonObj[1];
					
				    var diffLevelsDropDown=document.getElementById('diff-dropdown');
					while (diffLevelsDropDown.hasChildNodes()) {  
						diffLevelsDropDown.removeChild(diffLevelsDropDown.firstChild);
					}
					
				    //alert("diffLevelsList.length = "+diffLevelsList.length);
					for (var i = 0; i < diffLevelsList.length; i++) {
						var anchor6 = document.createElement('a');
						anchor6.className="dropdown-item";
						anchor6.setAttribute('href', "#");
						anchor6.id = diffLevelsList[i].difficultyLevelId + 'D';
						anchor6.textContent = diffLevelsList[i].difficultyLevelName.toUpperCase().replace("_"," ");
						//alert("difficultyLevelName  " + diffLevelsList[i].difficultyLevelName);
						anchor6.setAttribute('onclick', "getDiffLevelId(this.id)");
						document.getElementById('diff-dropdown').appendChild(anchor6);
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

		var diffLevelId;
		var diffLvlElem;
		function getDiffLevelId(diffLevel_id){
			diffLevelId = diffLevel_id.substring(0, diffLevel_id.length - 1);

			diffLvlElem = document.getElementById(diffLevel_id);
			
			document.getElementById('dropdownMenuButtonDiffLvl').textContent = diffLvlElem.textContent;
		}
		
		var optionArr = ['option1','option2','option3','option4'];
		function addQuestion(){
			//alert("Add Question");
			var question = document.getElementById('question').value;
			var option1 = document.getElementById(optionArr[0]).value;
			//alert(option1);
			var option2 = document.getElementById(optionArr[1]).value;
			//alert(option2);
			var option3 = document.getElementById(optionArr[2]).value;
			//alert(option3);
			var option4 = document.getElementById(optionArr[3]).value;
			//alert(option4);
			var correctOption = document.getElementById('correctOptions').value;
			//alert(correctOptions);
			var totalMarks = document.getElementById('totalMarks').value;
			//alert(totalMarks);
			var explanation = document.getElementById('explanation').value;
			//alert(explanation);
			var inCrt="No";
			if(courseTypeId == 2){
				inCrt="YES";
			}
			alert(inCrt);
			var myData = {
					courseId:courseId,
					topicId:topicId,
					question:question,
					option1:option1,
					option2:option2,
					option3:option3,
					option4:option4,
					correctOption:correctOption,
					totalMarks:totalMarks,
					explanation:explanation,
					difficultyLevelId:diffLevelId,
					inCrt:inCrt
			};
			//alert(myData);
			$.ajax({
				type: 'POST',
				url: servletURL + 'AddQuestionServlet',
				data: JSON.stringify(myData),
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				traditional: true,
				success: function (jsonObj) {
					//alert("FRom EMPDash");
					var responseJson1=jsonObj[0], responseJson2=jsonObj[1], responseJson3=jsonObj[2];
					var locationJson = eval('(' + responseJson1 + ')');
					//alert("^^^^^^^" + locationJson);
					if (locationJson.success) {
						var strResJSON = JSON.stringify(responseJson2);
						var streamJSON = JSON.stringify(responseJson3);
						//alert("studentEmail : " + responseJson2.email);
						window.location.href = locationJson.location + "?varid=" + encodeURIComponent(strResJSON) + encodeURIComponent(streamJSON) +"&username=" + "Anjali" +"&password=" + "Anjali";
					}
				  //window.location.href=;
				},
				error: function(){
					alert("Error");
					//document.getElementById("error").innerHTML = "Invalid email or password";
				}

			});
			alert("After AJAX");
		}

    </script> 
	
	<script type="text/javascript">

		//Adding Dynamic Option content

		var optionArr = ['option1','option2','option3','option4'];
		for (var i = 0; i < optionArr.length; i++) {
			var row = document.createElement('div');
			row.className="row";
			var col = document.createElement('div');
			col.className="col-md-4";
			var formcheck = document.createElement('div');
			formcheck.className="form-check";
			var label = document.createElement('label');
			label.className="form-check-label";
			label.textContent = optionArr[i];
			var input1 =  document.createElement('input');
			input1.className="form-check-input";
			input1.setAttribute('type',"radio");
		    input1.setAttribute('name', "exampleRadios");
			input1.id="exampleRadios2";
			input1.setAttribute('value',optionArr[i]);
			//input1.innerHTML= optionArr[i];
			//input1.setAttribute('style', "color:#000;");
			formcheck.appendChild(input1);
			formcheck.appendChild(label);
			var span = document.createElement('span');
			span.className="circle";
			var span2 = document.createElement('span');
			span2.className="check";
			span.appendChild(span2);

			label.appendChild(span);
			formcheck.appendChild(label);
			col.appendChild(formcheck);
			row.appendChild(col);
			var col2 = document.createElement('div');
			col2.className="col-md-4";
			var formgroup = document.createElement('div');
			formgroup.className="form-group";
			var label2 = document.createElement('label');
			label2.className="bmd-label-floating";
			label2.textContent = 'Enter the option content';
			var input2 = document.createElement('input');
			input2.setAttribute('type',"text");
			input2.setAttribute('required',true);
			input2.className="form-control";
			input2.id=optionArr[i];
			formgroup.appendChild(input2);
			formgroup.appendChild(label2);
			col2.appendChild(formgroup);
		    row.appendChild(col2);
			document.getElementById('inner-opt-content').appendChild(row);
		}
	</script>
	
	<script>
	/*
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
				alert("stream list length   " + streamList.length);
				//document.getElementById('welcome').textContent = userProfile.firstName + " " + userProfile.lastName;
				//md.initDashboardPageCharts();
				strResJSON = JSON.stringify(userProfile);
			});
	*/
	</script>
</body>
</html>
