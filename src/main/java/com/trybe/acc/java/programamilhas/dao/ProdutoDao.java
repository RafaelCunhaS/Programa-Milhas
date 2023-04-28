package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Produto;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoDao extends GenericDao<Produto, Integer> {

  public ProdutoDao() {
    super(Produto.class);
  }
}
