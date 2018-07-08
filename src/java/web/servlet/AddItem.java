/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Item;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Soares
 */
public class AddItem extends HttpServlet {   
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
        ServletContext sc = req.getServletContext();
        
        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
        
        try{
             String descricao = req.getParameter("descricao");
            int quantidade = Integer.parseInt(req.getParameter("quantidade"));
            double valor = Double.parseDouble(req.getParameter("valor"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtleticaPU"); 
            EntityManager em = emf.createEntityManager();

            Item i = new Item();
            i.setDescricao(descricao);
            i.setQuantidade(quantidade);
            i.setValor(valor);
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            
            req.setAttribute("itemAdicionado",true);
            sc.getRequestDispatcher("/dynamic/jsp/home.jsp").forward(req, resp); 
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            try {
                req.setAttribute("falhaAadicionar", true);
                sc.getRequestDispatcher("/dynamic/jsp/addItem.jsp").forward(req, resp);
            }catch(Exception ex){
                //Tratamento de erro de IO ou de Servlet..
                System.err.println(ex.getMessage());
            }  
        }
//        if (uBD!= null && uBD.getSenha().equals(senha)){
//            try{
//                req.setAttribute("usuarioLogado",uBD);
//                ItemDAOMariaDB10 iBD = new ItemDAOMariaDB10();
//                List<Item> itens = iBD.findAll();
//                Gson gson = new Gson();
//                String jsonItens = gson.toJson(itens);
//                System.out.println(jsonItens);
//                req.setAttribute("itens",jsonItens);
//                sc.getRequestDispatcher("/dynamic/jsp/home.jsp").forward(req, resp); 
//            }catch( Exception e){
//               //Tratamento de exceção... 
//            }            
//        }
//        else{
//            try {
//                req.setAttribute("falhaAadicionar", true);
//                sc.getRequestDispatcher("/dynamic/jsp/addItem.jsp").forward(req, resp);
//            }catch(Exception e){
//                //Tratamento de erro de IO ou de Servlet..
//            }  
//        }//if-else 
    }//doPost
    
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
        ServletContext sc = req.getServletContext();
        try{
            req.getServletContext().getRequestDispatcher("/dynamic/jsp/addItem.jsp").forward(req, resp);       
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}//AddItem.java