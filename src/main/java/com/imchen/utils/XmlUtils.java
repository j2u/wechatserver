package com.imchen.utils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

/**
 * Created by imch1n on 6/10/17.
 */
public class XmlUtils {

    public static String xmlToString() throws TransformerException {
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
        transformer.setOutputProperty("encoding","UTF-8");
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        transformer.transform(new DOMSource(),new StreamResult(outputStream));
        return outputStream.toString();
    }
}
