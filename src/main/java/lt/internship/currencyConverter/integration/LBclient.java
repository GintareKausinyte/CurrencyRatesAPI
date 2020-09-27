package lt.internship.currencyConverter.integration;

import lt.lb.webservices.wsdl.GetCurrentFxRates;
import lt.lb.webservices.wsdl.GetCurrentFxRatesResponse;
import lt.lb.webservices.wsdl.GetFxRates;
import lt.lb.webservices.wsdl.GetFxRatesResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class LBclient extends WebServiceGatewaySupport {

    public GetCurrentFxRatesResponse getCurrentFxRates() {
        GetCurrentFxRates request = new GetCurrentFxRates();
        request.setTp("EU");

        GetCurrentFxRatesResponse response = (GetCurrentFxRatesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://lb.lt/webservices/fxrates/fxrates.asmx", request, new SoapActionCallback("http://www.lb.lt/WebServices/FxRates/getCurrentFxRates"));
        return response;
    }
    public GetFxRatesResponse getFxRatesResponse(){
        GetFxRates request=new GetFxRates();
        request.setTp("EU");
        GetFxRatesResponse response=(GetFxRatesResponse)getWebServiceTemplate().marshalSendAndReceive("https://lb.lt/webservices/fxrates/fxrates.asmx", request, new SoapActionCallback("http://www.lb.lt/WebServices/FxRates/getFxRates"));
        return response;
    }


}
