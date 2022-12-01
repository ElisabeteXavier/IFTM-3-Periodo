
function fazGet(url){
let request =  new XMLHttpRequest()
request.open("GET", url, false)
request.send()
return request.responseText
}

function criaLinha(produto){
   linha = document.createElement("tr");
   tdId = document.createElement("td");
   tdNome = document.createElement("td");
   tdestoque = document.createElement("td");
   tdvalor = document.createElement("td");
   tdId.innerHTML = produto.id;
   tdNome.innerHTML = produto.nome;
   tdestoque.innerHTML = produto.qtdEstoque;
   tdvalor.innerHTML = produto.valorUnitario;

   linha.appendChild(tdId);
   linha.appendChild(tdNome);
   linha.appendChild(tdestoque);
   linha.appendChild(tdvalor);

   return linha;

}

function main(){
   aux = fazGet("http://127.0.0.1:8080/produtos")
   produtos = JSON.parse(aux);
   console.log(produtos)
   let tabela = document.getElementById("tabela")

   produtos.forEach(element => {
    let linha = criaLinha(element);
    tabela.appendChild(linha)

    
   });


}

main()