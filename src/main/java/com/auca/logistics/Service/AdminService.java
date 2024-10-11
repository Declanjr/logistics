package com.auca.logistics.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auca.logistics.Model.MyAppUser;
import com.auca.logistics.Model.MyAppUserRepository;
import com.auca.logistics.Model.Role;

@Service
public class AdminService {
    
    @Autowired
    private MyAppUserRepository appUserRepository;

    // Only ADMIN can promote to MANAGER or ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public void promoteToManager(Long userId) {
        MyAppUser user = appUserRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.getRoles().add(Role.MANAGER);
        appUserRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public void promoteToAdmin(Long userId) {
        MyAppUser user = appUserRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.getRoles().add(Role.ADMIN);
        appUserRepository.save(user);
    }
}