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
import dao.EmprestimoDao;
import dao.JogoDao;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Emprestimo;
import model.Jogo;

@ManagedBean
public class EmprestimoBean
{

    EmprestimoDao emprestimoDao = new EmprestimoDao();
    JogoDao jogoDao = new JogoDao();

    private final Emprestimo emprestimo = new Emprestimo();

    public Emprestimo getEmprestimo()
    {
        return this.emprestimo;
    }

    public void gravar() throws IOException
    {
        this.emprestimoDao.salvar(this.getEmprestimo());
    }
    
    public void devolver(Emprestimo emprestimo) throws IOException
    {
        this.emprestimoDao.devolverEmprestimo(emprestimo);
    }

    public List<Emprestimo> getEmprestimos()
    {
        return this.emprestimoDao.getEmprestimo();
    }

    public List<Jogo> getJogos()
    {
        return this.jogoDao.getJogo(" WHERE jo.estado != 'E'");
    }

}
