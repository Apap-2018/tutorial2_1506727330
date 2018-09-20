package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/viral")
    public String index(){
        return "viral";
    }

    @RequestMapping("/challenge")
    public String challenge(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "challenge";
    }

    @RequestMapping("/challenge/{name}")
    public String challengePath(@PathVariable String name, Model model){
        model.addAttribute("name",name);
        return "challenge";
    }

    @RequestMapping("/generator")
    public String generator(@RequestParam(value = "a") int mCounts, @RequestParam(value = "b") int wordCounts, Model model){
        model.addAttribute("mCounts",mCounts);
        model.addAttribute("wordCounts",wordCounts);
        String word = "hm";
        for (int i = 1; i < mCounts; i++){
            word = word + 'm';
        }
        String words = word;
        for (int i = 1; i < wordCounts; i++) {
            words = words + " " + word;
        }
        model.addAttribute("words", words);
        return "viral-generator";
    }
}
