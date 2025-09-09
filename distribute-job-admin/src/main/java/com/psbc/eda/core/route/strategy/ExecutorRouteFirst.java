package com.psbc.eda.core.route.strategy;

import com.psbc.eda.core.route.ExecutorRouter;
import com.psbc.eda.biz.model.ReturnT;
import com.psbc.eda.biz.model.TriggerParam;

import java.util.List;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteFirst extends ExecutorRouter {

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList) {
        return new ReturnT<String>(addressList.get(0));
    }

}
