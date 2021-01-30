package com.exchange.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.exchange.vo.Data;

@Controller
public class ExchangeController {

    @RequestMapping(value = "/")
    public String calculation(Model model) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        
        final String baseUrl = "http://www.apilayer.net/api/live?access_key=ee50cd7cc73c9b7a7bb3d9617cfb6b9c";
        URI uri = new URI(baseUrl);
         
        ResponseEntity<Data> result = restTemplate.getForEntity(uri, Data.class);
        model.addAttribute("data", result.getBody());
        return "exchange";
    }
}
