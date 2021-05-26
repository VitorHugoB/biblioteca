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
 * @author Aluno
 */
public class DALLivro {
    public boolean salvar (livro p)
    {   
        ArrayList<livro> lt = getLivro(p.getNome());
        boolean flag = false;
        if(lt.isEmpty()){
        String sql="insert into livro(nome,nome_autor,editora) values ('$1','$2','$3');";
        sql=sql.replace("$1",p.getNome().toUpperCase());
        sql=sql.replace("$2",p.getAutor().toUpperCase());
        sql=sql.replace("$3",p.getEditora().toUpperCase());
        Conexao con=new Conexao();
        flag=con.manipular(sql);
        con.fecharConexao();
        return flag;  
        }
        
        else
        {
            alterar(p);
        }
        
        return flag;
    }
    
    public boolean alterar (livro p)
    {
        String sql="update livro set nome='$1', nome_autor='$2', editora='$3' where nome='"+p.getNome()+"';";
        sql=sql.replace("$1",p.getNome());
        sql=sql.replace("$2",p.getAutor());
        sql=sql.replace("$3",p.getEditora());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(String id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from livro where nome='"+id.toUpperCase()+"';");
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
    
    public livro getLivros(String cod)
    {   livro p=null;
        String sql="select * from livro where nome='"+cod+"';";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            p= new livro(rs.getInt("livro_cod"),rs.getString("nome"),rs.getString("nome_autor"),rs.getString("editora"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return p;
    }
    
    public ArrayList <livro> getLivro(String filtro)
    {   ArrayList <livro> lista=new ArrayList();
        System.out.println(filtro);
        String aux= filtro;
        String sql="select * from livro";
        
         if(!aux.isEmpty())
            sql="select * from livro where nome like '%"+aux.toUpperCase()+"%';";
        
         Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(
          new livro(rs.getInt("livro_cod"),rs.getString("nome"),rs.getString("nome_autor"),rs.getString("editora")));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
    
   
}