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

<!-- panel-custom -->
<div class="panel-custom">
  <div class="panel-heading">
  
  </div>
  <div class="panel-body" >
  <!--search students info  -->
    <form  role="form" class="form-inline" action="" method="post" >
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
          	<c:forEach items="${ApplianceInfo }" var="abi">
            <option value="${abi.app_num }">${abi.app_num }</option>
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
        <button title="addStu" type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">
										<span style="margin-right: 5px" class="" aria-hidden="true">
											<i class="fa fa-user-plus">添加仪器信息</i>
											</span>
        </button>
       
      </div> <!-- add button -->
    </form>
  </div>
</div>
<!-- panel-custom -->

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
      
      <!-- delUserModal -->
      <button type="button" class="btn btn-danger "
                data-stu_id_card="${abi.app_num }" data-toggle="modal"
                onclick="" data-target="#delUserModal">
          <i class="fa fa-user-times">删除</i>
        </button> 
        <!-- delUserModal -->
        <!-- StuBasicInfo -->
        <button type="button" class="btn btn-default "
        		data-stu_id_card="${abi.app_num }"
        		
                 data-toggle="modal"
                 data-target="#stuStatusInfo">
          <i class="fa fa-user-times">仪器图片</i>
        </button>
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
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/bijs.js" ></script>

</body>

</html>