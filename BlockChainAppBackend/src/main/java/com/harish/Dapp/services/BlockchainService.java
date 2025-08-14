package com.harish.Dapp.services;

import org.springframework.stereotype.Service;

@Service
public class BlockchainService
{

    private final ManualContractCaller contractCaller;

    public BlockchainService(ManualContractCaller contractCaller) {
        this.contractCaller = contractCaller;
    }

    public String storeHashOnBlockchain(String ipfsHash) throws Exception {
        return contractCaller.issueCertificate(ipfsHash);
    }

    public boolean isCertificateValid(String ipfsHash) throws Exception {
        return contractCaller.verifyCertificate(ipfsHash);
    }

}
