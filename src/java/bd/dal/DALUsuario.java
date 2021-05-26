/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.dal;

import bd.entidades.livro;
import bd.entidades.usuario;
import bd.util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class DALUsuario 
{
     public boolean salvar (usuario p)
    {   
        ArrayList<usuario> lt = getUsuario(p.getCli_nome());
        boolean flag = false;
        if(lt.isEmpty())
        {
            String sql="insert into cliente(cli_nome,data_nasc,cli_ra,cli_status) values ('$1','28-10-1999 00:00:00.000','$2','D');";
            sql=sql.replace("$1",p.getCli_nome().toUpperCase());
            sql=sql.replace("$2",""+p.getRa());
            Conexao con=new Conexao();
            flag=con.manipular(sql);
            con.fecharConexao();
            return flag;  
        }
        else
            alterar(p);
        
        return flag;
    }
     
     
    public boolean alterar (usuario p)
    {
    //  String sql="update cliente set cli_nome='$1', cli_cod='$2', ra='$3' where nome='"+p.getCli_nome()+"';";
        String sql="update cliente set cli_nome='$1', ra='$3' where nome='"+p.getCli_nome()+"';";
        sql=sql.replace("$1",p.getCli_nome());
  //      sql=sql.replace("$2",p.getCli_cod());
        sql=sql.replace("$3",""+p.getRa());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    public boolean apagar(String id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from cliente where nome='"+id.toUpperCase()+"';");
        con.fecharConexao();
        return flag;                      
    }
    
    public usuario login(String cod)
    {   usuario p= new usuario(0,"teste", 0);
        String sql="select * from cliente where cli_ra="+Integer.parseInt(cod)+";";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            p= new usuario(rs.getInt("cli_cod"),rs.getString("cli_nome"),rs.getInt("cli_ra"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return p;
    }
    
    public usuario getUsuarioo(String cod)
    {   usuario p=null;
        String sql="select * from cliente where cli_ra="+cod+";";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            p= new usuario(rs.getInt("cli_cod"),rs.getString("cli_nome"),rs.getInt("ra"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return p;
    }
    
    
    public ArrayList <usuario> getUsuario(String filtro)
    {   ArrayList <usuario> lista=new ArrayList();
        System.out.println(filtro);
        String aux= filtro;
        String sql="select * from cliente";
        
         if(!aux.isEmpty())
            sql="select * from cliente where nome like '%"+aux.toUpperCase()+"%';";
        
         Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(
          new usuario(rs.getInt("cli_cod"),rs.getString("cli_nome"),rs.getInt("ra")));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
    
}
