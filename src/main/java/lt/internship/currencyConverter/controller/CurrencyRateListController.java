package lt.internship.currencyConverter.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

@RestController
@RequestMapping("/list")
public class CurrencyRateListController {
    LBclient lBclient;

    public CurrencyRateListController(LBclient lBclient) {
        this.lBclient = lBclient;
    }

    @RequestMapping(method= RequestMethod.GET,
            produces="application/json")
    public GetCurrentFxRatesResponse getFxRatesResponse(){
        return lBclient.getCurrentFxRates();
    }
//    @GetMapping("/rates")
//    public GetFxRatesResponse.GetFxRatesResult fxRatesResponse(){
//        return lBclient.getFxRates().getGetFxRatesResult();
//    }

}

