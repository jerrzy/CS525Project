$(document).ready(function() {
	var url = "login.do";
	alert("Hey");
	$("#login").click(function() {
		var name = $("#username").val();
		var pass = $("#userpass").val();
		
		console.log("name: "+name);
		console.log("Pass: "+pass);
		
		$.ajax({
			url : url,
			type : 'POST',
			data : {
				"name" : name,
				"password" : pass
			},
			dataType : "json"
		}).done(function(msg) {
			// console.log(msg);

		});
	});

});