package lt.internship.currencyConverter.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class GetFxRatesList {
        RestTemplate restTemplate=new RestTemplate();

        FxRates result = restTemplate.getForObject("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU", FxRates.class);
//        String string= restTemplate.getForObject("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU", String.class);


}