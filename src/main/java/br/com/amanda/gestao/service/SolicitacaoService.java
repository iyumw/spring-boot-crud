package br.com.amanda.gestao.service;

import br.com.amanda.gestao.dao.SolicitacaoDao;
import br.com.amanda.gestao.model.entities.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoDao solicitacaoDao;

    @Transactional(readOnly = true)
    public Solicitacao pesquisarSolicitacao(long id) throws Exception {
        return solicitacaoDao.pesquisarSolicitacao(id);
    }

    @Transactional(readOnly = true)
    public List<Solicitacao> listarSolicitacoes() throws Exception {
        return solicitacaoDao.listarSolicitacoes();
    }

    @Transactional
    public void criarSolicitacao(Solicitacao solicitacao) throws Exception {
        solicitacaoDao.criarSolicitacao(solicitacao);
    }

    @Transactional
    public void editarSolicitacao(Solicitacao solicitacao) throws Exception {
        solicitacaoDao.editarSolicitacao(solicitacao);
    }

    @Transactional
    public void excluirSolicitacao(Solicitacao solicitacao) throws Exception {
        solicitacaoDao.excluirSolicitacao(solicitacao);
    }
}
