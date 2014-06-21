/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Drazzull
 */
public class Distribuidora
{

    private Integer idDistribuidora;
    private String nome;

    public Integer getIdDistribuidora()
    {
        return this.idDistribuidora;
    }

    public void setIdDistribuidora(Integer idDistribuidora)
    {
        this.idDistribuidora = idDistribuidora;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idDistribuidora);
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
        final Distribuidora other = (Distribuidora) obj;

        return Objects.equals(this.idDistribuidora, other.idDistribuidora);
    }

}
