<%-- 
    Document   : AddItem
    Created on : 03/07/2018
    Author     : Lucas Soares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="atletica/static/js/home.js"></script>

        <link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />

        <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

        <title>Atlética XXII de Setembro - Adicionar itens</title>
        <script>
            $(document).ready(function () {
                var cancelar = document.getElementById("btnCancelar");
                cancelar.addEventListener("click", function () {
                    history.back();
                }, true);

            });
        </script>
        <style type="text/css">
            body{
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <form role="form" action="inventario.html" method="post">
                        <div class="form-group">
                            <label for="item">
                                Item
                            </label>
                            <input name="descricao" type="text" required class="form-control" id="item" />
                        </div>
                        <div class="form-group">
                            <label for="quantidade">
                                Quantidade
                            </label>
                            <input name="quantidade" type="number" required class="form-control" id="quantidade" />
                        </div>
                        <div class="form-group">
                            <label for="valorUnitario">
                                Valor unitario
                            </label>
                            <input name="valor" type="number" required class="form-control" id="valorUnitario" />
                        </div>
                        <button type="submit" class="btn btn-primary">
                            Enviar
                        </button> 
                        <button type="button" id="btnCancelar" class="btn btn-secondary">
                            Cancelar
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
