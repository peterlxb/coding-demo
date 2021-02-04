package com.demo.springdemo.controller;

import com.demo.springdemo.domain.City;
import com.demo.springdemo.service.ICityService;
import com.demo.springdemo.util.GeneratePdfReport;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class MyController {

  @Autowired
  private ICityService cityService;

  @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_PDF_VALUE)
  public ResponseEntity<InputStreamResource> citiesReport() {

    var cities = (List<City>) cityService.findAll();

    ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);

    var headers = new HttpHeaders();
    headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

    return ResponseEntity
      .ok()
      .headers(headers)
      .contentType(MediaType.APPLICATION_PDF)
      .body(new InputStreamResource(bis));
  }
}
