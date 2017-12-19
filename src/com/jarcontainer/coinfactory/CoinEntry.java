package com.jarcontainer.coinfactory;

public class CoinEntry {

    public String fileName = "";
    public String walletDefaultParameterFromManifest = "";
    public String tickerFromMethodCall = "";
    public String walletVersion = "";

    public CoinServiceInterface coinServiceInterface;

    public CoinEntry(String fileName, CoinServiceInterface coinServiceInterface) {
        this.fileName = fileName;
        this.walletVersion = coinServiceInterface.getVersion();
        this.walletDefaultParameterFromManifest = "Unfinished...";

        this.coinServiceInterface = coinServiceInterface;
    }
}
