package dev.liam.videoplatform.handler;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.liam.videoplatform.component.VideoAccessComp;
import dev.liam.videoplatform.component.dto.VideoDTO;

@Component
public class VideoHandler {

    @Autowired
    private VideoAccessComp videoAccessComp;

    // @Autowired
    // private VideoAccessComp videoAccessComp;

    public boolean saveVideo(InputStream inputStream, VideoDTO videoDTO){
        return videoAccessComp.saveVideo(inputStream, videoDTO);
    }

//    public void delteVideo()

    // public byte[] getVideo(int SerialNum){
    //     return new byte[];
    // }
}
