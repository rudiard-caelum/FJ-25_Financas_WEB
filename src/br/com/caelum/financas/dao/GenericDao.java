package br.com.caelum.financas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GenericDao<T> {

	private Class<T> clazz;

	/*
	 * @PersistenceContext private EntityManager manager;
	 */

	@Inject
	private EntityManager manager;

	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void adiciona(T entity) {
		this.manager.joinTransaction();
		this.manager.persist(entity);
	}

	public void remove(T entity) {
		this.manager.joinTransaction();
		this.manager.remove(this.manager.merge(entity));
	}

	public void altera(T entity) {
		this.manager.joinTransaction();
		this.manager.merge(entity);
	}

	public T busca(Integer id) {
		return (T) this.manager.find(clazz, id);
	}

	public List<T> lista() {
		return this.manager.createQuery(
				"select g from " + clazz.getSimpleName() + " g", clazz)
				.getResultList();
	}

}
