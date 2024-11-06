document.addEventListener('DOMContentLoaded', function() {
    const editarButton = document.getElementById('editarFunc');

    editarButton.addEventListener('click', function() {
        const radios = document.querySelectorAll('input[name="funcionario"]:checked');

        if (radios.length === 0) {
            alert('Selecione um funcionário para editar.');
            return;
        }

        const selectedRadio = radios[0];
        const selectedRow = selectedRadio.closest('tr'); // Encontra a linha do funcionário selecionado

        if (selectedRow) {
            const id = selectedRow.cells[1].textContent; // ID do funcionário (coluna 2)
            const nome = selectedRow.cells[2].textContent; // Nome do funcionário (coluna 3)

            // Preenche os campos do formulário com os dados
            const idInput = document.getElementById('funcionarioId');
            const nomeInput = document.getElementById('nome');
            
            if (idInput && nomeInput) {
                idInput.value = id;
                nomeInput.value = nome;
            }

            // Exibe o modal de edição
            const modalEditar = document.getElementById('modalEditar');
            if (modalEditar) {
                modalEditar.style.display = 'block';
            }
        }
    });

    // Quando o botão de salvar for clicado
    document.getElementById('salvarFuncionario').addEventListener('click', function() {
        const id = document.getElementById('funcionarioId').value;
        const nome = document.getElementById('nome').value;

        // Envia os dados como formulário (POST ou PUT, dependendo de como o backend espera)
        fetch(`/editarFuncionario/${id}`, {
            method: 'PUT',
            body: new URLSearchParams({ nome }), // Envia dados como formulário tradicional
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' // O servidor espera esse formato
            }
        })
        .then(response => {
            if (response.ok) {
                alert('Funcionário atualizado com sucesso!');
                window.location.href = '/listarFunc'; // Redireciona para a página de listagem
            } else {
                alert('Erro ao atualizar o funcionário');
            }
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Erro ao enviar dados para o servidor');
        });
    });

    // Fecha o modal ao clicar no botão de fechar
    const closeButton = document.querySelector('.modal .close');
    if (closeButton) {
        closeButton.addEventListener('click', function() {
            const modalEditar = document.getElementById('modalEditar');
            if (modalEditar) {
                modalEditar.style.display = 'none';  // Fecha o modal
            }
        });
    }
});
