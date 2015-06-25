package tp3SP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ProcesadorTexto {

	private static Scanner scanner;

	public static void main(String[] arg) throws Throwable {

		// Guardamos el tiempo de inicio
		long startTime = System.currentTimeMillis();
		
		File txtBaseIdiomas = null;
		File texto = null;
		String linea;
		FileReader fr = null;
		BufferedReader br = null;

		int caracter;
		String ruta = "";
		Archivo arch = new Archivo();
	
		/**c:\texto.txt
		 * Se carga la base de frecuencia de idiomas a partir de un TXT
		 */

		FrecuenciaIdioma frec = new FrecuenciaIdioma();
		String idiomaActual = "";
		String idiomaAnterior = "";

		txtBaseIdiomas = new File("C:\\base_idiomas.txt");
		fr = new FileReader(txtBaseIdiomas);
		br = new BufferedReader(fr);

		while ((linea = br.readLine()) != null) {
			String listaarray[] = linea.split("\\Q|\\E");
			idiomaActual = listaarray[0].trim();

			if (!(idiomaAnterior.equalsIgnoreCase(idiomaActual))) {
				// Se crea un nuevo mapa cantidadLetras para el nuevo idioma, luego se agrega la letra y su frecuencia
				frec.cantidadLetras = new HashMap<String, BigDecimal>();
				frec.cantidadLetras.put(listaarray[1], new BigDecimal(listaarray[2]));
				frec.listaIdiomas.put(idiomaActual, frec.cantidadLetras);
			} else {
				// Se agrega la letra y su frecuencia
				frec.cantidadLetras.put(listaarray[1], new BigDecimal(listaarray[2]));
			}

			idiomaAnterior = listaarray[0].trim();
		}

		// Se solicita que se ingrese la ruta del TXT que va a ser leido,  en donde se encuentra el archivo de texto a procesar
		System.out.println("Por favor, ingresar la ruta del directorio:");
		Scanner scanner = new Scanner(System.in);
		ruta = scanner.nextLine();
     //   c:/texto.txt
		texto = new File(ruta);
		fr = new FileReader(texto);
		br = new BufferedReader(fr);

		/**
		 * Se lee el TXT caracter por caracter
		 */

		while ((caracter = br.read()) != -1) {
			arch.evaluarCaracter(Character.toLowerCase((char) caracter));
		}

		// Se ejecuta metodo para calcular la frecuencia de letras para el texto leido
		arch.calcularFrecuencia();

		// Se ejecuta metodo para identificar el idioma del txt leido
		frec.compararIdiomas(arch);
		
		// Se obtiene y se imprime por pantalla el tiempo transcurrido
		long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;
        System.out.println("Tiempo de ejecución: " + totalTime + " segundos");

	}

}
