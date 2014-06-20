/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Drazzull
 */
import dao.CategoriaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Categoria;

@ManagedBean
public class CategoriaBean {
    CategoriaDao categoriaDao = new CategoriaDao();

    private final Categoria categoria = new Categoria();

    public Categoria getCategoria() {
        return categoria;
    }

    public void gravar() {
        categoriaDao.salvar(this.getCategoria());
    }
    
    public List<Categoria> getCategorias() {
        return categoriaDao.getCategoria();
    }
}
