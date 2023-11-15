package com.example.demo.admin;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin getAdmin(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalStateException("admin with id " + adminId + " does not exists"));
        return admin;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) {
        Optional<Admin> nameOptional = adminRepository.findAdminByName(admin.getName());
        if (nameOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }

        Optional<Admin> emailOptional = adminRepository.findAdminByEmail(admin.getEmail());
        if (emailOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        adminRepository.save(admin);
    }

    public void deleteAdmin(Long adminId) {
        boolean exists = adminRepository.existsById(adminId);
        if (!exists) {
            throw new IllegalStateException("admin with id " + adminId + " does not exists");
        }
        adminRepository.deleteById(adminId);
    }

    @Transactional
    public void updateAdmin(Long adminId, Admin updatedAdmin) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalStateException("admin with id " + adminId + " does not exists"));

        if (updatedAdmin.getName() != null && updatedAdmin.getName().length() > 0
                && !Objects.equals(admin.getName(), updatedAdmin.getName())) {
            admin.setName(updatedAdmin.getName());
        }

        if (updatedAdmin.getEmail() != null && updatedAdmin.getEmail().length() > 0
                && !Objects.equals(admin.getEmail(), updatedAdmin.getEmail())) {

            Optional<Admin> adminOptional = adminRepository.findAdminByEmail(updatedAdmin.getEmail());
            if (adminOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            admin.setEmail(updatedAdmin.getEmail());
        }

        if (updatedAdmin.getPassword() != null && updatedAdmin.getPassword().length() > 0
                && !Objects.equals(admin.getPassword(), updatedAdmin.getPassword())) {
            admin.setPassword(updatedAdmin.getPassword());
        }
    }

}
