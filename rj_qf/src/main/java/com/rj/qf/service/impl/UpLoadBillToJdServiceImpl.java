package com.rj.qf.service.impl;
import com.rj.qf.bean.common.ResultData;
import com.rj.qf.dao.UtilsDao;
import com.rj.qf.service.UpLoadBillToJdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class UpLoadBillToJdServiceImpl implements UpLoadBillToJdService {
    @Autowired
    private UtilsDao utilsDao;

    @Override
    public synchronized ResultData upLoadBill(int billId) {
        //   34 采购 11 销售 6 采购退货   45 销售退货
        Integer billType = utilsDao.getBillTypeByBillId(billId);
        if(billType == null){
            return  new ResultData(0,"单据["+billId+"]不存在",null);
        }
        log.info("单据类型为:"+billType);
        return new ResultData(1,"上传单据成功",null);
    }
}
