package com.demo.springdemo.anno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LogonService {

    @Lazy
    @Autowired(required=false)
    private LogDao logDao;


    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;


//    // 1.自动将LogDao传给方法入参
//    @Autowired
//    public void setLogDao(LogDao logDao) {
//        this.logDao = logDao;
//    }
//
//
//    // 2.自动将名为userDao的Bean传给方法入参
//    @Autowired
//    @Qualifier("userDao")
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    @Autowired
//    public void init(@Qualifier("userDao")UserDao userDao, LogDao logDao) {
//        System.out.println("multi param inject");
//        this.logDao = logDao;
//        this.userDao = userDao;
//    }
}

