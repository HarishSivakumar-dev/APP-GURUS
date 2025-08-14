package com.harish.Dapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harish.Dapp.DTO.CertificateResponseDTO;
import com.harish.Dapp.services.CertificateService;

@RestController
@RequestMapping("/credentials")
public class IssueController
{
	
	@Autowired 
	CertificateService certificateService;

    @PostMapping("/certificate")
    public ResponseEntity<CertificateResponseDTO> issueCert(
            @RequestParam("file") MultipartFile file,
            @RequestParam("studentWallet") String studentWallet
    ) throws Exception {
        CertificateResponseDTO dto = certificateService.issueCertificate(file, studentWallet);
        return ResponseEntity.ok(dto);
    }

}
