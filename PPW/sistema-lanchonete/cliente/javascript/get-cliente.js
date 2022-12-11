
function fazGet(url){
    let request =  new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
    }
    
    function criaLinha(cliente){
       linha = document.createElement("tr");
       tdNome = document.createElement("td");
       tdCpf = document.createElement("td");
       tdTelefone = document.createElement("td");
       tdemail = document.createElement("td");
       tdDataNasc = document.createElement("td");
       tdCidade = document.createElement("td");
       tdNome.innerHTML = cliente.nome;
       tdCpf.innerHTML = cliente.cpf;
       tdTelefone.innerHTML = cliente.telefone;
       tdemail.innerHTML = cliente.email;
       tdDataNasc.innerHTML = cliente.dataNascimento;
       tdCidade.innerHTML = cliente.cidade.nome;
    
       linha.appendChild(tdNome);
       linha.appendChild(tdCpf);      
       linha.appendChild(tdTelefone);
       linha.appendChild(tdemail);
       linha.appendChild(tdDataNasc);
       linha.appendChild(tdCidade)
    
       return linha;
    
    }

    function criaOption(cliente){
      let option = document.createElement("option")
      option.appendChild(document.createTextNode(`${cidade.nome}`))    
      option.setAttribute("value",`${cidade.id}`) 
      return option;
   
   }
    
    function main(){
       aux = fazGet("http://127.0.0.1:8080/clientes")
       let clientes = JSON.parse(aux);
       console.log(clientes)
       let tabela = document.getElementById("tabela")
    
       clientes.forEach(element => {
        let linha = criaLinha(element);
        tabela.appendChild(linha)
    
        
       });
    
    
    }
    
    main()