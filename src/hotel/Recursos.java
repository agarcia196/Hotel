/**
 * clasesBodega: Recursos.
 *
 * @author Alexis García Ramirez 
 * @author Jorge Luis Soriano Cuevas
 * @version 4.3.2018
 * 
 */
package hotel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * The Class Recursos.
 */
public class Recursos {

	/**
	 * Escribir Archivo empresa.
	 *
	 * @param archivo El archivo
	 * @param h El Hotel
	 */
	public static void WriteFileObjectEmpresa(String archivo, Hotel h) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			try {
				oos.writeObject(h);
			} catch (IOException e) {
				System.out.println("Problema al crear las clases");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la direcion para crear el fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problemas para crearse");
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (oos != null) {
					oos.close();
				}

			} catch (IOException e) {
				System.out.println("No se pudo cerrar el archivo");
			}
		}
	}

	/**
	 * Leer archivo de objeto empresa.
	 *
	 * @param archivo El archivo
	 * @return La empresa
	 */
	public static Hotel ReadFileObjectEmpresa(String archivo) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Hotel hotel = new Hotel();
		try {
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				Hotel hot = (Hotel) ois.readObject();
				hotel= hot;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la ruta para leer el fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problemas para ser leido");
		} catch (ClassNotFoundException e) {
			System.out.println("Problema al leer fichero");
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				System.out.println("El fichero tiene problemas al leerlo");
			}
		}
		if (hotel==null) {
			return null;
		} else {
			return hotel;
		}
	}
	
	 public static boolean isNumeric(String str) {
	        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
	    }
}
