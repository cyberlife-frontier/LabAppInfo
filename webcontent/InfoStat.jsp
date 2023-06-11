<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh" style="height: 100%">
<head>
	<meta charset="UTF-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/cet.ico" type="image/x-icon">
	<title>信息统计</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" 
	src="https://fastly.jsdelivr.net/npm/echarts@5.4.2/dist/echarts.min.js">
	</script>
</head>

<body style="height: 100%; margin: 0">
<!-- panel-custom -->
<div class="panel-custom">
  <div class="panel-heading">
  
  </div>
  <div class="panel-body" >
  <!--search students info  -->
    <form  role="form" class="form-inline" action="InfoStatistics?method=labAppStat" method="post" >
      <div class="form-group">
       <label style="color:white;">条件：
          <span class="form-control">
            实验室编号
          </span>
        </label> 
      </div>

      <div class="form-group">
        <label style="color:white;">值：
          <input type="text" class="form-control" name="value"  list="datanum" placeholder="关键字">
          <datalist id="datanum" class="form-control" style="display:none;">
          	<c:forEach items="${InfoStat }" var="info">
            	<option value="${info }"></option>
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
      
      <div class="form-group">
        <button type="button" class="button-default" onclick="showDia()"
        >年份采购统计
        </button>
        <!--years app stat info  -->
      </div>
      
    </form>
  </div>
</div>
<!-- panel-custom -->


<!--不同年份购置仪器数量变化  -->

<dialog id ="DialogInfo"  style="height: 70%;width:70%;top:10%;left:20%;">
	
    <div id="yearStat" style="height: 100%"></div>
	<button onclick="closeDia()" class="btn btn-danger">关闭</button>
</dialog>
<script type="text/javascript">
var DialogInfo = document.getElementById("DialogInfo");
function showDia(){
	
     DialogInfo.showModal();
     showStat();
}
	
function closeDia(){

    DialogInfo.close();

}
</script>
<script type="text/javascript">
function showStat(){
    var dom = document.getElementById('yearStat');
    var myChart = echarts.init(dom, null, {
      renderer: 'canvas',
      useDirtyRect: false
    });
    var app = {};
    
    var option;

    option = {
  xAxis: {
    type: 'category',
    data: [
    	<c:forEach items="${YearAppStat }" var="yas"> 
    	  "${yas.years }",
  		</c:forEach>
    	
    	]
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [
    	  <c:forEach items="${YearAppStat }" var="yas"> 
    	  		"${yas.counts }",
  			</c:forEach>
    	  
    	  ],
      type: 'line'
    }
  ]
};

    if (option && typeof option === 'object') {
      myChart.setOption(option);
    }

    window.addEventListener('resize', myChart.resize);
  
}
</script>
<!--不同年份购置仪器数量变化  -->


<!--各实验室仪器数量占比  -->
<div id="container" style="height: 100%"></div>

<script type="text/javascript">
    var dom = document.getElementById('container');
    var myChart = echarts.init(dom, null, {
      renderer: 'canvas',
      useDirtyRect: false
    });
    var app = {};

    var option;

    option = {
  title: {
    text: '实验室各仪器占比图',
    subtext: "${LabNum }",
    left: 'center'
  },
  tooltip: {
    trigger: 'item',
    formatter: '{a} <br/>{b} : {c} ({d}%)'
  },
  legend: {
    left: 'center',
    top: 'bottom',
    data: [
    <c:forEach items="${LabAppStat }" var="info"> 
  	  "${info.app_name }",
	</c:forEach>
    ]
  },
  toolbox: {
    show: true,
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  series: 

    {
      name: 'Area Mode',
      type: 'pie',
      radius: [20, 140],
      center: ['50%', '50%'],
      roseType: 'area',
      itemStyle: {
        borderRadius: 5
      },
      data: [
    	<c:forEach items="${LabAppStat }" var="info"> 
    	  { value:"${info.counts }", name:"${info.app_name }"},
		</c:forEach>

      ]
    }

};

    if (option && typeof option === 'object') {
      myChart.setOption(option);
    }

    window.addEventListener('resize', myChart.resize);
  </script>
<!--各实验室仪器数量占比  -->


</body>
</html>