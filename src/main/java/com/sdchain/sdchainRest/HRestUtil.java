package com.sdchain.sdchainRest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HRestUtil {

    public static final String BASE_URL = "https://rest-beta.sdchain.io";// 

    /**
     * 
     * <h6>获取新的钱包.</h6>
     * <pre>
     * </pre>
     * 
     * @return
     */
    public static JSONObject getNewWallet() {
        JSONObject s = HttpRequestUtils.httpGet(BASE_URL + "/v1/wallet/new");
        return s;
    }

    /**
     * 
     * <h6>激活钱包.</h6>
     * <pre>
     * 用已有账号向需要激活的钱包地址发送至少5个SDA.
     * </pre>
     * 
     * @param account
     * @return
     */
    public static JSONObject activeWallet(String account) {
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("secret", "saNYbpu4J3vb9EFcLbR1A3Hhg8kRu");// 发币账号私钥
        JSONObject payment = new JSONObject();
        payment.put("source_account", "6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5");// 发币公钥
        payment.put("destination_account", account);
        payment.put("amount", "6");// 激活所需SDA数量
        jsonParam.put("payment", payment);
        System.out.println(jsonParam);
        JSONObject s = HttpRequestUtils
                .httpPost(BASE_URL + "/v1/accounts/payments/6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5?submit=true", jsonParam);
        return s;
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
        JSONObject s = HttpRequestUtils.httpGet(BASE_URL + "/v1/accounts/balances/" + account);
        return s;
    }

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
        JSONObject s = HttpRequestUtils.httpPost(BASE_URL + "/v1/accounts/payments/" + source_account + "?submit=true",
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
        
        // 添加备注
        JSONObject memo = new JSONObject();
        memo.put("MemoType", "memo");
        memo.put("MemoData", memoString);
        JSONArray memos = new JSONArray();
        memos.add(memo);
        payment.put("memos", memos);
        // 添加数量
        payment.put("amount", num);
        jsonParam.put("payment", payment);
        JSONObject s = HttpRequestUtils.httpPost(BASE_URL + "/v1/accounts/payments/" + source_account + "?submit=true",
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
        JSONObject s = HttpRequestUtils.httpGet(BASE_URL + "/v1/accounts/payments/" + account);
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
        JSONObject s = HttpRequestUtils.httpGet(BASE_URL + "/v1/accounts/payments/" + account + "?params=1" + params);
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
        JSONObject s = HttpRequestUtils.httpGet(BASE_URL + "/v1/accounts/payments/" + account + "/" + hash);
        return s;
    }
    
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
        JSONObject s = HttpRequestUtils.httpGet(BASE_URL + "/v1/transactions/" + hash);
        return s;
    }

    public static void main(String[] args) {
        //一般步骤
        //获取账户
        JSONObject walletRes = getNewWallet();
        System.out.println(walletRes);
//    	JSONObject wallet=new JSONObject();
//    	if (Boolean.parseBoolean(walletRes.get("success").toString())) {
//    		wallet = (JSONObject) walletRes.get("wallet");
//		}
//    	
//    	//从获取的信息json 记住钱包的公钥和私钥，并用下面方法进行激活
//    	String account = wallet.get("address").toString();
//    	JSONObject activeWalletRes =activeWallet("64CuSJKfoo29SbvdGLwEfb8MAPosJSo7Q");
//    	System.out.println(activeWalletRes);
//    	//激活完成后可以查询到钱包信息
//    	JSONObject walletBalanceRes = getBalance("64CuSJKfoo29SbvdGLwEfb8MAPosJSo7Q");
//    	System.out.println(walletBalanceRes);
//    	
//    	//钱包激活后，可以用来向其他钱包进行转账(注:转账时需要给双方留至少6个SDA)
//    	String account="6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
//        String secret = "saNYbpu4J3vb9EFcLbR1A3Hhg8kRu";
//    	String accountB = "64CuSJKfoo29SbvdGLwEfb8MAPosJSo7Q";
//    	String num = "6";
//    	JSONObject paymentRes=payment(account, secret, accountB, num);
//    	System.out.println(paymentRes);
//    	
//    	//也可以在转账时加入备注信息
//    	String memo ="这是一个备注";
//    	String account="6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
//        String secret = "saNYbpu4J3vb9EFcLbR1A3Hhg8kRu";
//        String accountB = "64CuSJKfoo29SbvdGLwEfb8MAPosJSo7Q";
//        String num = "6";
//        JSONObject paymentHasMemosRes=paymentHasMemos(account, secret, accountB, num,memo);
//        System.out.println(paymentHasMemosRes);
//    	
//    	
//    	//交易完成后可以查询钱包的交易历史,可加入查询参数，详情见api文档
//    	JSONObject getPaymentsRes=getPayments("6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5");
//    	String params="";
//    	System.out.println(getPaymentsRes);
//    	
//    	//通过六域链地址和hash可以查到指定交易
//        String account="6faLUhmp9gNgS9jXS3rAWbg8hFfi9PbWH5";
//    	String hash="711C06B9A602870A0EAE78FB1C175050324EFD579CF46F98D47A857B9623CD5D";
//    	JSONObject getPaymentsDetailRes=getPaymentsDetail(account,hash);
//    	System.out.println(getPaymentsDetailRes);
    	
    	//通过hash可以查到指定交易
//        String hash="711C06B9A602870A0EAE78FB1C175050324EFD579CF46F98D47A857B9623CD5D";
//        JSONObject getTransactionDetailRes=getTransactionDetail(hash);
//        System.out.println(getTransactionDetailRes);
    }

}
