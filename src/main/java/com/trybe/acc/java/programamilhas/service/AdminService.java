package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.ContaDao;
import com.trybe.acc.java.programamilhas.dao.LancamentoDao;
import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dto.LancamentoDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.util.LancamentoUtil;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AdminService {

  @Inject
  LancamentoDao lancamentoDao;

  @Inject
  LancamentoUtil lancamentoUtil;

  @Inject
  PessoaDao pessoaDao;

  @Inject
  ContaDao contaDao;

  @Inject
  TokenUtil tokenUtil;

  /**
   * Método que realiza o lancamento de um resgate.
   */
  public void resgate(String token, LancamentoDto lancamentoDto)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    Pessoa usuario = pessoaDao.encontrarPorLogin(lancamentoDto.getUsuario());
    Lancamento resgate = lancamentoUtil.criarLancamento(usuario.getId(), -lancamentoDto.getValor(),
        lancamentoDto.getIdTipoLancamento(), lancamentoDto.getIdParceiro(),
        lancamentoDto.getDescricao(), null);
    lancamentoDao.salvar(resgate);
  }

  public List<SaldoResult> saldos(String token) throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return contaDao.listarSaldos();
  }
}
