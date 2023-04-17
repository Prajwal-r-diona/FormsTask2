

	import java.io.File;
	import java.util.ArrayList;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;

	import org.w3c.dom.Attr;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;

	public class CreateTestDemo2 {
		public static ArrayList<String> privacyWCtextOptions = new ArrayList<String>();
		public static ArrayList<String> suddenInjuryOptions = new ArrayList<String>();
		public static void main(String argv[]) {

			
			privacyWCtextOptions.add("yes");
			privacyWCtextOptions.add("no");
			int temp0max = 2; //No. of choices
			
			ArrayList<String> categoryOfIllnessOptions = new ArrayList<String>();
			categoryOfIllnessOptions.add("physical");
			categoryOfIllnessOptions.add("mentalHealth");
			categoryOfIllnessOptions.add("illness");
			categoryOfIllnessOptions.add("nihl");
			int temp1max = 4; //No. of choices
			
			ArrayList<String> accidentIllnessCatOptions =  new ArrayList<String>();
			accidentIllnessCatOptions.add("yes");
			accidentIllnessCatOptions.add("no");
			int temp2max = 2; //No. of choices
			
			
			suddenInjuryOptions.add("amputation");
			suddenInjuryOptions.add("bruise");
			suddenInjuryOptions.add("burn");
			suddenInjuryOptions.add("cut");
			suddenInjuryOptions.add("discHerniation");
			suddenInjuryOptions.add("electricShock");
			suddenInjuryOptions.add("faint");
			suddenInjuryOptions.add("objectInEye");
			suddenInjuryOptions.add("fracture");
			suddenInjuryOptions.add("suddenHernia");
			suddenInjuryOptions.add("suddenPlanter");
			suddenInjuryOptions.add("suddenSeizure");
			suddenInjuryOptions.add("suddenSprain");
			suddenInjuryOptions.add("suddenOther");
			int temp3max = 14; //No. of choices
			
		      try {
		      int temp0 = 0;
		      int temp1 = 0;
		      int temp2 = 0;
		      int temp3 = 0;
		      
		      
		   	  for(int i=0; i<19; i++) {
		   		 
		    
		         DocumentBuilderFactory dbFactory =
		         DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.newDocument();
		         
		         // root element
		         Element rootElement = doc.createElement("WIP_WSIB_Illness_or_Injury");
		         doc.appendChild(rootElement);
		         
		         Element recordScreenViewEvents = doc.createElement("recordScreenViewEvents");
		         recordScreenViewEvents.appendChild(doc.createTextNode("1"));
		         rootElement.appendChild(recordScreenViewEvents);
		         
		         //Introduction Group
		         Element introductionGroup = doc.createElement("introductionGroup");
		         // introductionNote element
		         Element introductionNote = doc.createElement("introductionNote");
		         introductionGroup.appendChild(introductionNote);
		         Element privacyWC = doc.createElement("privacyWC");
		         privacyWC.appendChild(doc.createTextNode(privacyWCtextOptions.get(temp0)));
		         introductionGroup.appendChild(privacyWC);
		         rootElement.appendChild(introductionGroup);

		         //if privacyWCtextOption == yes
		         if(privacyWCtextOptions.get(temp0).equals(privacyWCtextOptions.get(0))) {
		        	 
		        	 //for(int temp1=0; temp1<categoryOfIllnessOptions.size(); temp1++) {
		        		 	//Category Group
		        		 	Element categoryGroup = doc.createElement("categoryGroup");
		         
		        		 	Element requiredField1 = doc.createElement("requiredField1");
		        		 	categoryGroup.appendChild(requiredField1);
		        		 	Element categoryOfIllness = doc.createElement("categoryOfIllness");
		        		 	categoryOfIllness.appendChild(doc.createTextNode(categoryOfIllnessOptions.get(temp1)));
		        		 	categoryGroup.appendChild(categoryOfIllness);
		        		 	Element nihlNote = doc.createElement("nihlNote");
		        		 	categoryGroup.appendChild(nihlNote);
		        		 	rootElement.appendChild(categoryGroup);
		        		 	
		        		if(categoryOfIllnessOptions.get(temp1).equals(categoryOfIllnessOptions.get(0))) { 
		        			//physical Injury group
		        			Element physicalInjuryGroup = doc.createElement("physicalInjuryGroup");
		        			Element physicalNote = doc.createElement("physicalNote");
		        			physicalInjuryGroup.appendChild(physicalNote);
		        			Element requiredField2 = doc.createElement("requiredField2");
		        			physicalInjuryGroup.appendChild(requiredField2);
		        			
		        			//for(int temp2=0; temp2<accidentIllnessCatOptions.size(); temp2++) {
		        			Element accidentIllnessCat = doc.createElement("accidentIllnessCat");
		        			accidentIllnessCat.appendChild(doc.createTextNode(accidentIllnessCatOptions.get(temp2)));
		        			physicalInjuryGroup.appendChild(accidentIllnessCat);
		        			//}
		        			rootElement.appendChild(physicalInjuryGroup);
		        			
		        			if(accidentIllnessCatOptions.get(temp2).equals(accidentIllnessCatOptions.get(0))) {
		        				//Sudden Injury group
			        			Element suddenInjuryGroup = doc.createElement("suddenInjuryGroup");
			        			Element requiredField3 = doc.createElement("requiredField3");
			        			suddenInjuryGroup.appendChild(requiredField3);
			        			Element natureOfAccident = doc.createElement("natureOfAccident");
			        			natureOfAccident.appendChild(doc.createTextNode(suddenInjuryOptions.get(temp3)));
			        			suddenInjuryGroup.appendChild(natureOfAccident);
			        			
			        			
			        			
			        			String calculateOption = new String();
			        			for(int j=0; j<suddenInjuryOptions.size(); j++) {
			        			  Element suddenInjuryOptionElement = doc.createElement(suddenInjuryOptions.get(j));
			        			  
			        				if(suddenInjuryOptions.get(temp3).equals(suddenInjuryOptions.get(j))) {
			        					calculateOption = "1"; // * Note: Set it from constant file later on
			        				}
			        				else {
			        					calculateOption = "0";
			        				}
			        				suddenInjuryOptionElement.appendChild(doc.createTextNode(calculateOption));
			        				suddenInjuryGroup.appendChild(suddenInjuryOptionElement);
			        			}
			        			rootElement.appendChild(suddenInjuryGroup);
			        			//createElementbasedOnSuddenInjuryOption(doc, suddenInjuryOptions.get(temp3), temp3);
			        			
			        			
			        			
		        			}
		        		}
		        	 }
		         
		         //Logic to increment counters and reset when reaches max
		         if(temp3 != temp3max) {
		        	 temp3++;
		         }
		         
		         if(temp3 == temp3max && temp2 != temp2max) {
		        	 temp2++;
		         }
		         if(temp2 == temp2max && temp1 != temp1max ) {
		        	 temp1++;
		         }
		         if(temp1 == temp1max && temp0!= temp0max) {
		        	 temp0++;
		         }
		         

		         // write the content into xml file
		         TransformerFactory transformerFactory = TransformerFactory.newInstance();
		         Transformer transformer = transformerFactory.newTransformer();
		         DOMSource source = new DOMSource(doc);
		         StreamResult result = new StreamResult(new File("/Users/prajwal/DISK B/Eclipse Workspace/FormsTask/ParseFormData/src/demofile" +i+ ".xml"));
		         transformer.transform(source, result);
		         
		         // Output to console for testing
		         StreamResult consoleResult = new StreamResult(System.out);
		         System.out.println();
		         System.out.println("_____");
		         transformer.transform(source, consoleResult);
		         
		         
		   	  	}
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }

		private static void createElementbasedOnSuddenInjuryOption(Document doc, String suddenInjuryOption, int temp3) {
			String calculateOption = new String();
			for(int i=0; i<suddenInjuryOptions.size(); i++) {
			  Element suddenInjuryOptionElement = doc.createElement(suddenInjuryOptions.get(i));
			  
				if(suddenInjuryOption.equals(suddenInjuryOptions.get(i))) {
					calculateOption = "1"; // * Note: Set it from constant file later on
				}
				else {
					calculateOption = "0";
				}
				suddenInjuryOptionElement.appendChild(doc.createTextNode(calculateOption));
				
			}
			
			
			
			
			
		}

		      // introductionNote element
		        
		         
		         
		        
		         /*
		         Attr attr = doc.createAttribute("company");
		         attr.setValue("Ferrari");
		         supercar.setAttributeNode(attr);
				
		         
		         // carname element
		         Element carname = doc.createElement("carname");
		         Attr attrType = doc.createAttribute("type");
		         attrType.setValue("formula one");
		         carname.setAttributeNode(attrType);
		         carname.appendChild(doc.createTextNode("Ferrari 101"));
		         introductionNote.appendChild(carname);

		         Element carname1 = doc.createElement("carname");
		         Attr attrType1 = doc.createAttribute("type");
		         attrType1.setValue("sports");
		         carname1.setAttributeNode(attrType1);
		         carname1.appendChild(doc.createTextNode("Ferrari 202"));
		         supercar.appendChild(carname1);
	*/
	}
		

