/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conecta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author Drazzull
 */
public class CategoriaDao
{

    private Conecta c;

    public CategoriaDao()
    {
        this.c = new Conecta();
    }

    public String salvar(Categoria categoria)
    {
        if (!c.getMsg().equals("sucesso"))
        {
            return ("erro:" + c.getMsg());
        }

        //while (rs.next()) {
        String sql = "INSERT INTO Categoria (descricao)"
                + " VALUES ('" + categoria.getDescricao() + "')";
        try
        {
            c.getStm().execute(sql);
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

        if (!c.getMsg().equals("sucesso"))
        {
            return lista;
        }

        // Vamos preparar o comando SQL:
        String sql = "select CT.* from Categoria CT";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = c.getStm().executeQuery(sql);

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
}
