package com.jarcontainer.coinfactory;

import com.jarcontainer.Main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CoinBank {

    public static final String COINS_PATH = "/Users/guo/mygit/jarcontainer/coinbank";
    public static CoinBank instance = new CoinBank();

    private Map<String, CoinEntry> allCoins = Collections.synchronizedMap(new HashMap());

    public void registerCoin(String fileName, CoinServiceInterface coinServiceInterface) {
        CoinEntry coinEntry = new CoinEntry(fileName, coinServiceInterface);
        coinEntry.tickerFromMethodCall = coinServiceInterface.getTicker();
        allCoins.put(fileName, coinEntry);

        Main.log("Coin added with ticker: " + coinEntry.tickerFromMethodCall);
        Main.log("Coin added with version: " + coinEntry.walletVersion);
    }

    public void removeCoin(String fileName) {
        allCoins.remove(fileName);
    }

    public void printAllCoins() {
        Main.log(allCoins.toString());
    }

//    public void updateCoin(String fileName) {
//        CoinEntry coinEntry = tryParseCoinEntryByFileName(fileName);
//        allCoins.put(fileName, coinEntry);
//    }

}
