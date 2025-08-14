package com.harish.Dapp.DTO;

public class CertificateResponseDTO
{
	
	 private String ipfsHash;
	 private String transactionHash;
	 private String status;
	public String getIpfsHash() {
		return ipfsHash;
	}
	public void setIpfsHash(String ipfsHash) {
		this.ipfsHash = ipfsHash;
	}
	public String getTransactionHash() {
		return transactionHash;
	}
	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
