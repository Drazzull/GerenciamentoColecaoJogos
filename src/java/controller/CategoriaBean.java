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
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Categoria;

@ManagedBean
public class CategoriaBean {
    CategoriaDao categoriaDao = new CategoriaDao();

    private final Categoria categoria = new Categoria();

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void gravar() throws IOException {
        this.categoriaDao.salvar(this.getCategoria());
    }
    
    public List<Categoria> getCategorias() {
        return this.categoriaDao.getCategoria();
    }
}
