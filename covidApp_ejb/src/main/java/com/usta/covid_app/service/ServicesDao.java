package com.usta.covid_app.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.covidapp_mysql.model.Login;
import com.usta.covid.covid_app.beans.DaoObjectMysql;
import com.usta.covid.covid_app.beans.DaoObjectPostgresql;
import com.usta.covid_app.beans.interfaces.IObjectQueryMysql;
import com.usta.covid_app.beans.interfaces.IObjectQueryPostgres;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)

public class ServicesDao<T> {

	@EJB
	IObjectQueryMysql<T> mysqlDao;

	@EJB
	IObjectQueryPostgres<T> postgresDao;

	/**
	 * 
	 * Metodo que se encarga de crear el objeto a persistir
	 * 
	 * @param t
	 * @param db
	 * @throws Exception
	 */

	public void create(T t, int db) throws Exception {
		switch (db) {
		case 1:// Persiste mysql
			mysqlDao.create(t);
			break;

		case 2: // Persiste postgresql
			postgresDao.create(t);
			break;
		}
	}

	/**
	 * método encargado de buscar y listar todos los objetos de la consulta deseada.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> findAll(T t, int db) throws Exception {

		List<T> object = new ArrayList<T>();

		switch (db) {
		case 1:// Persiste mysql
			object = mysqlDao.findAll((Class<T>) t);
			break;

		case 2: // Persiste postgresql
			object = postgresDao.findAll((Class<T>) t);
			break;
		}

		return object;
	}

	/**
	 * Método de encontrar por el id el objeto buscado
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T findById(Integer id, Class<T> object, int db) throws Exception {

		T o = null;

		switch (db) {
		case 1:// Persiste mysql
			o = mysqlDao.findById(id, object);
			break;

		case 2: // Persiste postgresql
			o = postgresDao.findById(id, object);
			break;
		}

		return o;
	}

	/*
	 * Método par realizar cualquier cambio o modificacion sobre un dato de un
	 * objeto.
	 * 
	 * @param t
	 * 
	 * @throws Exception
	 */
	public void update(T t, int db) throws Exception {
		switch (db) {
		case 1:// Persiste mysql
			mysqlDao.update(t);
			break;

		case 2: // Persiste postgresql
			postgresDao.update(t);
			break;
		}
	}

	/**
	 * Elimina un objeto dependiendo el id que se solicite borrar.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer id, Class<T> object, int db) throws Exception {
		switch (db) {
		case 1:// Persiste mysql
			mysqlDao.delete(id, object);
			break;

		case 2: // Persiste postgresql
			postgresDao.delete(id, object);
			break;
		}
	}

	/**
	 * Busca el usuario según credenciales
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public T searchUser(String user, String password, int bd) throws Exception {
		T t = null;

		switch (bd) {
		case 1:
			t = mysqlDao.searchUser(user, password);
			break;
		case 2:
			t = postgresDao.searchUser(user, password);
			break;
		}

		return t;
	}

	/**
	 * Método que se encarga de buscar el usuario para traer contraseña
	 * 
	 * @return
	 * @throws Exception
	 */
	public T searchUser(String user, int bd) throws Exception {
		T t = null;

		switch (bd) {
		case 1:
			t = mysqlDao.requiredPass(user);
			break;
		case 2:
			t = postgresDao.requiredPass(user);
			break;
		}
		return t;

	}

	public T searchPersonByDocument(String document, int bd) throws Exception {
		T t = null;
		switch (bd) {
		case 1:
			t = mysqlDao.searchPersonByDocument(document);
			break;

		case 2:
			t = postgresDao.searchPersonByDocument(document);
			break;
		}
		return t;
	}
}
