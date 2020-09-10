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
  <link rel="stylesheet" href="assets/css/fontawesome.min.css">
  <!-- Material Kit CSS -->
  <link href="../assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet"/>
  <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>-->
  
  <!-- own CSS -->
  <!-- own CSS -->
  <style>
    .disabled-link{
	  color: currentColor;
	  cursor: not-allowed;
	  opacity: 0.5;
	  text-decoration: none;
	  pointer-events: none;
    }
  </style>
 
  <SCRIPT src="http://java.com/js/dtjava.js"></SCRIPT>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/WinPointScripts.js"></script>
<!--<script>
    function launchApplication(jnlpfile) {
        dtjava.launch(            {
                url : 'outjar.jnlp'
            },
            {
                javafx : '8.0+'
            },
            {}
        );
        return false;
    }
</script>

<script>
    function javafxEmbedaccounts.client() {
        dtjava.embed(
            {
                id : 'accounts.client',
                url : 'outjar.jnlp',
                placeholder : 'javafx-app-placeholder',
                width : '0',
                height : '0'
            },
            {
                javafx : '8.0+'
            },
            {}
        );
    }
    
    dtjava.addOnloadCallback(javafxEmbedaccounts.client);
</script>
  
</head>-->

<body>
 
    <div>
      <div class="content" id="main-content">
        <div class="container-fluid">
          <div class="row">
             <div class="col-lg-12 col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Employee Interface</h4>
                  
                </div>
                <div class="card-body">
                <div class="dropdown">
					
                    <button class="btn btn-secondary dropdown-toggle " type="button" id="dropdownMenuButton" data-toggle="dropdown" data-display="static" aria-haspopup="true" aria-expanded="false" style="display: block;margin: auto;">
                      SELECT ENTITY
                    </button>
					
						<div class="dropdown-menu entity-menu" aria-labelledby="dropdownMenuButton">
						  <div class="pull-left">
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Course Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Difficulty Level</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Employee Category</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Evaluation Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Feedback Category</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Feedback Question Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Organization Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Grading System</a>
						  </div>
						  <div  class="pull-right">
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Payment Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Reminder Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Revenue Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Security Questions</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Segment Type</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Stream</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Student Category</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">Time Slots</a>
							  <a class="dropdown-item" href="#" onclick="showBody(this.textContent)">User Category</a>
							  
						  </div>
                        </div>
					  
                    
                </div>
                 <!--   1.  Course Type
						2.  Difficulty Level
						3.  Employee Category
						4.  Evaluation Type
						5.  Feedback Category
						6.  Feedback Questions Type
						7.  Organization Type
						8.  Grades
						9.  Payment Type
						10. Reminder type
						11. Revenue type
						12. Security Questions
						13. Segment Type
						14. Stream
						15. Student Category
						16. Time Slots
						17. User Category
						 -->
                                
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-12 col-md-12">
              <div class="card" id="entityTable" style="display: none;">
                <div class="card-header card-header-primary">
                  <p><h4 class="card-title " style="display: inline;">Entity Name</h4>
                   <a style="margin-left: 550px;" data-toggle="modal" data-target="#addRowModal">
                    Add a row
            <i class="material-icons">add_circle</i>
            
          </a>
		   <a style="margin-left: 30px;" onclick="delRow()">
                   Delete rows
           <i class="material-icons">remove_circle</i>
		   
          </a>
                </p>  
                </div>
						<div id="entity-table"></div>
						 <button type="button" style="margin-left: 400px;" class="btn btn-primary" onclick='submit()'>Submit</button>
			  </div>
            </div>
           </div>

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
			  <a href="https://www.winpointlc.com" target="_blank">WinPoint Team</a> for a better education.
			</div>
			<!-- your footer here -->
		  </div>
		</footer>

	</div>
  </div>
</div>

<!--ADD ROW MODAL START-->
<div class="modal fade" id="addRowModal" tabindex="-1" role="">
    <div class="modal-dialog modal-login" role="document">
        <div class="modal-content">
            <div class="card card-signup card-plain">
                <div class="modal-header">
                  <div class="card-header card-header-primary text-center" id="head-mod" style="width: 100%;">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                      <i class="material-icons">clear</i>
                    </button>

                    <h4 class="card-title">Add Row</h4>
                    
                  </div>
       
      </div>
                <div class="modal-body">
                  <form id="addRowForm">
  <!--<div class="form-group">
    <label for="exampleId1">ID</label>
    <input type="text" class="form-control" id="exampleId1">
  </div>
  <div class="form-group">
    <label for="exampleColumn1">Column 1</label>
    <input type="text" class="form-control" id="exampleColumn1" >
  </div>
  <div class="form-group">
    <label for="exampleColumn2">Column 2</label>
    <input type="text" class="form-control" id="exampleColumn2" >
  </div>
  <div class="form-group"> 
    <label for="exampleColumn3">Column 3</label>
    <input type="text" class="form-control" id="exampleColumn3" >
  </div>
 

  <button type="button" class="btn btn-primary" onclick='addRow()'>Add</button>-->
  
  
</form>
                    
                </div>
                
            </div>
        </div>
    </div>
</div>
<!--ADD ROW MODAL END-->

<!-- EDIT ROW MODAL START-->
<div class="modal fade" id="editRowModal" tabindex="-1" role="">
    <div class="modal-dialog modal-login" role="document">
        <div class="modal-content">
            <div class="card card-signup card-plain">
                <div class="modal-header">
                  <div class="card-header card-header-primary text-center" id="head-mod" style="width: 100%;">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                      <i class="material-icons">clear</i>
                    </button>

                    <h4 class="card-title">Edit Row</h4>
                    
                  </div>
       
      </div>          
                <div class="modal-body">
                  <form id="editRowForm">
				  <!--                    
  <div class="form-group">
    <label for="editId1">ID</label>
    <input type="text" class="form-control" id="editId1">                                                            
  </div>
  <div class="form-group">
    <label for="editColumn1">Column 1</label>
    <input type="text" class="form-control" id="editColumn1">
  </div>
  <div class="form-group">
    <label for="editColumn2">Column 2</label>
    <input type="text" class="form-control" id="editColumn2">
  </div>
  <div class="form-group">
    <label for="editColumn3">Column 3</label>
    <input type="text" class="form-control" id="editColumn3">
  </div>
 

  <button type="button" class="btn btn-primary" onclick='editRowDet()'>Edit</button>-->
  
  
</form>
                    
                </div>
                
            </div>
        </div>
    </div>
</div>
<!--EDIT ROW MODAL END-->

<!-- Script for showing and hiding Jsp  -->
<script type="text/javascript">
 
</script>


<script type="text/javascript">
	
	
</script>

<script type="text/javascript">
 var add_rows = new Array();
function addRow(col_count){
	var row_data = new Array();
					
	row_count++;
	var new_row = document.createElement('tr');
	new_row.id=row_count+'r';	
	//alert(new_row.id);
	
	for(i=0;i<col_count;i++){
		var det_1  = document.createElement('td');
		det_1.textContent=document.getElementById('exampleColumn'+(i+1)).value;
		var data=det_1.textContent;
		row_data.push(data);
		//row_data.push('pushed');
		det_1.id=row_count+'d1';
		new_row.appendChild(det_1);
		//alert("data pushed: "+row_data[i]);
	}
	
	
	/*var det_2  = document.createElement('td');
	var det_3  = document.createElement('td');
	var det_4  = document.createElement('td');*/
	var det_op  = document.createElement('td');
	
	/*
	det_2.textContent=document.getElementById('exampleColumn1').value;
	det_3.textContent=document.getElementById('exampleColumn2').value;
	det_4.textContent=document.getElementById('exampleColumn3').value;
	
	
	det_2.id=row_count+'d2';
	det_3.id=row_count+'d3';
	det_4.id=row_count+'d4';*/
	
	var button_edit  = document.createElement('button');
	button_edit.setAttribute('type',"button");
	button_edit.setAttribute('rel',"tooltip");
	button_edit.setAttribute('title',"Edit");
	button_edit.id="btn-edit";
	button_edit.className = "btn btn-primary btn-link btn-sm";
	
	var button_rem  = document.createElement('button');
	button_rem.setAttribute('type',"button");
	button_rem.setAttribute('rel',"tooltip");
	button_rem.setAttribute('title',"Remove");
	button_rem.className = "btn btn-danger btn-link btn-sm";
	
	var div_check=document.createElement('div');
	div_check.className="form-check";
	var check_label=document.createElement('label');
	check_label.className="form-check-label";
	div_check.appendChild(check_label);
	var inputCheck=document.createElement('input');
	inputCheck.className="form-check-input chk";
	inputCheck.setAttribute('type','checkbox');
	inputCheck.id=row_count+"c";
	inputCheck.setAttribute('name',checkboxName);
	
	check_label.appendChild(inputCheck);
	var checksp1=document.createElement('span');
	checksp1.className="form-check-sign";
	check_label.appendChild(checksp1);
	var checksp2=document.createElement('span');
	checksp2.className="check";
	checksp1.appendChild(checksp2);
	
	var icon_edit = document.createElement('div');
	var img = document.createElement('img');
	img.setAttribute('src','../assets/img/edit.png');
	img.setAttribute('style', "width:20px;height:20px;");
    icon_edit.appendChild(img);
	button_edit.appendChild(icon_edit);
	//button_edit.setAttribute('data-toggle', 'modal');
	//button_edit.setAttribute('data-target', '#editRowModal');
	button_edit.setAttribute('row_no', row_count+'r');
	button_edit.setAttribute('column-cnt', col_count);
	button_edit.setAttribute('onclick', "editRow(this.getAttribute('row_no'),this.getAttribute('column-cnt'))");
	
	det_op.appendChild(button_edit);
	
	var sheet_check = document.createElement('style')
	sheet_check.innerHTML = ".form-check{margin-left:80px; margin-top:-32px!important;}";
	document.body.appendChild(sheet_check);
	det_op.appendChild(div_check);
	
	/*
	new_row.appendChild(det_2);
	new_row.appendChild(det_3);
	new_row.appendChild(det_4);*/
	new_row.appendChild(det_op);
	
	document.getElementById('table-entity').appendChild(new_row);
	
	var form = document.getElementById('addRowForm'); 
	form.reset();
	
	
	add_rows.push(row_data);
	/*
	for(i=0;i<add_rows.length;i++){
		alert("row pushed:" + add_rows[i]);
	}*/
}

function removeRow(row_id){

	//alert(row_id);
	var elem = document.getElementById(row_id);
	elem.parentNode.removeChild(elem);
	
}

function submit(){

	for(i=0;i<add_rows.length;i++){
		alert("add row: " + add_rows[i]);
	}
	var del_rows = new Array();
	var checkboxes= document.getElementsByClassName('prev_chk');
	var checkboxes_checked=[];
		 
	for(var i = 0; i<checkboxes.length; i++){
		 if(checkboxes[i].checked){
		
		  checkboxes_checked.push(checkboxes[i].id);
		  del_rows.push(checkboxes[i].getAttribute('del_id'));
		 }
	}
	//alert(checkboxes_checked)
	
	for(var i = 0; i<checkboxes_checked.length; i++){
	
		 //alert(checkboxes_checked.length);
		rowDel=checkboxes_checked[i].substring(0,checkboxes_checked[i].length - 1)+'r';
		//alert(rowDel);
		
		elem = document.getElementById(rowDel);
		
		elem.parentNode.removeChild(elem);
		
	}
	
	for(i=0;i<del_rows.length;i++){
		alert("del : " + del_rows[i]);
	}
	
	
	var myData = {
	  addRows: add_rows,
	  delRowIds: del_rows
	};
	$.ajax({
		type: 'POST',
		url: servletURL + 'EntityServlet?entityInfoParam=' + entityName + '&activity=update',
		data: JSON.stringify(myData),
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		traditional: true,
		success: function (jsonObj) {
			alert("sucess ajax call for add and delete");
			
	    },
		error: function(){
            alert("Error");
        }
    });
	
}
</script>

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

	var entityName;
	var col_names = [];
	var col_count;
	var row_count;
	row_count=0;
	var CourseTypeList;
	var entityDetailList;
	
	function countColumns(obj) {
			var result = 0;
			for (var p in obj) {
				
				if( (p!='createdBy') && (p!='createdDate')&& ( p.includes("Id")==false )) {
					//alert(p);
					col_names.push(p);
					result = result+1;
					
				} 
					
			}              
			return result;
    }
	
	function addPrevRows(obj) {
	
			
			
			var table_row=document.createElement('tr');
			row_count++;
			table_row.id=row_count+'r';
			for (var p in obj) {
			
				if( p.includes("Id")==true){
				   var id = obj[p];
				}
			
				if( (p!='createdBy') && (p!='createdDate')&& ( p.includes("Id")==false )) {
				
					var det = document.createElement('td');
					det.textContent=obj[p];
					table_row.appendChild(det);				
					
				}	
			}  

			var button_edit  = document.createElement('button');
			button_edit.setAttribute('type',"button");
			button_edit.setAttribute('rel',"tooltip");
			button_edit.setAttribute('title',"Edit");
			button_edit.id="btn-edit";
			button_edit.className = "btn btn-primary btn-link btn-sm";
			
			var icon_edit = document.createElement('div');
			var img = document.createElement('img');
			img.setAttribute('src','../assets/img/edit.png');
			img.setAttribute('style', "width:20px;height:20px;");
			icon_edit.appendChild(img);
			button_edit.appendChild(icon_edit);
			button_edit.setAttribute('row_no', row_count+'r');
			col_count=countColumns(entityDetailList[0]);
			button_edit.setAttribute('column-cnt', col_count);
			button_edit.setAttribute('onclick', "editRow(this.getAttribute('row_no'),this.getAttribute('column-cnt'))");
			table_row.appendChild(button_edit);
			
			
			var div_check=document.createElement('div');
			div_check.className="form-check";
			var check_label=document.createElement('label');
			check_label.className="form-check-label";
			div_check.appendChild(check_label);
			var inputCheck=document.createElement('input');
			inputCheck.className="form-check-input chk prev_chk";
			inputCheck.setAttribute('type','checkbox');
			inputCheck.setAttribute('del_id',id);
			inputCheck.id=row_count+"c";
			inputCheck.setAttribute('onclick','disable_del(this.id)');
			//alert(inputCheck.id);
			inputCheck.setAttribute('name',checkboxName);
			
			check_label.appendChild(inputCheck);
			var checksp1=document.createElement('span');
			checksp1.className="form-check-sign";
			check_label.appendChild(checksp1);
			var checksp2=document.createElement('span');
			checksp2.className="check";
			checksp1.appendChild(checksp2);
			table_row.appendChild(div_check);
			
			var sheet_check = document.createElement('style')
			sheet_check.innerHTML = ".form-check{margin-left:80px; margin-top:-32px!important;}";
			document.body.appendChild(sheet_check);
	
			document.getElementById('table-entity').appendChild(table_row);
		}
		
	function disable_del(checkbox_id){
		
		var cb=document.getElementById(checkbox_id);
		if(cb.checked)
			document.getElementById('del_link').className="disabled-link";
		else
			document.getElementById('del_link').className="";
	}
	
    function showBody(entity_name){
	
		entityName=entity_name.replace(/\s+/g, "");
		//alert(entityName);
		
		$.ajax({
			type: 'POST',
			url: servletURL + 'EntityServlet?entityInfoParam=' + entityName + '&activity=read',
			//data: JSON.stringify(myData),
			//dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			traditional: true,
			success: function (jsonObj) {
			
				entityDetailList=jsonObj;
				alert("Entity List "+ entityDetailList);
				
				entityDetailList=JSON.parse(entityDetailList); 
				alert("Entity List as object "+ entityDetailList[0]);
				
				var col_names = [];
				function countColumns(obj) {
					var result = 0;
					for (var p in obj) {
						
						if( (p!='createdBy') && (p!='createdDate')&& ( p.includes("Id")==false )) {
							//alert(p);
							col_names.push(p);
							result = result+1;
							
						} 
							
					}              
					return result;
				}
	
				col_cnt=countColumns(entityDetailList[0]); 
			  
				var elem = document.getElementById('cardBody');
				if (elem!=null){
					elem.parentNode.removeChild(elem);
				}
				row_count=0;
				
				var cardBody = document.createElement('div');
				cardBody.className="card-body";	
				cardBody.id="cardBody";	
				
				var tableRes = document.createElement('div');
				tableRes.className="table-responsive";

				var tableEntity = document.createElement('table');
				tableEntity.id="table-entity";
				tableEntity.className="table";
				
				var thead = document.createElement('thead');
				thead.className="text-primary";
				
				for(var i=0;i<col_cnt;i++){
				
					var th1 = document.createElement('th');
					
					th1.textContent=col_names[i].charAt(0).toUpperCase()+ col_names[i].slice(1).replace(/([a-z0-9])([A-Z])/g, '$1 $2');
					
					thead.appendChild(th1);
					
				}
				tableEntity.appendChild(thead);
				
				tableRes.appendChild(tableEntity);
				cardBody.appendChild(tableRes);
				
				var tbody = document.createElement('tbody');
				tbody.id="table-rows";
				tableEntity.appendChild(tbody);
				
				document.getElementById('entity-table').appendChild(cardBody);
				
				document.getElementById('entityTable').style.display="block";
				
				for(var i=0;i<entityDetailList.length;i++){	
					addPrevRows(entityDetailList[i]);
				}
				
				var form_modal=document.createElement('div');
				form_modal.id='formModalAddRow';
				
				var elem = document.getElementById('formModalAddRow');
				if (elem!=null){
					elem.parentNode.removeChild(elem);
				}
				
				for(var i=0;i<col_cnt;i++){
				
					var fg = document.createElement('div');
					fg.className="form-group";
					var label = document.createElement('label');
					label.setAttribute("for",'exampleColumn'+(i+1));
					label.textContent=col_names[i].charAt(0).toUpperCase()+ col_names[i].slice(1).replace(/([a-z0-9])([A-Z])/g, '$1 $2');
					fg.appendChild(label);
					
					var input = document.createElement('input');
					input.setAttribute("type",'text');
					input.className="form-control";
					input.id="exampleColumn"+(i+1);
					fg.appendChild(input);
					
					form_modal.appendChild(fg);
					
				}
				var btn_add_row=document.createElement('button');
				btn_add_row.className='btn btn-primary';
				btn_add_row.setAttribute('type','button');
				btn_add_row.setAttribute('col-cnt',col_cnt);
				btn_add_row.setAttribute('onclick',"addRow(this.getAttribute('col-cnt'))");
				btn_add_row.textContent='Add';
				form_modal.appendChild(btn_add_row);
				
				document.getElementById('addRowForm').appendChild(form_modal);
			},
			error: function(){
				alert("Error");
			}
		});
			
	}
				
			 //   }
		//});
		/*
        CourseTypeList = [

		{
			"courseTypeId":1,
			"courseTypeName":"Modular",
			"courseTypeNameNew":"Modular",
			"createdBy":"abc",
			"createdDate":"14/08/2020"
			
			//createddDate in backend
			
		},
		{
			"courseTypeId":20,
			"courseTypeName":"TBC",
			"courseTypeNameNew":"Modular",
			"createdBy":"abc",
			"createdDate":"14/08/2020"
			
		},
		{
			"courseTypeId":3,
			"courseTypeName":"CRT",
			"courseTypeNameNew":"Modular",
			"createdBy":"abc",
			"createdDate":"14/08/2020"
			
		}

		]
		
			
		col_cnt=countColumns(CourseTypeList[0]); 
	  
		var elem = document.getElementById('cardBody');
		if (elem!=null){
			elem.parentNode.removeChild(elem);
		}
		row_count=0;
		
		var cardBody = document.createElement('div');
		cardBody.className="card-body";	
		cardBody.id="cardBody";	
		
		//var tableRes = document.createElement('div');
		//tableRes.className="table-responsive";

		var tableEntity = document.createElement('table');
		tableEntity.id="table-entity";
		tableEntity.className="table";
		
		var thead = document.createElement('thead');
		thead.className="text-primary";
		
		for(var i=0;i<col_cnt;i++){
		
			var th1 = document.createElement('th');
			/*var th2 = document.createElement('th');
			var th3 = document.createElement('th');
			var th4 = document.createElement('th');
			var th5 = document.createElement('th');  
			th1.textContent=col_names[i].charAt(0).toUpperCase()+ col_names[i].slice(1).replace(/([a-z0-9])([A-Z])/g, '$1 $2');
			/*th2.textContent="Column 1";
			th3.textContent="Column 2";
			th4.textContent="Column 3";
			th5.textContent="Option";
			thead.appendChild(th1);
			/*thead.appendChild(th2);
			thead.appendChild(th3);
			thead.appendChild(th4);
			thead.appendChild(th5);
		}
		tableEntity.appendChild(thead);
		
		//tableRes.appendChild(tableEntity);
		//cardBody.appendChild(tableRes);
		cardBody.appendChild(tableEntity);
		
		//var tbody = document.createElement('tbody');
		//tbody.id="table-rows";
		//tableEntity.appendChild(tbody);
		
		document.getElementById('entity-table').appendChild(cardBody);
		
		document.getElementById('entityTable').style.display="block";
		
		for(var i=0;i<CourseTypeList.length;i++){	
			addPrevRows(CourseTypeList[i]);
		}
		
		var form_modal=document.createElement('div');
		form_modal.id='formModalAddRow';
		
		var elem = document.getElementById('formModalAddRow');
		if (elem!=null){
			elem.parentNode.removeChild(elem);
		}
		
		for(var i=0;i<col_cnt;i++){
		
			var fg = document.createElement('div');
			fg.className="form-group";
			var label = document.createElement('label');
			label.setAttribute("for",'exampleColumn'+(i+1));
			label.textContent=col_names[i].charAt(0).toUpperCase()+ col_names[i].slice(1).replace(/([a-z0-9])([A-Z])/g, '$1 $2');
			fg.appendChild(label);
			
			var input = document.createElement('input');
			input.setAttribute("type",'text');
			input.className="form-control";
			input.id="exampleColumn"+(i+1);
			fg.appendChild(input);
			
			form_modal.appendChild(fg);
			
		}
		var btn_add_row=document.createElement('button');
		btn_add_row.className='btn btn-primary';
		btn_add_row.setAttribute('type','button');
		btn_add_row.setAttribute('col-cnt',col_cnt);
		btn_add_row.setAttribute('onclick',"addRow(this.getAttribute('col-cnt'))");
		btn_add_row.textContent='Add';
		form_modal.appendChild(btn_add_row);
		
		document.getElementById('addRowForm').appendChild(form_modal);*/
					
		
  
</script>



<script type="text/javascript">

	var rowId;
	var checkboxName="checkBox";
  
  function editRow(row_id,col_cnt){
	rowId=row_id;
	
    var children = document.getElementById(rowId).childNodes; 
	
	var form_modal=document.createElement('div');
	form_modal.id='formModalEditRow';
	
	var elem = document.getElementById('formModalEditRow');
	if (elem!=null){
		elem.parentNode.removeChild(elem);
	}
	
	for(var i=0;i<col_cnt;i++){
	
		var fg = document.createElement('div');
		fg.className="form-group";
		var label = document.createElement('label');
		label.setAttribute("for",'editColumn'+(i+1));
		label.textContent=col_names[i].charAt(0).toUpperCase()+ col_names[i].slice(1).replace(/([a-z0-9])([A-Z])/g, '$1 $2');
		fg.appendChild(label);
		
		var input = document.createElement('input');
		input.setAttribute("type",'text');
		input.className="form-control";
		input.id="editColumn"+(i+1);
		fg.appendChild(input);
		
		form_modal.appendChild(fg);
		
	}
	
	var btn_edit_row=document.createElement('button');
	btn_edit_row.className='btn btn-primary';
	btn_edit_row.setAttribute('type','button');
	btn_edit_row.setAttribute('col-cnt',col_cnt);
	btn_edit_row.setAttribute('onclick',"editRowDet(this.getAttribute('col-cnt'))");
	btn_edit_row.textContent='Edit';
	form_modal.appendChild(btn_edit_row);
	
	document.getElementById('editRowForm').appendChild(form_modal);
	
    $("#editRowModal").modal();
	
	for(var i=0;i<col_cnt;i++){
	
		document.getElementById('editColumn'+(i+1)).value=children[i].innerHTML;
		
	}
	
	//document.getElementById('editId1').value=children[0].innerHTML;
	
	//document.getElementById('editColumn2').value=children[2].innerHTML;
	//document.getElementById('editColumn3').value=children[3].innerHTML;
  };
  
  function editRowDet(col_cnt){
	var children = document.getElementById(rowId).childNodes;
    //alert(children[0].innerHTML);

	for(var i=0;i<col_cnt;i++){
	
		children[i].innerHTML=document.getElementById('editColumn'+(i+1)).value;
		
	}
   // children[0].innerHTML=document.getElementById('editId1').value;
	
	/*children[2].innerHTML=document.getElementById('editColumn2').value;
	children[3].innerHTML=document.getElementById('editColumn3').value;*/
  }
  
  
    function delRow(){
        var elem ;
        var elem_par;
        var elem_par_2;
        var checkboxes_checked=[];
        var j=0;
		var rowDel;

	  //alert(row_count)
	  if(row_count==0){
		alert("There is no row in the table")
	  }
	  else{
			var checkboxes= document.getElementsByClassName('chk');
		 
			for(var i = 0; i<checkboxes.length; i++){
				 if(checkboxes[i].checked){
				
				  checkboxes_checked.push(checkboxes[i].id);
				 }
			}
			//alert(checkboxes_checked)
			
			

			for(var i = 0; i<checkboxes_checked.length; i++){
			
				 //alert(checkboxes_checked.length);
				rowDel=checkboxes_checked[i].substring(0,checkboxes_checked[i].length - 1)+'r';
				//alert(rowDel);
			
				elem = document.getElementById(rowDel);
				//alert(checkboxes_checked[i]);
				//elem_par=elem.parentElement;
				//elem_par_2=elem_par.parentElement;
				//elem_par_2.parentNode.removeChild(elem_par_2);
				elem.parentNode.removeChild(elem);
				//checkboxes_checked.shift();
				//row_count--;
				//j++;

			}


		}


    }
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


</script>

</body>

</html>

