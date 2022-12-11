function fazGet(url){
    let request =  new XMLHttpRequest()
    request.open("GET", url, true)
    request.send()
    return request.responseText
    }

    function criaOption(cliente) {
        let option = document.createElement("option")
        option.appendChild(document.createTextNode(`${cliente.nome}`))
        option.setAttribute("value", `${cliente.cpf}`)
        return option;
     
     }
     
     function main() {
        let aux = fazGet("http://127.0.0.1:8080/clientes")
        let clientes = JSON.parse(aux);
        console.log(clientes)
     
        let select = document.getElementById("cliente-atualizar")
     
        
     
        clientes.forEach(element => {
           let linha = criaOption(element);
           select.appendChild(linha)
     
        });
        let idCliente = select.value;
        let dado = fazGet(`http://127.0.0.1:8080/clientes/${idCliente}`)
        let cliente = JSON.parse(dado);
     
        
     }
     main() 

 
 