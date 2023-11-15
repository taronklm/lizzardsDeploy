package com.example.demo.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(path = "get/{adminId}")
    public Admin getAdmin(@PathVariable("adminId") Long id) {
        return adminService.getAdmin(id);
    }

    @GetMapping(path = "getAll")
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @PostMapping(path = "create")
    public void registerNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
    }

    @DeleteMapping(path = "delete/{adminId}")
    public void deleteAdmin(@PathVariable("adminId") Long adminId) {
        adminService.deleteAdmin(adminId);
    }

    @PutMapping(path = "update/{adminId}")
    public void updateAdmin(@PathVariable("adminId") Long adminId,
            @RequestBody(required = false) Admin admin) {
        adminService.updateAdmin(adminId, admin);
    }
}
