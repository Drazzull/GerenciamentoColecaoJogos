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
public class Categoria
{

    private Integer idCategoria;
    private String descricao;

    public Integer getIdCategoria()
    {
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria)
    {
        this.idCategoria = idCategoria;
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
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idCategoria);
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

        final Categoria other = (Categoria) obj;
        
        return Objects.equals(this.idCategoria, other.idCategoria);
    }
}
