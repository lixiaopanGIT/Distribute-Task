package com.psbc.eda.biz;

import com.psbc.eda.biz.model.IdleBeatParam;
import com.psbc.eda.biz.model.KillParam;
import com.psbc.eda.biz.model.LogParam;
import com.psbc.eda.biz.model.LogResult;
import com.psbc.eda.biz.model.ReturnT;
import com.psbc.eda.biz.model.TriggerParam;

/**
 * Created by xuxueli on 17/3/1.
 */
public interface ExecutorBiz {

    /**
     * beat
     *
     * @return
     */
    public ReturnT<String> beat();

    /**
     * idle beat
     *
     * @param idleBeatParam
     * @return
     */
    public ReturnT<String> idleBeat(IdleBeatParam idleBeatParam);

    /**
     * run
     *
     * @param triggerParam
     * @return
     */
    public ReturnT<String> run(TriggerParam triggerParam);

    /**
     * kill
     *
     * @param killParam
     * @return
     */
    public ReturnT<String> kill(KillParam killParam);

    /**
     * log
     *
     * @param logParam
     * @return
     */
    public ReturnT<LogResult> log(LogParam logParam);

}
