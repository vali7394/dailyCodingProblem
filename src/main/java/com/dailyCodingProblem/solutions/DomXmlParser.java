package com.dailyCodingProblem.solutions;

import org.w3c.dom.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class DomXmlParser {

  List<BackPressure> pressureList = new ArrayList<>();

  List<String> list = new ArrayList<>();

  public static void main(String argv[]) {
    try {
      File fXmlFile = new File("/Users/mshaik/Downloads/Harchive_copy.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);
      doc.getDocumentElement().normalize();

      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

      if (doc.getDocumentElement().hasChildNodes()) {
        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        DomXmlParser domXmlParser = new DomXmlParser();
        domXmlParser.printNote(nodeList);
        System.out.println(domXmlParser.pressureList.size());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private  void printNote(NodeList nodeList) {

    for (int count = 0; count < nodeList.getLength(); count++) {

      org.w3c.dom.Node tempNode = nodeList.item(count);

      // make sure it's element node.
      if (tempNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE)
        if( "snippet".equalsIgnoreCase(tempNode
            .getNodeName())) {
          System.out.println("Inside");
          readCollectionNode(tempNode);
        }

    }


  }


  public void readCollectionNode(org.w3c.dom.Node node) {

    BackPressure pressure = new BackPressure();
    NodeList nodeList = node.getChildNodes();
    for(int i=0 ; i<nodeList.getLength() ; i++) {
      getChildNodes(nodeList.item(i),pressure);
    }

  }


  public void getChildNodes(org.w3c.dom.Node childNode, BackPressure pressure) {



    if(childNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){

      if("id".equalsIgnoreCase(childNode.getNodeName())) {
        pressure.setId(childNode.getNodeValue());
      }

      if("backPressureDataSizeThreshold".equalsIgnoreCase(childNode.getNodeName())) {
        pressure.setId(childNode.getNodeValue());
      }

      if("destination".equalsIgnoreCase(childNode.getNodeName())) {
        pressure.setId(getChildNodeId(childNode.getFirstChild()));
      }



    }

    pressureList.add(pressure);

  }

  public String getChildNodeId(org.w3c.dom.Node childNode) {
    if(childNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
      if("id".equalsIgnoreCase(childNode.getNodeName())) {
        return childNode.getNodeValue();
      }
    }
    return "";
  }

}
