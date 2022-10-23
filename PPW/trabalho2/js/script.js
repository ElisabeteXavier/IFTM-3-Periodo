function abrir_fechar_resposta(resposta, mais){

    if(document.getElementById(resposta).style.display == 'block'){
        document.getElementById(mais).innerHTML = '+'
        document.getElementById(resposta).style.display = 'none'
    }else if (document.getElementById(resposta).style.display != 'block') {
        document.getElementById(mais).innerHTML = 'x'
        document.getElementById(resposta).style.display = 'block'
    }
    

}