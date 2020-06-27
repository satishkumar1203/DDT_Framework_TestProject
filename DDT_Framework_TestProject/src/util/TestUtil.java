/*Utility class (TestUtil.java) stores and handles the functions (The code which is repetitive in nature such as waits, actions,
capturing screenshots, accessing excels, sending email etc.,) which can be commonly used across the entire framework. 
The reason behind creating utility class is to achieve reusability. 
This class extends the TestBase class to inherit the properties of TestBase in TestUtil.*/

package util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.wellsfargo.tests.TestBase;

public class TestUtil extends TestBase {
	File fXmlFile;
	DocumentBuilderFactory dbFactory;
	DocumentBuilder dBuilder;
	Document doc;
	Node nNode;
	protected Element eElement;
	
	public TestUtil() {
		try {
			fXmlFile = new File(prop.getProperty("testInputData"));
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("user");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					eElement = (Element) nNode;
					System.out.println("User : " + eElement.getAttribute("name"));
					System.out
							.println("Company : " + eElement.getElementsByTagName("company").item(0).getTextContent());
					System.out.println(
							"User Name : " + eElement.getElementsByTagName("userName").item(0).getTextContent());
					System.out.println(
							"Password : " + eElement.getElementsByTagName("password").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
