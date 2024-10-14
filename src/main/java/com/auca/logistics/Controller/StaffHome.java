package com.auca.logistics.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StaffHome {

    @GetMapping("/StaffHome")
    public String home(){
        return "StaffHome";
    }
    
}
