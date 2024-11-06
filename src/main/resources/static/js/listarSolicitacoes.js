// Função para carregar solicitações da API
function carregarSolicitacoes() {
  fetch('http://localhost:8080/listarSolic') // A URL para carregar as solicitações
      .then(response => {
          if (!response.ok) {
              throw new Error('Erro ao carregar solicitações');
          }
          return response.json(); // Converter resposta para JSON
      })
      .then(solicitacoes => {
          const tabelaSolicitacoes = document.getElementById('tabelaSolicitacoes');
          tabelaSolicitacoes.innerHTML = ''; // Limpar as linhas anteriores da tabela

          solicitacoes.forEach(solicitacao => {
              // Criar uma nova linha para a tabela
              const row = document.createElement('tr');
              row.innerHTML = `
                  <td><input type="radio" name="solicitacao" value="${solicitacao.id}"></td>
                  <td>${solicitacao.id}</td>
                  <td>${solicitacao.titulo}</td>
                  <td>${solicitacao.assunto}</td>
              `;
              tabelaSolicitacoes.appendChild(row); // Adicionar a linha à tabela
          });
      })
      .catch(error => {
          console.error('Erro:', error);
          alert('Erro ao carregar solicitações!');
      });
}

// Chamar a função assim que a página for carregada
window.onload = carregarSolicitacoes;
