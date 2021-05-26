function MostraPaises()
{   event.preventDefault(); // evita refresh da tela
    var filtro=document.getElementById("filtro").value; // verifica o filtro
    const URL_TO_FETCH='TelaPaisesNegocio?acao=consultar&filtro='+filtro;
    fetch(URL_TO_FETCH,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('preview').innerHTML = result;
        });
    }).catch (function(err) {console.error(err);});

}


function ApagaAlteraPais(acao,cod)
{   event.preventDefault(); // evita refresh da tela
    var url = "";
    switch (acao)
    {
        case "apagar":
            url = "TelaPaisesNegocio?acao=apagar&cod=" + cod;         
            break;
        case "alterar":
            url = "TelaPaisesNegocio?acao=alterar&cod=" + cod;           
            break;
       case "apagaremprestimo":
            url = "TelaPaisesNegocio?acao=apagaremprestimo&cod=" + cod;         
            break;
        case "alteraremprestimo":
            url = "TelaPaisesNegocio?acao=alteraremprestimo&cod=" + cod;           
            break;
        case "confirmaremprestimo":
            url = "TelaPaisesNegocio?acao=confirmaremprestimo&cod=" + cod;           
            break;
    }
    
    fetch(url,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            if (acao === 'apagar')
            {
                document.getElementById("erromsg").innerHTML = result;
                MostraPaises();
            } 
            
            if (acao === 'confirmaremprestimo'||acao === 'apagaremprestimo'||acao === 'alteraremprestimo')
            {
                var aux = result;
                
               // MostraPaises();
            }
            else
            {
                var aux = result;
                var pais = aux.split(",");
                var form = document.forms["dados"];
                
                
                
                form.nome.value = pais[0];
                form.nome_autor.value= pais[1];
                form.editora.value = pais[2];
                
            }
        });
    }).catch (function(err) {console.error(err);});

}

function GravaPais()
{
    //event.preventDefault(); // evita refresh da tela

    const URL_TO_FETCH = 'TelaPaisesNegocio';
    
    const data = new URLSearchParams();
    for (const pair of new FormData(document.getElementById('fdados'))) {
        data.append(pair[0], pair[1]);
    }
    data.append('acao', 'confirmar');
    fetch(URL_TO_FETCH, { method: 'post', body: data 
    }).then(function (response) {
        return response.text();
    }).then(function (retorno) {
        // result recebe a resposta do módulo dinâmico
        if (retorno.startsWith('Erro')) // problemas ao alterar/gravar
        {
            document.getElementById('erromsg').innerHTML = retorno;
            document.getElementById('erro').style.display = "block";
        } else  // tudo OK, limpar o formulário
        {
            document.getElementById('fdados').reset();            
            MostraPaises();
        }
         
    }).catch(function (error) {
        console.error(error);
    });
      
}


