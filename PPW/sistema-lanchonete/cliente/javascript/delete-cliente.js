function fazDelete(url) {
  let request = new XMLHttpRequest();
  request.open("DELETE", url, true);
  request.send();
  let form = document.getElementById("formulario");
  // form.reset();
  location.reload();
}

function confirmacao() {
  var x;
  var r = confirm("Confirma a exclusão?");
  if (r == true) {
    x = "você pressionou OK!";
    deletarCliente();
  } else {
    x = "Você pressionou Cancelar!";
  }
}

function deletarCliente() {
  event.preventDefault();
  var clienteId = document.getElementById("cliente-atualizar").value;

  let url = `http://127.0.0.1:8080/clientes/${clienteId}`;

  fazDelete(url);
}
