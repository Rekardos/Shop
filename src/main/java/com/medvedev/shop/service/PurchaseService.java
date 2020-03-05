package com.medvedev.shop.service;

import com.medvedev.shop.model.Purchase;
import com.medvedev.shop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElseThrow();
    }

    public List<Purchase> findAll() {
        return (List<Purchase>) purchaseRepository.findAll();
    }

    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }

    public void save(Purchase purchase)  {
        purchase.setPurchaseDate(LocalDateTime.now());
        purchaseRepository.save(purchase);
    }
}
