package com.xxl.job.adminbiz;

import com.psbc.eda.biz.AdminBiz;
import com.psbc.eda.biz.client.AdminBizClient;
import com.psbc.eda.biz.model.HandleCallbackParam;
import com.psbc.eda.biz.model.RegistryParam;
import com.psbc.eda.biz.model.ReturnT;
import com.psbc.eda.context.DistributeJobContext;
import com.psbc.eda.enums.RegistryConfig;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * admin api test
 *
 * @author xuxueli 2017-07-28 22:14:52
 */
public class AdminBizTest {

    // admin-client
    private static String addressUrl = "http://127.0.0.1:8080/xxl-job-admin/";
    private static String accessToken = null;


    @Test
    public void callback() throws Exception {
        AdminBiz adminBiz = new AdminBizClient(addressUrl, accessToken);

        HandleCallbackParam param = new HandleCallbackParam();
        param.setLogId(1);
        param.setHandleCode(DistributeJobContext.HANDLE_CODE_SUCCESS);

        List<HandleCallbackParam> callbackParamList = Arrays.asList(param);

        ReturnT<String> returnT = adminBiz.callback(callbackParamList);

        assertTrue(returnT.getCode() == ReturnT.SUCCESS_CODE);
    }

    /**
     * registry executor
     *
     * @throws Exception
     */
    @Test
    public void registry() throws Exception {
        AdminBiz adminBiz = new AdminBizClient(addressUrl, accessToken);

        RegistryParam registryParam = new RegistryParam(RegistryConfig.RegistType.EXECUTOR.name(), "xxl-job-executor-example", "127.0.0.1:9999");
        ReturnT<String> returnT = adminBiz.registry(registryParam);

        assertTrue(returnT.getCode() == ReturnT.SUCCESS_CODE);
    }

    /**
     * registry executor remove
     *
     * @throws Exception
     */
    @Test
    public void registryRemove() throws Exception {
        AdminBiz adminBiz = new AdminBizClient(addressUrl, accessToken);

        RegistryParam registryParam = new RegistryParam(RegistryConfig.RegistType.EXECUTOR.name(), "xxl-job-executor-example", "127.0.0.1:9999");
        ReturnT<String> returnT = adminBiz.registryRemove(registryParam);

        assertTrue(returnT.getCode() == ReturnT.SUCCESS_CODE);

    }

}
