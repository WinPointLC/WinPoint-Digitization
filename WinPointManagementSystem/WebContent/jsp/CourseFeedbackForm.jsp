<!doctype html>
<html lang="en">

<head>
  <title>Feedback</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="../assets/css/style2.css">
</head>

<body class="">
  <div class="wrapper ">
  <!--  <div class="sidebar" data-color="purple" data-background-color="white">
      <div class="logo"><a href="http://www.creative-tim.com" class="simple-text logo-normal">
          WINPOINT
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="#0">
              <i class="material-icons">dashboard</i>
              <p>User Dashboard</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">laptop</i>
              <p>Course Registration</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">laptop</i>
              <p>Online Evaluation</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">poll</i>
              <p>Analytics</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">show_chart</i>
              <p>Result</p>
            </a>
          </li>
          <li class="nav-item active  ">
            <a class="nav-link active" href="./feedback.html">
              <i class="material-icons">feedback</i>
              <p>Feedback</p>
            </a>
          </li>
                  
        </ul> ul ends heer 
      </div>.sidebar-wrapper ends here 
    </div>.sidebar ends here 
    <div class="main-panel">
    
      navba
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:;">Dashboard</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            
            <ul class="navbar-nav">
              <li class="nav-item" id="user">
              USER
            </li>
              

              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                  <a class="dropdown-item" href="#">Profile</a>
                  <a class="dropdown-item" href="#">Settings</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">Log out</a>
                </div>
              </li>
         </ul>
          </div>
        </div>
      </nav>
      End Navbar 
      <div class="content">
        <div class="container-fluid">
          <div class="container-fluid">
            <div class="card card-plain">
              <div class="card-header card-header-primary">
                <h4 class="card-title">Feedback</h4>
                
         </div></div>
         -->

    
      <!-- instructions -->

      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title "></h4>
                  <p class="card-category">Following are some statements regarding the course. Rate your degree of concurrence with each of these statements on a scale of (1) to (5), where<br>
                  (1)Strongly Disagree, (2) Disagree, (3)Can't say/Neutral, (4)Agree, (5)Strongly Agree</p>
                </div>
                <form  name="myForm"  onsubmit="getFeedbackInfo()">
                
                <div class="card-body">
                  <div class="table-responsive">
                    <form  name="myForm">
                    <!-- table -->
                    <table class="table">
                      <thead class=" text-primary">
                        <th>
                          SR
                        </th>
                        <th class="col2">
                          STATEMENT
                        </th>
                        <th>
                          SCORE
                        </th>
                      </thead>

                <!-- 1 -->
                        <tr>
                          <th scope="row">1</th>
                          <td><b>Coverage:</b>The instructor demonstrated good hold
                                            and expertise on the subject.</td>
                           <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions1"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions1"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions1" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions1"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions1" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                        </tr>
                <!-- 2 -->

                        <tr>
                          <th scope="row">2</th>
                          <td><b>Subject Knowledge:</b>The instructor made sure that the topics were
                                            well understood by all.</td>
                            <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions2"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions2"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions2" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions2"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions2" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                        </tr>
                  <!-- 3 -->
                      <tr>
                          <th scope="row">3</th>
                         <td><b>Training Skills:</b>The topic coverage was as per expectation</td>
                            <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions3"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions3"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions3" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions3"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions3" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                            
                        </tr>



                    <!-- 4 -->
                            <tr>
                          <th scope="row">4</th>
                          <td><b>Handling Questions:</b>The instructor has been able to handle
                                questions in a judicious manner and has been able to drive
                                good discussions in the class.</td>
                                <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions4"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions4"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions4" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions4"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions4" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                            
                        </tr>

                      <!-- 5 -->
                            <tr>
                          <th scope="row">5</th>
                          <td><b>The Quality:</b>You will be able to use the skills when you step
                                outside, with some practice.</td>
                                <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions5"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions5"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions5" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions5"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions5" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                            
                        </tr>

                  <!-- 6 -->
                            <tr>
                          <th scope="row">6</th>
                          <td><b>Environment</b>The environment where the course was
                                    conducted was comfortable and conducive to learning.</td>
                                    <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions6"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions6"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions6" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions6"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions6" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                           
                        </tr>

                <!-- 7 -->
                            <tr>
                          <th scope="row">7</th>
                           <td><b>Environment</b>The environment where the course was
                            conducted was comfortable and conducive to learning.</td>
                            <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions7"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions7"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions7" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions7"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions7" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                           
                        </tr>

         <!-- 8 -->
                            <tr>
                          <th scope="row">8</th>
                           <td><b>Punctuality:</b>The course was conducted on time each day.</td>
                           <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions8"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions8"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions8" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions8"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions8" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                           
                        </tr>

           <!-- 9 -->
                            <tr>
                          <th scope="row">9</th>
                          <td><b>Practical Approach:</b>Approach: The instructor consistently linked theory
                                            with practical nuances to bring about the correct
                                      understanding for the participants.
                                    </td>
                                    <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions9"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions9"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions9" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions9"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions9" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                            
                        </tr>

              <!-- 10 -->
                            <tr>
                          <th scope="row">10</th>
                          <td><b>Course Pedogogy:</b>The instructor used relevant methods of
teaching (white-boarding, examples, and exercises) to ensure
better comprehension of topics covered.</td>
                           <td>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="inlineRadioOptions10"  value="Strongly disagree" required> 1
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions10"  value="Disagree"> 2
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions10" value="Neutral"> 3
                              
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input  type="radio" name="inlineRadioOptions10"  value="Agree"> 4
                                
                                </label>
                              </div>

                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="inlineRadioOptions10" value="Strongly Agree"> 5
                                
                              </div>
                            </td>
                        </tr>
                    </table>

                  <!-- table ends here -->

                <!-- remaining questions -->
                    <div>
                      <div >
                        A] Please comment on the strengths of the course, and how it has benefitted you.
                        <div class="form-group form-file-upload form-file-simple">
                        <input type="text" class="form-control inputFileVisible" placeholder="Answer" id="ansA" required>
                        
                        </div>
                      </div>
                      <div class>
                        B] Please give suggestions on how the course could be further improved.
                         <div class="form-group form-file-upload form-file-simple">
                        <input type="text" class="form-control inputFileVisible" placeholder="Answer" id="ansB" required >
                      

                      </div>
                      <div>
                        C] Would you recommend the course to others.<br>
                         <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input  type="radio" name="yes" value="Yes" required> YES
                               
                              </div>

                      </div>
                       <div class="form-check form-check-radio form-check-inline">
                                <label></label>
                                <input  type="radio" name="yes" value="No"> NO
                              
                                </label>
                              </div>

                      <div>
                        
                        D] On a scale of (1) to (5) rate your overall WinPoint experience where,<br>
                        
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="oveRall" value="Hdissatisfied" required> Highly Dissatisfied
                               
                                </label>
                              </div>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="oveRall" value="Dissatisfied"> Dissatisfied
                              
                                </label>
                              </div>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input class type="radio" name="oveRall" value="Neutral"> Can't say/ Neutral
                              
                                </label>
                              </div>
                              <div class="form-check form-check-radio form-check-inline">
                                <label>
                                <input type="radio" name="oveRall" value="Satisfied"> Satisfied
                                
                                </label>
                              </div>
                              <div class="form-check form-check-radio form-check-inline">
                                <label >
                                <input type="radio" name="oveRall" value="Hsatisfied"> Highly Satisfied
                                
                                </label>
                              </div>
                            </div>
                          

              <div class="btn-submit">                  
          <button type="submit" class="btn btn-primary" >Submit</button>
      </div>
</form>

    </div><!-- mainpanel ends here -->
  </div><!-- .wrapper ends here-->

  <!--   Core JS Files   -->
  <script src="../assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="../assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>

  <!-- Plugin for the Perfect Scrollbar -->
  <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>

  <!-- Plugin for the momentJs  -->
  <script src="assets/js/plugins/moment.min.js"></script>

  <!--  Plugin for Sweet Alert -->
  <script src="assets/js/plugins/sweetalert2.js"></script>

  <!-- Forms Validations Plugin -->
  <script src="assets/js/plugins/jquery.validate.min.js"></script>

  <!--  Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="assets/js/plugins/jquery.bootstrap-wizard.js"></script>

  <!--  Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="assets/js/plugins/bootstrap-selectpicker.js" ></script>

  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="assets/js/plugins/bootstrap-datetimepicker.min.js"></script>

  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/    -->
  <script src="assets/js/plugins/jquery.datatables.min.js"></script>

  <!--  Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="assets/js/plugins/bootstrap-tagsinput.js"></script>

  <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
  <script src="assets/js/plugins/jasny-bootstrap.min.js"></script>

  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="assets/js/plugins/fullcalendar.min.js"></script>

  <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
  <script src="assets/js/plugins/jquery-jvectormap.js"></script>

  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="assets/js/plugins/nouislider.min.js" ></script>

  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>

  <!-- Library for adding dinamically elements -->
  <script src="assets/js/plugins/arrive.min.js"></script>

  <!--  Google Maps Plugin    -->
  <script  src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

  <!-- Chartist JS -->
  <script src="assets/js/plugins/chartist.min.js"></script>

  <!--  Notifications Plugin    -->
  <script src="assets/js/plugins/bootstrap-notify.js"></script>

  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="assets/js/material-dashboard.min.js?v=2.1.2" type="text/javascript"></script>
  <script type="text/javascript">

    function getFeedbackInfo(){

      var tr1=$("input[name=inlineRadioOptions1]:checked").val();
      var tr2=$("input[name=inlineRadioOptions2]:checked").val();
      var tr3=$("input[name=inlineRadioOptions3]:checked").val();
      var tr4=$("input[name=inlineRadioOptions4]:checked").val();
      var tr5=$("input[name=inlineRadioOptions5]:checked").val();
      var tr6=$("input[name=inlineRadioOptions6]:checked").val();
      var tr7=$("input[name=inlineRadioOptions7]:checked").val();
      var tr8=$("input[name=inlineRadioOptions8]:checked").val();
      var tr9=$("input[name=inlineRadioOptions9]:checked").val();
      var tr10=$("input[name=inlineRadioOptions10]:checked").val();

     var a1=document.getElementById('ansA').value;
      var a2=document.getElementById('ansB').value;
      var c=$("input[name=yes]:checked").val();
      var d=$("input[name=oveRall]:checked").val();

      var feedbackInfo={
        coverage:tr1,
        subject_knowledge:tr2,
        training_skills:tr3,
        handling_questions:tr4,
        quality:tr5,
        environment:tr6,
        envo:tr7,
        punctuality:tr8,
        practical_approach: tr9,
        course_pedogogy:tr10,
        ansA:a1,
        ansB:a2,
        recommendation:c,
        overall_rating:d
      };
      /*var inf= new Array(tr1, tr2, tr3, tr4 , tr5, tr6, tr7, tr8, tr9, tr10,c,d);*/
      
      //alert(information);
      //alert("hello");
      var myJSON=JSON.stringify(information);
      alert(myJSON);
}

function con(){
  confirm("Are you sure?");
}
</script>
</body>
</html>