package the.md.project.SaxParsing;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.junit.Test;
import org.xml.sax.SAXException;

import the.md.project.SaxParsing.bean.Garage;
import the.md.project.SaxParsing.bean.Vehicule;
import the.md.project.SaxParsing.bean.VehiculeGroup;
import the.md.project.SaxParsing.xml.SaxParser;

/**
 * Unit test for parseur
 * 
 * @author mdoiteau
 * 
 */
public class ParseTest {

	/** Le path du fichier à parser */
	String fileXmlFullPath = "./src/main/resources/DescUp.xml";

	@Test
	public void testParseur() throws ParserConfigurationException,
			SAXException, IOException {
		SaxParser parser = new SaxParser();
		parser.parseIt(fileXmlFullPath);

		Garage garage = parser.getGarage();

		// Test du garage
		List<VehiculeGroup> vehiculeGroups = garage.getVehiculeGroup();
		Assert.assertNotNull(vehiculeGroups);
		Assert.assertEquals(vehiculeGroups.size(), 2);

		// Test des motos
		VehiculeGroup motos = vehiculeGroups.get(0);
		Assert.assertNotNull(motos);
		Assert.assertEquals("moto", motos.getType());
		Assert.assertNotNull(motos.getVehicules());
		Assert.assertEquals(2, motos.getVehicules().size());

		// Test pour le speed triple
		Vehicule speed = motos.getVehicules().get(0);
		Assert.assertNotNull(speed);
		Assert.assertEquals("Triumph", speed.getMarque());
		Assert.assertTrue(speed.getCylindree() == 1050L);
		Assert.assertEquals("Speed Triple", speed.getModele());

		Vehicule street = motos.getVehicules().get(1);
		Assert.assertNotNull(street);
		Assert.assertEquals("Triumph", street.getMarque());
		Assert.assertTrue(street.getCylindree() == 675L);
		Assert.assertEquals("Street Triple", street.getModele());

		// Test des autos
		VehiculeGroup autos = vehiculeGroups.get(1);
		Assert.assertNotNull(autos);
		Assert.assertEquals("auto", autos.getType());
		Assert.assertNotNull(autos.getVehicules());
		Assert.assertEquals(2, autos.getVehicules().size());

		Vehicule elise = autos.getVehicules().get(0);
		Assert.assertNotNull(elise);
		Assert.assertEquals("Lotus", elise.getMarque());
		Assert.assertTrue(elise.getCylindree() == 1800L);
		Assert.assertEquals("Elise S1 MMC", elise.getModele());

		Vehicule saxo = autos.getVehicules().get(1);
		Assert.assertNotNull(saxo);
		Assert.assertEquals("Citroën", saxo.getMarque());
		Assert.assertTrue(saxo.getCylindree() == 1600L);
		Assert.assertEquals("Saxo VTS 16V", saxo.getModele());

	}

}
