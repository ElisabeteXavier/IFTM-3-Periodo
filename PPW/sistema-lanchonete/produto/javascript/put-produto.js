function fazPut(url, body) {
  console.log(body);
  let request = new XMLHttpRequest();
  request.open("PUT", url, true);
  request.setRequestHeader("Content-type", "application/json");
  request.send(JSON.stringify(body));

  request.onload = function () {
    console.log(this.responseText);

    let dado = this.responseText;
    let resposta = JSON.parse(dado);
    if (this.status == "200" || this.status == "201") {
      alert("ATUALIZAÇÃO REALIZADA COM SUCESSO!");
    } else {
      alert(resposta.mensagem);
    }
  };
  return request.responseText;
}

function atualizarProduto() {
  event.preventDefault();
  var produtoId = document.getElementById("produto-atualizar").value;

  let url = `http://127.0.0.1:8080/produtos/${produtoId}`;

  let nome = document.getElementById("nome").value;
  let estoque = document.getElementById("estoque").value;
  let valor = document.getElementById("valor").value;

  console.log(nome);
  console.log(estoque);

  body = {
    nome: nome,
    qtdEstoque: estoque,
    valorUnitario: valor,
  };

  fazPut(url, body);
}

function main() {}
