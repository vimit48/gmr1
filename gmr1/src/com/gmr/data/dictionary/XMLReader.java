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

public class XMLReader {

 List<List<String>> dataList = new ArrayList<List<String>>();
	
 public List<List<String>> readXML() {
	 
	  try {
		  File file = new File("mydata.xml");
		  
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(file);
		  doc.getDocumentElement().normalize();
		  
		  // Getting Header
		  System.out.println("Root element " + doc.getDocumentElement().getNodeName());
		  NodeList headerLst = doc.getElementsByTagName("header");
		  getNodeData(headerLst);
		  
		  NodeList dataLst = doc.getElementsByTagName("data");
		  getNodeData(dataLst);
		  
	   } catch (Exception e) {
		    e.printStackTrace();
	  }
	  return dataList;
 }

  public void getNodeData(NodeList nodeLst) {

	  for (int s = 0; s < nodeLst.getLength(); s++) {
			
		  List<String> nodeData = new ArrayList<String>();
		  
		    Node fstNode = nodeLst.item(s);
		    
		    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
		  
		      Element fstElmnt = (Element) fstNode;
		      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("bucket");
		      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		      NodeList fstNm = fstNmElmnt.getChildNodes();
		      System.out.println("First Name : "  + ((Node) fstNm.item(0)).getNodeValue());
		      nodeData.add(((Node) fstNm.item(0)).getNodeValue());
		      
		      NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("attribute");
		      Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
		      NodeList lstNm = lstNmElmnt.getChildNodes();
		      System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());
		      nodeData.add(((Node) lstNm.item(0)).getNodeValue());
		      
		      NodeList columnLst = fstElmnt.getElementsByTagName("column");
		      Element columnElmnt = (Element) columnLst.item(0);
		      NodeList columnNm = columnElmnt.getChildNodes();
		      System.out.println("columnLst : " + ((Node) columnNm.item(0)).getNodeValue());
		      nodeData.add(((Node) columnNm.item(0)).getNodeValue());
		      
		      NodeList platformLst = fstElmnt.getElementsByTagName("platformsource");
		      Element platformElmnt = (Element) platformLst.item(0);
		      NodeList platformNm = platformElmnt.getChildNodes();
		      System.out.println("platformLst : " + ((Node) platformNm.item(0)).getNodeValue());
		      nodeData.add(((Node) platformNm.item(0)).getNodeValue());
		      
		      NodeList dataEleLst = fstElmnt.getElementsByTagName("dataElement");
		      Element dataEleElmnt = (Element) dataEleLst.item(0);
		      NodeList dataEleNm = dataEleElmnt.getChildNodes();
		      System.out.println("dataEleLst : " + ((Node) dataEleNm.item(0)).getNodeValue());
		      nodeData.add(((Node) dataEleNm.item(0)).getNodeValue());
		      
		      NodeList dataTypeLst = fstElmnt.getElementsByTagName("datatype");
		      Element dataTypeElmnt = (Element) dataTypeLst.item(0);
		      NodeList dataTypeNm = dataTypeElmnt.getChildNodes();
		      System.out.println("dataTypeLst : " + ((Node) dataTypeNm.item(0)).getNodeValue());
		      nodeData.add(((Node) dataTypeNm.item(0)).getNodeValue());
		      
		      NodeList nullDefiLst = fstElmnt.getElementsByTagName("nulldefi");
		      Element nullDefiElmnt = (Element) nullDefiLst.item(0);
		      NodeList nullDefiNm = nullDefiElmnt.getChildNodes();
		      System.out.println("nullDefiNm : " + ((Node) nullDefiNm.item(0)).getNodeValue());
		      nodeData.add(((Node) nullDefiNm.item(0)).getNodeValue());

		      NodeList busiDefiLst = fstElmnt.getElementsByTagName("businessDesc");
		      Element busiDefiElmnt = (Element) busiDefiLst.item(0);
		      NodeList busiDefiNm = busiDefiElmnt.getChildNodes();
		      System.out.println("busiDefiNm : " + ((Node) busiDefiNm.item(0)).getNodeValue());
		      nodeData.add(((Node) busiDefiNm.item(0)).getNodeValue());
		    }
		    dataList.add(nodeData);
	  }// for
  }

}