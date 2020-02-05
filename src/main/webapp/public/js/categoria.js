$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8090/categorias/1"
    }).then(function(data) {
    	$('.titulo').append("<h3 class='header'>"+ data.nome +"</h3>");
    	
    	var table = $('#CategoriaTable tbody');
    	
    	$.each(data.produtos, function (key, item) {
    		table.append("<tr><td>" + item.id + "</td><td>" + item.nome + "</td><td>" + item.preco + "</td></tr>");
        });
    });
});