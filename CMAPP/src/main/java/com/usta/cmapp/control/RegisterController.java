package com.usta.cmapp.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.covidapp_mysql.model.Empresa;
import com.covidapp_mysql.model.Enfermedade;
import com.covidapp_mysql.model.Persona;
import com.covidapp_mysql.model.Registro;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.covid_app.service.ServicesDao;

@ManagedBean(name = "register")
@SessionScoped
public class RegisterController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Properties properties;
	private Registro registerPerson;
	private String userAcces;
	private String usLoged;
	private List<Enfermedade> listDisease;
	private List<Empresa> listEmpresa;
	private String document;
	private boolean visiblePanel;
	private Persona personRegister;
	private Float imc;
	private String resultaImc;

	@EJB
	private ServicesDao<Object> servicesDao;

	public RegisterController() {
		properties = new Properties();
		userAcces = null;
		registerPerson = new Registro();
		listDisease = new ArrayList<Enfermedade>();
		listEmpresa = new ArrayList<Empresa>();
		document = null;
		visiblePanel = false;
		imc = 0.0F;
		resultaImc = null;
		personRegister = new Persona();
		chargeProperties();
	}

	private void chargeProperties() {
		try {
			properties.load(RegisterController.class.getResourceAsStream("messages.properties"));
			userAcces = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get(LoginController.USER_AUTENTICH)).toUpperCase();
			usLoged = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get(LoginController.AUTH_KEY)).toUpperCase();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty("errorGeneral"), properties.getProperty("errorCargaPropiedades")));
		}
	}

	@PostConstruct
	public void chargeData() {
		try {
			List<Object> diseaseTemp = servicesDao.findAll(Enfermedade.class, EnumDataBase.MYSQL.getId());
			for (Object o : diseaseTemp) {
				listDisease.add((Enfermedade) o);
			}

			List<Object> empresaTemp = servicesDao.findAll(Empresa.class, EnumDataBase.MYSQL.getId());
			for (Object o : empresaTemp) {
				listEmpresa.add((Empresa) o);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void validatePerson() {
		try {
			if (document != null && !document.equals("")
					&& (registerPerson.getIdEnfermedadSerial() > 0 && (registerPerson.getIdEmpresaSerial() > 0))) {
				personRegister = (Persona) servicesDao.searchPersonByDocument(document, EnumDataBase.MYSQL.getId());
				if (personRegister != null && !personRegister.equals("")) {
					registerPerson.setIdPersonaSerial(personRegister.getIdPersonaSerial());
					visiblePanel = true;
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							properties.getProperty(""), properties.getProperty("")));
				}

			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty(""), properties.getProperty("")));
		}
	}

	public void regisInto() {
		try {
			if (personRegister.getPeso() > 0 && registerPerson.getTemperatura() > 0) {
				if (registerPerson.getTemperatura() < 38 && registerPerson.getTemperatura() > 35) {
					registerPerson.setIngreso(Byte.valueOf("0"));
					registerPerson.setFechaIngreso(new Date());
					registerPerson.setSintomas(Byte.valueOf("0"));
					servicesDao.create(registerPerson, EnumDataBase.MYSQL.getId());
					imc = Float.valueOf(personRegister.getPeso())
							/ Float.valueOf((float) Math.pow(Double.valueOf(personRegister.getEstatura()), 2));
					resultaImc = personRegister.getGenero().equals("male")
							? (imc > 25 ? "Sobrepeso".concat(imc.toString()) : "Normal".concat(imc.toString()))
							: (imc > 24 ?"Sobrepeso".concat(imc.toString()) : "Normal".concat(imc.toString()));

				}
			}
		} catch (Exception e) {

		}

	}

	public Registro getRegisterPerson() {
		return registerPerson;
	}

	public void setRegisterPerson(Registro registerPerson) {
		this.registerPerson = registerPerson;
	}

	public String getUserAcces() {
		return userAcces;
	}

	public void setUserAcces(String userAcces) {
		this.userAcces = userAcces;
	}

	public String getUsLoged() {
		return usLoged;
	}

	public void setUsLoged(String usLoged) {
		this.usLoged = usLoged;
	}

	public List<Enfermedade> getListDisease() {
		return listDisease;
	}

	public void setListDisease(List<Enfermedade> listDisease) {
		this.listDisease = listDisease;
	}

	public List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

	public void setListEmpresa(List<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public boolean isVisiblePanel() {
		return visiblePanel;
	}

	public void setVisiblePanel(boolean visiblePanel) {
		this.visiblePanel = visiblePanel;
	}

	public Persona getPersonRegister() {
		return personRegister;
	}

	public void setPersonRegister(Persona personRegister) {
		this.personRegister = personRegister;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

	public String getResultaImc() {
		return resultaImc;
	}

	public void setResultaImc(String resultaImc) {
		this.resultaImc = resultaImc;
	}

}
