/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;

/**
 *
 * @author pedro
 */
public class emprestimo 
{
    int emprestimo_cod;
    int cli_cod;
    String livro_cod;
    LocalDate data_emprestimo;
    LocalDate data_devolucao;

    public emprestimo(int cli_cod, String livro_cod) 
    {
        this.cli_cod = cli_cod;
        this.livro_cod = livro_cod;
        this.data_emprestimo = LocalDate.now();
        this.data_devolucao = LocalDate.now();
        data_devolucao = data_devolucao.plusDays(7);
    }

    public emprestimo(int cli_cod, String livro_cod, LocalDate data_emprestimo, LocalDate data_devolucao) {
        
        this.cli_cod = cli_cod;
        this.livro_cod = livro_cod;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public emprestimo(int emprestimo_cod, int cli_cod, String livro_cod, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.emprestimo_cod = emprestimo_cod;
        this.cli_cod = cli_cod;
        this.livro_cod = livro_cod;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    
    
    public int getEmprestimo_cod() {
        return emprestimo_cod;
    }

    public void setEmprestimo_cod(int cod_emp) {
        this.emprestimo_cod = cod_emp;
    }

    public int getCli_cod() {
        return cli_cod;
    }

    public void setCli_cod(int cli_cod) {
        this.cli_cod = cli_cod;
    }

    public String getLivro_cod() {
        return livro_cod;
    }

    public void setLivro_cod(String livro_cod) {
        this.livro_cod = livro_cod;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
            
    
}
