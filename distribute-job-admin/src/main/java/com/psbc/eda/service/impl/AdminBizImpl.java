package com.psbc.eda.service.impl;

import com.psbc.eda.core.thread.JobCompleteHelper;
import com.psbc.eda.core.thread.JobRegistryHelper;
import com.psbc.eda.biz.AdminBiz;
import com.psbc.eda.biz.model.HandleCallbackParam;
import com.psbc.eda.biz.model.RegistryParam;
import com.psbc.eda.biz.model.ReturnT;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuxueli 2017-07-27 21:54:20
 */
@Service
public class AdminBizImpl implements AdminBiz {


    @Override
    public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList) {
        return JobCompleteHelper.getInstance().callback(callbackParamList);
    }

    @Override
    public ReturnT<String> registry(RegistryParam registryParam) {
        return JobRegistryHelper.getInstance().registry(registryParam);
    }

    @Override
    public ReturnT<String> registryRemove(RegistryParam registryParam) {
        return JobRegistryHelper.getInstance().registryRemove(registryParam);
    }

}
