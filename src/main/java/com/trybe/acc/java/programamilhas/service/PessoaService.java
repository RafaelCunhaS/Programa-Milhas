package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.LancamentoDao;
import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.util.HashUtil;
import com.trybe.acc.java.programamilhas.util.LancamentoUtil;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PessoaService {

  @Inject
  PessoaDao pessoaDao;

  @Inject
  HashUtil hashUtil;

  @Inject
  TokenUtil tokenUtil;

  @Inject
  LancamentoUtil lancamentoUtil;

  @Inject
  LancamentoDao lancamentoDao;

  /**
   * Salva uma pessoa no banco de dados.
   */
  public void salvar(LoginDto loginDto) throws InvalidKeySpecException, NoSuchAlgorithmException {
    Pessoa pessoa = new Pessoa();
    String hash = hashUtil.hash(loginDto.getSenha());
    pessoa.setLogin(loginDto.getLogin());
    pessoa.setHash(hash);
    pessoaDao.salvar(pessoa);
    Lancamento lancamento =
        lancamentoUtil.criarLancamento(pessoa.getId(), 0, 1, null, "Nova conta", null);
    lancamentoDao.salvar(lancamento);
  }

  /**
   * Remove uma pessoa do banco de dados.
   */
  public void deletar(String token) throws AcessoNaoAutorizadoException {
    Integer id = tokenUtil.obterIdUsuario(token);
    pessoaDao.deletar(id);
  }
}
