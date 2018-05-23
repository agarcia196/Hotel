/**
 * 
 *
 * @author Alexis García Ramírez 
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
import java.io.Serializable;

import exception.ECamposVacios;
import exception.EIgualdad;
import exception.ELongitud;
/**
 * The Class Recursos.
 */
public class Recursos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1637407092354011236L;

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
			System.out.println("Problemas con la direccion para crear el fichero");
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
	
	 public static boolean validarLongitudPwd(String pwd) throws ELongitud {
		 if(pwd.length()<8)throw new ELongitud();
		 else return true;
	 }
	 public static boolean validarIgualdadPwd(String pwd, String cpwd) throws EIgualdad {
		 if(pwd.compareTo(cpwd)!=0)throw new EIgualdad();
		 else return true;
	 }
	 public static boolean validarCamposVaciosU(String nombre, String apellido, String genero, String correo, String id, String tipoId,
				String pwd, String cpwd, String cargo) throws ECamposVacios {
		 if (nombre.compareTo("")==0 ||apellido.compareTo("")==0 || id.compareTo("")==0 || tipoId.compareTo("")==0 
					|| pwd.compareTo("") == 0 ||cpwd.compareTo("") == 0|| cargo.compareTo("")==0)throw new ECamposVacios();
		 else
			 return true;
	 }
	 
	 public static boolean validarCamposVaciosU(String nombre, String apellido, String genero, String correo, String id,
				String pwd, String cpwd) throws ECamposVacios {
		 if (nombre.compareTo("")==0 ||apellido.compareTo("")==0 || id.compareTo("")==0 
					|| pwd.compareTo("") == 0 ||cpwd.compareTo("") == 0)throw new ECamposVacios();
		 else
			 return true;
	 }
}
