package the.md.project.JAXBExample.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Un garage correspond à une liste de différent type de véhicule
 * @author mdoiteau
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Garage {

	/** Les groupes de véhicules du garage */
	@XmlElement(name = "group")
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
