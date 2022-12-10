function fazGet(url){
    let request =  new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
    }

    function criaOption(produto){
        let option = document.createElement("option")
        option.appendChild(document.createTextNode(`${produto.nome}`))    
        option.setAttribute("value",`${produto.id}`) 
        return option;
     
     }
     
     function main(){
        aux = fazGet("http://127.0.0.1:8080/produtos")
        console.log("oiiiiiiiii")
        produtos = JSON.parse(aux);
        console.log(produtos)
        let select = document.getElementById("produto-atualizar")
     
        produtos.forEach(element => {
         let linha = criaOption(element);
         select.appendChild(linha)
     
         
        });
     
     
     }
     
     main()