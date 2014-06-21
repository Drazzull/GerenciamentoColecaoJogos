/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import funcoes.Conecta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Obtencao;

/**
 *
 * @author Drazzull
 */
public class ObtencaoDao
{

    private final Conecta c;

    public ObtencaoDao()
    {
        this.c = new Conecta();
    }

    public String salvar(Obtencao obtencao)
    {
        if (!this.c.getMsg().equals("sucesso"))
        {
            return ("erro:" + this.c.getMsg());
        }

        String sql = "INSERT INTO Obtencao (descricao)"
                + " VALUES (\"" + obtencao.getDescricao() + "\")";
        try
        {
            this.c.getStm().execute(sql);
            return "sucesso";
        }
        catch (SQLException ex)
        {
            return ("erro:" + ex.getMessage());
        }

    }

    public List<Obtencao> getObtencao()
    {
        List<Obtencao> lista = new ArrayList<>();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return lista;
        }

        // Vamos preparar o comando SQL:
        String sql = "SELECT ot.* FROM Obtencao ot";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            // caso existir resultados, percorremos a lista.
            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int id = rs.getInt("idObtencao");
                String descricao = rs.getString("descricao");

                Obtencao obtencao = new Obtencao();
                obtencao.setIdObtencao(id);
                obtencao.setDescricao(descricao);

                lista.add(obtencao);
            }
        }
        catch (SQLException ex)
        {
        }

        return lista;
    }

    public Obtencao getObtencaoPorCodigo(Long codigo)
    {
        Obtencao obtencao = new Obtencao();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return obtencao;
        }

        // Vamos preparar o comando SQL:
        String sql = "SELECT ot.* FROM Obtencao ot WHERE ot.idObtencao =" + codigo;

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int id = rs.getInt("idObtencao");
                String descricao = rs.getString("descricao");
                obtencao.setIdObtencao(id);
                obtencao.setDescricao(descricao);
            }
        }
        catch (SQLException ex)
        {

        }
        return obtencao;
    }
}
