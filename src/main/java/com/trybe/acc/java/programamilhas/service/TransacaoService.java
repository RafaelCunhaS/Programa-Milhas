package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.ContaDao;
import com.trybe.acc.java.programamilhas.dao.LancamentoDao;
import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dao.ProdutoDao;
import com.trybe.acc.java.programamilhas.dominio.TipoLancamentoEnum;
import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.exception.SaldoInsuficienteException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.util.LancamentoUtil;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TransacaoService {

  @Inject
  LancamentoDao lancamentoDao;

  @Inject
  TokenUtil tokenUtil;

  @Inject
  LancamentoUtil lancamentoUtil;

  @Inject
  ContaDao contaDao;

  @Inject
  PessoaDao pessoaDao;

  @Inject
  ProdutoDao produtoDao;

  /**
   * Método responsável pela transferência entre usuários.
   */
  public void transferencia(String token, TransferenciaDto transferenciaDto)
      throws AcessoNaoAutorizadoException, SaldoInsuficienteException {
    Integer idPessoa = tokenUtil.obterIdUsuario(token);
    Integer valor = transferenciaDto.getValor();
    if (contaDao.saldo(idPessoa) < valor) {
      throw new SaldoInsuficienteException();
    }

    Lancamento transferenciaRealizada = lancamentoUtil.criarLancamento(idPessoa, -valor,
        TipoLancamentoEnum.TRANSFERENCIA.getId(), null, "Transferência de pontos realizada", null);
    lancamentoDao.salvar(transferenciaRealizada);

    Pessoa usuarioDestino = pessoaDao.encontrarPorLogin(transferenciaDto.getUsuarioDestino());
    Lancamento transferenciaRecebida = lancamentoUtil.criarLancamento(usuarioDestino.getId(), valor,
        TipoLancamentoEnum.TRANSFERENCIA.getId(), null, "Transferência de pontos recebida", null);
    lancamentoDao.salvar(transferenciaRecebida);
  }

  /**
   * Método que realiza o lancamento do resgate de um produto.
   */
  public void resgateProduto(String token, ResgateProdutoDto resgateProdutoDto)
      throws SaldoInsuficienteException, AcessoNaoAutorizadoException {
    Integer idPessoa = tokenUtil.obterIdUsuario(token);
    Produto produto = produtoDao.encontrar(resgateProdutoDto.getIdProduto());
    if (contaDao.saldo(idPessoa) < produto.getValor()) {
      throw new SaldoInsuficienteException();
    }
    Lancamento resgateProdutoRealizado =
        lancamentoUtil.criarLancamento(idPessoa, -produto.getValor(),
            TipoLancamentoEnum.RESGATE.getId(), null, "Resgate de produto", produto.getId());
    lancamentoDao.salvar(resgateProdutoRealizado);
  }
}
