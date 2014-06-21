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
import model.Emprestimo;
import model.Jogo;

/**
 *
 * @author Drazzull
 */
public class EmprestimoDao
{

    private final Conecta c;

    public EmprestimoDao()
    {
        this.c = new Conecta();
    }

    public String salvar(Emprestimo emprestimo) throws IOException
    {
        if (!this.c.getMsg().equals("sucesso"))
        {
            return ("erro:" + c.getMsg());
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(emprestimo.getDataEmprestimo());

        int anoConvertido = calendar.get(Calendar.YEAR);
        int mesConvertido = calendar.get(Calendar.MONTH) + 1;
        int diaConvertido = calendar.get(Calendar.DAY_OF_MONTH);
        String dataConvertida = anoConvertido + "-" + mesConvertido + "-" + diaConvertido;

        String sql = "INSERT INTO Emprestimo (idJogo, nomePessoa, dataEmprestimo, devolvido)"
                + " VALUES (" + emprestimo.getJogo().getIdJogo() + ", \""
                + emprestimo.getNomePessoa() + "\", '" + dataConvertida + "',"
                + " false)";
        
        try
        {
            this.c.getStm().execute(sql);
            JogoDao dao = new JogoDao();
            dao.alterarEstado(emprestimo.getJogo(), 'E');
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("listarEmprestimos.xhtml");
            return "sucesso";
        }
        catch (SQLException ex)
        {
            return ("erro:" + ex.getMessage());
        }

    }

    public String devolverEmprestimo(Emprestimo emprestimo) throws IOException
    {
        if (!this.c.getMsg().equals("sucesso"))
        {
            return ("erro:" + c.getMsg());
        }

        String sql = "UPDATE emprestimo"
                + " SET devolvido = true"
                + " WHERE idEmprestimo = " + emprestimo.getIdEmprestimo();

        try
        {
            this.c.getStm().execute(sql);
            emprestimo.setDevolvido(true);
            JogoDao jogoDao = new JogoDao();
            jogoDao.alterarEstado(emprestimo.getJogo(), 'N');
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect("listarEmprestimos.xhtml");
            return "sucesso";
        }
        catch (SQLException ex)
        {
            return ("erro:" + ex.getMessage());
        }

    }

    public List<Emprestimo> getEmprestimo()
    {
        List<Emprestimo> lista = new ArrayList<>();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return lista;
        }

        // Vamos preparar o comando SQL:
        String sql = "select em.*, jo.nome AS nomeJogo"
                + " FROM Emprestimo em"
                + " INNER JOIN Jogo jo ON (jo.idJogo = em.idJogo)"
                + " ORDER BY em.idEmprestimo";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            // caso existir resultados, percorremos a lista.
            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int idEmprestimo = rs.getInt("idEmprestimo");
                int idJogo = rs.getInt("idJogo");
                String nomeJogo = rs.getString("nomeJogo");
                String nomePessoa = rs.getString("nomePessoa");
                Date dataEmprestimo = rs.getDate("dataEmprestimo");
                boolean devolvido = rs.getBoolean("devolvido");

                Jogo jogo = new Jogo();
                jogo.setIdJogo(idJogo);
                jogo.setNome(nomeJogo);

                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(idEmprestimo);
                emprestimo.setNomePessoa(nomePessoa);
                emprestimo.setDataEmprestimo(dataEmprestimo);
                emprestimo.setJogo(jogo);
                emprestimo.setDevolvido(devolvido);

                lista.add(emprestimo);
            }
        }
        catch (SQLException ex)
        {
        }

        return lista;
    }

    public Emprestimo getEmprestimoPorCodigo(Long codigo)
    {
        Emprestimo emprestimo = new Emprestimo();

        if (!this.c.getMsg().equals("sucesso"))
        {
            return emprestimo;
        }

        // Vamos preparar o comando SQL:
        String sql = "select em.*, jo.nome AS nomeJogo"
                + " FROM Emprestimo em"
                + " INNER JOIN Jogo jo ON (jo.idJogo = em.idJogo)"
                + " WHERE em.idEmprestimo =" + codigo
                + " ORDER BY em.idEmprestimo";

        // Definido o Statement, executamos o comando no banco de dados.
        ResultSet rs;

        try
        {
            rs = this.c.getStm().executeQuery(sql);

            while (rs.next())
            {
                //leitura dos campos da tabela em variáveis
                int idEmprestimo = rs.getInt("idEmprestimo");
                int idJogo = rs.getInt("idJogo");
                String nomeJogo = rs.getString("nomeJogo");
                String nomePessoa = rs.getString("nomePessoa");
                Date dataEmprestimo = rs.getDate("dataEmprestimo");
                boolean devolvido = rs.getBoolean("devolvido");

                Jogo jogo = new Jogo();
                jogo.setIdJogo(idJogo);
                jogo.setNome(nomeJogo);

                emprestimo.setIdEmprestimo(idEmprestimo);
                emprestimo.setNomePessoa(nomePessoa);
                emprestimo.setDataEmprestimo(dataEmprestimo);
                emprestimo.setDevolvido(devolvido);
                emprestimo.setJogo(jogo);
            }
        }
        catch (SQLException ex)
        {

        }
        return emprestimo;
    }
}
