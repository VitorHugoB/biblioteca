/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.entidades;

/**
 *
 * @author Vitor
 */
public class livro {
    int livro_cod;
    private String nome;
    private String autor;
    private String editora;

    public livro(String nome, String autor, String editora) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
    }

    
    public livro(int livro_cod, String nome, String autor, String editora) {
        this.livro_cod = livro_cod;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
    }

    public int getLivro_cod() {
        return livro_cod;
    }

    public void setLivro_cod(int livro_cod) {
        this.livro_cod = livro_cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

  

   
    
    
}
