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

$('#addUserModal').on('show.bs.modal');

$('#delUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var stu_id_card = button.data('stu_id_card')
        var modal = $(this)
        /*modal.find('.modal-title').text('删除宿管信息')*/
        modal.find('#deleteLabel').text('是否删除身份证号码为  ' + stu_id_card + ' 的信息')
        modal.find('#id').val(stu_id_card)
        
    });
    
    
