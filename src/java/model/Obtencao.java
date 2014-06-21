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
public class Obtencao
{

    private Integer idObtencao;
    private String descricao;

    public Integer getIdObtencao()
    {
        return this.idObtencao;
    }

    public void setIdObtencao(Integer idObtencao)
    {
        this.idObtencao = idObtencao;
    }

    public String getDescricao()
    {
        return this.descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.idObtencao);
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

        final Obtencao other = (Obtencao) obj;
        return Objects.equals(this.idObtencao, other.idObtencao);
    }

}
