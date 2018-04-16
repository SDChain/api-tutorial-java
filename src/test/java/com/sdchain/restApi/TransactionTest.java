package com.sdchain.restApi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class TransactionTest {
    private static Logger logger = LoggerFactory.getLogger(TransactionTest.class); // 日志记录

    @Test
    public void run() throws Exception {
        //获取交易详情
        getTransactionDetail();
    }

    public void getTransactionDetail() {
        String hash = "711C06B9A602870A0EAE78FB1C175050324EFD579CF46F98D47A857B9623CD5D";
        JSONObject getTransactionDetail = Transaction.getTransactionDetail(hash);
        logger.info(getTransactionDetail.toString());
    }

}
