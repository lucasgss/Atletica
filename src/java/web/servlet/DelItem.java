/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import api.modelo.Item;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Soares
 */
public class DelItem extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result = "NOK";
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtleticaPU");
            EntityManager em = emf.createEntityManager();

            Item i = em.find(Item.class, id);
            em.getTransaction().begin();
            em.remove(i);
            em.getTransaction().commit();
           
            em.close();
            emf.close();
            result = "OK";
        } catch (Exception e) {

        }
        PrintWriter out = response.getWriter();
        out.print(result);
        out.close();
    }

}
