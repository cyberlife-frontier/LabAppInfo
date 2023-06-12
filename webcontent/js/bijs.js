/*$("#date_purchase").datetimepicker({
  format: 'YYYY-MM-DD',
  locale: moment.locale('zh-CN'),
         
});*/

function csschange(){
    var key =  $("#key-change option:selected").val();

    $('#name-key').attr("name","value");
    $('#num-key').attr("name","value");
    
    switch(key){
		case "app_name":
			$('#num-key').removeAttr("name");
        	$('#num-key').hide();
        	$('#name-key').show();
		break;
		case "app_num":
			$('#name-key').removeAttr("name");
        	$('#name-key').hide();
			$('#num-key').show();
		break;
		
	}
   
};

$('#addInfoModal').on('show.bs.modal');


$('#delInfoModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var app_num = button.data('app_num')
        var modal = $(this)
        
        modal.find('#deleteLabel').text('是否删除仪器编号  ' + app_num + ' 的信息')
        modal.find('#AppNum').val(app_num)
        
        
    });
    
    
