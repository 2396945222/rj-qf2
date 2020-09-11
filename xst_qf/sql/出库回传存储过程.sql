USE [lxzt]
GO
/****** Object:  StoredProcedure [dbo].[ZXY_XS_CK_SC_BILL]    Script Date: 08/21/2020 17:22:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER  PROCEDURE  [dbo].[ZXY_XS_CK_SC_BILL]
--广九出库上传存储过程
    (
    @Checker varchar(20),-- 复核人
    @cc_qty varchar(20),-- 出库数量
    @pUserCode varchar(20),-- 商品rec
    @RIQI_CHAR varchar(20),-- 复核日期
    @YEW_TYPE int ,--业务类型
    @billcode varchar(20),--单据编号
    @pici varchar(20),--批次号
    @hanghao int --行号
    )
    as
if  @YEW_TYPE = 2--如果是2代表是销售出库上传
    begin
        update GSP_OutBill set Checker = @Checker,Warehouseman = @Checker,OutQty = @cc_qty,
                               CheckDate = @RIQI_CHAR where billcode =@billcode and Ord = @hanghao;
        -- 修改中间库数据为已经获取状态
        update zxy_UpLoadBill set deleted = 1,DELETED_DATE = GETDATE()
        where billCode = @billcode and ord = @hanghao and billtype = 11;
    end

if  @YEW_TYPE = 3--如果是3代表是采购退货
    begin --如果是3代表购进退出
    update GSP_OutBill set Checker = @Checker,Warehouseman = @Checker,OutQty =
        @cc_qty,CheckDate = @RIQI_CHAR where BillCode =@billcode and Ord = @hanghao;
    -- 修改中间库数据为已经获取状态
    update zxy_UpLoadBill set deleted = 1,DELETED_DATE = GETDATE()
    where billCode = @billcode and ord = @hanghao and billtype = 6;
    end

