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

/**
 *
 * @author fabriciogmc
 */
public class Autenticador extends HttpServlet {   
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServicoUsuario sUsuario = new ServicoUsuarioImpl();
        Usuario uBD = sUsuario.findByEmail(nomeUsuario);      
        ServletContext sc = req.getServletContext();
        if (uBD!= null && uBD.getSenha().equals(senha)){
            try{
                req.setAttribute("usuarioLogado",uBD);
                ItemDAOMariaDB10 iBD = new ItemDAOMariaDB10();
                List<Item> itens = iBD.findAll();
                Gson gson = new Gson();
                String jsonItens = gson.toJson(itens);
                System.out.println(jsonItens);
                req.setAttribute("itens",jsonItens);
                sc.getRequestDispatcher("/dynamic/jsp/home.jsp").forward(req, resp); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }            
        }
        else{
            try {
                req.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/dynamic/jsp/login.jsp").forward(req, resp);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }//if-else 
    }//doPost
}//Autenticador.java