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
import dao.ObtencaoDao;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Obtencao;

@ManagedBean
public class ObtencaoBean {
    ObtencaoDao obtencaoDao = new ObtencaoDao();

    private final Obtencao obtencao = new Obtencao();

    public Obtencao getObtencao() {
        return this.obtencao;
    }

    public void gravar() throws IOException {
        this.obtencaoDao.salvar(this.getObtencao());
    }
    
    public List<Obtencao> getObtencoes() {
        return this.obtencaoDao.getObtencao();
    }
}
