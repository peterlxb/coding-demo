package com.demo.springdemo.attr;

import java.util.*;

public class Boss {
    // 声明初始化对象
    private Car car = new Car();

    private Properties mails = new Properties();
    private Map jobs = new HashMap();
    private List favorites = new ArrayList();
    private Map<String,Integer> jobTime = new HashMap<>();

    public Properties getMails() {
        return mails;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }

    public Map getJobs() {
        return jobs;
    }

    public void setJobs(Map jobs) {
        this.jobs = jobs;
    }

    public List getFavorites() {
        return favorites;
    }

    public void setFavorites(List favorites) {
        this.favorites = favorites;
    }

    public Map<String, Integer> getJobTime() {
        return jobTime;
    }

    public void setJobTime(Map<String,Integer> jobTime) {
        this.jobTime = jobTime;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public String toString() {
        String temp = "car:" + car + "\n";
        temp += "favorites.size:" + favorites.size() + "\n";
        temp += "jobs.size:" + jobs.size();
        return temp;
    }
}
