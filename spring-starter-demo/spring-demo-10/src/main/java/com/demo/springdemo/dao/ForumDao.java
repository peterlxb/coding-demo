package com.demo.springdemo.dao;

import com.demo.springdemo.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ForumDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addForum(final Forum forum) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int randomKey = keyHolder.getKey().intValue();
		final String sql = "INSERT INTO forum(forumName,forumDesc) VALUES(?,?)";

		jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, forum.getForumName());
			ps.setString(2, forum.getForumDesc());
			return ps;
		}, keyHolder);

		forum.setForumId(randomKey);
	}

	// 批量操作
	public void addForum(final List<Forum> forums) {
		final String sql = "INSERT INTO forum(forumName,forumDesc) VALUES(?,?)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			// 1.指定该批的记录数
			@Override
			public int getBatchSize() {
				return forums.size();
			}

			// 2.绑定插入的参数
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Forum forum = forums.get(i);
				ps.setString(1, forum.getForumName());
				ps.setString(2, forum.getForumDesc());
			}
		});
	}

	public Forum getForum(final int forumId) {
		String sql = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id=?";
		final Forum forum = new Forum();

		// 将结果集数据行中的数据抽取到 forum 对象中
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

	public List<Forum> getForums(final int fromId, final int toId) {
		String sql = "SELECT forum_id, forum_name,forum_desc FROM t_forum " +
				"WHERE forum_id between ? and ?";

		final List forums = new ArrayList();
		jdbcTemplate.query(sql, new Object[]{fromId, toId},
				// 将结果集中的数据映射到 List中
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						final Forum forum = new Forum();
						forum.setForumId(rs.getInt("forum_id"));
						forum.setForumName(rs.getString("forum_name"));
						forum.setForumDesc(rs.getString("forum_desc"));
						forums.add(forum);
					}
				});
		return forums;
	}

	public List<Forum> getForumsOfMapper(final int fromId, final int toId) {
		String sql = "SELECT forum_id, forum_name,forum_desc FROM t_forum " +
				"WHERE forum_id between ? and ?";

	return	jdbcTemplate.query(sql, new Object[]{fromId, toId}, new RowMapper<Forum>() {
			@Override
			public Forum mapRow(ResultSet rs, int rowNum) throws SQLException {
				Forum forum = new Forum();
				forum.setForumId(rs.getInt("forum_id"));
				forum.setForumName(rs.getString("forum_name"));
				forum.setForumDesc(rs.getString("forum_desc"));
				return forum;
			}
		});
	}

	public int getForumNum() {
		String sql = "SELECT forum_id FROM t_forum ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public void updateForum(final Forum forum) {
		final String sql = "UPDATE  t_forum SET forum_name=?,forum_desc=? WHERE forum_id=?";
		Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc(),forum.getForumId()};
		// jdbcTemplate.update(sql, params,new int[]{Types.VARBINARY, Types.VARBINARY});
		jdbcTemplate.update(sql, params);
	}
}
