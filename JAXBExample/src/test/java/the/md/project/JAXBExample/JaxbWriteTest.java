package the.md.project.JAXBExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import the.md.project.JAXBExample.bean.Garage;
import the.md.project.JAXBExample.bean.Vehicule;
import the.md.project.JAXBExample.bean.VehiculeGroup;

/**
 * Class de test pour tester l'écriture de document XML à partir de classes Java
 * Les tags JAXB se trouve dans les bean
 * @author mdoiteau
 *
 */
public class JaxbWriteTest {

	
	@Test
    public void unmarshallingTest() throws Exception { 
       
		Garage garage = new Garage();
		
		VehiculeGroup motos = new VehiculeGroup();
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
		garage.getVehiculeGroup().add(autos);
		
		Vehicule auto1 = new Vehicule();
		auto1.setCylindree(3000L);
		auto1.setMarque("BMW");
		auto1.setModele("130i");
		autos.getVehicules().add(auto1);
		
		JAXB.marshal(garage, new File("./src/main/resources/DescDown.xml"));
		
    }
	
}
