let botao = document.getElementById('searchButton');

botao.addEventListener('click', pesquisarFuncionario)


function pesquisarFuncionario() {
    const id = document.getElementById('searchInput').value;

    if (id) {
        fetch(`http://localhost:8080/pesquisarFunc/${id}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Erro ao buscar funcionário');
                }
                return response.json(); 
            })
            .then(funcionario => {
                const tableBody = document.getElementById('funcionarioTableBody');
                tableBody.innerHTML = '';

                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>
                        <input type="radio" name="funcionario" value="${funcionario.id}">
                    </td>
                    <td>${funcionario.id}</td>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.solicitacao}</td>
                `;
                tableBody.appendChild(row);
            })
            .catch(error => {
                console.error('Erro:', error);
                alert('Funcionário não encontrado!');
            });
    } else {
        alert('Por favor, digite um ID!');
    }
}
