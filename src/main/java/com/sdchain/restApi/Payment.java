package com.sdchain.restApi;

import com.sdchain.common.Constant;
import com.sdchain.common.HttpRequestUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Payment {

    /**
     * 
     * <h6>支付.</h6>
     * <pre>
     * 支付.
     * </pre>
     * 
     * @param source_account 六域链支付地址
     * @param secret 六域链支付地址的秘钥
     * @param destination_account 六域链收款地址
     * @param num 数量
     * @return
     */
    public static JSONObject payment(String source_account, String secret, String destination_account, String num) {
        JSONObject jsonParam = new JSONObject();
        // 添加秘钥
        jsonParam.put("secret", secret);
        // 添加支付信息
        JSONObject payment = new JSONObject();
        // 添加支付账号
        payment.put("source_account", source_account);
        // 添加收款账号
        payment.put("destination_account", destination_account);
        // 添加数量
        payment.put("amount", num);
        jsonParam.put("payment", payment);
        JSONObject s = HttpRequestUtils.httpPost(Constant.BASE_URL + "/v1/accounts/payments/" + source_account + "?submit=true",
                jsonParam);
        return s;
    }

    /**
     * 
     * <h6>支付(带有备注).</h6>
     * <pre>
     * 支付(带有备注).
     * </pre>
     * 
     * @param source_account 六域链支付地址
     * @param secret 六域链支付地址的秘钥
     * @param destination_account 六域链收款地址
     * @param num 数量
     * @param memoString 备注
     * @return
     */
    public static JSONObject paymentHasMemos(String source_account, String secret, String destination_account,
            String num, String memoString) {
        JSONObject jsonParam = new JSONObject();
        // 添加秘钥
        jsonParam.put("secret", secret);

        // 添加支付信息
        JSONObject payment = new JSONObject();
        // 添加支付账号
        payment.put("source_account", source_account);
        // 添加收款账号
        payment.put("destination_account", destination_account);
        // 添加数量
        payment.put("amount", num);
        // 添加备注
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
     * <h6>获取账户的账单.</h6>
     * <pre>
     * 获取指定六域链钱包的交易历史.
     * </pre>
     * 
     * @param account 六域链地址
     * @return
     */
    public static JSONObject getPayments(String account) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/payments/" + account);
        return s;
    }

    /**
     * 
     * <h6>获取账户的账单.</h6>
     * <pre>
     * 获取指定六域链钱包的交易历史.
     * </pre>
     * 
     * @param account 六域链地址
     * @param params 可选参数（详情见api文档）
     * @return
     */
    public static JSONObject getPayments(String account, String params) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/payments/" + account + "?params=1" + params);
        return s;
    }

    /**
     * 
     * <h6>获取交易详情.</h6>
     * <pre>
     * 根据六域链地址和交易hash获取指定交易的详情.
     * </pre>
     * 
     * @param account 六域链地址
     * @param account 交易hash
     * @return
     */
    public static JSONObject getPaymentsDetail(String account, String hash) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/payments/" + account + "/" + hash);
        return s;
    }

}
