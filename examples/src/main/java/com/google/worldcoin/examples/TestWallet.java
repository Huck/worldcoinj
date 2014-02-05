package com.google.worldcoin.examples;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.worldcoin.core.*;
import com.google.worldcoin.kits.WalletAppKit;
import com.google.worldcoin.params.MainNetParams;
import com.google.worldcoin.utils.Threading;

import java.io.File;
import java.math.BigInteger;


public class TestWallet {

	private static WalletAppKit appKit;
    private static boolean go = false;

	public static void main(String[] args) throws Exception {
		new TestWallet().run();
	}

	public void run() throws Exception {
		NetworkParameters params = MainNetParams.get();
		
		appKit = new WalletAppKit(params, new File("."), "worldcoins") {
			@Override
			protected void onSetupCompleted() {
				if (wallet().getKeychainSize() < 1) {
					ECKey key = new ECKey();
					wallet().addKey(key);
				}
				
				peerGroup().setConnectTimeoutMillis(1000);
				
				System.out.println(appKit.wallet());


                peerGroup().addEventListener(new AbstractPeerEventListener() {
					@Override
					public void onPeerConnected(Peer peer, int peerCount) {
						super.onPeerConnected(peer, peerCount);
						System.out.println(String.format("onPeerConnected: %s %s",peer,peerCount));
					}
					@Override
					public void onPeerDisconnected(Peer peer, int peerCount) {
						super.onPeerDisconnected(peer, peerCount);
						System.out.println(String.format("onPeerDisconnected: %s %s",peer,peerCount));
					}
					@Override public void onBlocksDownloaded(Peer peer, Block block, int blocksLeft) {
						super.onBlocksDownloaded(peer, block, blocksLeft);
						System.out.println(String.format("%s blocks left (downloaded %s)",blocksLeft,block.getHashAsString()));
					}
					
					@Override public Message onPreMessageReceived(Peer peer, Message m) {
						System.out.println(String.format("%s -> %s",peer,m.getClass()));
						return super.onPreMessageReceived(peer, m);
					}

                    @Override
                    public void onTransaction(Peer peer, Transaction t) {
                        System.out.println(String.format("Transaction with value to me: %s", t.getValueSentToMe(appKit.wallet())));
                        super.onTransaction(peer, t);
                    }
                },Threading.SAME_THREAD);
			}
		};

		
		appKit.startAndWait();

        System.in.read();

        // send money
        //send(appKit.wallet());

        appKit.stop();
	}

    /*private static void send(Wallet wallet)
    {

        System.out.println("You have " + Utils.worldcoinValueToFriendlyString(appKit.wallet().getBalance()) + " WDC");

        Address target1 = null;
        try {
            target1 = new Address(MainNetParams.get(), "WmF36LkLPKQubprd2JfpCZxEnLPoRgpfQU");
        } catch (AddressFormatException e) {
            e.printStackTrace();
        }


        try {
            final Wallet.SendResult result = wallet.sendCoins(appKit.peerGroup(), target1, Utils.toNanoCoins(1, 0));

            if (result == null) {
                // Not enough money!
            } else {
                // Wait for the transaction to propagate across the P2P network, indicating acceptance.
                result.broadcastComplete.addListener(new Runnable() {
                    @Override
                    public void run() {
                        // The wallet has changed now, it'll get auto saved shortly or when the app shuts down.
                        System.out.println("Sent coins onwards! Transaction hash is " + result.tx.getHashAsString());
                    }
                }, MoreExecutors.sameThreadExecutor());

            }

            System.out.println("Processed send!!");
        } catch (InsufficientMoneyException e) {
            e.printStackTrace();
        }

    }*/

}
