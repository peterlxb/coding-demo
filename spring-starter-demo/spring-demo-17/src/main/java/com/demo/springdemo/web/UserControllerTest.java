package com.demo.springdemo.web;


import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class UserControllerTest {

  @Test
  public void testHandle41() {

    RestTemplate restTemplate = new RestTemplate();
    MultiValueMap<String,String> form = new LinkedMultiValueMap<>();
    form.add("userName","tom");
    form.add("password","123456");
    form.add("age","23");
    restTemplate.postForLocation(
      "http://http://localhost:8080/user/handle41.html",form);
  }

  @Test
  public void testHandle42() throws IOException {

    RestTemplate restTemplate = new RestTemplate();
    byte[] response = restTemplate.postForObject(
      "http://localhost:8080/user/handle42/{itemId}.html",
      null, byte[].class,"1233"
      );
    Resource outFile = new FileSystemResource("copy.img");
    FileCopyUtils.copy(response, outFile.getFile());
  }

}
