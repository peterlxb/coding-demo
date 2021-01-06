package com.demo.springdemo.dao;

import com.demo.springdemo.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addPost(final Post post) {
		String sql = " INSERT INTO t_post(topic_id,post_text)"
				+ " VALUES(?,?)";
        Object[] params = new Object[]{post.getTopicId(),post.getPostText()};
		jdbcTemplate.update(sql, params);
	}
}
