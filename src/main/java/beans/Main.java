
package beans;

import es.demo.beans.BeanFuente;
import es.demo.beans.BeanReceptor;
import es.demo.beans.VetoableBeanFuente;
import es.demo.beans.VetoableBeanReceptor;

/**
 *
 * @author mfernandez
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws ClassNotFoundException {		
		testPropertiesVeto();
	//	testPropertiesLigadas();
	}

	private static void testPropertiesLigadas() {
		BeanFuente bf = new BeanFuente();
		BeanReceptor br = new BeanReceptor();

		bf.addPropertyChangeListener(br);
		bf.setValue("new value");

	}

	private static void testPropertiesVeto() {
		VetoableBeanFuente vbf = new VetoableBeanFuente();
		//Creamos dos receptores
		VetoableBeanReceptor vbr = new VetoableBeanReceptor();

		VetoableBeanReceptor vbr2 = new VetoableBeanReceptor();

		//Añadimos los dos receptores al bean fuente
		vbf.addVetoableChangeListener(vbr);
		vbf.addVetoableChangeListener(vbr2);

		//Cambiamos la propiedad en el bean fuente
		vbf.setValue("new value");
		vbf.setValue("ABORT");
		vbf.setValue("second value");

	}

}
