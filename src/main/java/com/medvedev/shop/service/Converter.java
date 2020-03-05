package com.medvedev.shop.service;

import com.medvedev.shop.model.Product;
import com.medvedev.shop.model.Purchase;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class Converter extends AbstractHttpMessageConverter<Purchase> {
    private final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    public Converter() {
        super(MediaType.APPLICATION_XML);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.equals(Purchase.class);
    }

    @Override
    protected Purchase readInternal(Class<? extends Purchase> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Product.class,Purchase.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Schema schema = schemaFactory.newSchema(new StreamSource(Converter.class.getResourceAsStream("/schema.xsd")));
            jaxbUnmarshaller.setSchema(schema);
            return (Purchase) jaxbUnmarshaller.unmarshal(httpInputMessage.getBody());
        } catch (Exception e) {
            throw new HttpMessageNotReadableException(e.getMessage(),e ,  httpInputMessage);
        }
    }

    @Override
    protected void writeInternal(Purchase purchase, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

    }


}
