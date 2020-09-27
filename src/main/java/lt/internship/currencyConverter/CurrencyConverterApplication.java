package lt.internship.currencyConverter;

import lt.internship.currencyConverter.integration.LBclient;
import lt.lb.webservices.wsdl.GetCurrencyListResponse;
import lt.lb.webservices.wsdl.GetCurrentFxRates;
import lt.lb.webservices.wsdl.GetCurrentFxRatesResponse;
import lt.lb.webservices.wsdl.GetFxRates;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CurrencyConverterApplication.class, args);


	}

}
