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
 * Class de test pour la manipulation d'objets XML via JAXB
 * Les tags JAXB se trouve dans les bean, au niveau des getters
 * @author mdoiteau
 *
 */
public class JaxbManipulationTest {

	/** garage */
	private Garage garage;
	
	@Before
    public void before() throws FileNotFoundException { 
        InputStream xmlStream = new FileInputStream("./src/main/resources/Desc.xml"); 
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
        Assert.assertEquals(speed.getCylindree(), "1050");
        Assert.assertEquals(speed.getModele(), "Speed Triple");
        
        Vehicule street = motos.getVehicules().get(1);
        Assert.assertNotNull(street);
        Assert.assertEquals(street.getMarque(), "Triumph");
        Assert.assertEquals(street.getCylindree(), "675");
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
        Assert.assertEquals(elise.getCylindree(), "1800");
        Assert.assertEquals(elise.getModele(), "Elise S1 MMC");
        
        Vehicule saxo = autos.getVehicules().get(1);
        Assert.assertNotNull(saxo);
        Assert.assertEquals(saxo.getMarque(), "Citroën");
        Assert.assertEquals(saxo.getCylindree(), "1600");
        Assert.assertEquals(saxo.getModele(), "Saxo VTS 16V");
    }
	
}
