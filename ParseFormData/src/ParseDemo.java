import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseDemo {
/* Get the document builder
 * Get Document
 * Normalize the xml structure
 * Get all te xml structure
 */
	public static void main(String[] args) {
	
		//Get the Document builder
		DocumentBuilderFactory dcfactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dcbuilder = dcfactory.newDocumentBuilder();
			//Get Document
			
			Document doc = dcbuilder.parse(new File("/Users/prajwal/DISK B/Eclipse Workspace/FormsTask/ParseFormData/src/InjuryXMLFormData.xml"));
			
			//Normalizing the xml structure
			
			doc.getDocumentElement().normalize();
			
			//Get all the elements by the tag name
			
			 NodeList list = doc.getElementsByTagName("suddenInjuryGroup");
			 
			 for(int i=0; i<list.getLength(); i++ ) {
				 Node sig = list.item(i);
				 
				 if(sig.getNodeType() == Node.ELEMENT_NODE) {
					 
					 Element sigElement = (Element) sig;
					 System.out.println("--------------");
					  NodeList sigChildNodeList = sigElement.getChildNodes();
					  for(int temp=0; temp<sigChildNodeList.getLength(); temp++) {
						 Node sigChildNode = sigChildNodeList.item(temp);
						 if(sigChildNode.getNodeType() == Node.ELEMENT_NODE) {
							 Element sigChildElement = (Element) sigChildNode;
							 System.out.println("Child element "+ temp + " " + sigChildElement.getNodeName()+" : " +sigChildElement.getTextContent());
						 }
					  }
						 
					 
					 System.out.println();
					 System.out.println("requiredField3 : " +sigElement.getAttribute("requiredField3"));
					 System.out.println("natureOfAccident : " +sigElement.getElementsByTagName("natureOfAccident").item(0).getTextContent());
					 
					 
					 /*
					 NodeList sigcnList = sigElement.getChildNodes();
					 for(int j=0; j<sigcnList.getLength(); j++) {
						 Node sigcndetail = sigcnList.item(j);
						 if(sigcndetail.getNodeType() == Node.ELEMENT_NODE) {
							 
							 Element sigcndetailElement = (Element) sigcndetail;
						 System.out.println(sigcndetailElement.getTagName()+"  "+ sigcndetailElement.getNodeValue());
						  NodeList natureOfAccident = sigcndetailElement.getElementsByTagName("natureOfAccident");
						  for(int k=0; k<sigcnList.getLength(); k++) {
								 Node natureOfAccidentDetail = natureOfAccident.item(k);
								 System.out.println(natureOfAccidentDetail);
						  }
						 }
					 }
					 */
				 }
			 }
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
