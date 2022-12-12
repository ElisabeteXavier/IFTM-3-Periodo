
function fazGet(url) {
   let request = new XMLHttpRequest()
   request.open("GET", url, false)
   request.send()
   return request.responseText
}


function criaOption(cliente) {
   let option = document.createElement("option")
   option.appendChild(document.createTextNode(`${cliente.nome}`))
   option.setAttribute("value", `${cliente.cpf}`)
   return option;

}

function main() {
   let aux = fazGet("http://127.0.0.1:8080/clientes")
   let clientes = JSON.parse(aux);
   console.log(clientes)

   let select = document.getElementById("cliente-atualizar")

   var nome = document.getElementById("nome");
   var cpf = document.getElementById("cpf");
   var telefone = document.getElementById("telefone");
   var email = document.getElementById("email");
   var nascimento = document.getElementById("datanasc");
   // var selectCidade = document.getElementById("cidade");
   // var cidadeId = select.options[selectCidade.selectedIndex];

   clientes.forEach(element => {
      let linha = criaOption(element);
      select.appendChild(linha)

   });
   let idCliente = select.value;
   let dado = fazGet(`http://127.0.0.1:8080/clientes/${idCliente}`)
   let cliente = JSON.parse(dado);

   nome.value = cliente.nome;
   cpf.value = cliente.cpf;
   telefone.value = cliente.telefone;
   email.value = cliente.email;
   nascimento.value = cliente.dataNascimento;

   select.onchange = function () {
      let idCliente = this.value;
      let dado = fazGet(`http://127.0.0.1:8080/clientes/${idCliente}`)
      let cliente = JSON.parse(dado);

      nome.value = cliente.nome;
      cpf.value = cliente.cpf;
      telefone.value = cliente.telefone;
      email.value = cliente.email;
      nascimento.value = cliente.dataNascimento;



   }
}
main()