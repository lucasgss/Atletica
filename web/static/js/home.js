$(document).ready( function () {
        montaGrid();
});

function montaGrid(){
    $("#jsGrid").show();
    Js = getItens();
    if (Js.length == 0){
            $("#semDados").show();
            return;
    }

    var content = "";
    for (i = 0; i < Js.length; i++) {
            var t = Js[i];
            content +="<tr>";
            content += "<td>" + t.id + "</td>";
            content += "<td>" + t.descricao + "</td>";
            content += "<td id='qtd"+t.id+"'>" + t.quantidade + "</td>";
            content += "<td> R$" + t.valor + "</td>";
            content += "<td> R$" + (t.quantidade * t.valor) + "</td>";
            content += "<td> <a href='EditarItem?id=" + t.id + "'><i class='fas fa-edit'></i></a></td>";
            content +="</tr>";
    }
    $("#gdTbItens").html(content);
    $('#jsGrid').DataTable({
        "language": {
        "url": "https://cdn.datatables.net/plug-ins/1.10.16/i18n/Portuguese-Brasil.json"
    }});
}