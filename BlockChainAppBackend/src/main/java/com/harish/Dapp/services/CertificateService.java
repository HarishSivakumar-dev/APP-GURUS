package com.harish.Dapp.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.harish.Dapp.DTO.CertificateResponseDTO;

@Service
@Component
public class CertificateService
{
	@Autowired
	IPFSService ipfsService;
    @Autowired
    BlockchainService blockchainService;

    public CertificateResponseDTO issueCertificate(MultipartFile file, String studentWallet) throws Exception {
        String ipfsHash = ipfsService.uploadFileToIPFS(file);
        String txnHash = blockchainService.storeHashOnBlockchain(ipfsHash);

        CertificateResponseDTO dto = new CertificateResponseDTO();
        dto.setIpfsHash(ipfsHash);
        dto.setTransactionHash(txnHash);
        dto.setStatus("Certificate Issued Successfully");
        return dto;
    }

    public boolean verifyCertificate(MultipartFile file, String originalIpfsHash) throws IOException {
        String currentIpfsHash = ipfsService.uploadFileToIPFS(file);
        return currentIpfsHash.equals(originalIpfsHash);
    }
}
