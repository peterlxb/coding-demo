package com.demo.springdemo.web;


import com.demo.springdemo.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

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

  @Test
  public void testHandle51() throws IOException{
    RestTemplate restTemplate = buildRestTemplate();

    User user = new User();
    user.setUserName("tom");
    user.setPassword("1234");
    user.setRealName("汤姆");

    HttpHeaders entityHeaders = new HttpHeaders();
    // 指定请求的报文头信息
//    entityHeaders.setContentType(MediaType.valueOf("application/xml;UTF-8"));
//    entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
    entityHeaders.setContentType(MediaType.valueOf("application/json;UTF-8"));
    entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    HttpEntity<User> requestEntity = new HttpEntity<>(user, entityHeaders);

    ResponseEntity<User> responseEntity = restTemplate.exchange(
      "http://localhost:8080/user/handle51.html",
      HttpMethod.POST,requestEntity,User.class);

    User responseUser = responseEntity.getBody();
    System.out.println("User: "+ responseUser);

  }

  private RestTemplate buildRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();

    // 使用 XStream 流化器，使用 Stax 技术处理 XML，同时加载使用了 XSteam 注解的User 类。
    XStreamMarshaller xmlMarshaller = new XStreamMarshaller();
    xmlMarshaller.setStreamDriver(new StaxDriver());
    xmlMarshaller.setAnnotatedClasses(new Class[]{User.class});

    // 创建处理 XML 报文的 HttpMessageConverter,将其组装到 restTemplate 中
    MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
    xmlConverter.setMarshaller(xmlMarshaller);
    xmlConverter.setUnmarshaller(xmlMarshaller);
    restTemplate.getMessageConverters().add(xmlConverter);

    // 创建处理 JSON 报文的 HttpMessageConverter,将其组装到 restTemplate 中
    MappingJackson2HttpMessageConverter jsonConverter =
      new MappingJackson2HttpMessageConverter();
    restTemplate.getMessageConverters().add(jsonConverter);

    return restTemplate;
  }

}
