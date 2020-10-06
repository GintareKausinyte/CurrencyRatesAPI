package lt.internship.currencyConverter.integration.services;

import lt.internship.currencyConverter.entities.CcyAmtDto;
import lt.internship.currencyConverter.entities.FxRateDto;
import lt.internship.currencyConverter.entities.FxRatesDto;
import lt.internship.currencyConverter.integration.xmlEntities.FxRates;
import lt.internship.currencyConverter.repositories.CcyAmtRepository;
import lt.internship.currencyConverter.repositories.FxRateRepository;
import lt.internship.currencyConverter.repositories.FxRatesRepsository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FxRatesService {
    FxRatesRepsository ratesRepsository;
    FxRateRepository rateRepository;
    CcyAmtRepository ccyAmtRepository;

    public FxRatesService(FxRatesRepsository ratesRepsository, FxRateRepository rateRepository, CcyAmtRepository ccyAmtRepository) {
        this.ratesRepsository = ratesRepsository;
        this.rateRepository = rateRepository;
        this.ccyAmtRepository = ccyAmtRepository;
    }

    public List<CcyAmtDto> getCcyAmtList() {
        return ccyAmtRepository.findAll();
    }

    public List<FxRateDto> getFxRateList() {
        if (rateRepository.findAll().isEmpty()) {
            saveToDb(fetchRatesFromApi());
        }
        return rateRepository.findAll();
    }

    public List<FxRatesDto> getRates() {
        if (ratesRepsository.findAll().isEmpty()) {
            FxRates fxRatesFromApi = fetchRatesFromApi();
            FxRatesDto dto = saveToDb(fxRatesFromApi);
        }
        return ratesRepsository.findAll();
    }

    private FxRates fetchRatesFromApi() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU");
            String response = restTemplate.getForObject(uri, String.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FxRates recordes = (FxRates) unmarshaller.unmarshal(new StringReader(response));
            return recordes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private FxRatesDto saveToDb(FxRates fxRates) {
        List<FxRateDto> dtos = fxRates.getFxRate().stream()
                .map(fxRate -> {
                    FxRateDto fxRateDto = new FxRateDto();
                    fxRateDto.setDate(fxRate.getDt());
                    fxRateDto.setType(fxRate.getTp());
                    List<CcyAmtDto> ccyAmtDtos = fxRate.getCcyAmt().stream()
                            .map(ccyAmt -> {
                                CcyAmtDto ccyAmtDto = new CcyAmtDto();
                                ccyAmtDto.setAmount(ccyAmt.getAmt());
                                ccyAmtDto.setCurrency(ccyAmt.getCcy());
                                return ccyAmtDto;
                            }).collect(Collectors.toList());
                    fxRateDto.setCurrencyAmountList(ccyAmtDtos);
                    return fxRateDto;
                }).collect(Collectors.toList());
        FxRatesDto fxRatesDto = new FxRatesDto();
        fxRatesDto.setFxRateDtoList(dtos);
        return ratesRepsository.save(fxRatesDto);
    }

}
