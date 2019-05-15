var addresswsport = "https://helloworld-david.herokuapp.com";//"http://195.55.99.47:8082/HappyForce";//"http://52.17.173.22:21396/HappyForce";

$(document).ready(function() {
    loadComments();
});

function sendComment() {
	if($("#comentario").val() != null){
		if($("#comentario").val() == ""){
			createModal("Debe rellenar el comentario");
			return;
		}
	}else{
		createModal("Debe rellenar el comentario");
		return;
	}
	
	$("#loading").show();
	var jsonComentario = {
		"user":"Cabielles", "text":$("#comentario").val()
	}
	//crear el json striing
	var jsonComentarioString = JSON.stringify(jsonComentario);
    $.ajax({
        type: "POST",
        url: addresswsport + '/insercion/inserciones/insertarcomentario',
        crossDomain: false,
        data: jsonComentarioString,
        contentType: "application/json",
        dataType:'json',
        success: function(data) {
        	$("#loading").hide();
        	$("#comentario").val("");
        	loadComments();
        	createModal("Comentario enviado");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 0) {
                return;
            } else {
                createModal("Problema en el servidor");
    			$("#loading").hide();
            }
        }
    });
}

function setLikeDislike(kind, comment){
	$.ajax({
        type: "POST",
        url: addresswsport + '/insercion/inserciones/actualizarlikes/'+comment+'/'+kind,
        crossDomain: false,
        dataType:'json',
        success: function(data) {
        	//cambiar el texto
        	/*$("#loading").hide();
        	$("#comentario").val("");
        	loadComments();
        	createModal("Comentario enviado");*/
        },
        error: function(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 0) {
                return;
            } else {
                createModal("Problema en el servidor");
    			$("#loading").hide();
            }
        }
    });
}

function loadComments() {
	$.ajax({
        type: "GET",
        url: addresswsport+'/comentarios',
        crossDomain: false,
        success: function(data) {
            var comentariosString = JSON.stringify(data);
            var comentarios = JSON.parse(comentariosString);

            if(comentarios.length > 0){
    			clearBox("tabloncomentarios");
    			for (var i = 0; i < comentarios.length; i++) {
    				var comentarioActual = comentarios[i];
    				ponerComentarioEnTablon(comentarioActual);
    			};
    			$("#loading").hide();
            }else{
                createModal("No hay comentarios disponibles");
    			$("#loading").hide();
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            if(jqXHR.status==0){
                return;
            }else{
                createModal("Problema en el servidor");
    			$("#loading").hide();
            }
        }
    });
}

function ponerComentarioEnTablon(jsonComentario){
	var tablon = document.getElementById("tabloncomentarios");

	var card = document.createElement("div");
	card.setAttribute("class", "card");
	var cardbody = document.createElement("div");
	cardbody.setAttribute("class", "card-body");
	var row = document.createElement("div");
	row.setAttribute("class", "row");
	var divcol = document.createElement("div");
	divcol.setAttribute("class", "col-md-12");

	var puser = document.createElement("p");
	puser.setAttribute("class", "float-left text-primary");
	var pstrong = document.createElement("strong");
	pstrong.appendChild(document.createTextNode(jsonComentario["userName"]));
	var pspan = document.createElement("span");
	pspan.setAttribute("class", "text-dark");
	pspan.appendChild(document.createTextNode(" - "+jsonComentario["date"]));
	puser.appendChild(pstrong);
	puser.appendChild(pspan);

	var divclearfix = document.createElement("div");
	divclearfix.setAttribute("class", "clearfix");

	var pcomentario = document.createElement("p");
	pcomentario.appendChild(document.createTextNode(jsonComentario["text"]));

	var pbotones = document.createElement("p");

	var a1pcomentario = document.createElement("a");
	a1pcomentario.setAttribute("class", "float-right btn text-white btn-danger ml-2");
	a1pcomentario.setAttribute("onclick","setLikeDislike('dislike','"+jsonComentario["idComment"]+"')");
	a1pcomentario.setAttribute("disabled", "true"); //TEMPORAL
	ia1 = document.createElement("i");
	ia1.setAttribute("class", "fa fa-thumbs-down");
	a1pcomentario.appendChild(ia1);
	a1pcomentario.appendChild(document.createTextNode("No me gusta ("+jsonComentario["numDislikes"]+")"));

	var a2pcomentario = document.createElement("a");
	a2pcomentario.setAttribute("class", "float-right btn text-white btn-success");
	a2pcomentario.setAttribute("onclick","setLikeDislike('like','"+jsonComentario["idComment"]+"')");
	a2pcomentario.setAttribute("disabled", "true"); //TEMPORAL
	ia2 = document.createElement("i");
	ia2.setAttribute("class", "fa fa-thumbs-down");
	a2pcomentario.appendChild(ia2);
	a2pcomentario.appendChild(document.createTextNode("Me gusta ("+jsonComentario["numLikes"]+")"));

	pbotones.appendChild(a1pcomentario);
	pbotones.appendChild(a2pcomentario);

	divcol.appendChild(puser);
	divcol.appendChild(divclearfix);
	divcol.appendChild(pcomentario);
	divcol.appendChild(pbotones);
	row.appendChild(divcol);
	cardbody.appendChild(row);
	card.appendChild(cardbody);
	tablon.appendChild(card);

	var br = document.createElement("br");
	tablon.appendChild(br);
}

function createModal(textoCuerpo) {
    clearBox("cuerpomodal");
    var cuerpomodal = document.getElementById("cuerpomodal");
    cuerpomodal.appendChild(document.createTextNode(textoCuerpo));
    $("#myModal").modal();
}

function clearBox(elementID) {
    document.getElementById(elementID).innerHTML = "";
}