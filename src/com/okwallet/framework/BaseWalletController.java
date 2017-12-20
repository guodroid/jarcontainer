package com.okwallet.framework;

public class BaseWalletController implements WalletController {
    @Override
    public void stop() {

    }

    @Override
    public void start() {

    }

    @Override
    public ServiceStatus getStatus() {
        return ServiceStatus.UNKNOWN;
    }

    @Override
    public String getTicker() {
        return null;
    }

    @Override
    public String getVersion() {
        return null;
    }
}
