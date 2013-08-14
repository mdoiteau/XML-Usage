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
        Assert.assertEquals(motos.getType(), "moto");
        Assert.assertNotNull(motos.getVehicules());
        Assert.assertEquals(motos.getVehicules().size(), 2);
        
        //Test pour le speed triple
        Vehicule speed = motos.getVehicules().get(0);
        Assert.assertNotNull(speed);
        Assert.assertEquals(speed.getMarque(), "Triumph");
        Assert.assertTrue(speed.getCylindree()==1050L);
        Assert.assertEquals(speed.getModele(), "Speed Triple");
        
        Vehicule street = motos.getVehicules().get(1);
        Assert.assertNotNull(street);
        Assert.assertEquals(street.getMarque(), "Triumph");
        Assert.assertTrue(street.getCylindree()==675L);
        Assert.assertEquals(street.getModele(), "Street Triple");
        
        //Test des autos	
        VehiculeGroup autos = vehiculeGroups.get(1);
        Assert.assertNotNull(autos);
        Assert.assertEquals(autos.getType(), "auto");
        Assert.assertNotNull(autos.getVehicules());
        Assert.assertEquals(autos.getVehicules().size(), 2);
        
        Vehicule elise = autos.getVehicules().get(0);
        Assert.assertNotNull(elise);
        Assert.assertEquals(elise.getMarque(), "Lotus");
        Assert.assertTrue(elise.getCylindree()==1800L);
        Assert.assertEquals(elise.getModele(), "Elise S1 MMC");
        
        Vehicule saxo = autos.getVehicules().get(1);
        Assert.assertNotNull(saxo);
        Assert.assertEquals(saxo.getMarque(), "Citroën");
        Assert.assertTrue(saxo.getCylindree()==1600L);
        Assert.assertEquals(saxo.getModele(), "Saxo VTS 16V");
    }
	
}
