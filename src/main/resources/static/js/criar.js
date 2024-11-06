function criarFuncionario(nome) {
    fetch('/criarFunc', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nome })
    })
    .then(response => {
        if (response.ok) {
            // Redireciona para a lista de funcionários
            window.location.href = "/listarFunc";
        } else {
            console.error('Erro ao criar funcionário');
        }
    })
    .catch(error => {
        console.error('Erro:', error);
    });
}