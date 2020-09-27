package lt.internship.currencyConverter.config;

import lt.internship.currencyConverter.integration.LBclient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class LBclientConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("lt.lb.webservices.wsdl");
        return marshaller;
    }

    @Bean
    public LBclient lBclient(Jaxb2Marshaller marshaller) {
        LBclient client = new LBclient();
        client.setDefaultUri("https://lb.lt/webservices/fxrates");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
