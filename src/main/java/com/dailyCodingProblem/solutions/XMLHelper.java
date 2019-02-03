package com.dailyCodingProblem.solutions;

import org.w3c.dom.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by mshaik on 1/30/19.
 */
public class XMLHelper {

  public static void main(String argv[]) throws XMLStreamException,FileNotFoundException{
    try {
      File fXmlFile = new File("/Users/mshaik/Downloads/Harchive_copy.xml");

      XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(
          fXmlFile));

      while (reader.hasNext()) {
        int Event = reader.next();

        switch (Event) {

          case XMLStreamConstants.START_ELEMENT: {
            System.out.println("Start" + reader.getLocalName());
            if(reader.getLocalName().equalsIgnoreCase("connections"))
            break;
          }

          case XMLStreamConstants.END_ELEMENT: {
            System.out.println("End" + reader.getLocalName());
            break;
          }


          case XMLStreamConstants.CHARACTERS: {
            System.out.println("Texttt"+reader.getText());
            break;
          }

        }

      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
