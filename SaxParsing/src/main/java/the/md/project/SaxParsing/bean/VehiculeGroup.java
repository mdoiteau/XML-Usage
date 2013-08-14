package the.md.project.SaxParsing.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Les véhicules sont classés par type : auto, moto...
 * @author mdoiteau
 *
 */
public class VehiculeGroup {

	/** Type du groupe de véhicules */
	private String type; 
	  
	/** Liste des véhicules */
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
