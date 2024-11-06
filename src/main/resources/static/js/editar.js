document.getElementById('editarFunc').addEventListener('click', function() {
    const radios = document.querySelectorAll('input[name="funcionario"]');
    let id = null;
  
    radios.forEach(function(radio) {
      if (radio.checked) {
        const row = radio.closest('tr');
        id = row.cells[1].innerText;
      }
    });
  
    if (id) {
      $(document).ready(function() {
        $('#editarFunc').click(function() {
          const selectedRow = $('#tabelaFuncionarios tbody tr.selected');
          if (selectedRow.length === 0) {
            alert('Selecione um funcionário para editar.');
            return;
          }
      
          const id = selectedRow.find('td:eq(1)').text();
          const nome = selectedRow.find('td:eq(2)').text();
          // ... obter outros dados da linha selecionada
      
          $('#funcionarioId').val(id);
          $('#nome').val(nome);
          // ... preencher outros campos do formulário
      
          $('#modalEditar').modal('show');
        });
      
        $('#formEditarFuncionario').submit(function(event) {
          event.preventDefault();
          const formData = $(this).serialize();
          const id = $('#funcionarioId').val();
      
          $.ajax({
            url: `/editarFuncionario/${id}`,
            type: 'PUT',
            data: formData,
            success: function() {
              alert('Funcionário editado com sucesso!');
              $('#modalEditar').modal('hide');
              // Atualizar a tabela com os novos dados
            },
            error: function() {
              alert('Erro ao editar funcionário.');
            }
          });
        });
      });
    }
})
