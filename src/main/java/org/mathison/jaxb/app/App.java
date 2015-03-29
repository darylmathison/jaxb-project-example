package org.mathison.jaxb.app;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.mathison.jaxb.beans.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext cxt = new GenericXmlApplicationContext("jaxb.xml");
        Contact contact = cxt.getBean("contact", Contact.class);
        StringWriter writer = new StringWriter();
        try {
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
            Contact fromXml = (Contact)u.unmarshal(reader);
            
            System.out.println("Are the instances equivalent: " + contact.equals(fromXml));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
