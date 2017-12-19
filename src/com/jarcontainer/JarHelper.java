package com.jarcontainer;

import com.jarcontainer.coinfactory.CoinBank;

import java.io.File;

public class JarHelper {

    public static void loadCoinFromJar(String fileName) {
        try {
            JarClassLoader jarClassLoader = new JarClassLoader(CoinBank.COINS_PATH + File.separator + fileName);
            jarClassLoader.invokeClass(jarClassLoader.getMainClassName(), new String[]{fileName});
        } catch (Throwable throwable) {
            Main.log(throwable.getMessage());
            //TODO:
        }
    }


}
