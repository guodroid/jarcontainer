package com.okwallet.extention.btc;

import com.okwallet.commons.CoinBank;
import com.okwallet.framework.BaseWalletController;
import com.okwallet.framework.ServiceStatus;
import com.okwallet.framework.WalletController;

public class BtcWallet extends BaseWalletController {

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
