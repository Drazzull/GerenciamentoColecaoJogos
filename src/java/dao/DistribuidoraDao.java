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
import model.Distribuidora;

/**
 *
 * @author Drazzull
 */
public class DistribuidoraDao
{

    private final Conecta c;

    public DistribuidoraDao()
    {
        this.c = new Conecta();
    }

    public String salvar(Distribuidora distribuidora) throws IOException
    {
        if (!this.c.getMsg().equals("sucesso"))
        {
            return ("erro:" + this.c.getMsg());
        }

        String sql = "INSERT INTO Distribuidora (nome)"
                + " VALUES (\"" + distribuidora.getNome() + "\")";
        try
        {
            this.c.getStm().execute(sql);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("listarDistribuidoras.xhtml");
            return "sucesso";
        }
        catch (SQLException ex)
        {
            return ("erro:" + ex.getMessage());
        }

    }

    public List<Distribuidora> getDistribuidora()
    {
        List<Distribuidora> lista = new ArrayList<>();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return lista;
        }

        // Vamos preparar o comando SQL:
        String sql = "SELECT dt.* FROM Distribuidora dt";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            // caso existir resultados, percorremos a lista.
            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int id = rs.getInt("idDistribuidora");
                String nome = rs.getString("nome");

                Distribuidora distribuidora = new Distribuidora();
                distribuidora.setIdDistribuidora(id);
                distribuidora.setNome(nome);

                lista.add(distribuidora);
            }
        }
        catch (SQLException ex)
        {
        }

        return lista;
    }

    public Distribuidora getDistribuidoraPorCodigo(Long codigo)
    {
        Distribuidora distribuidora = new Distribuidora();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return distribuidora;
        }

        // Vamos preparar o comando SQL:
        String sql = "SELECT dt.* FROM Distribuidora dt WHERE dt.idDistribuidora =" + codigo;

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int id = rs.getInt("idDistribuidora");
                String nome = rs.getString("nome");
                distribuidora.setIdDistribuidora(id);
                distribuidora.setNome(nome);
            }
        }
        catch (SQLException ex)
        {

        }
        return distribuidora;
    }
}
