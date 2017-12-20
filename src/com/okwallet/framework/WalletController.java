package com.okwallet.framework;

public interface WalletController extends WalletService {
    String getTicker();
    String getVersion();
}
