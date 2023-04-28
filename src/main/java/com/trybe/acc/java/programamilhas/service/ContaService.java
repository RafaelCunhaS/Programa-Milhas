package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.ContaDao;
import com.trybe.acc.java.programamilhas.dao.LancamentoDao;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ContaService {

  @Inject
  TokenUtil tokenUtil;

  @Inject
  LancamentoDao lancamentoDao;

  @Inject
  ContaDao contaDao;

  /**
   * Retorna o saldo da pessoa.
   */
  public SaldoResult saldo(String token) throws AcessoNaoAutorizadoException {
    Integer idPessoa = tokenUtil.obterIdUsuario(token);
    SaldoResult saldo = new SaldoResult();
    saldo.setSaldo(contaDao.saldo(idPessoa));
    return saldo;
  }

  public List<Lancamento> extrato(String token) throws AcessoNaoAutorizadoException {
    Integer id = tokenUtil.obterIdUsuario(token);
    return lancamentoDao.listarPorIdPessoa(id);
  }
}
