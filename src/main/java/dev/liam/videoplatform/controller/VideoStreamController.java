package dev.liam.videoplatform.controller;

import dev.liam.videoplatform.service.VideoStreamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videoStream")
public class VideoStreamController {

    
    private VideoStreamService videoStreamService;

//    @Qualifier(value="test")
    public VideoStreamController(VideoStreamService videoStreamService) {
        this.videoStreamService = videoStreamService;
    }

    @GetMapping("/stream/{fileName}")
    public Mono<ResponseEntity<byte[]>> streamVideo(
                                                    @RequestHeader(value = "Range", required = false) String httpRangeList,
                                                    @PathVariable("fileName") String fileName) {
        return Mono.just(videoStreamService.prepareContent(fileName, httpRangeList));
    }
}
