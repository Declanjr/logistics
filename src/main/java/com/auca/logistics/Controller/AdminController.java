package com.auca.logistics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auca.logistics.Service.AdminService;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')") 
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/users/{userId}/promote/manager")
    public String promoteToManager(@PathVariable Long userId) {
        adminService.promoteToManager(userId);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/{userId}/promote/admin")
    public String promoteToAdmin(@PathVariable Long userId) {
        adminService.promoteToAdmin(userId);
        return "redirect:/admin/users";
    }
}