package com.demo.springdemo.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class Forum implements Serializable{

	private int forumId;

	private String forumName;

	private String forumDesc;

}
