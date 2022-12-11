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
    var clienteId = document.getElementById("").value
  
    let url = `http://127.0.0.1:8080/clientes/${clieteId}`;
  
  let nome = document.getElementById("nome").value;
  let cpf = document.getElementById("cpf").value;
  let telefone = document.getElementById("telefone").value;
  let email = document.getElementById("email").value;
  let nascimento = document.getElementById("datanasc").value;
  let select = document.getElementById("cidade");
  let cidadeId = select.options[select.selectedIndex].value;
   
  
    console.log(nome);
    console.log(estoque);
  
    body = {
      "nome": nome,
      "cpf": cpf,
      "telefone": telefone,
      "email": email,
      "dataNascimento": nascimento, 
      "cidade": cidadeId
  
    };
  
    fazPut(url, body);
  }
  
  function main() {}