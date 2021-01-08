package com.demo.springdemo.dao;

import com.demo.springdemo.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class TopicDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addTopic(final Topic topic) {
		final String sql = "INSERT INTO t_topic(topic_title) VALUES(?)";
        		
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		getJdbcTemplate().update(new PreparedStatementCreator() {
//			public PreparedStatement createPreparedStatement(Connection conn)
//					throws SQLException {
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setString(1, topic.getTopicTitle());
//				return ps;
//			}
//		}, keyHolder);
//		topic.setTopicId(keyHolder.getKey().intValue());
		
		Object[] params = new Object[]{topic.getTopicTitle()};
		jdbcTemplate.update(sql, params);
	}

	public double getReplyRate(int userId) {
		final String sql = "SELECT topic_replies, topic_views from  t_topic where user_id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] {userId}, (rs, rowNum) -> {
			int replies = rs.getInt("topic_replies");
			int views = rs.getInt("topic_views");

			if (views > 0) {
				return new Double((double) replies / views );
			} else {
				return new Double(0.0);
			}
		});
	};

	public SqlRowSet getTopicRowSet(int userId) {
		final String sql = "SELECT topic_id, topic_title from  t_topic where user_id = ?";
		return jdbcTemplate.queryForRowSet(sql);
	}
}
