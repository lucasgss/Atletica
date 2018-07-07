/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import api.dao.ItemDao;
import api.modelo.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Soares
 */
public class ItemDAOMariaDB10 implements ItemDao {
    
    Connection conexao;
    
    public ItemDAOMariaDB10(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.mariadb.jdbc.Driver");
            /* Abertura de conexão: */
            /* Notar que poderia ser substituida por
            uma chamada de get instance de uma conexão já aberta. 
            */
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/agenda","usuario", "usuario123"); 
            //conexao = DriverManager.getConnection("jdbc:mysql://150.163.17.237:3306/agenda?" +
            //                       "user=usuario&password=usuario123");
            System.out.println("Conectado.. Item DAO...");
        } catch (Exception e){
            System.out.print("Erro de conexão...ItemDAOMYSQL");
        }
        
    }

    @Override
    public Item insert(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item findByNomeItem(String nomeItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> findAll() {
        List<Item> l = new ArrayList();
        
        try {
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from atletica.inventario");  
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectado...");
            int c = 0;
            while (rs.next()) {
                c+=1;
                System.out.println("Lendo Item ${c}");
                Item i = new Item();
                i.setId(rs.getLong(1));
                i.setQuantidade(rs.getInt(2));
                i.setValor(rs.getDouble(3));
                l.add(i);
            }
        }
        catch (Exception e)
        {
          System.out.print("\nErro de conexão... find all item.");
        }
        
        return l;
    }

    @Override
    public Item update(Item itemAnt, Item itemAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
