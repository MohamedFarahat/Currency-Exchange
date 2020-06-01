package com.microservices.currencyconversionservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currecnyExchangeProxy;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateAmount(@PathVariable String from, @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {
        Map<String, String> map = new HashMap<>();
        map.put("from", from);
        map.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                 CurrencyConversion.class,map);
        CurrencyConversion response = responseEntity.getBody();
        return  new CurrencyConversion(response.getId(),from,to,response.getConvertion_multible(),
                quantity,quantity.multiply(response.getConvertion_multible()),response.getPort());

    }
    // using fiegn easier
    @GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateAmountProxy(@PathVariable("from") String from, @PathVariable("to") String to,
                                              @PathVariable BigDecimal quantity) {

        CurrencyConversion response = currecnyExchangeProxy.retrieveExchangeValue(from,to);
        logger.info("Conversion -> {}",response);
        return  new CurrencyConversion(response.getId(),from,to,response.getConvertion_multible(),
                quantity,quantity.multiply(response.getConvertion_multible()),response.getPort());
    }
}
