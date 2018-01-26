/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var lookupUrl = "lookup.do";
    var similarUrl = "similar.do";

    function appendEntries(msg) {

        $("#content").empty();
        var html = '';
        $.each(msg, function (index, value) {
            html = html + "<div class='entry'><p class='type'>" + value['type'] + "</p><p class='definition'>" + value['definition'] + "</p></div>";
        });
        $("#content").append(html);
    }

    function appendSimilars(msg) {
        $("#similar").empty();
        var html = "";
        $.each(msg, function (index, value) {
            
            html = html + "<a class='similar' href='#'>" + value + "</a>";
        });
        $("#similar").append("<div id='similarTitle'>Similar Words</div>");
        $("#similar").append(html);
    }
    
    $("#searchButton").click(function () {
        var inputWord = $("#inputWord").val();
        $.ajax({
            url: lookupUrl,
            data: {word: inputWord},
            dataType: "json"
        }).done(function (msg) {
//            console.log(msg);
            appendEntries(msg);
        });

        $.ajax({
            url: similarUrl,
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