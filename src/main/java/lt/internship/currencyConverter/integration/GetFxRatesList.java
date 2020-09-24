package lt.internship.currencyConverter.integration;


import lt.internship.currencyConverter.integration.xmlEntities.FxRate;
import lt.internship.currencyConverter.integration.xmlEntities.FxRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Component
public class GetFxRatesList {

        RestTemplate restTemplate=new RestTemplate();
        String rates=restTemplate.getForObject("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU",  String.class);

        public FxRates getRatesfromUrl(){
                return restTemplate.getForObject("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU",  FxRates.class);
        }


}