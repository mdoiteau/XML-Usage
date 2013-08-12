package the.md.project.JAXBExample.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Un véhicule est caractérisé par sa marque, sa cylindrée et son nom commercial
 * @author mdoiteau
 *
 */
public class Vehicule {

	/** Marque du véhicule */
	private String marque;
	/** Cylindrée du moteur du véhicule */
	private String cylindree;
	/** Modèle ou nom commercial du véhicule */
	private String modele;
	
	/**
	 * getter marque
	 * @return the marque
	 */
	@XmlAttribute
	public String getMarque() {
		return marque;
	}
	/** setter marque
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}
	/** getter cylindree
	 * @return the cylindree
	 */
	@XmlAttribute
	public String getCylindree() {
		return cylindree;
	}
	/** setter cylindree
	 * @param cylindree the cylindree to set
	 */
	public void setCylindree(String cylindree) {
		this.cylindree = cylindree;
	}
	/** getter modele
	 * @return the modele
	 */
	@XmlValue
	public String getModele() {
		return modele;
	}
	/** setter modele
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}
	
}
