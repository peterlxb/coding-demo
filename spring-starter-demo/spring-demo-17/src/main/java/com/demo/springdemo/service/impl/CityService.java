package com.demo.springdemo.service.impl;

import java.util.List;
import com.demo.springdemo.domain.City;
import com.demo.springdemo.repository.CityRepository;
import com.demo.springdemo.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

  @Autowired
  private CityRepository repository;

  @Override
  public List<City> findAll() {

    return (List<City>) repository.findAll();
  }
}
