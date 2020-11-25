package com.usta.covid_app.beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.covidapp_postgres.model.PGLoginPostgres;

/**
 * Interfaz de tipo Bean que se encarga de definir los metodos para realizar el
 * crud.
 * 
 * @author Moises Villalba
 * @param <T> tipo de objeto que recibe.
 */

@Remote
public interface IObjectQueryPostgres<T> {

	/**
	 * Metodo que se encarga de crear el objeto apersistir
	 * 
	 * @param t
	 * @throws Exception
	 */
	public void create(T t) throws Exception;

	/**
	 * método encargado de buscar y listar todos los objetos de la consulta deseada.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> findAll(Class<T> t) throws Exception;

	/**
	 * Método de encontrar por el id el objeto buscado
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T findById(Integer id, Class<T> object) throws Exception;

	/*
	 * Método par realizar cualquier cambio o modificacion sobre un dato de un
	 * objeto.
	 * 
	 * @param t
	 * 
	 * @throws Exception
	 */
	public void update(T t) throws Exception;

	/**
	 * Elimina un objeto dependiendo el id que se solicite borrar.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer id, Class<T> object) throws Exception;

	/**
	 * Busca el usuario según credenciales
	 * 
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public T searchUser(String user, String password) throws Exception;

	/**
	 * recuperamos contraseña del usuario
	 * 
	 * @param user
	 * @return
	 */
	public T requiredPass(String user);

	/**
	 * busca persona por el numero de documento
	 * 
	 * @param documento
	 * @return
	 * @throws Exception
	 */
	public T searchPersonByDocument(String documento) throws Exception;
}
