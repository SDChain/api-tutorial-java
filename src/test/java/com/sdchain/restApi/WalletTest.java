package com.sdchain.restApi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class WalletTest {
    private static Logger logger = LoggerFactory.getLogger(WalletTest.class); // 日志记录

    @Test
    public void run() throws Exception {
        //获取钱包
        getNewWallet();
        //获取激活钱包
        //activeWallet();
        //查询余额
        //getBalance();
    }

    public void getNewWallet() {
        JSONObject wallet = Wallet.getNewWallet();
        logger.info(wallet.toString());
    }

    public void activeWallet() {
        String account = "6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
        JSONObject activeWallet = Wallet.activeWallet(account);
        logger.info(activeWallet.toString());
    }

    public void getBalance() {
        String account = "6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
        JSONObject getBalance = Wallet.getBalance(account);
        logger.info(getBalance.toString());
    }
}
