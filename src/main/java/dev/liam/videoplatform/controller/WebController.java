package dev.liam.videoplatform.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("web")
public class WebController {

    @GetMapping("/{path}")
    public String Main(@PathVariable String path, Model model){
        return path;
    }
}
