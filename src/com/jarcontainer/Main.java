package com.jarcontainer;

import com.jarcontainer.coinfactory.CoinBank;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {

        WatchService watcher = FileSystems.getDefault().newWatchService();

        Path dir = new File(CoinBank.COINS_PATH).toPath();
        ;
        try {
            WatchKey key = dir.register(watcher,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException x) {
            System.err.println(x);
        }

        setupWatcherFromThread(watcher);

        waitExitCommand();

    }


    private static void waitExitCommand() {
        System.out.println("Press X for exit.....");
        Scanner s = new Scanner(System.in);
        while (true) {
            String input = s.nextLine();
            if ("X".equalsIgnoreCase(input)) {
                System.exit(0);
            }
            if ("P".equalsIgnoreCase(input)) {
                CoinBank.instance.printAllCoins();
            }
        }
    }


    public static void setupWatcherFromThread(final WatchService watcher) {
        new Thread() {
            @Override
            public void run() {
                setupWatcher(watcher);
            }
        }.start();

    }

    public static void log(String s) {
        System.out.println(s);
    }


    public static void setupWatcher(WatchService watcher) {
        for (; ; ) {

            // wait for key to be signaled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // This key is registered only
                // for ENTRY_CREATE events,
                // but an OVERFLOW event can
                // occur regardless if events
                // are lost or discarded.
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }

                // The filename is the
                // context of the event.
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                String filename = ev.context().toString();

                // Verify that the new
                //  file is a text file.
                log(kind.name() + "   -----  FileName is: " + filename.toString());

                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    JarHelper.loadCoinFromJar(filename);
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    CoinBank.instance.removeCoin(filename);
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    JarHelper.loadCoinFromJar(filename);
                }


            }

            // Reset the key -- this step is critical if you want to
            // receive further watch events.  If the key is no longer valid,
            // the directory is inaccessible so exit the loop.
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }

}
