function carregarSolicitacoes() {
    fetch('http://localhost:8080/listarSolic') // Replace with your actual URL
      .then(response => {
        if (!response.ok) {
          throw new Error('Erro ao carregar solicitações');
        }
        return response.json();
      })
      .then(solicitacoes => {
        const tabelaSolicitacoes = document.getElementById('tabelaSolicitacoes');
        tabelaSolicitacoes.innerHTML = ''; // Clear existing rows
  
        solicitacoes.forEach(solicitacao => {
          const row = document.createElement('tr');
          row.innerHTML = `
            <td th:text="${solicitacao.cod}"></td>
            <td th:text="${solicitacao.titulo}"></td>
            <td th:text="${solicitacao.assunto}"></td>
          `;
          tabelaSolicitacoes.appendChild(row);
        });
      })
      .catch(error => {
        console.error('Erro:', error);
        alert('Erro ao carregar solicitações!');
      });
  }

  window.onload(carregarSolicitacoes());