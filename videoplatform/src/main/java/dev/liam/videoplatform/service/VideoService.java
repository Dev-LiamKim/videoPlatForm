package dev.liam.videoplatform.service;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.liam.videoplatform.component.dto.VideoDTO;
import dev.liam.videoplatform.handler.DaoHandler;
import dev.liam.videoplatform.handler.VideoHandler;

@Service
public class VideoService {

    @Autowired
    private DaoHandler daoHandler;
    @Autowired
    private VideoHandler videoHandler;

    public boolean saveVideo(MultipartFile multipartFile, String title) throws Exception{
        //빠른 구현을 위해 Video 객체는 만들지 않기로 함 추후 만들어서 
        //비디오를 서버 스토리지에 저장후 video 객체를 만들어 db에 저장하게 수정할 예정
        //지금은 saveVideo안에 몰아 넣기
        int localNum = daoHandler.getLocalNum();
        VideoDTO videoDTO = new VideoDTO(title, localNum);
        if(videoHandler.saveVideo(new BufferedInputStream(multipartFile.getInputStream()), videoDTO)){
            daoHandler.saveVideoInfo(videoDTO);
            return true;
        }
        return false;
    }
    
    public boolean deleteVideo(int serialNum) throws Exception{
        daoHandler.deleteVideo(serialNum);

        return false;
    }

    public List<Map<String,Object>> getVideoList() throws Exception{
        return daoHandler.getVideoList();
    }


    /**
     * 비디오 오브젝트를 반환하는 함수
     * @param serialNum
     * @return
     * @throws Exception
     */
    public VideoDTO getVideoDTO(int serialNum) throws Exception{
        return daoHandler.getVideoDTO(serialNum);
    }
}
