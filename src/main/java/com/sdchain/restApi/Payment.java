package com.sdchain.restApi;

import com.sdchain.common.Constant;
import com.sdchain.common.HttpRequestUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Payment {

    /**
     * 
     * <h6>Payment.</h6>
     * <pre>
     * Payment.
     * </pre>
     * 
     * @param source_account SDChain payment address
     * @param secret Key of SDChain payment address
     * @param destination_account SDChain receipt address
     * @param num Amount
     * @return
     */
    public static JSONObject payment(String source_account, String secret, String destination_account, String num) {
        JSONObject jsonParam = new JSONObject();
        // Add payment secret
        jsonParam.put("secret", secret);
        // Add payment information
        JSONObject payment = new JSONObject();
        // Add payment address
        payment.put("source_account", source_account);
        // Add receipt address
        payment.put("destination_account", destination_account);
        // Add amount
        payment.put("amount", num);
        jsonParam.put("payment", payment);
        JSONObject s = HttpRequestUtils.httpPost(Constant.BASE_URL + "/v1/accounts/payments/" + source_account + "?submit=true",
                jsonParam);
        return s;
    }

    /**
     * 
     * <h6>Payment(Memos).</h6>
     * <pre>
     * Payment(Memos).
     * </pre>
     * 
     * @param source_account SDChain payment address
     * @param secret Key of SDChain payment address
     * @param destination_account SDChain receipt address
     * @param num Amount
     * @param memoString Memos
     * @return
     */
    public static JSONObject paymentHasMemos(String source_account, String secret, String destination_account,
            String num, String memoString) {
        JSONObject jsonParam = new JSONObject();
        //  Add payment secret
        jsonParam.put("secret", secret);

        // Add payment information
        JSONObject payment = new JSONObject();
        // Add payment address
        payment.put("source_account", source_account);
        // Add receipt address
        payment.put("destination_account", destination_account);
        // Add amount
        payment.put("amount", num);
        // Add memos
        JSONObject memo = new JSONObject();
        memo.put("MemoType", "memo");
        memo.put("MemoData", memoString);
        JSONArray memos = new JSONArray();
        memos.add(memo);
        payment.put("memos", memos);

        jsonParam.put("payment", payment);
        JSONObject s = HttpRequestUtils.httpPost(Constant.BASE_URL + "/v1/accounts/payments/" + source_account + "?submit=true",
                jsonParam);
        return s;
    }

    /**
     * 
     * <h6>Get payments history.</h6>
     * <pre>
     * Get transaction history for a specified SDChain wallet.
     * </pre>
     * 
     * @param account SDChain address
     * @return
     */
    public static JSONObject getPayments(String account) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/payments/" + account);
        return s;
    }

    /**
     * 
     * <h6>Get payments history.</h6>
     * <pre>
     * Get transaction history for a specified SDChain wallet.
     * </pre>
     * 
     * @param account SDChain address
     * @param params 
     * @return
     */
    public static JSONObject getPayments(String account, String params) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/payments/" + account + "?params=1" + params);
        return s;
    }

    /**
     * 
     * <h6>Get payment information.</h6>
     * <pre>
     * Get details of the specified deal based on SDChain address and transaction hash.
     * </pre>
     * 
     * @param account SDChain address
     * @param hash Transaction hash
     * @return
     */
    public static JSONObject getPaymentsDetail(String account, String hash) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/payments/" + account + "/" + hash);
        return s;
    }

}
