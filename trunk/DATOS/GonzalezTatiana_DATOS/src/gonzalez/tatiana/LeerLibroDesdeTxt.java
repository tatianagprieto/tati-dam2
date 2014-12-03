package gonzalez.tatiana;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



public class LeerLibroDesdeTxt {

	public static void main(String[] args) throws Exception{
		//Archivo con el que vamos a trabajar
		File ficheroLibros = new File("libros.txt");
		RandomAccessFile rafLibros = new RandomAccessFile(ficheroLibros, "r");
		
		int posicion = 0;
		String titulo, genero;
		
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();

		rafLibros.seek(0);
		String linea = rafLibros.readLine();
		while(linea!=null){
			titulo = linea.split(":",2)[1];
			linea = rafLibros.readLine();
			genero = linea.split(":",2)[1];
			arrayLibros.add(new Libro(titulo, genero));
			linea = rafLibros.readLine();
		}//while
		for (int i=0;i<arrayLibros.size();i++){
			System.out.println(arrayLibros.get(i));
		}//for
		//hemos convertido el txt en un arrayList de libros
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document documento = implementation.createDocument(null, "Libros", null);
		documento.setXmlVersion("1.0");
		
		Element raiz = documento.createElement("libro");
		documento.getDocumentElement().appendChild(raiz);
		
		for (int i=0; i<arrayLibros.size(); i++){
			CrearElemento("titulo", arrayLibros.get(i).getTitulo(), raiz, documento);
			CrearElemento("genero", arrayLibros.get(i).getGenero(), raiz, documento);
		}
		
		
		//Creamos ¡por fin! el xml
		Source source = new DOMSource(documento);
		Result docXml = new StreamResult(new File("libros.xml"));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, docXml);
		rafLibros.close();
		
	}//main

	static void CrearElemento(String datoLibro, String valor, Element raiz, Document documento){
		Element elemento = documento.createElement(datoLibro);
		Text texto = documento.createTextNode(valor);
		raiz.appendChild(elemento);
		elemento.appendChild(texto);
	}
	
}//class
