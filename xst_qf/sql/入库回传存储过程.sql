USE [lxzt]
GO
/****** Object:  StoredProcedure [dbo].[ZXY_GJ_RK_SC_BILL]    Script Date: 08/21/2020 14:19:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER  PROCEDURE  [dbo].[ZXY_GJ_RK_SC_BILL]
--广九入库上传存储过程
    (
        @DANJ_NO varchar(20),--九中通单据号
        @picihao varchar(20),--批次号
        @yx_date varchar(20),--有效日期
        @sc_date varchar(20),--生产日期
        @ss_qty float,--实收数量
        @CHOUY_QTY float,--抽样数量
        @PRICE float,--单价
        @billid varchar(50),--单据编号
        @prec varchar(20),--商品编号
        @Checker varchar(10),--验收人
        @SHR varchar(10),--收货人
        @RIQI_CHAR varchar(20),--日期_字符（验收日期）
        @RUK_TYPE int,--入库类型 1 代表采购入库，3 代表销售退回  34   45
        @zxy_countId int,-- 中间表billid 总数,如果总数等于1 ,证明已经有一条相同billid 的数据返回,,是分批单据,如果等于0,不是分批,第一条记录
        @return_billid int,--存储过程返回billid
        @YANS_RLT int--验收类型 1为合格,2不合格
        )
    as
--重新赋值价格
    if  @RUK_TYPE = 1  -- 等于1 证明是采购入库单
        begin
            select @PRICE = Price from gsp_inbill  where BillID = @billid
            select @zxy_countId = COUNT(id) from qf_inBill_billid  where billid = @billid;
            if @YANS_RLT = 1    -- 如果验收类型为合格处理逻辑
                BEGIN
                    --当入库类型为1时,代表采购入库单,billtype为34
                    if @zxy_countId = 1 -- 当id总数为1时候,证明是分批验收,oldbillid 需要传递当前的billid,billid 需要传递0
                        begin
                            exec @return_billid = zxy_fpys_pro 0,@billid,@picihao,@sc_date,@yx_date,@ss_qty,@PRICE,@RIQI_CHAR,@Checker,@SHR,25
                            update  GSP_InBill set CheckDate = @RIQI_CHAR,Checker = @Checker,SampleQty= @CHOUY_QTY where BillID = @return_billid
                        end
                    else--反之billid 正常传递,oldbillid传递0
                        begin
                            exec @return_billid = zxy_fpys_pro @billid,0,@picihao,@sc_date,@yx_date,@ss_qty,@PRICE,@RIQI_CHAR,@Checker,@SHR,25
                            update  GSP_InBill set CheckDate = @RIQI_CHAR,Checker = @Checker,SampleQty= @CHOUY_QTY  where BillID = @return_billid
                            insert into qf_inBill_billid (billid) values(@billid);
                            update zxy_UpLoadBill set deleted = 1,DELETED_DATE = GETDATE() where billCode = @billid and billtype = 34;
                        end
                END
            if @YANS_RLT = 2 --如果验收类型为不合格类型处理逻辑
                BEGIN
                    update GSP_InBill set BeforeCheckQty = BeforeCheckQty + @ss_qty,JHQty = BeforeCheckQty + @ss_qty,
                                          UnqualifiedQty = @ss_qty,EligibleQty = BeforeCheckQty,
                                          YS_Qty=BeforeCheckQty + @ss_qty
                    where BillID = @billid and Jobnumber = @picihao
                END
            if @YANS_RLT = 3 --如果验收类型为拒收类型处理逻辑
                BEGIN
                    update GSP_InBill set BeforeCheckQty = BeforeCheckQty + @ss_qty,JHQty = BeforeCheckQty + @ss_qty,
                                          YS_BackQty = @ss_qty,YS_Qty=BeforeCheckQty + @ss_qty
                    where BillID = @billid and Jobnumber = @picihao
                END
        end
    if @RUK_TYPE = 4       -- 等于4证明是销售退回单
        begin
            declare @th_hanghao int; -- 退货单据行号
--查询单据行号
            select @th_hanghao = Ord from GSP_BackBill where BillID
                = (Select top 1 billid from GSP_BackBillIndex where Billcode = @billid  order by BillDate desc)
                                                         and PRec = (select rec from ptype where usercode =  @prec and deleted = 0 )
                                                         and Jobnumber = @picihao
            if  (@YANS_RLT = 1)
                begin
                    --当入库类型为4时,代表销售退回,billtype为34
                    update gsp_inbill set EligibleQty = @ss_qty,
                                          Checker = @Checker,CheckDate =@RIQI_CHAR,AcceptDate = @RIQI_CHAR,Accepter = @SHR,YS_SHName =@Checker
                    where billcode = @billid and
                            PRec = (select rec from ptype where usercode =  @prec and deleted = 0 )
                      and Jobnumber = @picihao;
                    --更改中间表标识符
                    update zxy_UpLoadBill set deleted = 1,DELETED_DATE = GETDATE()
                    where billCode = @billid and ord = @th_hanghao and billtype = 45;
                end
            if  (@YANS_RLT = 2)
                begin
                    --当入库类型为4时,代表销售退回,billtype为34，@YANS_RLT为2 时候。证明验收不合格
                    update gsp_inbill set   UnqualifiedQty = @ss_qty,
                                            Checker = @Checker,CheckDate =@RIQI_CHAR ,AcceptDate = @RIQI_CHAR,Accepter = @SHR,YS_SHName =@Checker
                    where billcode = @billid
                      and PRec = (select rec from ptype where usercode =  @prec and deleted = 0 )
                      and Jobnumber = @picihao;
                    --更改中间表标识符
                    update zxy_UpLoadBill set deleted = 1,DELETED_DATE = GETDATE()
                    where billCode = @billid and ord = @th_hanghao and billtype = 45;
                end
        end
