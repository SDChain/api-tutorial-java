package com.sdchain.restApi;

import com.sdchain.common.Constant;
import com.sdchain.common.HttpRequestUtils;

import net.sf.json.JSONObject;

public class Transaction {

    
    /**
     * 
     * <h6>Get transaction information.</h6>
     * <pre>
     * Get details of the specified deal based on  transaction hash.
     * </pre>
     * 
     * @param account Transaction hash
     * @return
     */
    public static JSONObject getTransactionDetail(String hash) {
        JSONObject s = HttpRequestUtils.httpGet(Constant.BASE_URL + "/v1/transactions/" + hash);
        return s;
    }
    

}
