package lt.internship.currencyConverter.controller;

import lt.internship.currencyConverter.integration.GetFxRatesList;
import lt.internship.currencyConverter.integration.xmlEntities.FxRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/list")
public class CurrencyListController {
    public CurrencyListController(GetFxRatesList getFxRatesList) {
        this.getFxRatesList = getFxRatesList;
    }

    GetFxRatesList getFxRatesList;
    @GetMapping
    public FxRates get() {
        return getFxRatesList.getRatesfromUrl();
    }
}

