package com.jarcontainer.coinfactory.btc;

import com.jarcontainer.coinfactory.CoinBank;
import com.jarcontainer.coinfactory.CoinServiceInterface;

public class BtcWallet implements CoinServiceInterface {

    private static BtcWallet instance = new BtcWallet();

    public static void main(String args[]) {
        CoinBank.instance.registerCoin(args[0], instance);
    }

    @Override
    public String getTicker() {
        return "BTC";
    }

    @Override
    public String getVersion() {
        return "btcwallet0.01";
    }

}
