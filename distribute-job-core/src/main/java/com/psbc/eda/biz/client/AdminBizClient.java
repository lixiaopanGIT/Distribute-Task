package com.psbc.eda.biz.client;

import com.psbc.eda.biz.AdminBiz;
import com.psbc.eda.biz.model.HandleCallbackParam;
import com.psbc.eda.biz.model.RegistryParam;
import com.psbc.eda.biz.model.ReturnT;
import com.psbc.eda.util.DistributeJobRemotingUtil;

import java.util.List;

public class AdminBizClient implements AdminBiz {

    public AdminBizClient() {
    }

    public AdminBizClient(String addressUrl, String accessToken) {
        this.addressUrl = addressUrl;
        this.accessToken = accessToken;

        // valid
        if (!this.addressUrl.endsWith("/")) {
            this.addressUrl = this.addressUrl + "/";
        }
    }

    private String addressUrl;
    private String accessToken;
    private int timeout = 3;


    @Override
    public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList) {
        return DistributeJobRemotingUtil.postBody(addressUrl + "api/callback", accessToken, timeout, callbackParamList, String.class);
    }

    @Override
    public ReturnT<String> registry(RegistryParam registryParam) {
        return DistributeJobRemotingUtil.postBody(addressUrl + "api/registry", accessToken, timeout, registryParam, String.class);
    }

    @Override
    public ReturnT<String> registryRemove(RegistryParam registryParam) {
        return DistributeJobRemotingUtil.postBody(addressUrl + "api/registryRemove", accessToken, timeout, registryParam, String.class);
    }

}
