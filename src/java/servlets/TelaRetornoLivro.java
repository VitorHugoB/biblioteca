package servlets;

import bd.dal.DALEmprestimo;
import bd.dal.DALLivro;
import bd.dal.DALUsuario;
import bd.entidades.emprestimo;
import bd.entidades.livro;
import bd.entidades.usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TelaPaisesNegocio", urlPatterns = {"/TelaPaisesNegocio"})
public class TelaRetornoLivro extends HttpServlet {

    public String buscalivroadm(String filtro) {
        String res = "<ul class=\"list-group\"><li class=\"list-group-item active\" aria-current=\"true\">Livros</li>\n";
        ArrayList<livro> produto = new DALLivro().getLivro(filtro);
        ArrayList<emprestimo> emp = new DALEmprestimo().getEmprestimo(filtro);
        for (int i = 0; i < produto.size(); i++) {
             res +="<li class=\"list-group-item\">"+"Nome:"+ produto.get(i).getNome()+"</br> Autor:"+ produto.get(i).getAutor()+" </br>  Editora:"+ produto.get(i).getEditora()+ "</br> &nbsp<button class=\"btn btnprimary\" onclick=\"ApagaAlteraPais('apagar','"+produto.get(i).getNome()+"'),MostraPaises()\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-trash\" viewBox=\"0 0 16 16\">\n" +
"  <path d=\"M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z\"/>\n" +
"  <path fill-rule=\"evenodd\" d=\"M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z\"/>\n" +
"</svg></button>&nbsp<button class=\"btn btnprimary\" onclick=\"ApagaAlteraPais('alterar','"+produto.get(i).getNome()+"'),MostraPaises()\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-pencil-square\" viewBox=\"0 0 16 16\">\n" +
"  <path d=\"M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z\"/>\n" +
"  <path fill-rule=\"evenodd\" d=\"M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z\"/>\n" +
"</svg></button></li>";
            
        }
       res +="</ul>";
       
       
        return res;
    }
    
    public String buscalivrouser(String filtro,int cod) {
        
        String res = "<ul class=\"list-group\"><li class=\"list-group-item active\" aria-current=\"true\">Emprestimo</li>\n";
        ArrayList<livro> produto = new DALLivro().getLivro(filtro);
        ArrayList<emprestimo> emp = new DALEmprestimo().getEmprestimo(Integer.toString(cod));
        
        
        for (int i = 0; i <produto.size(); i++) {
            for (int j = 0; j <emp.size(); j++) {
               if(produto.get(i).getNome().equalsIgnoreCase(emp.get(j).getLivro_cod()))
               {produto.remove(i);}
            }
        }
        
        
        for (int i = 0; i < emp.size(); i++) {
             res +="<li class=\"list-group-item\">"+"EmprestimoCod:"+ emp.get(i).getEmprestimo_cod()+"</br> Cli_Cod:"+ emp.get(i).getCli_cod()+" </br>  Livro:"+ emp.get(i).getLivro_cod()+ "</br>DataEmprestimo:"+ emp.get(i).getData_emprestimo()+ "</br>DataDevolucao:"+emp.get(i).getData_devolucao()+"</br> &nbsp<button class=\"btn btnprimary\" onclick=\"ApagaAlteraPais('alteraremprestimo','"+emp.get(i).getEmprestimo_cod()+"'),MostraPaises()\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-arrow-counterclockwise\" viewBox=\"0 0 16 16\">\n" +
"  <path fill-rule=\"evenodd\" d=\"M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z\"/>\n" +
"  <path d=\"M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z\"/>\n" +
"</svg></button>&nbsp<button class=\"btn btnprimary\" onclick=\"ApagaAlteraPais('apagaremprestimo','"+emp.get(i).getEmprestimo_cod()+"'),MostraPaises()\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-x-circle\" viewBox=\"0 0 16 16\">\n" +
"  <path d=\"M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z\"/>\n" +
"  <path d=\"M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z\"/>\n" +
"</svg></button></li>";
            
        }
       res +="</ul></br>"; 
       res +="<ul class=\"list-group\"><li class=\"list-group-item active\" aria-current=\"true\">Livro</li>\n";
       for (int i = 0; i < produto.size(); i++) {
             res +="<li class=\"list-group-item\">"+"Nome:"+ produto.get(i).getNome()+"</br> Autor:"+ produto.get(i).getAutor()+" </br>  Editora:"+ produto.get(i).getEditora()+ "</br> &nbsp<button class=\"btn btnprimary\" onclick=\"ApagaAlteraPais('confirmaremprestimo','"+produto.get(i).getLivro_cod()+"'),MostraPaises()\"><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-journal-check\" viewBox=\"0 0 16 16\">\n" +
"  <path fill-rule=\"evenodd\" d=\"M10.854 6.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 8.793l2.646-2.647a.5.5 0 0 1 .708 0z\"/>\n" +
"  <path d=\"M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z\"/>\n" +
"  <path d=\"M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z\"/>\n" +
"</svg></button></li>";
            
        }
       res +="</ul>";
        return res;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             HttpSession session=request.getSession();
            String usuario =(String)session.getAttribute("usuario");
            String erro = "";
            String acao = request.getParameter("acao");
            String cod;                    
            try {
                cod = request.getParameter("cod");
            } catch (Exception e) {
                cod = "";
            }
            DALLivro ctr = new DALLivro();
            DALEmprestimo emp= new DALEmprestimo();
          
            switch (acao.toLowerCase()) 
            {
                case "consultar":
                    String filtro = request.getParameter("filtro");
                    if("261810529".equals(usuario))
                    response.getWriter().print(buscalivroadm(filtro));
                    
                    else
                    { usuario retorno = ctr.login(usuario);    
                    response.getWriter().print(buscalivrouser(filtro,retorno.getCli_cod()));    
                    break;}
                case "apagar":
                    if (!ctr.apagar(cod))
                       erro = "Erro ao apagar o pais";
                    response.getWriter().print(erro);
                    break;
                case "alterar":
                    livro p = ctr.getLivros(cod);
                    String retorno= p.getNome()+","+p.getAutor()+","+p.getEditora();
                    response.getWriter().print(retorno); // retorna todos os dados na forma de lista (,,,)
                    break;
               case "apagaremprestimo":
                    if (!emp.apagar(cod))
                       erro = "Erro ao apagar o pais";
                    response.getWriter().print(erro);
                    break;
                case "alteraremprestimo":
                    emprestimo em = emp.getEmprestimos(cod);
                    emp.alterar(em);
                    String retornoemp= em.getEmprestimo_cod()+","+em.getCli_cod()+","+em.getLivro_cod()+","+em.getData_emprestimo()+","+em.getData_devolucao();
                    response.getWriter().print(retornoemp); // retorna todos os dados na forma de lista (,,,)
                    break;     
                case "confirmar": //novo e alteração
                    erro="ok";
                    String nome = request.getParameter("nome");
                    String nome_autor = request.getParameter("nome_autor");
                    String editora = request.getParameter("editora");
                    livro novolivro = new livro(nome,nome_autor,editora);
                    if (cod == "") 
                    {   if (!ctr.salvar(novolivro)) erro = "Erro ao gravar o pais";}
                    else 
                    {   if (!ctr.alterar(novolivro)) erro = "Erro ao alterar o pais";}
                    response.getWriter().print(erro);
                    break;
                case "confirmaremprestimo": //novo e alteração
                     usuario teste = ctr.login(usuario);
                     emprestimo a=new emprestimo(teste.getCli_cod(),cod, LocalDate.now(), LocalDate.now().plusDays(7));
                     String sql = "insert into emprestimo(cli_cod, livro_cod, data_emprestimo, data_devolucao) values ('"+a.getCli_cod()+"','"+a.getLivro_cod()+"','"+a.getData_emprestimo()+"','"+a.getData_devolucao()+"');";
                     emp.salvar(sql);
                     response.getWriter().print(a.getCli_cod()+" "+a.getLivro_cod()+" "+a.getCli_cod()+" "+a.getData_emprestimo()+" "+a.getData_devolucao()); 
                    
                    break;
                    
            }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
