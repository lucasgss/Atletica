<%-- 
    Document   : menu
    Created on : 09/11/2017, 16:56:06
    Author     : fabriciogmc
--%>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <form role="form" action="<%= action %>" method="post">
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
                <%if (request.getAttribute("id")!= null){
                        out.print("<input name='id' type='hidden' id='id' value='"+ request.getAttribute("id") +"' />");
                    }                    
                %>
                <button type="submit" class="btn btn-primary">
                    Salvar
                </button> 
                <button type="button" id="btnCancelar" class="btn btn-secondary">
                    Cancelar
                </button>
            </form>
        </div>
    </div>
</div>
