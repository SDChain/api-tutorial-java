package com.sdchain.restApi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class PaymentTest {
    private static Logger logger = LoggerFactory.getLogger(PaymentTest.class); // 日志记录

    @Test
    public void run() throws Exception {
        //转账
        payment();
        //转账带备注
        //paymentHasMemos();
        //获取账单
        //getPayments();
        //获取转账详情
        //getPaymentsDetail();
    }

    public void payment() {
        String source_account = "6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
        String secret = "saNYbpu4J3vb9EFcLbR1A3Hhg8kRu";
        String destination_account = "64CuSJKfoo29SbvdGLwEfb8MAPosJSo7Q";
        String num = "0.02";
        JSONObject payment = Payment.payment(source_account, secret, destination_account, num);
        logger.info(payment.toString());
    }

    public void paymentHasMemos() {
        String source_account = "6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
        String secret = "saNYbpu4J3vb9EFcLbR1A3Hhg8kRu";
        String destination_account = "64CuSJKfoo29SbvdGLwEfb8MAPosJSo7Q";
        String num = "0.02";
        String memoString = "This is a memo!";
        JSONObject paymentHasMemos = Payment.paymentHasMemos(source_account, secret, destination_account, num, memoString);
        logger.info(paymentHasMemos.toString());
    }

    public void getPayments() {
        String account = "6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
        JSONObject getPayments = Payment.getPayments(account);
        logger.info(getPayments.toString());
    }

    public void getPaymentsDetail() {
        String account = "6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
        String hash = "711C06B9A602870A0EAE78FB1C175050324EFD579CF46F98D47A857B9623CD5D";
        JSONObject getPaymentsDetail = Payment.getPaymentsDetail(account, hash);
        logger.info(getPaymentsDetail.toString());
    }
}
