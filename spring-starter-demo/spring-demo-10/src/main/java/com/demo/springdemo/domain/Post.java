package com.demo.springdemo.domain;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class Post implements Serializable {

	private int postId;

	private int topicId;

	private int forumId;

	private int userId;

	private String postText;

	private byte[] postAttach;

	private Date postTime;

}
