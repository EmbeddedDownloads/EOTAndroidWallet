package com.eotcoin.core.coins;

import com.eotcoin.core.coins.families.BitFamily;

/**
 * @author John L. Jegutanis
 */
public class EOTCoinMain extends CoinType {
    private EOTCoinMain() {
        id = "eotcoin.main";

        addressHeader = 33;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 60;

        family = BitFamily.get();
        name = "EOTCoin";
        symbol = "EOT";
        uriScheme = "EOTCoin";
        bip44Index = 99;
        unitExponent = 8;
        feePerKb = value(10000); // 0.0001 AUM
        minNonDust = value(1);
        softDustLimit = value(1000000); // 0.01 AUM
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("EOTCOIN Signed Message:\n");
    }

    private static EOTCoinMain instance = new EOTCoinMain();
    public static synchronized EOTCoinMain get() {
        return instance;
    }
}