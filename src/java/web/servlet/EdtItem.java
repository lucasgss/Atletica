/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Item;
import com.google.gson.Gson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas Soares
 */
public class EdtItem extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        ServletContext sc = req.getServletContext();

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
        }

        try {
            long id = Long.parseLong(req.getParameter("id"));
            String descricao = req.getParameter("descricao");
            int quantidade = Integer.parseInt(req.getParameter("quantidade"));
            double valor = Double.parseDouble(req.getParameter("valor"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtleticaPU");
            EntityManager em = emf.createEntityManager();

            Item i = em.find(Item.class, id);
            em.getTransaction().begin();
            i.setDescricao(descricao);
            i.setQuantidade(quantidade);
            i.setValor(valor);
            em.getTransaction().commit();

            em.close();
            emf.close();
            //if request is not from HttpServletRequest, you should do a typecast before
            //HttpSession session = req.getSession(false);
            //save message in session
            //session.setAttribute("itemAdicionado", true);
            resp.sendRedirect("Home");
            //sc.getRequestDispatcher("/dynamic/jsp/home.jsp").forward(req, resp); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
            try {
                req.setAttribute("falhaAadicionar", true);
                sc.getRequestDispatcher("/dynamic/jsp/addItem.jsp").forward(req, resp);
            } catch (Exception ex) {
                //Tratamento de erro de IO ou de Servlet..
                System.err.println(ex.getMessage());
            }
        }
    }//doPost

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") == null) {
            System.out.println("parametro id para editar vazio!");
        } else {
            ServletContext sc = req.getServletContext();
            try {
                long id = Long.parseLong(req.getParameter("id"));
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtleticaPU");
                EntityManager em = emf.createEntityManager();

                Item i = em.find(Item.class, id);
                Gson gson = new Gson();
                String jsonItem = gson.toJson(i);
                
                req.setAttribute("id", id);
                req.setAttribute("itemEditar", jsonItem);

                em.close();
                emf.close();
                req.getServletContext().getRequestDispatcher("/dynamic/jsp/edtItem.jsp").forward(req, resp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                try {
                    resp.sendRedirect("Home");
                } catch (Exception ex) {

                }
            }
        }

    }
}//EdtItem.java
