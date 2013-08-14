package the.md.project.SaxParsing.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import the.md.project.SaxParsing.bean.Garage;

/**
 * @author mdoiteau Le parseur SAX permettant de lire un fichier XML
 *         représentant un garage et de le récupérer dans des objets JAVA
 * 
 */
public class SaxParser implements IGarageParser {

	/** le garage résultant du parsing XML */
	private Garage garage;

	/**
	 * Parse le flux xml
	 * 
	 * @param fileXmlFullPath
	 *            le fichier xml à parser
	 * @throws ParserConfigurationException
	 *             exception
	 * @throws SAXException
	 *             exception
	 * @throws IOException
	 *             exception
	 */
	public void parseIt(String fileXmlFullPath) throws ParserConfigurationException,
			SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(fileXmlFullPath),  new XMLHandler(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * the.md.project.SaxParsing.xml.IGarageParser#setGarage(the.md.project.
	 * SaxParsing.bean.Garage)
	 */
	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	/**
	 * Récupère le garage
	 * 
	 * @return the garage
	 */
	public Garage getGarage() {
		return garage;
	}

}
