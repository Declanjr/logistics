package com.auca.logistics.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ForgotController {

    @GetMapping("/forgot")
    public String forgot() {
        return "forgot";
    }
    
    
}