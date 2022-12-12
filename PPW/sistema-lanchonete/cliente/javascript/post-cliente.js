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

    
    
// if(this.status == "401"){
    
    //   alert(this.responseText );
      

    // } else if (this.status == "200"){
    //   alert("CADASTRO REALIZADO COM SUCESSO!");

    // }else if (this.status == "409"){

    //   alert(this.responseText );

    // }
    if(this.status == "200"){
      alert("CADASTRO REALIZADO COM SUCESSO!");

  }else{
    alert(resposta.mensagem );
  }

   return request.responseText
}
}


function cadastrarCliente() {
  event.preventDefault();

  let url = "http://127.0.0.1:8080/clientes";

  let nome = document.getElementById("nome").value;
  let cpf = document.getElementById("cpf").value;
  let telefone = document.getElementById("telefone").value;
  let email = document.getElementById("email").value;
  let nascimento = document.getElementById("datanasc").value;
  let select = document.getElementById("cidade");
  let cidadeId = select.options[select.selectedIndex].value
 
  console.log(cidadeId)
  let dado = fazGet(`http://127.0.0.1:8080/cidades/${cidadeId}`);
  var cidade = JSON.parse(dado);
  console.log(cidade)

  body = {
    "nome": nome,
    "cpf": cpf,
    "telefone": telefone,
    "email": email,
    "dataNascimento": nascimento, 
    "cidade": cidade

  };

  fazPost(url, body);
}

