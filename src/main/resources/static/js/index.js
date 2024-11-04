fetch('/funcionarios/listar')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Erro ao buscar funcionários');
                }
                return response.json();
            })
            .then(funcionarios => {
                const tableBody = document.getElementById('funcionarioTableBody');
                funcionarios.forEach(funcionario => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td><input type="radio" name="funcionario"></td>
                        <td>${funcionario.id}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.solicitacao}</td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => {
                console.error('Erro:', error);
            });