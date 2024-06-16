package org.mathison.jaxbproject;


import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;
import org.mathison.jaxb.beans.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

  @Test
  void test() throws JAXBException {
    ApplicationContext cxt = new GenericXmlApplicationContext("jaxb.xml");
    Contact contact = cxt.getBean("contact", Contact.class);
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Contact.class);

    //create xml from an instance from Contact
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    m.marshal(contact, writer);
    String xml = writer.getBuffer().toString();
    System.out.println(xml);

    //Take xml to Contact
    StringReader reader = new StringReader(xml);
    Unmarshaller u = context.createUnmarshaller();
    Contact fromXml = (Contact) u.unmarshal(reader);

    assertEquals(contact, fromXml);
  }
}
