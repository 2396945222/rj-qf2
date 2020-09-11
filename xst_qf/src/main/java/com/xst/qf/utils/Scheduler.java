package com.xst.qf.utils;

import com.xst.qf.Thread.CGBackBillThread;
import com.xst.qf.Thread.CGBillThread;
import com.xst.qf.Thread.XSBackBillThread;
import com.xst.qf.Thread.XSBillThread;
import com.xst.qf.dao.BuyBillDao;
import com.xst.qf.dao.SaleBillDao;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.service.GetService.GetInStockService;
import com.xst.qf.service.GetService.GetOutStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 　* @description:定时任务
 * 　* @author zxy
 * 　* @date 2020-07-22 16:51
 */
@Component
@Slf4j
public class Scheduler{
    public static int TAG = 0;
    @Autowired
    private ZxyUploadbillDao zxyUploadbillDao;//中间表dao
    @Autowired
    private BuyBillDao buyBillDao;//采购dao
    @Autowired
    private SaleBillDao saleBillDao;//销售dao
    @Autowired
    private GetInStockService getInStockService;//获取九州通入库单信息
    @Autowired
    private GetOutStockService getOutStockService;//获取九州通出库单信息
    //TODO 300000秒执行一次（每5分钟执行一次。）
    @Scheduled(fixedRate = 300000)
    public void testTasks() {
        TAG = TAG + 1;//开启程序不需要执行,加入TAG限制执行
        //不需要多线程,按顺序执行即可
        if (TAG > 0) {
            log.info("当前定时任务执行次数" + TAG);
            //采购线程
            CGBillThread cgBillThread = new CGBillThread(zxyUploadbillDao,buyBillDao,getInStockService);
            Thread CGThread =new Thread(cgBillThread);
            //销售线程
            XSBillThread xsBillThread = new XSBillThread(zxyUploadbillDao,saleBillDao,getOutStockService);
            Thread XSThread =new Thread(xsBillThread);
            //采购退货线程
            CGBackBillThread cgBackBillThread = new CGBackBillThread(zxyUploadbillDao,saleBillDao,getOutStockService);
            Thread CGBackThread =new Thread(cgBackBillThread);
            //销售退货线程
            XSBackBillThread xsBackBillThread = new XSBackBillThread(zxyUploadbillDao,buyBillDao,getInStockService);
            Thread XSBackThread =new Thread(xsBackBillThread);
            //开启线程
            XSThread.start();
            CGThread.start();
            CGBackThread.start();
            XSBackThread.start();
        }
    }

}
