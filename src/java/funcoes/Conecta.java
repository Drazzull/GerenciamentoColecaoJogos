/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Drazzull
 */
public final class Conecta
{

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/dbgerenciamentocolecaojogos?zeroDateTimeBehavior=convertToNull";
    private String USERNAME = "root";
    private String PASSWORD = "root";
    private Connection conexao;
    private Statement stm;
    private final String msg;

    public Conecta()
    {
        this.msg = this.iniciaConexao();
    }

    public Conecta(String bd, String user, String senha)
    {
        this.USERNAME = user;
        this.PASSWORD = senha;
        this.msg = this.iniciaConexao();
    }

    public String iniciaConexao()
    {
        try
        {
            Class.forName(this.DRIVER);
            this.conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            this.stm = this.getConexao().createStatement();
            return "sucesso";

        } catch (ClassNotFoundException e)
        {
            this.conexao = null;
            return "Não foi possivel encontrar o driver de banco: " + e.getMessage();
        } catch (SQLException e)
        {
            this.conexao = null;
            return "SQLException Erro!" + e.getMessage();
        }
    }

    public String fechaConexao()
    {
        try
        {
            if (this.getConexao() != null)
            {
                this.getConexao().close();
                this.conexao = null;
            }

            if (this.getStm() != null)
            {
                this.stm = null;
            }

            return "Conexão Encerrada";
        } catch (SQLException ex)
        {
            return "Houve erro no fechamento da conexão! " + ex.getMessage();
        }
    }

    public Connection getConexao()
    {
        return this.conexao;
    }

    public Statement getStm()
    {
        return this.stm;
    }

    public String getMsg()
    {
        return this.msg;
    }
}
