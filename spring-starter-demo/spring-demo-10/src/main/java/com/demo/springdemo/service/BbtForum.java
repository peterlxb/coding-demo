package com.demo.springdemo.service;

import com.demo.springdemo.dao.ForumDao;
import com.demo.springdemo.dao.PostDao;
import com.demo.springdemo.dao.TopicDao;
import com.demo.springdemo.domain.Forum;
import com.demo.springdemo.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BbtForum {

    @Autowired
    public ForumDao forumDao;

    @Autowired
    public TopicDao topicDao;

    @Autowired
    public PostDao postDao;

    public void addTopic(Topic topic) throws Exception {
        topicDao.addTopic(topic);
//		if(true) throw new PessimisticLockingFailureException("fail");
        postDao.addPost(topic.getPost());
    }


    @Transactional(readOnly = true)
    public Forum getForum(int forumId) {
        return forumDao.getForum(forumId);
    }

    public void updateForum(Forum forum) {
        forumDao.updateForum(forum);
    }

    public int getForumNum() {
        return forumDao.getForumNum();
    }
}