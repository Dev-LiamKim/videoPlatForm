package dev.liam.videoplatform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import dev.liam.videoplatform.service.VideoService;

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // @GetMapping("/call/{serialNum}")
    // public ResponseEntity<Resource> callVideo(@PathVariable("serialNum") int
    // serialNum){
    // try{
    // }catch(Exception e){
    // e.printStackTrace();
    // }
    // return ResponseEntity.ok(new
    // ByteArrayResource(videoService.getVideo(serialNum).getData()));
    // }

    @PostMapping("/save")
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file,
            @RequestParam("name") String name) {
        try {
            videoService.saveVideo(file, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("\'" + name + "\' saved successfully");
    }

    @GetMapping("/getList")
    public List<Map<String, Object>> getVideoList() {
        List<Map<String, Object>> videoListMap = null;
        try {
            videoListMap = videoService.getVideoList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return videoListMap;
    }
    
    @GetMapping("/delete/{serialNum}")
    public ResponseEntity<String> deleteVideo(@PathVariable("serialNum")int serialNum){

        return ResponseEntity.ok("not working");
    }

    @PostMapping("/getVideo/{serialNum}")
    public ResponseEntity<StreamingResponseBody> videoFile(@PathVariable("serialNum")int serialNum){
        
        return null;
    }

    // @GetMapping("/all")
    // public ResponseEntity<List<Map<Integer,String>>> getAllVideos() {
    // List<Map<Integer,String>> videoList;
    // try{
    // videoList = videoService.getAllVideos();
    // }catch (Exception e){
    // e.printStackTrace();
    // videoList = new ArrayList<Map<Integer,String>>();
    // Map<Integer, String> tempMap = new HashMap<Integer, String>();
    // tempMap.put(100, "error : Couldn't get VideoList");
    // videoList.add(tempMap);
    // }

    // return ResponseEntity.ok(videoList);
    // }
}