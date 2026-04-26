package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ApiResponse;

@RestController
public class DemoController {

    @GetMapping("/")
    public ApiResponse getMessage()
    {      
        return new ApiResponse("Hello, World!", "success");
    }
}