package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParceiroDao extends GenericDao<Parceiro, Integer> {

  public ParceiroDao() {
    super(Parceiro.class);
  }
}
