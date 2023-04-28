package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ApplicationScoped
public class LancamentoDao extends GenericDao<Lancamento, Integer> {

  @Inject
  EntityManager entityManager;

  public LancamentoDao() {
    super(Lancamento.class);
  }

  /**
   * Retorna todos lancamentos da pessoa.
   */
  @SuppressWarnings("unchecked")
  public List<Lancamento> listarPorIdPessoa(Integer idPessoa) {
    String hql = "from " + Lancamento.class.getSimpleName() + " where idPessoa = :idPessoa";
    Query query = entityManager.createQuery(hql);
    query.setParameter("idPessoa", idPessoa);
    return query.getResultList();
  }
}
