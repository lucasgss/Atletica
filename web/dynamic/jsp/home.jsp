<%-- 
    Document   : home
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
        <link type="text/css" rel="stylesheet" href="atletica/static/css/home.css" />

        <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

        <title>Atlética XXII de Setembro - Lista de itens</title>
        <script>
            function getItens() {
                var json = <%= (String) request.getAttribute("itens")%>
                return JSON.parse(json);
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <label>
                            <h2>Lista de itens</h2>
                        </label>
                    </div>
                </div>
                <div class="col-md-6">
                    <form role="form" action="atletica/AdicionarItem" method="get">
                        <button type="submit" id="logar" class="btn btn-primary">
                            Adicionar Item
                        </button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div>
                        <div id="semDados" class="alert alert-dismissable alert-danger">
                            <h4>
                                Não foi possivel montar a visualização!
                            </h4> 
                            <strong id="semDadosText">
                                Adicione itens para viasualizar!
                            </strong>
                        </div>	
                        <div> 
                            <table id="jsGrid" style="width:100%">
                                <thead>
                                <th>Id</th>
                                <th>Item </th>
                                <th>Quantidade </th>
                                <th>Valor unitario </th>
                                <th>Valor Total </th>
                                </thead>
                                <tbody id="gdTbItens">

                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
