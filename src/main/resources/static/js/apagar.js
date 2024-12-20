document.getElementById('apagarFunc').addEventListener('click', function() {
    const radios = document.querySelectorAll('input[name="funcionario"]');
    let id = null;

    radios.forEach(function(radio) {
        if (radio.checked) {
            const row = radio.closest('tr');
            id = row.cells[1].innerText;
        }
    });

    if (id) {
        fetch(`http://localhost:8080/excluirFunc?identificacao=${id}`, { method: 'DELETE' })
            .then(response => {
                if (!response.ok) {
                    throw new Error('A resposta da rede não estava ok');
                }
                return response.text();
            })
            .then(data => {
                alert(data);
                location.reload();
            })
            .catch(error => {
                console.error('Ouve um problema: ', error);
            });
        
    } else {
        alert("Por favor, selecione um funcionário para apagar.");
    }
});
