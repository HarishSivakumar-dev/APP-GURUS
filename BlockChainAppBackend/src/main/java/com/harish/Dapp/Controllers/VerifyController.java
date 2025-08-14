package com.harish.Dapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harish.Dapp.services.CertificateService;

@RestController
@RequestMapping("/credentials")
public class VerifyController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("/verify")
    public ResponseEntity<String> verifyCertificate(@RequestParam("file") MultipartFile file, @RequestParam("originalHash") String originalHash) {
        try {
            boolean isValid = certificateService.verifyCertificate(file,originalHash);

            if (isValid) {
                return ResponseEntity.ok("Certificate is valid ✅");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certificate is invalid ❌");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Verification failed: " + e.getMessage());
        }
    }
}
