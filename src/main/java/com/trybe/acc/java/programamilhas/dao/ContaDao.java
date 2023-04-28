package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class ContaDao {

  @Inject
  EntityManager entityManager;

  /**
   * Retorna saldo da pessoa através de seu id.
   */
  public Integer saldo(Integer idPessoa) {
    String hql = "select sum(valor) from Lancamento where idPessoa = :idPessoa";
    Query query = entityManager.createQuery(hql);
    query.setParameter("idPessoa", idPessoa);
    Long saldo = (Long) query.getSingleResult();
    return saldo.intValue();
  }

  /**
   * Retorna saldos de todas pessoas.
   */
  public List<SaldoResult> listarSaldos() {
    String hql = "select sum(valor) from Lancamento group by idPessoa";
    TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
    List<SaldoResult> saldos = new ArrayList<SaldoResult>();
    for (Long saldo : query.getResultList()) {
      SaldoResult novoSaldo = new SaldoResult();
      novoSaldo.setSaldo(saldo.intValue());
      saldos.add(novoSaldo);
    }
    return saldos;
  }
}
