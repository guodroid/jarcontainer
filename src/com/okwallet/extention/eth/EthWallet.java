package com.okwallet.extention.eth;

import com.okwallet.commons.CoinBank;
import com.okwallet.framework.BaseWalletController;
import com.okwallet.framework.WalletController;

public class EthWallet extends BaseWalletController {

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
