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
import dao.DistribuidoraDao;
import dao.JogoDao;
import dao.ObtencaoDao;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Categoria;
import model.Distribuidora;
import model.Jogo;
import model.Obtencao;

@ManagedBean
public class JogoBean
{

    JogoDao jogoDao = new JogoDao();
    CategoriaDao categoriaDao = new CategoriaDao();
    CategoriaDao subCategoriaDao = new CategoriaDao();
    DistribuidoraDao distribuidoraDao = new DistribuidoraDao();
    ObtencaoDao obtencaoDao = new ObtencaoDao();

    private final Jogo jogo = new Jogo();

    public Jogo getJogo()
    {
        return this.jogo;
    }

    public void gravar() throws IOException
    {
        this.jogoDao.salvar(this.getJogo());
    }

    public List<Jogo> getJogos()
    {
        return this.jogoDao.getJogo();
    }

    public List<Categoria> getCategorias()
    {
        return this.categoriaDao.getCategoria();
    }

    public List<Categoria> getSubCategorias()
    {
        return this.subCategoriaDao.getCategoria();
    }

    public List<Distribuidora> getDistribuidoras()
    {
        return this.distribuidoraDao.getDistribuidora();
    }

    public List<Obtencao> getObtencoes()
    {
        return this.obtencaoDao.getObtencao();
    }
}
