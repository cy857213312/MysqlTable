package com.yongcao.mysqltable.controller;


import com.yongcao.mysqltable.entity.Index;
import com.yongcao.mysqltable.entity.Result;
import com.yongcao.mysqltable.mapper.ResultMapper;
import com.yongcao.mysqltable.service.ResultService;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.List;

@Controller
public class ResultController {


    @Autowired
    ResultService resultService;
    @Autowired
    ResultMapper resultMapper;


    @RequestMapping("/allTableName")
    public String allTableName(Model model){
        List<Result> results = resultService.allTableName();
        model.addAttribute("results",results);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/allIndex")
    public List<Index> allIndex(){
        return resultMapper.allIndex("question_answer");
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }




}
