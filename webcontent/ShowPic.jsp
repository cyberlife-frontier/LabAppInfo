<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="zh">
<head>
	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/cet.ico" type="image/x-icon">
	<title>图片显示</title>
</head>


<body>
	<h4>${app_num }</h4>
	<c:forEach items="${showPic }" var="sp">
	<img alt="图片缺失" src="${sp }">
	</c:forEach>

</body>
</html>