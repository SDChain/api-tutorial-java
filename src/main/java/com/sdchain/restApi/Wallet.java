package com.sdchain.restApi;

import com.sdchain.common.Constant;
import com.sdchain.common.HttpRequestUtils;

import net.sf.json.JSONObject;

public class Wallet {
    /**
     * 
     * <h6>Generate New Wallet.</h6>
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
     * <h6>Activate wallet.</h6>
     * <pre>
     * Send at least 6 SDAs to the wallet address that needs to be activated using an existing account.
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
     * <h6>Get wallet balance.</h6>
     * <pre>
     * Get wallet balance.
     * </pre>
     * 
     * @param account SDChain address
     * @return
     */
    public static JSONObject getBalance(String account) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/accounts/balances/" + account);
        return s;
    }

}
