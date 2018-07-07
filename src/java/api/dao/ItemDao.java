/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dao;

import api.modelo.Item;
import java.util.List;

/**
 *
 * @author Lucas Soares
 */
public interface ItemDao {
    public Item insert(Item item);
    public Item findById(Long id);
    public Item findByNomeItem(String nomeItem);
    public Item findByName(String name);
    public List<Item> findAll();
    public Item update(Item itemAnt, Item itemAt);
    public boolean delete(Item item);
    public boolean delete(Long id);   
}
