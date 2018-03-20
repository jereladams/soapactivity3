package gov.noaa;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class NdfdXMLBindingStubTest {

    @Test
    void latLonListZipCode() throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        // specify the location and name of xml file to be read
        File XMLfile = new File(classLoader.getResource("response.xml").getFile());

        // this will create Java object - DwmlType from the XML file
        DwmlType dwmlType = (DwmlType) jaxbUnmarshaller.unmarshal(XMLfile);

        assertEquals("44.9617,-89.6445",dwmlType.getLatLonList());

    }
}