package dev.liam.videoplatform.component.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dev.liam.videoplatform.component.dto.VideoDTO;

public class VideoDao {


    private SqlSession sqlSession;

    
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public int getLocalNum() throws Exception{
        return sqlSession.selectOne("video.localNum");
    }

    public VideoDTO getVideoDTO(int serialNum) throws Exception{
        return (VideoDTO)sqlSession.selectOne("video.getVideoInfo", serialNum);

    }

    public boolean saveVideoInfo(VideoDTO videoDTO) throws Exception{
        sqlSession.insert("video.saveVideoInfo", videoDTO);
        return true;
    }

    public List<Map<String,Object>> getVideoList() throws Exception{
        return sqlSession.selectList("video.getVideoList");
    }

    public int deleteVideo(int serialNum) throws Exception{
        return sqlSession.delete("video.deleteVideo", serialNum);
    }
}
                