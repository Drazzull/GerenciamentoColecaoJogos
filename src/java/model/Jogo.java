/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Drazzull
 */
public class Jogo implements Serializable
{

    private Integer idJogo;
    private String nome;
    private double precoPago;
    private char estado;
    private Date dataObtencao;
    private Categoria categoria = new Categoria();
    private Categoria subCategoria = new Categoria();
    private Distribuidora distribuidora = new Distribuidora();
    private Obtencao obtencao = new Obtencao();

    public Integer getIdJogo()
    {
        return this.idJogo;
    }

    public void setIdJogo(Integer idJogo)
    {
        this.idJogo = idJogo;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public double getPrecoPago()
    {
        return this.precoPago;
    }

    public void setPrecoPago(double precoPago)
    {
        this.precoPago = precoPago;
    }

    public char getEstado()
    {
        return this.estado;
    }

    public String getEstadoString()
    {
        if (this.estado == 'N')
        {
            return "Normal";
        }
        return "Emprestado";
    }

    public void setEstado(char estado)
    {
        this.estado = estado;
    }

    public Date getDataObtencao()
    {
        return this.dataObtencao;
    }

    public String getDataObtencaoString()
    {
        Calendar cal = new GregorianCalendar();
        cal.setTime(this.dataObtencao);
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        return String.format("%02d", dia) + "/" + String.format("%02d", mes) + "/" + String.format("%04d", ano);
    }

    public void setDataObtencao(Date dataObtencao)
    {
        this.dataObtencao = dataObtencao;
    }

    public Categoria getCategoria()
    {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
    }

    public Categoria getSubCategoria()
    {
        return this.subCategoria;
    }

    public void setSubCategoria(Categoria subCategoria)
    {
        this.subCategoria = subCategoria;
    }

    public Distribuidora getDistribuidora()
    {
        return this.distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora)
    {
        this.distribuidora = distribuidora;
    }

    public Obtencao getObtencao()
    {
        return this.obtencao;
    }

    public void setObtencao(Obtencao obtencao)
    {
        this.obtencao = obtencao;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idJogo);
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
        final Jogo other = (Jogo) obj;

        return Objects.equals(this.idJogo, other.idJogo);
    }

}
