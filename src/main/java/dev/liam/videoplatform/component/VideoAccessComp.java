package dev.liam.videoplatform.component;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import dev.liam.videoplatform.component.dto.VideoDTO;

@Component
public class VideoAccessComp {

    @Value("${videoSaveComp.rootPath}")
    private String rootPath;

    @Value("#{new Integer('${videoSaveComp.bufferSize}')}")
    private Integer bufferSize;

    

    public boolean saveVideo(InputStream file, VideoDTO videoDTO) {
        String tempFile = rootPath + "\\" + videoDTO.getLocalNum();
        try (InputStream inputStream = file;
                BufferedOutputStream targetStream = new BufferedOutputStream(
                        new FileOutputStream(rootPath + "\\" + videoDTO.getLocalNum()), bufferSize)) {
            inputStream.transferTo(targetStream);
        } catch (Exception e) {
            System.out.println("Failed File Path : " + tempFile);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public InputStream getVideo(int serialNum) throws FileNotFoundException{
        String tempFile = rootPath + "\\" + serialNum;
        return new FileInputStream(tempFile);
    }
}