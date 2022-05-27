package dev.liam.videoplatform.config;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.liam.videoplatform.component.dao.VideoDao;

@Configuration
public class DaoBeanConfig {

    @Bean(name = "videoDao")
    public VideoDao setUserDao(@Qualifier("sqlSession") SqlSession sqlSession) throws Exception {
        VideoDao tempDao = new VideoDao();
        tempDao.setSqlSession(sqlSession);
        return tempDao;
    }
}
