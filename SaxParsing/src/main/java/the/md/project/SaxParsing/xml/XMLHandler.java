package the.md.project.SaxParsing.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import the.md.project.SaxParsing.bean.Garage;
import the.md.project.SaxParsing.bean.Vehicule;
import the.md.project.SaxParsing.bean.VehiculeGroup;
import the.md.project.SaxParsing.util.XMLConstant;
import the.md.project.SaxParsing.util.XMLElement;

/**
 * @author mdoiteau
 * Handler permettant de lire un fichier XML représentant un
 *         garage
 */
public class XMLHandler extends DefaultHandler {

	/** Le parent utilisant ce handler */
	private IGarageParser parent;

	/** Le garage résultant du parsing xml */
	private Garage garage;
	
	/** Le groupe de véhicule */
	private VehiculeGroup group;

	/** Le véhicule */
	private Vehicule vehicule;
	
	/** Buffer contenant le contenu d'une balise **/
	private StringBuilder buffer;
	
	public XMLHandler(IGarageParser parent) {
		this.parent = parent;
	}

	/**
	 * {@inheritDoc}
	 */
	public void startDocument() throws SAXException {
		garage = new Garage();
	}

	/**
	 * {@inheritDoc}
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) {

		XMLElement curElement = XMLElement.getXmlElementParNom(qName);

		if (curElement != null) {

			switch (curElement) {
			case GARAGE: //do nothing
				break;

			case GROUP:
				group = new VehiculeGroup();
				group.setType(attributes.getValue(XMLConstant.GROUP_ATTR_TYPE));
				break;

			case VEHICULE:
				vehicule = new Vehicule();
				buffer = new StringBuilder();
				String cylindree = attributes.getValue(XMLConstant.VEHICULE_ATTR_CYLINDREE);
				vehicule.setCylindree(Long.valueOf(cylindree));
				vehicule.setMarque(attributes.getValue(XMLConstant.VEHICULE_ATTR_MARQUE));
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		XMLElement curElement = XMLElement.getXmlElementParNom(qName);

		if (curElement != null) {

			switch (curElement) {
			case GARAGE: // do nothing
				break;

			case GROUP:
				garage.getVehiculeGroup().add(group);
				group = null;
				break;

			case VEHICULE:
				vehicule.setModele(buffer.toString());
				group.getVehicules().add(vehicule);
				buffer = null;
				vehicule = null;
				break;
			}
		}
	}


	/**
	 * {@inheritDoc}
	 */
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String lecture = new String(ch, start, length);
		if (buffer != null) {
			buffer.append(lecture);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void endDocument() throws SAXException {
		parent.setGarage(garage);
	}

}
