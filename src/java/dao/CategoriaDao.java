/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import funcoes.Conecta;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Categoria;

/**
 *
 * @author Drazzull
 */
public class CategoriaDao
{

    private final Conecta c;

    public CategoriaDao()
    {
        this.c = new Conecta();
    }

    public String salvar(Categoria categoria) throws IOException
    {
        if (!this.c.getMsg().equals("sucesso"))
        {
            return ("erro:" + this.c.getMsg());
        }

        String sql = "INSERT INTO Categoria (descricao)"
                + " VALUES (\"" + categoria.getDescricao() + "\")";
        try
        {
            this.c.getStm().execute(sql);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("listarCategorias.xhtml");
            return "sucesso";
        }
        catch (SQLException ex)
        {
            return ("erro:" + ex.getMessage());
        }
    }

    public List<Categoria> getCategoria()
    {
        List<Categoria> lista = new ArrayList<>();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return lista;
        }

        // Vamos preparar o comando SQL:
        String sql = "SELECT ct.* FROM Categoria ct";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            // caso existir resultados, percorremos a lista.
            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int id = rs.getInt("idCategoria");
                String descricao = rs.getString("descricao");

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(id);
                categoria.setDescricao(descricao);

                lista.add(categoria);
            }
        }
        catch (SQLException ex)
        {
        }

        return lista;
    }

    public Categoria getCategoriaPorCodigo(Long codigo)
    {
        Categoria categoria = new Categoria();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return categoria;
        }

        // Vamos preparar o comando SQL:
        String sql = "SELECT ct.* FROM Categoria ct WHERE ct.idCategoria =" + codigo;

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int id = rs.getInt("idCategoria");
                String descricao = rs.getString("descricao");
                categoria.setIdCategoria(id);
                categoria.setDescricao(descricao);
            }
        }
        catch (SQLException ex)
        {

        }
        return categoria;
    }
}
