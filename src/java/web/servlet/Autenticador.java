/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Item;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import com.google.gson.Gson;
import core.servico.ServicoUsuarioImpl;
import core.dao.ItemDAOMariaDB10;
import java.util.List;
import java.util.Arrays;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas Soares
 */
public class Autenticador extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
        }

        ServletContext sc = req.getServletContext();
        String nomeUsuario = req.getParameter("email");
        String senha = req.getParameter("senha");

        try {
            ServicoUsuario sUsuario = new ServicoUsuarioImpl();
            Usuario uBD = sUsuario.findByEmail(nomeUsuario);

            if (uBD != null && uBD.getSenha().equals(senha)) {
                try {
                    req.setAttribute("usuarioLogado", uBD);
                    String jsonItens = getJsonItens();
                    req.setAttribute("itens", jsonItens);
                    sc.getRequestDispatcher("/dynamic/jsp/home.jsp").forward(req, resp);
                } catch (Exception e) {
                    //Tratamento de exceção... 
                }
            } else {
                try {
                    req.setAttribute("falhaAutenticacao", true);
                    sc.getRequestDispatcher("/dynamic/jsp/login.jsp").forward(req, resp);
                } catch (Exception e) {
                    //Tratamento de erro de IO ou de Servlet..
                }
            }//if-else 

        } catch (Exception e) {
            //Tratamento de erro de BD..
        }
    }//doPost

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession(false);
        ServletContext sc = req.getServletContext();

        if (session.getAttribute("itemAdicionado") != null) {
            session.removeAttribute("itemAdicionado");
        }
        try {
            String jsonItens = getJsonItens();
            req.setAttribute("itens", jsonItens);
            sc.getRequestDispatcher("/dynamic/jsp/home.jsp").forward(req, resp);
        } catch (Exception e) {
            //Tratamento de erro de IO ou de Servlet..
        }

    }

    private String getJsonItens() {
        String jsonItens;

        try {
            ItemDAOMariaDB10 iBD = new ItemDAOMariaDB10();
            List<Item> itens = iBD.findAll();
            Gson gson = new Gson();
            jsonItens = gson.toJson(itens);
            System.out.println(jsonItens);
        } catch (Exception e) {
            //Não tratado erro de conexão ou conversão...
            throw e;
        }
        return jsonItens;
    }
}//Autenticador.java
