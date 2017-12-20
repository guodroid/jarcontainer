package com.okwallet.commons;

import com.okwallet.framework.WalletController;

public class CoinEntry {

    public String fileName = "";
    public String walletDefaultParameterFromManifest = "";
    public String tickerFromMethodCall = "";
    public String walletVersion = "";

    public WalletController coinServiceInterface;

    public CoinEntry(String fileName, WalletController coinServiceInterface) {
        this.fileName = fileName;
        this.walletVersion = coinServiceInterface.getVersion();
        this.walletDefaultParameterFromManifest = "Unfinished...";

        this.coinServiceInterface = coinServiceInterface;
    }
}
