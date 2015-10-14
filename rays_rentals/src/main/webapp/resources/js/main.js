$(document).ready(function(){	
	
	function tableScrollHeight(){
		var height = $(window).height();
		$(".table-scroll").css("max-height", height - "380");
		$(".table-scroll-small").height(height - 500);
	};
});


