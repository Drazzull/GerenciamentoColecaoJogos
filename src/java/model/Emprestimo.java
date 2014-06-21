/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Drazzull
 */
public class Emprestimo
{

    private int idEmprestimo;
    private Jogo jogo = new Jogo();
    private String nomePessoa;
    private Date dataEmprestimo;
    private boolean devolvido;

    public int getIdEmprestimo()
    {
        return this.idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo)
    {
        this.idEmprestimo = idEmprestimo;
    }

    public Jogo getJogo()
    {
        return this.jogo;
    }

    public void setJogo(Jogo jogo)
    {
        this.jogo = jogo;
    }

    public String getNomePessoa()
    {
        return this.nomePessoa;
    }

    public void setNomePessoa(String nomePessoa)
    {
        this.nomePessoa = nomePessoa;
    }

    public Date getDataEmprestimo()
    {
        return this.dataEmprestimo;
    }

    public String getDataEmprestimoString()
    {
        Calendar cal = new GregorianCalendar();
        cal.setTime(this.dataEmprestimo);
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        return String.format("%02d", dia) + "/" + String.format("%02d", mes) + "/" + String.format("%04d", ano);
    }

    public void setDataEmprestimo(Date dataEmprestimo)
    {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public boolean getDevolvido()
    {
        return this.devolvido;
    }
    
    public void setDevolvido(boolean devolvido)
    {
        this.devolvido = devolvido;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 61 * hash + this.idEmprestimo;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        
        final Emprestimo other = (Emprestimo) obj;
        return this.idEmprestimo == other.idEmprestimo;
    }

}
