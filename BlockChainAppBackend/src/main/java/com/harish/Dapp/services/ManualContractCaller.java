package com.harish.Dapp.services;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.response.PollingTransactionReceiptProcessor;

@Component
public class ManualContractCaller {

    private final Web3j web3j;
    private final RawTransactionManager txManager;
    private final Credentials credentials;

    @Value("${contract.address}")
    private String contractAddress;

    private final BigInteger gasPrice = BigInteger.valueOf(2_000_000_000L); // 2 Gwei
    private final BigInteger gasLimit = BigInteger.valueOf(300_000);        // 300,000

    public ManualContractCaller(Web3j web3j, Credentials credentials) {
        this.web3j = web3j;
        this.credentials = credentials;
        this.txManager = new RawTransactionManager(
        	    web3j,
        	    credentials,
        	    11155111L, // Sepolia chain ID 
        	    new PollingTransactionReceiptProcessor(web3j, 1000, 40)
        	);

    }

    // Call to issue certificate (write operation)
    public String issueCertificate(String ipfsHash) throws Exception {
        Function function = new Function(
                "issueCertificate",
                Collections.singletonList(new Utf8String(ipfsHash)),
                Collections.emptyList()
        );

        String encodedFunction = FunctionEncoder.encode(function);

        EthSendTransaction transactionResponse = txManager.sendTransaction(
                gasPrice,
                gasLimit,
                contractAddress,
                encodedFunction,
                BigInteger.ZERO
        );

        if (transactionResponse.hasError()) {
            throw new RuntimeException("Transaction Error: " + transactionResponse.getError().getMessage());
        }

        return transactionResponse.getTransactionHash();
    }

    // Call to verify certificate (read-only)
    public boolean verifyCertificate(String ipfsHash) throws Exception {
        Function function = new Function(
                "verifyCertificate",
                Collections.singletonList(new Utf8String(ipfsHash)),
                Collections.singletonList(new TypeReference<Bool>() {})
        );

        String encodedFunction = FunctionEncoder.encode(function);

        EthCall response = web3j.ethCall(
                Transaction.createEthCallTransaction(
                        credentials.getAddress(),
                        contractAddress,
                        encodedFunction
                ),
                DefaultBlockParameterName.LATEST
        ).send();

        List<org.web3j.abi.datatypes.Type> results = FunctionReturnDecoder.decode(
                response.getValue(),
                function.getOutputParameters()
        );

        return !results.isEmpty() && (Boolean) results.get(0).getValue();
    }
}
