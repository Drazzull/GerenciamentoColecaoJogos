/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

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

    public void setEstado(char estado)
    {
        this.estado = estado;
    }

    public Date getDataObtencao()
    {
        return this.dataObtencao;
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

}
