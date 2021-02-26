package com.jkb.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${app.description}")
    private String greetingMessage;

    @Value("${my.list}")
    private List<String> myList;

    //caso não tenha app.null nas propriedades, vai mostra o que tem depois do :
    @Value("${app.null : defaulValorAqui}")
    private String unexistingProp;

    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting(){
//        return greetingMessage+ "  -  " + myList + "  -  " + unexistingProp + "  -  " + dbValues;
        return dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();
    }

    //http://localhost:8080/greeting check the endPoint...
}
