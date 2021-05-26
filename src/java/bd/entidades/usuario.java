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
public class usuario {
    int cli_cod;
    String cli_nome;
    String data_nasc;
    int ra;
    char cli_status;

    public usuario(int cli_cod, String cli_nome, int ra) {
        this.cli_cod = cli_cod;
        this.cli_nome = cli_nome;
        this.ra = ra;
    }

    

    public int getCli_cod() {
        return cli_cod;
    }

    public void setCli_cod(int cli_cod) {
        this.cli_cod = cli_cod;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public char getCli_status() {
        return cli_status;
    }

    public void setCli_status(char cli_status) {
        this.cli_status = cli_status;
    }

    
    
}
