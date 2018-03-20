package gov.noaa;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBXMLToJava {

    public static void main(String[] args) {

            try {

                // create JAXB context and initializing Marshaller
                JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                ClassLoader classLoader = ClassLoader.getSystemClassLoader();

                // specify the location and name of xml file to be read
                File XMLfile = new File(classLoader.getResource("response.xml").getFile());;


                // this will create Java object - DwmlType from the XML file
                DwmlType dwmlType = (DwmlType) jaxbUnmarshaller.unmarshal(XMLfile);

                System.out.println("Latitude Longitude: " + dwmlType.getLatLonList());

            } catch (JAXBException e) {
                // some exception occured
                e.printStackTrace();
            }

        }
}
