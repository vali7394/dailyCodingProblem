package com.dailyCodingProblem.solutions;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Created by mshaik on 1/3/19.
 */
public class XMLReader {

  public static void main(String argv[]) {
    try {
      File fXmlFile = new File("/Users/mshaik/Downloads/2018-12-14mdo_price_export.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);
      doc.getDocumentElement().normalize();

      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
      NodeList nList = doc.getElementsByTagName("clearancePrice");
      System.out.println("----------------------------");

      for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
       // System.out.println("\nCurrent Element :" + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;
          String reasonCode = eElement.getElementsByTagName("reasonCode")
              .item(0).getTextContent();
          if("0".equalsIgnoreCase(reasonCode) || "2".equalsIgnoreCase(reasonCode) ) {
            System.out.println("Lot Number : "
                + eElement.getElementsByTagName("lotNumber").item(0).getTextContent());
          }

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
