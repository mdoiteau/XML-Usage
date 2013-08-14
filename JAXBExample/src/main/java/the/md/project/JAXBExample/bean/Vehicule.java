package the.md.project.JAXBExample.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Un véhicule est caractérisé par sa marque, sa cylindrée et son nom commercial
 * @author mdoiteau
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicule {

	/** Marque du véhicule */
	@XmlAttribute
	private String marque;
	/** Cylindrée du moteur du véhicule */
	@XmlAttribute
	private Long cylindree;
	/** Modèle ou nom commercial du véhicule */
	@XmlValue
	private String modele;
	
	/**
	 * getter marque
	 * @return the marque
	 */
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
	public Long getCylindree() {
		return cylindree;
	}
	/** setter cylindree
	 * @param cylindree the cylindree to set
	 */
	public void setCylindree(Long cylindree) {
		this.cylindree = cylindree;
	}
	
	/** getter modele
	 * @return the modele
	 */
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
