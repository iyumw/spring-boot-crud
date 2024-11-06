// document.getElementById('editarFunc').addEventListener('click', function() {
//     const radios = document.querySelectorAll('input[name="funcionario"]');
//     let id = null;
  
//     radios.forEach(function(radio) {
//       if (radio.checked) {
//         const row = radio.closest('tr');
//         id = row.cells[1].innerText;
//       }
//     });
  
//     if (id) {
//       $(document).ready(function() {
//         $('#editarFunc').click(function() {
//           const selectedRow = $('#tabelaFuncionarios tbody tr.selected');
//           if (selectedRow.length === 0) {
//             alert('Selecione um funcionário para editar.');
//             return;
//           }
      
//           const id = selectedRow.find('td:eq(1)').text();
//           const nome = selectedRow.find('td:eq(2)').text();
//           // ... obter outros dados da linha selecionada
      
//           $('#funcionarioId').val(id);
//           $('#nome').val(nome);
//           // ... preencher outros campos do formulário
      
//           $('#modalEditar').modal('show');
//         });
      
//         $('#formEditarFuncionario').submit(function(event) {
//           event.preventDefault();
//           const formData = $(this).serialize();
//           const id = $('#funcionarioId').val();
      
//           $.ajax({
//             url: `/editarFuncionario/${id}`,
//             type: 'PUT',
//             data: formData,
//             success: function() {
//               alert('Funcionário editado com sucesso!');
//               $('#modalEditar').modal('hide');
//               // Atualizar a tabela com os novos dados
//             },
//             error: function() {
//               alert('Erro ao editar funcionário.');
//             }
//           });
//         });
//       });
//     }
// })

// Esperar o DOM carregar completamente
document.addEventListener('DOMContentLoaded', function() {

  // Variáveis para os elementos
  const editarBtn = document.getElementById('editarFunc');
  const modal = document.getElementById('modalEditar');
  const fecharModalBtn = document.getElementById('fecharModal');
  const salvarBtn = document.getElementById('salvarFuncionario');
  const formEditarFuncionario = document.getElementById('formEditarFuncionario');
  
  // Evento de clique no botão "Editar"
  editarBtn.addEventListener('click', function() {
      // Procura pelo funcionário selecionado
      const selectedRadio = document.querySelector('input[name="funcionario"]:checked');
      
      if (!selectedRadio) {
          alert('Selecione um funcionário para editar.');
          return;
      }

      const row = selectedRadio.closest('tr');
      const id = row.cells[1].innerText;  // Pega o ID
      const nome = row.cells[2].innerText;  // Pega o Nome
      
      // Preenche o formulário do modal com os dados do funcionário
      document.getElementById('funcionarioId').value = id;
      document.getElementById('nome').value = nome;

      // Exibe o modal
      modal.style.display = 'block';
  });

  // Evento de clique no botão "Fechar" no modal
  fecharModalBtn.addEventListener('click', function() {
      modal.style.display = 'none';
  });

  // Evento de clique no botão "Salvar" no modal
  salvarBtn.addEventListener('click', function() {
      const id = document.getElementById('funcionarioId').value;
      const nome = document.getElementById('nome').value;

      // Crie o objeto de dados para enviar
      const funcionarioData = {
          nome: nome
      };

      // Fazer a requisição PUT para salvar os dados
      fetch(`/editarFuncionario/${id}`, {
          method: 'PUT',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(funcionarioData)
      })
      .then(response => {
          if (response.ok) {
              alert('Funcionário editado com sucesso!');
              modal.style.display = 'none';
              // Atualizar a tabela ou realizar outras ações após salvar
          } else {
              alert('Erro ao editar o funcionário.');
          }
      })
      .catch(error => {
          console.error('Erro:', error);
          alert('Erro na requisição.');
      });
  });

});
