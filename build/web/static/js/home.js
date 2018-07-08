$(document).ready(function () {
    montaGrid();
});
function excluirItem(itemId, itemNome) {
    $("#TrGd" + itemId).hide();

    $.post(
            "DeletarItem",
            {id: itemId},
            function (result) {
                console.log(result);
                if (result == "OK") {
                    alert("Item " + itemNome + " excluido com sucesso!");
                    $("#TrGd" + itemId).remove();
                } else {
                    alert('Erro ao exlcuir o item ' + itemNome);
                    $("#TrGd" + itemId).show();
                }
            });
}
function montaGrid() {
    $("#jsGrid").show();
    Js = getItens();
    if (Js.length == 0) {
        $("#semDados").show();
        return;
    }

    var content = "";
    for (i = 0; i < Js.length; i++) {
        var t = Js[i];
        content += "<tr id='TrGd" + t.id + "'>";
        content += "<td>" + t.id + "</td>";
        content += "<td>" + t.descricao + "</td>";
        content += "<td id='qtd" + t.id + "'>" + t.quantidade + "</td>";
        content += "<td> R$" + t.valor + "</td>";
        content += "<td> R$" + (t.quantidade * t.valor) + "</td>";
        content += "<td class='edt'> <a href='EditarItem?id=" + t.id + "'><i class='fas fa-edit'></i></a></td>";
        content += "<td class='del'> <a href='#' onclick='excluirItem(" + t.id + ",\"" + t.descricao + "\");return false;'><i class='fas fa-minus-circle'></i></a></td>";
        content += "</tr>";
    }
    $("#gdTbItens").html(content);
    $('#jsGrid').DataTable({
        "language": {
            "url": "https://cdn.datatables.net/plug-ins/1.10.16/i18n/Portuguese-Brasil.json"
        }});

}