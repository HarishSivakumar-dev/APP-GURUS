package com.harish.Dapp.services;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;


@Service
@Component
public class IPFSService
{
	private final IPFS ipfs = new IPFS("https://ipfs.infura.io:5001"); // IPFS daemon must be running

    public String uploadFileToIPFS(MultipartFile file) throws IOException {
        NamedStreamable.InputStreamWrapper is = new NamedStreamable.InputStreamWrapper(file.getInputStream());
        MerkleNode response = ipfs.add(is).get(0);
        return response.hash.toString();
    }

}
