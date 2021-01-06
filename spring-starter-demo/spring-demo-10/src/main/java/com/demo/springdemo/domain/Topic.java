package com.demo.springdemo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	private int topicId;

	private String topicTitle;

	private Date topicTime;

	private Post post;

	private int topicViews;
}
