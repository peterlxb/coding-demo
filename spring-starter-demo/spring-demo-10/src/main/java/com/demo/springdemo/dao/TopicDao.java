package com.demo.springdemo.dao;

import com.demo.springdemo.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
