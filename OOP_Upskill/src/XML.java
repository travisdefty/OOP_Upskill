import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class XML {

	static Document doc = null;
	static String fileName = "WorkerDatabase.xml";

	public static Document loadXML(String fileName) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		return doc;
	}

	public static void viewXML() throws ParserConfigurationException, SAXException, IOException {
		Document doc = loadXML(fileName);
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("operator");
		System.out.println("----------------------------");


		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Operator : " 
						+ eElement.getAttribute("number"));
				System.out.println("First Name : " 
						+ eElement
						.getElementsByTagName("firstname")
						.item(0)
						.getTextContent());
				System.out.println("Last Name : " 
						+ eElement
						.getElementsByTagName("lastname")
						.item(0)
						.getTextContent());
				System.out.println("Skill : " 
						+ eElement
						.getElementsByTagName("skill")
						.item(0)
						.getTextContent());
				System.out.println("Availability : " 
						+ eElement
						.getElementsByTagName("availability")
						.item(0)
						.getTextContent());
			}
		}
	}

	public static void main(String[] args) {


	}
}
