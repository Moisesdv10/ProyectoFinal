package com.usta.cmapp.control;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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

import org.primefaces.event.FlowEvent;

import com.covidapp_mysql.model.Ciudade;
import com.covidapp_mysql.model.Persona;
import com.covidapp_mysql.model.TipoDocumento;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.cmapp.constants.EnumRhBlood;
import com.usta.covid_app.service.ServicesDao;

@ManagedBean(name = "principal")
@SessionScoped
public class PrincipalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String PAGE_PRINCIPAL = "../login/login.faces";

	private Properties properties;
	private String usLoged;
	private String userAcces;
	private Persona newPerson;
	private List<TipoDocumento> typesDocuments;
	private List<Ciudade> listCities;
	private List<EnumRhBlood> rhlist;
	private TipoDocumento documentType;
	private Ciudade city;
	private String phone;

	@EJB
	private ServicesDao<Object> servicesDao;

	/**
	 * constructor class
	 */
	public PrincipalController() {

		try {
			properties = new Properties();
			userAcces = null;
			newPerson = new Persona();
			city = new Ciudade();
			documentType = new TipoDocumento();
			typesDocuments = new ArrayList<TipoDocumento>();
			listCities = new ArrayList<Ciudade>();
			rhlist = new ArrayList<EnumRhBlood>();
			chargeProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * init variables
	 */
	private void chargeProperties() {
		try {
			properties.load(PrincipalController.class.getResourceAsStream("messages.properties"));
			userAcces = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get(LoginController.USER_AUTENTICH)).toUpperCase();
			usLoged = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get(LoginController.AUTH_KEY)).toUpperCase();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty("errorGeneral"), properties.getProperty("errorCargaPropiedades")));
		}
	}

	/**
	 * este metodo se inicializa tan pronto se carga la clase y despues que crea el
	 * constructor No recibi de ningun cliente, el cliente es el mismo servidor
	 * cuando la aplicacion es inicializada.
	 */
	@PostConstruct
	public void chargeData() {
		try {
			List<Object> d = servicesDao.findAll(TipoDocumento.class, EnumDataBase.MYSQL.getId());
			for (Object o : d) {
				typesDocuments.add((TipoDocumento) o);
			}

			List<Object> c = servicesDao.findAll(Ciudade.class, EnumDataBase.MYSQL.getId());
			for (Object o : c) {
				listCities.add((Ciudade) o);
			}

			rhlist.add(EnumRhBlood.ABPOS);
			rhlist.add(EnumRhBlood.ABNEG);
			rhlist.add(EnumRhBlood.ABPOS);
			rhlist.add(EnumRhBlood.ANEG);
			rhlist.add(EnumRhBlood.BPOS);
			rhlist.add(EnumRhBlood.BNEG);
			rhlist.add(EnumRhBlood.OPOS);
			rhlist.add(EnumRhBlood.ONEG);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty("errorGeneral"), properties.getProperty("errorCargaPropiedades")));
		}
	}

	/**
	 * valida para hacer el paso a la siguiente pestania
	 * 
	 * @param event
	 * @return
	 */
	public String onFlowProcess(FlowEvent event) {
		String result = null;

		if (validateDataPerson()) {
			result = event.getNewStep();
		} else {
			result = event.getOldStep();
		}

		return result;
	}

	/**
	 * valida los registros que sean de caracter obligatorio y valida que la fecha
	 * de nacimiento sea menor a la dia de hoy
	 * 
	 * @return
	 */
	private boolean validateDataPerson() {
		boolean flag = false;
		if ((newPerson.getDocumento() != null && !newPerson.getDocumento().equals(""))
				&& (newPerson.getPrimerNombre() != null && !newPerson.getPrimerNombre().equals(""))
				&& (newPerson.getPrimerApellido() != null && !newPerson.getPrimerApellido().equals(""))
				&& (newPerson.getFechaNacimiento() != null && !newPerson.getFechaNacimiento().equals(""))
				&& (phone != null && !phone.equals(""))) {

			Date today = new Date();
			if (newPerson.getFechaNacimiento().before(today)) {
				flag = true;
			} else {
				flag = false;
			}

		} else {
			flag = false;
		}

		return flag;
	}

	/**
	 * metodo que crea la persona desde el formulario
	 */
	public void createPerson() {
		try {
			if (validateDataPerson()) {
				newPerson.setCellPhone(new BigDecimal(phone));
				servicesDao.create(newPerson, EnumDataBase.MYSQL.getId());

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						properties.getProperty(""), properties.getProperty("")));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						properties.getProperty(""), properties.getProperty("")));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty(""), properties.getProperty("")));
		}
	}

	public String logut() {

		try {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("principal");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pesoncontroller");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.remove(LoginController.USER_AUTENTICH);
			FacesContext.getCurrentInstance().getExternalContext().redirect(PAGE_PRINCIPAL);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/* setter and getter */
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getUsLoged() {
		return usLoged;
	}

	public void setUsLoged(String usLoged) {
		this.usLoged = usLoged;
	}

	public String getUserAcces() {
		return userAcces;
	}

	public void setUserAcces(String userAcces) {
		this.userAcces = userAcces;
	}

	public Persona getNewPerson() {
		return newPerson;
	}

	public void setNewPerson(Persona newPerson) {
		this.newPerson = newPerson;
	}

	public List<TipoDocumento> getTypesDocuments() {
		return typesDocuments;
	}

	public void setTypesDocuments(List<TipoDocumento> typesDocuments) {
		this.typesDocuments = typesDocuments;
	}

	public List<Ciudade> getListCities() {
		return listCities;
	}

	public void setListCities(List<Ciudade> listCities) {
		this.listCities = listCities;
	}

	public List<EnumRhBlood> getRhlist() {
		return rhlist;
	}

	public void setRhlist(List<EnumRhBlood> rhlist) {
		this.rhlist = rhlist;
	}

	public TipoDocumento getDocumentType() {
		return documentType;
	}

	public void setDocumentType(TipoDocumento documentType) {
		this.documentType = documentType;
	}

	public Ciudade getCity() {
		return city;
	}

	public void setCity(Ciudade city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}