package the.md.project.JAXBExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXB;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import the.md.project.JAXBExample.bean.Garage;
import the.md.project.JAXBExample.bean.Vehicule;
import the.md.project.JAXBExample.bean.VehiculeGroup;

/**
 * Class de test pour tester l'écriture de document XML à partir de classes Java
 * Les tags JAXB se trouve dans les bean
 * 
 * @author mdoiteau
 * 
 */
public class JaxbWriteTest {

	/** Données source du test */
	private Garage garage;

	/** le fichier en écriture */
	private String filePath = "./src/main/resources/DescDown.xml";

	@Before
	public void before() throws FileNotFoundException {
		// Chargement des données
		garage = new Garage();

		VehiculeGroup motos = new VehiculeGroup();
		motos.setType("moto");
		garage.getVehiculeGroup().add(motos);

		Vehicule moto1 = new Vehicule();
		moto1.setCylindree(1700L);
		moto1.setMarque("Yamaha");
		moto1.setModele("MT-01");
		motos.getVehicules().add(moto1);

		Vehicule moto2 = new Vehicule();
		moto2.setCylindree(1000L);
		moto2.setMarque("Yamaha");
		moto2.setModele("FZ1");
		motos.getVehicules().add(moto2);

		VehiculeGroup autos = new VehiculeGroup();
		autos.setType("auto");
		garage.getVehiculeGroup().add(autos);

		Vehicule auto1 = new Vehicule();
		auto1.setCylindree(3000L);
		auto1.setMarque("BMW");
		auto1.setModele("130i");
		autos.getVehicules().add(auto1);
	}

	@Test
	public void unmarshallingTest() throws Exception {

		// Ecriture du fichier XML
		JAXB.marshal(garage, new File(filePath));

		// Lecture ensuite de ce même fichier
		InputStream xmlStream = new FileInputStream(filePath);
		Garage garageToVerify = JAXB.unmarshal(xmlStream, Garage.class);

		// Vérification
		Assert.assertNotNull(garageToVerify);
		Assert.assertNotNull(garageToVerify.getVehiculeGroup());
		Assert.assertEquals(2, garageToVerify.getVehiculeGroup().size());

		// Test des motos
		VehiculeGroup motos = garageToVerify.getVehiculeGroup().get(0);
		Assert.assertNotNull(motos);
		Assert.assertEquals("moto", motos.getType());
		Assert.assertNotNull(motos.getVehicules());
		Assert.assertEquals(2, motos.getVehicules().size());

		Vehicule mt = motos.getVehicules().get(0);
		Assert.assertNotNull(mt);
		Assert.assertEquals("Yamaha", mt.getMarque());
		Assert.assertTrue(mt.getCylindree() == 1700L);
		Assert.assertEquals("MT-01", mt.getModele());

		Vehicule fz1 = motos.getVehicules().get(1);
		Assert.assertNotNull(fz1);
		Assert.assertEquals("Yamaha", fz1.getMarque());
		Assert.assertTrue(fz1.getCylindree() == 1000L);
		Assert.assertEquals("FZ1", fz1.getModele());

		// Test des autos
		VehiculeGroup autos = garageToVerify.getVehiculeGroup().get(1);
		Assert.assertNotNull(autos);
		Assert.assertEquals("auto", autos.getType());
		Assert.assertNotNull(autos.getVehicules());
		Assert.assertEquals(1, autos.getVehicules().size());

		Vehicule bmw = autos.getVehicules().get(0);
		Assert.assertNotNull(bmw);
		Assert.assertEquals("BMW", bmw.getMarque());
		Assert.assertTrue(bmw.getCylindree() == 3000L);
		Assert.assertEquals("130i", bmw.getModele());

	}

}
