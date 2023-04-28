package com.trybe.acc.java.programamilhas.dao;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

/**
 * Classe abstrata GenericDao.
 **/

@ApplicationScoped
public abstract class GenericDao<T, I extends Serializable> {


  @Inject
  EntityManager em;

  private Class<T> persistedClass;

  protected GenericDao(Class<T> persistedClass) {
    this.persistedClass = persistedClass;
  }

  /**
   * Salva dados no banco.
   */
  @Transactional
  public void salvar(T t) {
    em.persist(t);
  }

  /**
   * Atualiza dados no banco.
   */
  @Transactional
  public void editar(T t) {
    em.merge(t);
  }

  /**
   * Remove dados no banco.
   */
  @Transactional
  public void deletar(Integer id) {
    T t = em.find(persistedClass, id);

    em.remove(t);
  }

  /**
   * Retorna todos dados da tabela.
   */
  public List<T> listar() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(persistedClass);
    Root<T> root = cq.from(persistedClass);
    cq.select(root);

    return em.createQuery(cq).getResultList();
  }

  /**
   * Retorna dados por id.
   */
  public T encontrar(Integer id) {
    return em.find(persistedClass, id);
  }

}
