/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.UsuarioDAO;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.dao.UsuarioDAOMariaDB10;

/**
 *
 * @author fabriciogmc
 */
public class ServicoUsuarioImpl implements ServicoUsuario {

    @Override
    public Usuario insert(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByEmail(String nomeUsuario) {
        UsuarioDAO uDao = new UsuarioDAOMariaDB10();
        Usuario u = uDao.findByEmail(nomeUsuario);
        return u;
    }    
}
