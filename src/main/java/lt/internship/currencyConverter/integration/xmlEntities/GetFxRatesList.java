package lt.internship.currencyConverter.integration.xmlEntities;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lt.internship.currencyConverter.integration.LBclient;
import lt.internship.currencyConverter.integration.xmlEntities.FxRate;
import lt.internship.currencyConverter.integration.xmlEntities.FxRates;
import lt.lb.webservices.wsdl.GetCurrentFxRatesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class GetFxRatesList {
//
//        RestTemplate restTemplate=new RestTemplate();
////        String rates=restTemplate.getForObject("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU",  String.class);
////    final String url = "https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU";
//    //                ResponseEntity<FxRates> rates = restTemplate.getForEntity("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU",  FxRates.class);
////                return rates.getBody();
//    public GetCurrentFxRatesResponse getRatesfromUrl() throws JAXBException, MalformedURLException {
//        JAXBContext jaxbContext = JAXBContext.newInstance(GetCurrentFxRatesResponse.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        URL url = new URL("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU");
//        GetCurrentFxRatesResponse fxRates = (GetCurrentFxRatesResponse) jaxbUnmarshaller.unmarshal(url);
//        return fxRates;
//    }
//    public LBclient convertToObject(){
//        LBclient lBclient=new LBclient();
//    }
}