/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var lookupUrl = "lookup.do";
    var similarUrl = "similar.do";
    var articleUrl = "article.do";
    
    initPageData();
    
    function initPageData(){
    	var userId = $("#inputParams").attr("userId");
    	var articleId = $("#inputParams").attr("articleId");
    	if(userId === "" && articleId === ""){
    		listArticles();
    	} else {
    		loadArticle(userId, articleId);
    	}
    }
    
    /*
     * list all articles
     */
    function listArticles(){
    	
    	$.ajax({
            url: articleUrl,
            type: 'get',
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
            appendArticles(msg);
        });
    }
    
    /*
     * load specific article
     */
    function loadArticle(userId, articleId){
    	$.ajax({
            url: articleUrl,
            type: 'get',
            data: {
            	userId: userId,
            	articleId: articleId
            	},
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
            showArticleDetail(msg);
        });
    }
    
    function showArticleDetail(msg){
    	$("#articlecontent").empty();
    	var html = "<p>" + msg['title'] + msg['date'] + "</p>";
    	html += "<p>"+ msg['content'] + "</p>"
		html += "<p> by user: " + msg['userId'] + "</p>";    	
    	$("#articlecontent").append(html);
    }
    
    function appendArticles(msg){
    	$("#articlecontent").empty();
    	var html = "<table style='width:100%'>";
    	
    	// the table header
    	//html += "<tr><th>Index</th><th>Title</th><th>Content</th><th>Author</th></tr>";
    	$.each(msg, function(index, value){
    		
    		var detailLink = "index.jsp?articleId=" + value['id'];
    		html += "<tr>";   
    		html += "<td>" + (index + 1) + "</td>";
    		html += "<td class='articleTitle'>" + wrapValueWithLink(value['title'], detailLink) + "</td>";
    		//html += "<td class='articleContent'>" + wrapValueWithLink(value['content'], detailLink) + "</td>"; 
    		html += "<td class='articleUserName'> by user: " + value['userId'] + "</td>";
    		html += "<td class='articleDate'>" + value['date'] + "</td>";
    		html += "</tr>";
    	});
    	html += "</table>";
    	$("#articlecontent").append(html);
    }
    
    function wrapValueWithLink(value, link){
    	return "<a target='_blank' href='" + link + "'>" + value + "</a>";
    }
    
    function appendEntries(msg) {

        $("#searchcontent").empty();
        var html = '';
        $.each(msg, function (index, value) {
            html = html + "<div class='entry'><p class='type'>" + value['type'] + "</p><p class='definition'>" + value['definition'] + "</p></div>";
        });
        $("#searchcontent").append(html);
    }

    function appendSimilars(msg) {
        $("#searchsimilar").empty();
        var html = "";
        $.each(msg, function (index, value) {
            
            html = html + "<a class='similar' href='#'>" + value + "</a>";
        });
        $("#searchsimilar").append("<div id='similarTitle'>Similar Words</div>");
        $("#searchsimilar").append(html);
    }
    
    $("#searchButton").click(function () {
        var inputWord = $("#inputWord").val();
        $.ajax({
            url: lookupUrl,
            type: 'get',
            data: {word: inputWord},
            dataType: "json"
        }).done(function (msg) {
//            console.log(msg);
            appendEntries(msg);
        });

        $.ajax({
            url: similarUrl,
            type: 'get',
            data: {
                input: inputWord
            },
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
            appendSimilars(msg);
        });
    });
});