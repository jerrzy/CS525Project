/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var lookupUrl = "lookup.do";
    var similarUrl = "similar.do";
    var articleUrl = "article.do";
    var userUrl = "user.do";
    
    initPageData();
    attachSerachAction();
    
    function initPageData(){
    	var userId = $("#inputParams").attr("userId");
    	var articleId = $("#inputParams").attr("articleId");
    	if(userId === "" && articleId === ""){
    		listAllArticles();
    	} else {
    		loadArticleById(userId, articleId);
    	}
    }
    
    /*
     * get user by userId
     */
    function getUserById(userId){
    	var userObj;
    	$.ajax({
    		url:userUrl,
    		type:'get',
    		data:{
    			userId:userId
    		},
    		async: false,
    		dataType:'json'
    	}).done(function(msg){
    		console.log(msg);
    		userObj = msg;
    	});
    	return userObj;
    }
    
    /*
     * list all articles
     */
    function listAllArticles(){
    	
    	$.ajax({
            url: articleUrl,
            type: 'get',
            dataType: 'json'
        }).done(function (msg) {
            console.log(msg);
            appendArticles(msg);
        });
    }
    
    function lookupWord(word) {
    	$.ajax({
            url: lookupUrl,
            type: 'get',
            data: {word: word},
            dataType: "json"
        }).done(function (msg) {
//            console.log(msg);
            appendEntries(msg);
        });

        $.ajax({
            url: similarUrl,
            type: 'get',
            data: {
                input: word
            },
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
            appendSimilars(msg);
        });
    }
    /*
     * search articles by key word
     */
    function searchArticlesByKeyWord(keyWord) {
    	$.ajax({
            url: articleUrl,
            type: 'get',
            data: {
            	keyWord:keyWord
            	},
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
            appendArticles(msg);
        });
    }
    
    /*
     * search articles by user ID
     */
    function searchArticlesByUserName(userId){
    	$.ajax({
            url: articleUrl,
            type: 'get',
            data: {
            	userId:userId
            	},
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
            appendArticles(msg);
        });
    }
    /*
     * load specific article
     */
    function loadArticleById(userId, articleId){
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
    	
    	var user = getUserById(msg['userId']);
    	
    	$("#articlecontent").empty();
    	var html = "<p class='articleTitle'>" + msg['title'] + "</p>";
    	html += "<p class='articleDate'>" + msg['date'] + "</p>";
    	html += "<p class='articleContent'>"+ msg['content'] + "</p>"
		html += "<p class='articleAuthor'> by: " + user['userName'] + "</p>";    	
    	$("#articlecontent").append(html);
    }
    
    function appendArticles(msg){
    	$("#articlecontent").empty();
    	var html = "<table style='width:100%'>";
    	
    	// the table header
    	//html += "<tr><th>Index</th><th>Title</th><th>Content</th><th>Author</th></tr>";
    	$.each(msg, function(index, value){
    		
    		var user = getUserById(value['userId']);
    		var detailLink = "index.jsp?articleId=" + value['id'];
    		html += "<tr>";   
    		html += "<td>" + (index + 1) + "</td>";
    		html += "<td class='articleTitle'>" + wrapValueWithLink(value['title'], detailLink) + "</td>";
    		//html += "<td class='articleContent'>" + wrapValueWithLink(value['content'], detailLink) + "</td>"; 
    		html += "<td class='articleAuthor'>" + user['userName'] + "</td>";
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
    
    function attachSerachAction(){
    	$("#searchButton").click(function () {
            var inputWord = $("#inputWord").val();
            var searchOption = $("input:checked").val();
            console.log("serch option:"+searchOption);
            if(searchOption === "word"){
            	lookupWord(inputWord);
            } else if(searchOption === "article"){
            	searchArticlesByKeyWord(inputWord);
            } else if(searchOption === "user"){
            	searchArticlesByUserName(inputWord);
            }
        });
    }
});