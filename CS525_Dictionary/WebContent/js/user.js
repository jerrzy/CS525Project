/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var userUrl = "user.do";
    
    initPageData();
    
    function initPageData(){
    	var userId = $("#inputParams").attr("userId");
    	
    	
    	if(userId === ""){
    		listUsers();
    	} else {
    		loadUser(userId);
    	}
    }
    
    /*
     * list all users
     */
    function listUsers(){
    	
    	$.ajax({
            url: userUrl,
            type: 'get',
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
        	showUsers(msg);
        });
    }
    
    /*
     * load specific article
     */
    function loadUser(userId){
    	$.ajax({
            url: userUrl,
            type: 'get',
            data: {
            	userId: userId            
            	},
            dataType: "json"
        }).done(function (msg) {
            console.log(msg);
            showUserDetail(msg);
        });
    }
    

    function showUserDetail(msg){
    	$("#usercontent").empty();
    	
    	var html = "<div class='userdetails'><h4> Word Lookup User Details</h4>";
    	html += "<div class='userp'>";
    	html += "<h5><img src='icons/user.png' width='16px' height='16px'> User Info</h5>";
    	html +=	"<p>Username: " + msg['userName'] + "</p>";
    	html += "<p>Name: "+ msg['firstName']+ " " + msg['lastName']  + "</p>";
    	
    	html += "<p>Email: "+ msg['email'] + "</p>";
    	html += "<p>Role: "+ msg['role'] + "</p>";
		
		html += "</div>";
		html += "<div class='userp'>";
    	html += "<h5><img src='icons/address.png' width='16px' height='16px'> User Adress</h5>";
    	html +=	"<p>Street: " + msg['street'] + "</p>";
    	html += "<p>City: "+ msg['city'] + "</p>";
		html += "<p>State:  " + msg['state'] + "</p>"; 
		html += "<p>Zipcode:  " + msg['zipcode'] + "</p>"; 
		html += "</div></div>";
    	
    	$("#usercontent").append(html);
    }
    
    function showUsers(msg){
    	$("#usercontent").empty();
    	var html = "<table style='width:100%'>";
    	
    	// the table header
    	//html += "<tr><th>Index</th><th>Title</th><th>Content</th><th>Author</th></tr>";
    	$.each(msg, function(index, value){
    		
    		var detailLink = "users.jsp?userId=" + value['id'];
    		html += "<tr>";  
    		html += "<td>" + (index + 1) + "</td>";
    		html += "<td class='userUserName'>" + wrapValueWithLink(value['userName'], detailLink) + "</td>";
    		html += "<td class='userFirstName'>" + wrapValueWithLink(value['firstName'], detailLink) + "</td>"; 
    		html += "<td class='userLastName'> by user: " + value['id'] + "</td>";
    		html += "</tr>";
    	});
    	html += "</table>";
    	$("#usercontent").append(html);
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