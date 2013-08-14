package the.md.project.JAXBExample;

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
 * Class de test pour tester le chargement de classe Java à partir de fichier XML
 * Les tags JAXB se trouve dans les bean, au niveau des getters
 * @author mdoiteau
 *
 */
public class JaxbLoadTest {

	/** garage */
	private Garage garage;
	
	@Before
    public void before() throws FileNotFoundException { 
        InputStream xmlStream = new FileInputStream("./src/main/resources/DescUp.xml"); 
        garage = JAXB.unmarshal(xmlStream, Garage.class); 
    } 
	
	@Test
    public void unmarshallingTest() throws Exception { 
       
		//Test du garage
		List<VehiculeGroup> vehiculeGroups = garage.getVehiculeGroup();
        Assert.assertNotNull(vehiculeGroups);
        Assert.assertEquals(vehiculeGroups.size(), 2);
        
        //Test des motos
        VehiculeGroup motos = vehiculeGroups.get(0);
        Assert.assertNotNull(motos);
        Assert.assertEquals("moto", motos.getType());
        Assert.assertNotNull(motos.getVehicules());
        Assert.assertEquals(2, motos.getVehicules().size());
        
        //Test pour le speed triple
        Vehicule speed = motos.getVehicules().get(0);
        Assert.assertNotNull(speed);
        Assert.assertEquals("Triumph", speed.getMarque());
        Assert.assertTrue(speed.getCylindree()==1050L);
        Assert.assertEquals("Speed Triple", speed.getModele());
        
        Vehicule street = motos.getVehicules().get(1);
        Assert.assertNotNull(street);
        Assert.assertEquals("Triumph", street.getMarque());
        Assert.assertTrue(street.getCylindree()==675L);
        Assert.assertEquals("Street Triple", street.getModele());
        
        //Test des autos	
        VehiculeGroup autos = vehiculeGroups.get(1);
        Assert.assertNotNull(autos);
        Assert.assertEquals("auto", autos.getType());
        Assert.assertNotNull(autos.getVehicules());
        Assert.assertEquals(2, autos.getVehicules().size());
        
        Vehicule elise = autos.getVehicules().get(0);
        Assert.assertNotNull(elise);
        Assert.assertEquals("Lotus", elise.getMarque());
        Assert.assertTrue(elise.getCylindree()==1800L);
        Assert.assertEquals("Elise S1 MMC", elise.getModele());
        
        Vehicule saxo = autos.getVehicules().get(1);
        Assert.assertNotNull(saxo);
        Assert.assertEquals("Citroën", saxo.getMarque());
        Assert.assertTrue(saxo.getCylindree()==1600L);
        Assert.assertEquals("Saxo VTS 16V", saxo.getModele());
    }
	
}
