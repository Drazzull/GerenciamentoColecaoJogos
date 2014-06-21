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
import dao.DistribuidoraDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Distribuidora;

@ManagedBean
public class DistribuidoraBean {
    DistribuidoraDao distribuidoraDao = new DistribuidoraDao();

    private final Distribuidora distribuidora = new Distribuidora();

    public Distribuidora getDistribuidora() {
        return this.distribuidora;
    }

    public void gravar() {
        this.distribuidoraDao.salvar(this.getDistribuidora());
    }
    
    public List<Distribuidora> getDistribuidoras() {
        return this.distribuidoraDao.getDistribuidora();
    }
}
