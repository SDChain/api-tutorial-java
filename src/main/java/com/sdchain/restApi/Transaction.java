package com.sdchain.restApi;

import com.sdchain.common.Constant;
import com.sdchain.common.HttpRequestUtils;

import net.sf.json.JSONObject;

public class Transaction {

    
    /**
     * 
     * <h6>获取交易详情.</h6>
     * <pre>
     * 根据交易hash获取指定交易的详情.
     * </pre>
     * 
     * @param account 交易hash
     * @return
     */
    public static JSONObject getTransactionDetail(String hash) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/transactions/" + hash);
        return s;
    }
    

}
