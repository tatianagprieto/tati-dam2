package gonzalez.tatiana;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class XmlToObjectDom {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File docXml = new File("libros.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//DOMImplementation implementation = builder.getDOMImplementation();
		Document documento = builder.parse(docXml);
		documento.getDocumentElement().normalize();
		
		System.out.println("Elemento raíz: " +documento.getDocumentElement().getNodeName());
		
		
		NodeList libros = documento.getElementsByTagName("libro");
		
	}

}
