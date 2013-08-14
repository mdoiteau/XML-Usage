package the.md.project.JAXBExample.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Les véhicules sont classés par type : auto, moto...
 * @author mdoiteau
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VehiculeGroup {

	/** Type du groupe de véhicules */
	@XmlAttribute
	private String type; 
	  
	/** Liste des véhicules */
	@XmlElement(name = "vehicule")
    private List<Vehicule> vehicules = new ArrayList<Vehicule>();

	/** getter type
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/** setter type
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/** getter vehicules
	 * @return the vehicules
	 */
	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	/**setter vehicules
	 * @param vehicules the vehicules to set
	 */
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	
	
}
