function fazPost(url, body) {
  console.log(body);
  let request = new XMLHttpRequest();
  request.open("POST", url, true);
  request.setRequestHeader("Content-type", "application/json");
  var teste = request.send(JSON.stringify(body));

  request.onload = function(){
    console.log(this.responseText)

    let dado = this.responseText;
    let resposta= JSON.parse(dado);
    if(this.status == "200"|| this.status == "201"){
      alert("CADASTRO REALIZADO COM SUCESSO!");

  }else{
    alert(resposta.mensagem );
  }
  }
   return request.responseText
}

function cadastrarProduto() {
  event.preventDefault();

  let url = "http://127.0.0.1:8080/produtos";

  let nome = document.getElementById("nome").value;
  let estoque = document.getElementById("estoque").value;
  let valor = document.getElementById("valor").value;
  

  console.log(nome);
  console.log(estoque);

  body = {
    "nome": nome,
    "qtdEstoque": estoque,
    "valorUnitario": valor

  };

  fazPost(url, body);
}

