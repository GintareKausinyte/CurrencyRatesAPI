package lt.internship.currencyConverter.controller;

import lt.internship.currencyConverter.entities.FxRateDto;
import lt.internship.currencyConverter.integration.services.FxRatesService;
import lt.internship.currencyConverter.integration.xmlEntities.FxRate;
import lt.internship.currencyConverter.integration.xmlEntities.FxRates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class CurrencyRateListController {
    private FxRatesService fxRatesService;

    public CurrencyRateListController(FxRatesService fxRatesService) {
        this.fxRatesService = fxRatesService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rates", produces = "application/json")
    public FxRates getFxRates() throws JAXBException, URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU");
        String response = restTemplate.getForObject(uri, String.class);
        JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        FxRates recordes = (FxRates) unmarshaller.unmarshal(new StringReader(response));
        return recordes;
    }

    @GetMapping("/save")
    public void save() throws JAXBException, URISyntaxException {
        fxRatesService.transformToDto(getFxRates());
    }

}

