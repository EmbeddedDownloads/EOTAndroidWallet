package com.eotcoin.core.coins;

import com.eotcoin.core.coins.families.VpncoinFamily;
import com.eotcoin.core.messages.MessageFactory;
import com.eotcoin.core.wallet.families.vpncoin.VpncoinTxMessage;

import javax.annotation.Nullable;

/**
 * @author John L. Jegutanis
 */
public class VpncoinMain extends CoinType {
    private VpncoinMain() {
        id = "vpncoin.main";

        addressHeader = 71;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;

        family = VpncoinFamily.get();
        name = "Vpncoin";
        symbol = "VPN";
        uriScheme = "vpncoin";
        bip44Index = 33;
        unitExponent = 8;
        feePerKb = value(10000000); // 0.1VPN
        minNonDust = feePerKb;
        softDustLimit = feePerKb;
        softDustPolicy = SoftDustPolicy.NO_POLICY;
        signedMessageHeader = toBytes("VpnCoin Signed Message:\n");
    }

    @Override
    @Nullable
    public MessageFactory getMessagesFactory() {
        return VpncoinTxMessage.getFactory();
    }

    private static VpncoinMain instance = new VpncoinMain();
    public static synchronized VpncoinMain get() {
        return instance;
    }
}
