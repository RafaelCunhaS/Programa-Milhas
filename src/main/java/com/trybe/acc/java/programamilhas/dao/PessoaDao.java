package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Pessoa;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
public class PessoaDao extends GenericDao<Pessoa, Integer> {

  @Inject
  EntityManager entityManager;

  public PessoaDao() {
    super(Pessoa.class);
  }

  /**
   * Método responsável pela realização do login.
   * 
   * <p>
   * Não delete este método!
   * </p>
   */
  public Pessoa autenticar(String login, String hash) {
    String hql = "from " + Pessoa.class.getSimpleName() + " where login = :login and hash = :hash";
    Query query = entityManager.createQuery(hql);
    query.setParameter("login", login);
    query.setParameter("hash", hash);
    return (Pessoa) query.getSingleResult();
  }

  /**
   * Encontra uma pessoa pelo seu login.
   */
  public Pessoa encontrarPorLogin(String login) {
    String hql = "from " + Pessoa.class.getSimpleName() + " where login = :login";
    Query query = entityManager.createQuery(hql);
    query.setParameter("login", login);
    return (Pessoa) query.getSingleResult();
  }

  @Override
  @Transactional
  public void deletar(Integer id) {
    String hql = "DELETE FROM Lancamento WHERE idPessoa = :id";
    Query query = entityManager.createQuery(hql);
    query.setParameter("id", id);
    query.executeUpdate();

    super.deletar(id);
  }
}
