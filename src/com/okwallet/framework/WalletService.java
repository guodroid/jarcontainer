package com.okwallet.framework;

public interface WalletService {
    void stop();
    void start();
    ServiceStatus getStatus();
}
