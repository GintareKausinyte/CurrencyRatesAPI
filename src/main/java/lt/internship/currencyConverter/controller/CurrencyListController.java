package lt.internship.currencyConverter.controller;

import lt.internship.currencyConverter.integration.FxRates;
import lt.internship.currencyConverter.integration.GetFxRatesList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class CurrencyListController {
    private GetFxRatesList getCurrencyRateList;

    public CurrencyListController(GetFxRatesList getCurrencyRateList) {
        this.getCurrencyRateList = getCurrencyRateList;
    }

//    @GetMapping
//    public FxRates getAll(){
//    }
}

