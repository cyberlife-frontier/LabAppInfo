<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/cet.ico" type="image/x-icon">
	<title>仪器管理</title>
  	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">

</head>

<body>

<div class="video-wrap">
    <video class="video-wrap__video" poster="images/img-bg@2x.png" 
    src="videos/bg-video.mp4"  tabindex="-1"    
    autoplay muted  loop>
    </video>
</div>


<!-- panel-custom -->
<div class="panel-custom">
  <div class="panel-heading">
  
  </div>
  <div class="panel-body" >
  <!--search students info  -->
    <form  role="form" class="form-inline" action="AppBasicInfo?method=queryinfo" method="post" >
      <div class="form-group">
        <label style="color:white;">条件：
          <select name="key" class="form-control" id="key-change"  onchange="csschange()">
            <option value="app_name">仪器名称</option>
            <option value="app_num">仪器编号</option>
            
          </select>
        </label>
      </div>

      <div class="form-group">
        <label style="color:white;">值：
          <input id="name-key" type="text" class="form-control" name="value" placeholder="关键字" maxlength="40" >
          <input type="text" class="form-control" id="num-key" list="datanum" placeholder="关键字" style="display:none;">
          <datalist id="datanum" class="form-control" style="display:none;">
          	<c:forEach items="${AppNum }" var="an">
            <option value="${an }"></option>
            </c:forEach>
          </datalist>
          
        </label>
      </div>

      <div class="form-group">
        <button type="submit" class="button-search ">
										<span style="margin-right: 5px"
                                              class="icon-search" aria-hidden="true">
										</span>开始搜索
        </button>
        <!--search students info  -->
      </div>
       <!-- add button-->
      <div class="form-group " style="margin-left: 40px">
        <button title="addStu" type="button" class="btn btn-default" data-toggle="modal" data-target="#addInfoModal">
										<span style="margin-right: 5px" class="" aria-hidden="true">
											<i class="fa fa-user-plus">添加仪器信息</i>
											</span>
        </button>
       
      </div> <!-- add button -->
      <div class="form-group " style="margin-left: 40px">
      <a href="InfoStatistics?method=yearAppStat" target="_blank">
      <button type="button" class="button-default">统计</button>
      </a>
      </div>
      
    </form>

  </div>
</div>
<!-- panel-custom -->

<!-- add AppInfo modal-->
<form method="post" enctype="multipart/form-data" action="AppBasicInfo?method=addAppInfo" 
class="form-horizontal" style="margin-top: 0px;margin: 20px;" 
role="form" id="form_data">
  <div class="modal fade" id="addInfoModal" tabindex="-1"
       role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"
                  aria-hidden="true">x</button>
          <h4 class="modal-title" id="myModalLabel">添加仪器信息</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" role="form">
            <!--appNum form-group -->
            <div class="form-group">
              <label for="app_num" class="col-sm-3 control-label">仪器编号</label>
              <div class="col-sm-9">
                <input type="text" required class="form-control" id="app_num"
                       name="app_num" placeholder="仪器编号" maxlength="9">
              </div>
            </div>
            <!--appNum form-group -->
            
            <!--appName form-group -->
            <div class="form-group">
              <label for="app_name" class="col-sm-3 control-label">仪器名称</label>
              <div class="col-sm-9">
                <input type="text" required class="form-control" id="app_name"
                       name="app_name" placeholder="仪器名称">
              </div>
            </div>
            <!--appName form-group -->
            
            <!--labNum form-group -->
            <div class="form-group">
              <label for="lab_num" class="col-sm-3 control-label">实验室编号</label>
              <div class="col-sm-9">
                <select  required class="form-control" id="lab_num"
                       name="lab_num" >
                   <c:forEach items="${InfoStat }" var="info">
                   	<option value="${info }">${info }</option>
                   </c:forEach>
                </select>
              </div>
            </div>
            <!--labNum form-group -->
            
            <!--datePurchase form-group -->
            <div class="form-group">
              <label for="date_purchase" class="col-sm-3 control-label">购买日期</label>
              <div class="col-sm-9">
                <input type="date" required class="form-control" id="date_purchase"
                       name="date_purchase" >
              </div>
            </div>
            <!--datePurchase form-group -->
           
            <!--appAdmin form-group -->
            <div class="form-group">
              <label for="app_admin" class="col-sm-3 control-label">仪器管理员</label>
              <div class="col-sm-9">
                <select multiple required class="form-control" id="app_admin"
                       name="app_admin" >
                   <c:forEach items="${PersonnelAdmin }" var="pa">
                   	<option value="${pa }">${pa }</option>
                   </c:forEach>
                       
                 </select>  
              </div>
            </div>
            <!--appAdmin form-group -->

			<!-- appPic form-group -->
            <div class="form-group">
              <label for="app_pic" class="col-sm-3 control-label">仪器图片</label>
              <div class="col-sm-9">
                <input type="file"  class="form-control" id="app_pic"
                       name="app_pic" multiple>
              </div>
            </div>
          <!-- appPic form-group -->
          
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </div>
      </div>
    </div>
  </div>
</form>
<!-- add AppInfo modal-->

<!-- delete app info modal -->
<form method="post" action="AppBasicInfo?method=delAppInfo"
      class="form-horizontal" style="margin-top: 0px" role="form"
      id="delete_form_data" style="margin: 20px;">
  <div class="modal fade" id="delInfoModal" tabindex="-1"
       role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"
                  aria-hidden="true">×</button>
          <h4 class="modal-title" id="DeleteModalLabel">删除仪器信息</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" role="form">
            <div class="form-group">
              <div class="col-sm-9">
                <p style="font-size:17px"  class="col-sm-18 control-label" 
                id="deleteLabel">删除信息</p>

                <input type="hidden" required id="AppNum"
                      name="app_num" >
              </div>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-danger">删除</button>
          <span id="tip"> </span>
        </div>
      </div>
    </div>
  </div>
</form>
 <!-- delete app info modal -->

<!-- appPicShow -->
<!-- <form method="post" action="ShowPic.jsp" id="picShow" target="_blank">
<div class="modal fade" id="picShowModal" tabindex="-1"
       role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<input type="hidden" name="app_num" id="picAppNum">
</div>
</form> -->

<!-- appPicShow -->

<!--show basic info  -->
<div class="container">
  <table>
    <thead>
    <!-- 表页眉 -->
    <tr>
      <th>仪器编号</th>
      <th>仪器名称</th>
      <th>实验室编号</th>
      <th>购买日期</th>
      <th>仪器管理员</th>
      <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <!-- 表主体 -->
    
    <c:forEach items="${ApplianceInfo }" var="abi" varStatus="state">
    <tr>
      <td>${abi.app_num }</td><!-- 仪器编号 -->
      <td>${abi.app_name }</td><!--仪器名称  -->
      <td>${abi.lab_num }</td><!-- 所在实验室编号 -->
      <td>${abi.date_purchase }</td><!-- 购买日期 -->
      <td>${abi.app_admin }</td><!-- 仪器管理员 -->
      <td>
      
      <!-- delInfoModal -->
      <button type="button" class="btn btn-danger "
                data-app_num="${abi.app_num }" data-toggle="modal"
                onclick="" data-target="#delInfoModal">
          <i class="fa fa-user-times">删除</i>
        </button> 
        <!-- delInfoModal -->
        <!-- AppPic -->
        <a href="AppBasicInfo?method=showAppPic&app_num=${abi.app_num }"
         target="_blank">
        <button type="button" class="btn btn-default">仪器图片</button>
        </a>
        <!-- AppPic -->
      </td>
    </tr>
    </c:forEach>
    
    </tbody>
    <!--表主体  -->
  </table>
</div>
<!--show basic info  -->

<!--the sequence of imported scripts cannot be changed -->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<!-- <script src="https://cdn.bootcss.com/moment.js/2.22.1/moment-with-locales.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script> -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/bijs.js" ></script>

</body>

</html>