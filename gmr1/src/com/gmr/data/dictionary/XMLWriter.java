package com.gmr.data.dictionary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLWriter {

 List<List<String>> dataList = new ArrayList<List<String>>();
	
 public void writeXML(String bucket, String attribute, String column, String platform, String dataEle, 
																String dataType, String nullDefi, String busiDefi) {
	 
	  try {
		  File file = new File("mydata.xml");
		  
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(file);
		  doc.getDocumentElement().normalize();

		  
		// Get the root element
		 Node root = doc.getFirstChild();
		  
			 writeXMLData(root, doc, bucket, attribute, column, platform, dataEle, dataType, nullDefi, busiDefi);
			 
			// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult("mydata.xml");
				transformer.transform(source, result);
		 
				System.out.println("Done");
	
		
		  } catch (TransformerException tfe) {
				tfe.printStackTrace();
		   } catch (Exception e) {
		    e.printStackTrace();
		  }
	 
 }
  
  public void writeXMLData(Node node,  Document doc, String bucket, String attribute, String column, String platform, String dataEle, 
		  																						String dataType, String nullDefi, String busiDefi){
	  
	  Element data = doc.createElement("data");
	  Element e = null;
	  	
      // create the root element
      e = doc.createElement("bucket");
      e.appendChild(doc.createTextNode(bucket));
      data.appendChild(e);
      
      e = doc.createElement("attribute");
      e.appendChild(doc.createTextNode(attribute));
      data.appendChild(e);
      
      e = doc.createElement("column");
      e.appendChild(doc.createTextNode(column));
      data.appendChild(e);
      
      e = doc.createElement("platformsource");
      e.appendChild(doc.createTextNode(platform));
      data.appendChild(e);
      
      e = doc.createElement("dataElement");
      e.appendChild(doc.createTextNode(dataEle));
      data.appendChild(e);

      e = doc.createElement("datatype");
      e.appendChild(doc.createTextNode(dataType));
      data.appendChild(e);
      
      e = doc.createElement("nulldefi");
      e.appendChild(doc.createTextNode(nullDefi));
      data.appendChild(e);
      
      e = doc.createElement("businessDesc");
      e.appendChild(doc.createTextNode(busiDefi));
      data.appendChild(e);
      
      node.appendChild(data);
  }

}