package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.ParceiroDao;
import com.trybe.acc.java.programamilhas.dao.ProdutoDao;
import com.trybe.acc.java.programamilhas.dao.TipoLancamentoDao;
import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DominioService {

  @Inject
  TipoLancamentoDao tipoLancamentoDao;

  @Inject
  ProdutoDao produtoDao;

  @Inject
  ParceiroDao parceiroDao;

  public List<TipoLancamento> listarTiposLancamentos() {
    return tipoLancamentoDao.listar();
  }

  public List<Produto> listarProdutos() {
    return produtoDao.listar();
  }

  public List<Parceiro> listarParceiros() {
    return parceiroDao.listar();
  }
}
