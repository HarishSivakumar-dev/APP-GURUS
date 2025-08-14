// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract CertificateRegistry 
{

    
    mapping(string => bool) private certificateHashes;

    
    event CertificateIssued(string ipfsHash, address indexed issuer);

    function issueCertificate(string memory ipfsHash) public {
        require(!certificateHashes[ipfsHash], "Certificate already exists");
        certificateHashes[ipfsHash] = true;

        emit CertificateIssued(ipfsHash, msg.sender);
    }

    // Verify whether a certificate exists
    function verifyCertificate(string memory ipfsHash) public view returns (bool) {
        return certificateHashes[ipfsHash];
    }
}
