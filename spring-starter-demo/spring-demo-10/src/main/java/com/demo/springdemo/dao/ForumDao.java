package com.demo.springdemo.dao;

import com.demo.springdemo.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ForumDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addForum(final Forum forum) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
//		int randomKey = keyHolder.getKey().intValue();
		final String sql = "INSERT INTO forum(forumId, forumName,forumDesc) VALUES(?,?,?)";


		jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, String.valueOf(forum.getForumId()));
			ps.setString(2, forum.getForumName());
			ps.setString(3, forum.getForumDesc());
			return ps;
		}, keyHolder);

//		forum.setForumId(keyHolder.getKey().intValue());
	}

	public Forum getForum(final int forumId) {
		String sql = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id=?";
		final Forum forum = new Forum();
		jdbcTemplate.query(sql, new Object[]{forumId},
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						forum.setForumId(forumId);
						forum.setForumName(rs.getString("forum_name"));
						forum.setForumDesc(rs.getString("forum_desc"));
					}
				});
		return forum;
	}

	public int getForumNum() {
		String sql = "SELECT forum_id FROM t_forum ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public void updateForum(final Forum forum) {
		final String sql = "UPDATE  t_forum SET forum_name=?,forum_desc=? WHERE forum_id=?";
		Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc(),forum.getForumId()};
		jdbcTemplate.update(sql, params);
	}
}
