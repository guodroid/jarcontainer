package com.jarcontainer.coinfactory.eth;

import com.jarcontainer.coinfactory.CoinBank;
import com.jarcontainer.coinfactory.CoinServiceInterface;

public class EthWallet implements CoinServiceInterface {

    private static EthWallet instance = new EthWallet();

    public static void main(String args[]) {
        CoinBank.instance.registerCoin(args[0], instance);
    }

    @Override
    public String getTicker() {
        return "ETH";
    }

    @Override
    public String getVersion() {
        return "ethwallet0.12.2";
    }

}
