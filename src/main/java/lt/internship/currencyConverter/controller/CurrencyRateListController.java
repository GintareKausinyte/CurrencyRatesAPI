package lt.internship.currencyConverter.controller;

import lt.internship.currencyConverter.entities.FxRateDto;
import lt.internship.currencyConverter.entities.FxRatesDto;
import lt.internship.currencyConverter.integration.services.FxRatesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/list")
public class CurrencyRateListController {
    private FxRatesService fxRatesService;

    public CurrencyRateListController(FxRatesService fxRatesService) {
        this.fxRatesService = fxRatesService;
    }
    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public List<FxRatesDto> getRates() {
        return fxRatesService.getRates();
    }
    @RequestMapping(produces = "application/json", method = RequestMethod.GET, value = "/rate")
    private List<FxRateDto> getListFxRate(){
        return fxRatesService.getFxRateList();
    }
}

