package com.usta.covid.covid_app.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.covidapp_postgres.model.PGLoginPostgres;
import com.usta.covid_app.beans.interfaces.IObjectQueryPostgres;

/**
 * 
 * @author Moises Villalba
 * @param <T>
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DaoObjectPostgresql<T> implements IObjectQueryPostgres<T> {

	// Aqui defino el motor de bases de datos que voy a trabajar
	// define los metodos que permiten las transacciones.

	@PersistenceContext(unitName = "covidapp_postgres")
	EntityManager postgresEntity;

	@Override
	public void create(T t) throws Exception {
		postgresEntity.persist(t);

	}

	@Override
	public List<T> findAll(Class<T> t) throws Exception {
		List<T> object = new ArrayList<T>();

		Query queryPostgres = postgresEntity.createNamedQuery(t.getSimpleName() + ".FIND_ALL");// Armo la consulta
		object = queryPostgres.getResultList();// trae los datos de la consulta
		return object;

	}

	@Override
	public T findById(Integer id, Class<T> object) throws Exception {
		T t = null;
		// Opción 1
		// Query q = (Query) postgresentity.createNamedQuery(object.getSimpleName()+
		// "FIND_ALL");
		// ((javax.persistence.Query) q).setParameter("id",id);

		// Opcion 2
		t = postgresEntity.find(object, id);

		return t;
	}

	@Override
	public void update(T t) throws Exception {
		postgresEntity.merge(t);

	}

	@Override
	public void delete(Integer id, Class<T> object) throws Exception {
		T t = findById(id, object);

		if (t != null) {
			postgresEntity.remove(t);
		}

	}

	@Override
	public T searchUser(String user, String password) throws Exception {

		T t = null;
		try {
			Query q = postgresEntity.createNamedQuery(PGLoginPostgres.FIND_USER_CREDENTIALS_POSTGRESQL);
			
			q.setParameter("us", user);
			q.setParameter("ps", password);
			t = (T) q.getSingleResult();

		} catch (Exception e) {
			t = null;
		}
		return t;
	}

	@Override
	public T requiredPass(String user) {
		T t = null;
		Query q = postgresEntity.createNamedQuery(PGLoginPostgres.FIND_USER);
		q.setParameter("us", user);

		try {
			t = (T) q.getSingleResult();
		} catch (NoResultException e) {
			t = null;
		}

		return t;
	}

	@Override
	public T searchPersonByDocument(String documento) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
