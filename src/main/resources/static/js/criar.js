document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio padrão do formulário
    
    const nome = document.getElementById('nome').value;
    
    fetch('/criarFunc', {
        method: 'POST',
        body: new URLSearchParams({ nome }), // Envia dados como formulário tradicional
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
    .then(response => {
        if (response.ok) {
            window.location.href = "/listarFunc"; // Redireciona após sucesso
        } else {
            console.error('Erro ao criar funcionário');
        }
    })
    .catch(error => {
        console.error('Erro:', error);
    });
});
