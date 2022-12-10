function fazGet(url){
    let request =  new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
    }

    function criaOption(cidade){
        let option = document.createElement("option")
        option.appendChild(document.createTextNode(`${cidade.nome}`))    
        option.setAttribute("value",`${cidade.id}`) 
        return option;
     
     }
     
     function main(){
        aux = fazGet("http://127.0.0.1:8080/cidades")
        console.log("oiiiiiiiii")
        cidades = JSON.parse(aux);
        console.log(cidades)
        let select = document.getElementById("cidade")
     
        cidades.forEach(element => {
         let linha = criaOption(element);
         select.appendChild(linha)
     
         
        });
     
     
     }
     
     main()