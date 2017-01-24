<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
 
<html lang="en"> 
 
<head>
        <meta charset="utf-8" />
        <title>Conversations</title>
         
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=all" rel="stylesheet" type="text/css" />
         <link href="resources/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
         
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="resources/css/datatables.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
        
        <link href="resources/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="resources/css/plugins.min.css" rel="stylesheet" type="text/css" />  
         </head> 
    <body>
        <div>
              
            <div class="page-container">
                <!-- BEGIN SIDEBAR -->
                <div class="page-sidebar-wrapper">
                    
                <div class="page-content-wrapper">
                    <!-- BEGIN CONTENT BODY -->
                    <div>
                        <div class="row">
                            <div class="col-md-12">
                                <!-- BEGIN EXAMPLE TABLE PORTLET-->
                                <div class="portlet box blue">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-globe"></i>Conversations Screen</div>
                                    </div>
                                    <div class="portlet-body">

                                    <div class="col-sm-12 table-bordered">
                                    <div class="row">
                                        <div class="form-group col-sm-2">
                                            <label for="single" class="control-label">Select Topic</label>
                                            <select id="topicId single" class="form-control select2" required="required" onchange="getSubTopicByTopicId(this);">
                                               	 <option value="">Select Topic</option>
                                               	 <c:forEach var="conversationTopicInfo" items="${conversationTopicInfo}">
                                               		 <option value="${conversationTopicInfo.topicId}">${conversationTopicInfo.topicName}</option>
                                               	 </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <label for="single" class="control-label">Select Sub Topic</label>
                                            <select id="single subTopic" class="form-control select2" required="required">
                                                <option value="">Select Sub Topic</option>
                                                    
                                            </select>
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <label for="multiple" class="control-label">Select User</label>
                                            <select id="multiple" class="form-control select2-multiple" multiple>
                                                <optgroup label="Alaskan">
                                                    <option value="AK">Alaska</option>
                                                    <option value="HI" disabled="disabled">Hawaii</option>
                                                </optgroup>
                                                <optgroup label="Pacific Time Zone">
                                                    <option value="CA">California</option>
                                                    <option value="NV">Nevada</option>
                                                    <option value="OR">Oregon</option>
                                                    <option value="WA">Washington</option>
                                                </optgroup>
                                                <optgroup label="Mountain Time Zone">
                                                    <option value="AZ">Arizona</option>
                                                    <option value="CO">Colorado</option>
                                                    <option value="ID">Idaho</option>
                                                    <option value="MT">Montana</option>
                                                    <option value="NE">Nebraska</option>
                                                    <option value="NM">New Mexico</option>
                                                    <option value="ND">North Dakota</option>
                                                    <option value="UT">Utah</option>
                                                    <option value="WY">Wyoming</option>
                                                </optgroup>
                                                <optgroup label="Central Time Zone">
                                                    <option value="AL">Alabama</option>
                                                    <option value="AR">Arkansas</option>
                                                    <option value="IL">Illinois</option>
                                                    <option value="IA">Iowa</option>
                                                    <option value="KS">Kansas</option>
                                                    <option value="KY">Kentucky</option>
                                                    <option value="LA">Louisiana</option>
                                                    <option value="MN">Minnesota</option>
                                                    <option value="MS">Mississippi</option>
                                                    <option value="MO">Missouri</option>
                                                    <option value="OK">Oklahoma</option>
                                                    <option value="SD">South Dakota</option>
                                                    <option value="TX">Texas</option>
                                                    <option value="TN">Tennessee</option>
                                                    <option value="WI">Wisconsin</option>
                                                </optgroup>
                                                <optgroup label="Eastern Time Zone">
                                                    <option value="CT">Connecticut</option>
                                                    <option value="DE">Delaware</option>
                                                    <option value="FL">Florida</option>
                                                    <option value="GA">Georgia</option>
                                                    <option value="IN">Indiana</option>
                                                    <option value="ME">Maine</option>
                                                    <option value="MD">Maryland</option>
                                                    <option value="MA">Massachusetts</option>
                                                    <option value="MI">Michigan</option>
                                                    <option value="NH">New Hampshire</option>
                                                    <option value="NJ">New Jersey</option>
                                                    <option value="NY">New York</option>
                                                    <option value="NC">North Carolina</option>
                                                    <option value="OH">Ohio</option>
                                                    <option value="PA">Pennsylvania</option>
                                                    <option value="RI">Rhode Island</option>
                                                    <option value="SC">South Carolina</option>
                                                    <option value="VT">Vermont</option>
                                                    <option value="VA">Virginia</option>
                                                    <option value="WV">West Virginia</option>
                                                </optgroup>
                                            </select>
                                        </div>
                                        </div>
                                        <div class="row">
                                        <div class="form-group col-sm-8">
                                                    <label>Write your Content</label>
                                                    <textarea placeholder="Write Your Content" class="form-control" rows="3"></textarea>
                                                   
                                          </div>
                                          <div class="form-group col-sm-8">
                                          <button type="submit" class="btn blue">Send</button>
                                          <button type="rest" class="btn blue">Clear</button>
                                          </div>
                                        </div>
                                        </div>
                                        <table class="table table-striped table-bordered table-hover " width="100%" id="sample_4" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th class="all">Group / User</th>
                                                    <th class="min-phone-l">Date / Time</th>
                                                    <th class="min-tablet">Vessel Name</th>
                                                    <th class="min-tablet">QC No.</th>
                                                    <th class="min-tablet">alert</th>
                                                    <th class="all">Comment</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Michael</td>
                                                    <td>Mon, 10 Aug 05 11:52:01</td>
                                                    <td>ABC</td>
                                                    <td>12</td>
                                                    <td style="font-size: 24px; color:blue;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td> 
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Paul</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>21</td>
                                                    <td style="font-size: 24px; color:black;"><i class="fa fa-user-circle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Gloria</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>12</td>
                                                    <td style="font-size: 24px; color:yellow;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></i></td>
                                                    <td>
                                                        <button type="submit" class="btn green">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Bradley</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>12</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                        <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Dai</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>11</td>
                                                    <td style="font-size: 24px; color:black;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Jenette</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>31</td>
                                                    <td style="font-size: 24px; color:blue;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Yuri</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>222</td>
                                                    <td style="font-size: 24px; color:green;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Caesar</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>1212</td>
                                                    <td style="font-size: 24px; color:yellow;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Doris</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>1212</td>
                                                   <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                        <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Angelica</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>121</td>
                                                    <td style="font-size: 24px; color:black;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                        <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Gavin</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>1212</td>
                                                    <td style="font-size: 24px; color:blue;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                        <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Jennifer</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>1212</td>
                                                    <td style="font-size: 24px; color:green;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Brenden</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>1211</td>
                                                    <td style="font-size: 24px; color:yellow;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Fiona</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>1111</td>
                                                    <td style="font-size: 24px; color:brown;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Shou</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>333</td>
                                                    <td style="font-size: 24px; color:grey;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Michelle</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>444</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Suki</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>434</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Prescott</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>42</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Gavin</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>43</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Martena</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>53</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Unity</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>54</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Howard</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>454</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Hope</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>4543</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Vivian</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>343</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Timothy</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>545</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Jackson</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>45</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td>
                                                    <button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Olivia</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>454</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td><button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Bruno</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>454</td>
                                                   <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td><button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Sakura</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>454</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td><button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Thor</td>
                                                    <td>Mon, 15 Aug 05 15:52:01</td>
                                                    <td>ABC</td>
                                                    <td>4545</td>
                                                    <td style="font-size: 24px; color:red;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></td>
                                                    <td><button type="submit" class="btn blue">View</button><button type="submit" class="btn blue">Comment</button>
                                                    
                                                    </td>
                                                </tr>
                                                
                                            </tbody>
                                            <tfoot> 
                                            	
                                                <tr>
                                                    <th class="all">Group / User</th>
                                                    <th class="min-phone-l">Date / Time</th>
                                                    <th class="min-tablet">Vessel Name</th>
                                                    <th class="min-tablet">QC No.</th>
                                                    <th class="min-tablet">alert</th>
                                                    <th class="all">Comment</th>
                                                </tr>
                                                <tr>
                                                   <th class="min-tablet"> </th>
                                                    <th class="min-tablet"></th>
                                                    <th class="min-tablet">
                                                    <button type="submit" class="btn blue">Filter By</button>
                                                    </th>
                                                    <th class="min-tablet">
                                                    
                                                    <th class="min-tablet"></th>
                                                    <th class="min-tablet"></th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                                <!-- END EXAMPLE TABLE PORTLET-->
                            </div>
                            
                        </div>
                    </div>
                    <!-- END CONTENT BODY -->
                </div>
                 
        <!-- BEGIN CORE PLUGINS -->
        <script src="resources/js/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/datatable.js" type="text/javascript"></script>
        <script src="resources/js/datatables.min.js" type="text/javascript"></script>
        <script src="resources/js/datatables.bootstrap.js" type="text/javascript"></script>
        <script src="resources/js/table-datatables-responsive.min.js" type="text/javascript"></script>
        <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/select2.full.min.js" type="text/javascript"></script>
        <script src="resources/js/app.min.js" type="text/javascript"></script>
        <script src="resources/js/components-select2.min.js" type="text/javascript"></script> 
        <script src="resources/js/quick-nav.min.js" type="text/javascript"></script>
      <script type="text/javascript">
      	function getSubTopicByTopicId(val){
      		alert(val.value)

      		$.ajax({url : "findSubTopicsByTopicId",
    	        type : "POST",
    			data : {topicId : val.value},
    			success : function(response) {
        			alert(response);
        			
    			},error : function(jqXHR,textStatus,errorThrown) {
    				alert("error");
    			}
    		});
          	
          	}
      </script>
 
</body>


 
</html>