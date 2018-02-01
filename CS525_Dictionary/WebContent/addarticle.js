/**
 * 
 */
$(document).ready(function () {
	
	var articleUrl = "article.do";
	
	function postNewArticle(userId, title, content){
		$.ajax({
			url: articleUrl,
			type: 'post',
			data:{
				userId: userId,
				title: title,
				content: content
			},
		}).done(function(msg){
			if(msg !== "0" || msg !== 0){
				alert("new Article added.");
			}
		});
	}
	
	$("#submitButton").click(function(){
		var userId = $("#articleUserId").val();
		var title = $("#articleTitle").val();
		var content = $("#articleContent").val();
		
		console.log("user ID:" + userId);
		console.log("article title:" + title);
		console.log("article content:" + content);
		
		postNewArticle(userId, title, content);
	});
});