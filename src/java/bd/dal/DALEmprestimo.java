/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.dal;

import bd.entidades.emprestimo;
import bd.entidades.livro;
import bd.util.Conexao;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class DALEmprestimo 
{
    public void salvar (String p)
    {   

            Conexao con=new Conexao();
            con.manipular(p);
            con.fecharConexao();
           
      
        
        
    }
     
    /* 
    public boolean alterar (emprestimo p)
    {
    //  String sql="update cliente set cli_nome='$1', cli_cod='$2', ra='$3' where nome='"+p.getCli_nome()+"';";
        String sql="update emprestimo set empre='$1', ra='$3' where nome='"+p.getCli_nome()+"';";
        sql=sql.replace("$1",p.getCli_nome());
  //      sql=sql.replace("$2",p.getCli_cod());
        sql=sql.replace("$3",""+p.getRa());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }

*/
    public boolean apagar(String id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from emprestimo where emprestimo_cod = "+id+";");
        con.fecharConexao();
        return flag;                      
    }
    
    public boolean alterar (emprestimo p)
    {   
        String sql="update emprestimo set data_emprestimo='$1', data_devolucao='$2'where emprestimo_cod="+p.getEmprestimo_cod()+";";
        if(p.getData_devolucao().isAfter(LocalDate.now()) && p.getData_emprestimo().isBefore(LocalDate.now()))
        {sql=sql.replace("$1",p.getData_emprestimo().plusDays(7).toString());
        sql=sql.replace("$2",p.getData_devolucao().plusDays(7).toString()); }     
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    
    public emprestimo getEmprestimos(String cod)
    {   
        emprestimo p=new emprestimo(0, cod);
        String sql="select * from emprestimo where emprestimo_cod = "+cod+";";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            p = new emprestimo(rs.getInt("emprestimo_cod"),rs.getInt("cli_cod"),rs.getString("livro_cod"),rs.getDate("data_emprestimo").toLocalDate(),rs.getDate("data_devolucao").toLocalDate());
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return p;
    }
    
    
    public ArrayList <emprestimo> getEmprestimo(String filtro)
    {   
        ArrayList <emprestimo> lista=new ArrayList();
        System.out.println(filtro);
        String aux= filtro;
        String sql="select * from emprestimo inner join livro on emprestimo.livro_cod = livro.livro_cod where cli_cod = "+aux+" ;";
        
        
         Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(
          new emprestimo(rs.getInt("emprestimo_cod"),rs.getInt("cli_cod"),rs.getString("nome"),rs.getDate("data_emprestimo").toLocalDate(),rs.getDate("data_devolucao").toLocalDate()));

        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
    
}
