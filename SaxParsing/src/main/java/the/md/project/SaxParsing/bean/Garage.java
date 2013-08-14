package the.md.project.SaxParsing.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Un garage correspond à une liste de différent type de véhicule
 * @author mdoiteau
 *
 */
public class Garage {

	/** Les groupes de véhicules du garage */
	private List<VehiculeGroup> vehiculeGroup = new ArrayList<VehiculeGroup>();

	/**
	 * getter sur le vehiculeGroup
	 * @return the vehiculeGroup
	 */
	public List<VehiculeGroup> getVehiculeGroup() {
		return vehiculeGroup;
	}

	/** setter vehiculeGroup
	 * @param vehiculeGroup the vehiculeGroup to set
	 */
	public void setVehiculeGroup(List<VehiculeGroup> vehiculeGroup) {
		this.vehiculeGroup = vehiculeGroup;
	}
	
	
	
}
