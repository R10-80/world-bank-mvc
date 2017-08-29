$(document).ready(function() {

	$("#incomeLevel").click(function() {
		$.ajax({url: "incomeLevels.html", success: function(result){
	        console.log('income levels hit');
	    }});

	});

});