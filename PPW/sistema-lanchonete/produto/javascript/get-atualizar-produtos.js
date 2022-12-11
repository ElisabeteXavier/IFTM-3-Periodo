function fazGet(url) {
   let request = new XMLHttpRequest()
   request.open("GET", url, false)
   request.send()
   return request.responseText
}

function criaOption(produto) {
   let option = document.createElement("option")
   option.appendChild(document.createTextNode(`${produto.nome}`))
   option.setAttribute("value", `${produto.id}`)


   return option;

}





function main() {
   let aux = fazGet("http://127.0.0.1:8080/produtos")
   console.log("oiiiiiiiii")
   let produtos = JSON.parse(aux);
   console.log(produtos)
   var select = document.getElementById("produto-atualizar")
   var nome = document.getElementById("nome");
   var estoque = document.getElementById("estoque");
   var valor = document.getElementById("valor");


   produtos.forEach(element => {
      let linha = criaOption(element);
      select.appendChild(linha);

   });
   let idProduto = select.value;
   let dado = fazGet(`http://127.0.0.1:8080/produtos/${idProduto}`)
   let produto = JSON.parse(dado);
   nome.value = produto.nome;
   estoque.value = produto.qtdEstoque;
   valor.value = produto.valorUnitario;

   select.onchange = function () {
      let idProduto = this.value;
      let dado = fazGet(`http://127.0.0.1:8080/produtos/${idProduto}`)
      let produto = JSON.parse(dado);

      nome.value = produto.nome;
      estoque.value = produto.qtdEstoque;
      valor.value = produto.valorUnitario;
   }

}

main()