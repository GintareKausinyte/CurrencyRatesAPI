package lt.internship.currencyConverter.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lt.internship.currencyConverter.integration.xmlEntities.CcyAmt;
import lt.internship.currencyConverter.integration.xmlEntities.FxRate;
import lt.internship.currencyConverter.integration.xmlEntities.FxRates;
import lt.internship.currencyConverter.integration.xmlEntities.GetFxRatesList;
import lt.internship.currencyConverter.integration.LBclient;
import lt.lb.webservices.wsdl.GetCurrentFxRatesResponse;
import lt.lb.webservices.wsdl.GetFxRatesResponse;
import lt.lb.webservices.wsdl.ObjectFactory;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLEventReader;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/list")
public class CurrencyRateListController {
    LBclient lBclient;

    public CurrencyRateListController(LBclient lBclient) {
        this.lBclient = lBclient;
    }

    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public Object getFxRatesResponse(Model model){

        return lBclient.getCurrentFxRates().getGetCurrentFxRatesResult().getContent().get(0);

    }
    //Getting data from url, unmarshalling to pojo
    @RequestMapping(method= RequestMethod.GET, value = "/rates",
            produces="application/json")
    public FxRates getFxRates() throws JAXBException, MalformedURLException, URISyntaxException {
        RestTemplate restTemplate=new RestTemplate();
        URI url=new URI("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU");
        String response = restTemplate.getForObject(url, String.class);
        StringReader reader = new StringReader(response);
        JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        FxRates recordes = (FxRates) unmarshaller.unmarshal(new StringReader(response));

///////////////////////////////////////////////////////////////////Getting data from xml file
//        File file = new File("src/main/java/lt/internship/currencyConverter/controller/data.xml");
//        JAXBContext jaxbContext1 = JAXBContext.newInstance(FxRates.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext1.createUnmarshaller();
//        FxRates que= (FxRates) jaxbUnmarshaller.unmarshal(new File(s));
 ///////////////////////////////////////////////////////////////////
        return recordes;
    }



}

