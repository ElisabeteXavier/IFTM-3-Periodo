function fazPut(url, body) {
    console.log(body);
    let request = new XMLHttpRequest();
    request.open("PUT", url, true);
    request.setRequestHeader("Content-type", "application/json");
    request.send(JSON.stringify(body));
  
    request.onload = function(){
      console.log(this.responseText)
    }
     return request.responseText
  }
  
  function atualizarCliente() {
    event.preventDefault();
    var clienteId = document.getElementById("cliente-atualizar").value
  
    let url = `http://127.0.0.1:8080/clientes/${clienteId}`;
  
  var nome = document.getElementById("nome").value;
  var cpf = document.getElementById("cpf").value;
  var telefone = document.getElementById("telefone").value;
  var email = document.getElementById("email").value;
  var nascimento = document.getElementById("datanasc").value;
  var select = document.getElementById("cidade");
  var cidadeId = select.options[select.selectedIndex].value;
  var dado = fazGet(`http://127.0.0.1:8080/cidades/${cidadeId}`)
  var cidade = JSON.parse(dado);
  console.log(cidade);
   
  
    body = {
      "nome": nome,
      // "cpf": cpf,
      "telefone": telefone,
      "email": email,
      "dataNascimento": nascimento, 
      "cidade": cidade
  
    };
  
    fazPut(url, body);
  }
  
  // function main() {}