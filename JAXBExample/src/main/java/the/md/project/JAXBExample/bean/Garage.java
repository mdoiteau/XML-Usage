package the.md.project.JAXBExample.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Un garage correspond à une liste de différent type de véhicule
 * @author mdoiteau
 *
 */
@XmlRootElement
public class Garage {

	/** Les groupes de véhicules du garage */
	private List<VehiculeGroup> vehiculeGroup = new ArrayList<VehiculeGroup>();

	/**
	 * getter sur le vehiculeGroup
	 * @return the vehiculeGroup
	 */
	@XmlElement(name = "group")
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
