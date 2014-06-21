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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Categoria;
import model.Distribuidora;
import model.Jogo;
import model.Obtencao;

/**
 *
 * @author Drazzull
 */
public class JogoDao
{

    private final Conecta c;

    public JogoDao()
    {
        this.c = new Conecta();
    }

    public String salvar(Jogo jogo) throws IOException
    {
        if (!this.c.getMsg().equals("sucesso"))
        {
            return ("erro:" + c.getMsg());
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(jogo.getDataObtencao());

        int anoConvertido = calendar.get(Calendar.YEAR);
        int mesConvertido = calendar.get(Calendar.MONTH) + 1;
        int diaConvertido = calendar.get(Calendar.DAY_OF_MONTH);
        String dataConvertida = anoConvertido + "-" + mesConvertido + "-" + diaConvertido;

        String idSubCategoria = null;
        if (jogo.getSubCategoria() != null)
        {
            idSubCategoria = jogo.getSubCategoria().getIdCategoria().toString();
        }

        String sql = "INSERT INTO Jogo (idCategoria, idSubCategoria, idDistribuidora, idObtencao, nome, precoPago, estado, dataObtencao)"
                + " VALUES (" + jogo.getCategoria().getIdCategoria() + ", " + idSubCategoria + ", "
                + jogo.getDistribuidora().getIdDistribuidora() + ", " + jogo.getObtencao().getIdObtencao() + ", \""
                + jogo.getNome() + "\", " + jogo.getPrecoPago() + ", \"N\", '" + dataConvertida + "')";

        try
        {
            this.c.getStm().execute(sql);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("listarJogos.xhtml");
            return "sucesso";
        }
        catch (SQLException ex)
        {
            return ("erro:" + ex.getMessage());
        }

    }

    public String alterarEstado(Jogo jogo, char estado)
    {
        if (!this.c.getMsg().equals("sucesso"))
        {
            return ("erro:" + c.getMsg());
        }

        String sql = "UPDATE jogo"
                + " SET estado = '" + estado + "'"
                + " WHERE idJogo = " + jogo.getIdJogo();

        try
        {
            this.c.getStm().execute(sql);
            jogo.setEstado(estado);
            return "sucesso";
        }
        catch (SQLException ex)
        {
            return ("erro:" + ex.getMessage());
        }

    }

    public List<Jogo> getJogo(String where)
    {
        List<Jogo> lista = new ArrayList<>();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return lista;
        }

        // Vamos preparar o comando SQL:
        String sql = "select jo.*, ct.descricao AS desCategoria,"
                + " sct.descricao AS desSubCategoria,"
                + " dt.nome AS nomeDistribuidora, ot.descricao AS desObtencao"
                + " FROM Jogo jo"
                + " INNER JOIN Categoria ct ON (ct.idCategoria = jo.idCategoria)"
                + " LEFT JOIN Categoria sct ON (sct.idCategoria = jo.idSubCategoria)"
                + " INNER JOIN Distribuidora dt ON (dt.idDistribuidora = jo.idDistribuidora)"
                + " INNER JOIN Obtencao ot ON (ot.idObtencao = jo.idObtencao)"
                + where
                + " ORDER BY jo.idJogo";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            // caso existir resultados, percorremos a lista.
            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int idJogo = rs.getInt("idJogo");
                String desCategoria = rs.getString("desCategoria");
                String desSubCategoria = rs.getString("desSubCategoria");
                String nomeDistribuidora = rs.getString("nomeDistribuidora");
                String desObtencao = rs.getString("desObtencao");
                String nome = rs.getString("nome");
                double precoPago = rs.getDouble("precoPago");
                char estado = rs.getString("estado").charAt(0);
                Date dataObtencao = rs.getDate("dataObtencao");

                Categoria categoria = new Categoria();
                categoria.setDescricao(desCategoria);

                Categoria subCategoria = new Categoria();
                subCategoria.setDescricao(desSubCategoria);

                Distribuidora distribuidora = new Distribuidora();
                distribuidora.setNome(nomeDistribuidora);

                Obtencao obtencao = new Obtencao();
                obtencao.setDescricao(desObtencao);

                Jogo jogo = new Jogo();
                jogo.setIdJogo(idJogo);
                jogo.setNome(nome);
                jogo.setPrecoPago(precoPago);
                jogo.setEstado(estado);
                jogo.setDataObtencao(dataObtencao);
                jogo.setCategoria(categoria);
                jogo.setSubCategoria(subCategoria);
                jogo.setDistribuidora(distribuidora);
                jogo.setObtencao(obtencao);

                lista.add(jogo);
            }
        }
        catch (SQLException ex)
        {
        }

        return lista;
    }

    public Jogo getJogoPorCodigo(Long codigo)
    {
        Jogo jogo = new Jogo();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return jogo;
        }

        // Vamos preparar o comando SQL:
        String sql = "select jo.*, ct.descricao AS desCategoria,"
                + " sct.descricao AS desSubCategoria,"
                + " dt.nome AS nomeDistribuidora, ot.descricao AS desObtencao"
                + " FROM Jogo jo"
                + " INNER JOIN Categoria ct ON (ct.idCategoria = jo.idCategoria)"
                + " LEFT JOIN Categoria sct ON (sct.idCategoria = jo.idSubCategoria)"
                + " INNER JOIN Distribuidora dt ON (dt.idDistribuidora = jo.idDistribuidora)"
                + " INNER JOIN Obtencao ot ON (ot.idObtencao = jo.idObtencao)"
                + " WHERE jo.idJogo =" + codigo
                + " ORDER BY jo.idJogo";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int idJogo = rs.getInt("idJogo");
                String desCategoria = rs.getString("desCategoria");
                String desSubCategoria = rs.getString("desSubCategoria");
                String nomeDistribuidora = rs.getString("nomeDistribuidora");
                String desObtencao = rs.getString("desObtencao");
                String nome = rs.getString("nome");
                double precoPago = rs.getDouble("precoPago");
                char estado = rs.getString("estado").charAt(0);
                Date dataObtencao = rs.getDate("dataObtencao");

                Categoria categoria = new Categoria();
                categoria.setDescricao(desCategoria);

                Categoria subCategoria = new Categoria();
                subCategoria.setDescricao(desSubCategoria);

                Distribuidora distribuidora = new Distribuidora();
                distribuidora.setNome(nomeDistribuidora);

                Obtencao obtencao = new Obtencao();
                obtencao.setDescricao(desObtencao);

                jogo.setIdJogo(idJogo);
                jogo.setNome(nome);
                jogo.setPrecoPago(precoPago);
                jogo.setEstado(estado);
                jogo.setDataObtencao(dataObtencao);
                jogo.setCategoria(categoria);
                jogo.setSubCategoria(subCategoria);
                jogo.setDistribuidora(distribuidora);
                jogo.setObtencao(obtencao);
            }
        }
        catch (SQLException ex)
        {

        }
        return jogo;
    }
}
