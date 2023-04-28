package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoLancamentoDao extends GenericDao<TipoLancamento, Integer> {

  public TipoLancamentoDao() {
    super(TipoLancamento.class);
  }

}
