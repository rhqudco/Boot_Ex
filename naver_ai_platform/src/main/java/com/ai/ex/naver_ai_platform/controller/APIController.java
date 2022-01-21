package com.ai.ex.naver_ai_platform.controller;

import com.ai.ex.naver_ai_platform.service.CFRCelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APIController {
    @Autowired
    private CFRCelebrityService cfrserviceCel;

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/faceRecogCel")
    public String faceRecogCel() {
        cfrserviceCel.clovaFaceRecogCel();
        return "celebrityView";
    }
}