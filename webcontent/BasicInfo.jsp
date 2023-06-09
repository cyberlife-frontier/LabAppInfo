<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/cet.ico" type="image/x-icon">
	<title>主页</title>
  		

</head>

<body>
<!--show basic info  -->
<div class="container">
  <table>
    <thead>
    <!-- 表页眉 -->
    <tr>
      <th>仪器编号</th>
      <th>仪器名称</th>
      <th>所在实验室编号</th>
      <th>购买日期</th>
      <th>仪器管理员</th>
      <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <!-- 表主体 -->
    
    <c:forEach items="${StuBasicInfo }" var="sbi" varStatus="state">
    <tr>
      <td>${sbi.stu_name }</td><!-- 姓名 -->
      <td>${sbi.stu_gender }</td><!--性别  -->
      <td>${sbi.stu_ID_type }</td><!-- 身份证类型 -->
      <td>${sbi.stu_ID_card }</td><!-- 身份证 -->
      <td>${sbi.stu_subject == 1 }</td><!-- 资格科目 -->
      <td>
      <!-- updateUserModal -->
      	 <button type="button" class="btn btn-default "
                  data-stu_name="${sbi.stu_name }"
                  

                  data-toggle="modal"
                  data-target="#updateUserModal">
        	<i class="fa fa-user-o">修改</i>
      	</button>
      <!-- updateUserModal -->
      <!-- delUserModal -->
      <button type="button" class="btn btn-danger "
                data-stu_id_card="${sbi.stu_ID_card }" data-toggle="modal"
                onclick="" data-target="#delUserModal">
          <i class="fa fa-user-times">删除</i>
        </button> 
        <!-- delUserModal -->
        <!-- StuBasicInfo -->
        <button type="button" class="btn btn-default "
        		data-stu_id_card="${StuStatusInfo[state.index].stu_ID_card }"
        		
                 data-toggle="modal"
                 data-target="#stuStatusInfo">
          <i class="fa fa-user-times">学籍信息</i>
        </button>
      </td>
    </tr>
    </c:forEach>
    
    </tbody>
    <!--表主体  -->
  </table>
</div>

<!--show basic info  -->
</body>

</html>