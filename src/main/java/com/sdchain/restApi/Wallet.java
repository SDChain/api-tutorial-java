package com.sdchain.restApi;

import com.sdchain.common.Constant;
import com.sdchain.common.HttpRequestUtils;

import net.sf.json.JSONObject;

public class Wallet {
    /**
     * 
     * <h6>获取新的钱包.</h6>
     * <pre>
     * </pre>
     * 
     * @return
     */
    public static JSONObject getNewWallet() {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/wallet/new");
        return s;
    }

    /**
     * 
     * <h6>激活钱包.</h6>
     * <pre>
     * 用已有账号向需要激活的钱包地址发送至少6个SDA.
     * </pre>
     * 
     * @param account
     * @return
     */
    public static JSONObject activeWallet(String account) {
        return Payment.payment("6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5", "saNYbpu4J3vb9EFcLbR1A3Hhg8kRu", account, "6");
    }

    /**
     * 
     * <h6>查询钱包余额.</h6>
     * <pre>
     * 查询钱包余额.
     * </pre>
     * 
     * @param account 需要查询的六域链地址
     * @return
     */
    public static JSONObject getBalance(String account) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/balances/" + account);
        return s;
    }

}
