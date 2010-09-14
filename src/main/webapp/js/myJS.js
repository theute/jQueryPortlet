$(function() {

		//callback function to bring a hidden box back
		function callback(){
			setTimeout(function(){
				$("#effect:visible").removeAttr('style').hide().fadeOut();
			}, 1000);
		};
		
		//set effect from select menu value
		$("#button").click(function() {
			var options = {};
			$("#effect").show("bounce",options,500,callback);
			return false;
		});
		
		$("#effect").hide();
	});