$(function(){
    $("#save").on('click', function(event){
    	event.preventDefault();
    	
    	$.ajax({
    	   type: 'POST',
    	   url:'/ajax',
    	   data: $("#form").serialize(),
    	   beforeSend: function(){  $("#pp").text("Loading..."); },
    	   success: function(result){
    		   console.log(result);
    		   table('#pp',null,result);
    	   }
    	});
    });
    
    function table(display, tnams, obj){
    	tab ='<table border=1>';
    	   $.each(obj, function(key, val){
      	     tab +='<tr><td>'+key+':</td><td>'+val+'</td></tr>';
      	   });
         tab +='</table>';
   		 $(display).html(tab);
    }
    
    
});