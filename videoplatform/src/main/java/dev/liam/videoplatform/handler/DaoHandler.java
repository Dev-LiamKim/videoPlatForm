package dev.liam.videoplatform.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.liam.videoplatform.component.dao.VideoDao;
import dev.liam.videoplatform.component.dto.VideoDTO;

@Component
public class DaoHandler {

    @Autowired
    private VideoDao videoDao;

    /**
     * 비디오 정보를 VideoDTO 객체에 담아 반환
     */
    public VideoDTO getVideoDTO(int serialNum) throws Exception{
        return videoDao.getVideoDTO(serialNum);
    }


    /**
     * 서버 경로에 저장된 파일이름을 가져오는 함수
     * @return
     * @throws Exception
     */
    public int getLocalNum() throws Exception {
        return videoDao.getLocalNum();
    }


    /**
     * 비디오 정보를 데이터베이스에 저장하는 함수
     * @param videoDTO
     * @return
     * @throws Exception
     */
    public boolean saveVideoInfo(VideoDTO videoDTO) throws Exception {
        return videoDao.saveVideoInfo(videoDTO);
    }

    /**
     * 데이터베이스에 저장된 모든 비디오 목록을 가져오는 함수
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> getVideoList() throws Exception{
        return videoDao.getVideoList();
    }

    /**
     * 비디오 정보를 삭제하는 함수
     * @param serialNum
     * @throws Exception
     */
    public void deleteVideo(int serialNum) throws Exception{
        if(videoDao.deleteVideo(serialNum) != 1)
            throw new Exception("Error occur while deleting Video");
            
    }
}
