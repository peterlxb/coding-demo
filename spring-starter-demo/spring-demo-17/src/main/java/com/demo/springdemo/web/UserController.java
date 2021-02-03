package com.demo.springdemo.web;

import com.demo.springdemo.domain.User;
import com.demo.springdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public ModelAndView firstView() {
        ModelAndView mav = new ModelAndView("greet");
        // must match the jsp page name which is being requested.
        mav.addObject("greeting", "GeeksForGeeks Welcomes you to Spring!");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(User user) {
        userService.createUser(user);
        log.info("user: ",user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/createSuccess");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, params = "!myParam")
    public String register(@ModelAttribute("user") User user) {
        log.info("register user");
        return "user/register";
    }

    @RequestMapping(value = "/handle41")
    // 将请求报文体转换为字符串绑定到 RequestBody 入参中
    public String handle41(@RequestBody String requestBody) {
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    @ResponseBody
    @RequestMapping(path = "/handle42/{imageId}")
    // 读取一张图片，并将图片数据输出到响应流中
    public byte[] handle42(@PathVariable("imageId") String imageId) throws Exception {
       System.out.println("load image of: " + imageId);
       ClassPathResource res = new ClassPathResource("images/image.jpg");
       byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
       return fileData;
    }

    @RequestMapping(path = "handle43")
    public String handle43(HttpEntity<String> httpEntity) {
      Long contentLen = httpEntity.getHeaders().getContentLength();
      System.out.println("body :" + httpEntity.getBody());
      return "success";
    }

   @RequestMapping(path = "/handle44/{imageId}")
   public ResponseEntity<byte[]> handle44(@PathVariable("imageId") String imageId)
        throws Exception {

     ClassPathResource res = new ClassPathResource("images/image.jpg");
     byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
     ResponseEntity<byte[]> responseEntity =
              new ResponseEntity<>(fileData, HttpStatus.OK);

     return responseEntity;
   }

   @RequestMapping(path = "/handle51")
   public ResponseEntity<User> handle51(HttpEntity<User> requestEntity) {
      User user = requestEntity.getBody();
      user.setUserId("1001");
      return new ResponseEntity<User>(user,HttpStatus.OK);
   }

   // 在入参对象前加入 @Valid 注解，同时在后面声明一个 BindingResult 对象
   @RequestMapping(path = "/handle91")
   public String handle91(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult) {
      if (bindingResult.hasErrors()) {
        return "/user/register3";
      } else {
        return "/user/showUser";
     }
   }

   @RequestMapping(path = "/showUserListByFtl")
   public String showUserListInFtl(ModelMap modelMap) {
     Calendar calendar = new GregorianCalendar();
     List<User> userList = new ArrayList<>();
     User user1 = new User();
     user1.setUserName("tom");
     user1.setRealName("汤姆");
     calendar.set(1980, 1, 1);
     user1.setBirthday(calendar.getTime());

     User user2 = new User();
     user2.setUserName("john");
     user2.setRealName("约翰");
     calendar.set(1991, 1, 23);
     user2.setBirthday(calendar.getTime());

     userList.add(user1);
     userList.add(user2);

     modelMap.addAttribute("userList", userList);
     return "userListFtl";
   }

  @RequestMapping(path = "/showUserListByXls")
  public String showUserListInExcel(ModelMap modelMap) throws Exception {
    Calendar calendar = new GregorianCalendar();
    List<User> userList = new ArrayList<>();
    User user1 = new User();
    user1.setUserName("tom");
    user1.setRealName("汤姆");
    calendar.set(1980, 1, 1);
    user1.setBirthday(calendar.getTime());

    User user2 = new User();
    user2.setUserName("john");
    user2.setRealName("约翰");
    calendar.set(1991, 1, 23);
    user2.setBirthday(calendar.getTime());

    userList.add(user1);
    userList.add(user2);

    modelMap.addAttribute("userList", userList);
    return "userListExcel";
//    Workbook workbook = null;
//    HttpServletRequest request = null;
//    HttpServletResponse response = null;
//    new UserListExcelView().buildExcelDocument(modelMap, workbook, request, response);
  }



//    @RequestMapping("/{userId}")
//    public ModelAndView showDetail(@PathVariable("userId") String userId) {
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("showUser");
//        mav.addObject("user", userService.getUserById(userId));
//        return mav;
//    }

}
