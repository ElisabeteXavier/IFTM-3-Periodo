
function fazGet(url){
    let request =  new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
    }
    

    function criaOption(cliente){
      let option = document.createElement("option")
      option.appendChild(document.createTextNode(`${cliente.nome}`))    
      option.setAttribute("value",`${cliente.id}`) 
      return option;
   
   }
    
    function main(){
       aux = fazGet("http://127.0.0.1:8080/clientes")
       produtos = JSON.parse(aux);
       console.log(produtos)
       let select = document.getElementById("cliente-atualizar")
    
       produtos.forEach(element => {
        let linha = criaOption(element);
        select.appendChild(linha)
    
        
       });
    
    
    }
    
    main()