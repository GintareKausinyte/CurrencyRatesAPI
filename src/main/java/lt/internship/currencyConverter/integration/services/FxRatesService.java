package lt.internship.currencyConverter.integration.services;

import lt.internship.currencyConverter.entities.CcyAmtDto;
import lt.internship.currencyConverter.entities.FxRateDto;
import lt.internship.currencyConverter.entities.FxRatesDto;
import lt.internship.currencyConverter.integration.xmlEntities.CcyAmt;
import lt.internship.currencyConverter.integration.xmlEntities.FxRate;
import lt.internship.currencyConverter.integration.xmlEntities.FxRates;
import lt.internship.currencyConverter.repositories.FxRatesRepsository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FxRatesService {
    FxRatesRepsository ratesRepsository;

    public FxRatesService(FxRatesRepsository ratesRepsository) {
        this.ratesRepsository = ratesRepsository;
    }

//    public FxRates getFxRates() {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            URI uri = new URI("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU");
//            String response = restTemplate.getForObject(uri, String.class);
//            JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            FxRates recordes = (FxRates) unmarshaller.unmarshal(new StringReader(response));
//            return recordes;
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//    }

    public FxRatesDto transformToDto(FxRates fxRates) {
        List<FxRateDto> dtos = fxRates.getFxRate().stream()
                .map(fxRate -> {
                    FxRateDto fxRateDto = new FxRateDto();
                    fxRateDto.setDate(fxRate.getDt());
                    fxRateDto.setType(fxRate.getTp());
                 List<CcyAmtDto> ccyAmtDtos=fxRate.getCcyAmt().stream()
                            .map(ccyAmt -> {
                                CcyAmtDto ccyAmtDto=new CcyAmtDto();
                                ccyAmtDto.setAmount(ccyAmt.getAmt());
                                ccyAmtDto.setCurrency(ccyAmt.getCcy());
                                return ccyAmtDto;
                            }).collect(Collectors.toList());
                    fxRateDto.setCurrencyAmountList(ccyAmtDtos);
                    return fxRateDto;
                }).collect(Collectors.toList());
        FxRatesDto fxRatesDto=new FxRatesDto();
        fxRatesDto.setFxRateDtoList(dtos);
        return ratesRepsository.save(fxRatesDto);
    }

//    public void saveToDb() {
//        transformToDto(getFxRates());
//    }


}
