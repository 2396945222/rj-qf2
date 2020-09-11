
CREATE PROCEDURE [dbo].[zxy_fpys_pro]
--分批验收
(
    @BillID int,
    @old_BillID int,
    @picihao VARCHAR(50),
    @OutFactoryDate DATETIME = NULL ,--生产日期
    @ValidDate DATETIME = NULL ,--有效期、
    @qty float,
    @price float,
    @djBillDate DATETIME = null,--对接日期
    @ysr VARCHAR(50),--验收人
    @shr varchar(50),--收货人
    @gsp_sign int = 25 --gsp验收状态 （默认不传验收记录）
)
as
declare  @returnBillId int;
    exec @returnBillId = GSP_InsInBill @BillID,
                         default,default,default,@picihao,'',@OutFactoryDate,@ValidDate,
                         @qty,default,default,@price,default,default,@djBillDate,
                         default,default,default,default,default,default,default,default,default,default,@ysr,default,@djBillDate,default,default,default,
                         @gsp_sign,0,default,default,default,default,10,default,default,default,default,default,default,default,default,default,
                         '','','','','',default,'',default,default,default,default,default,'','',NULL,'','',0,@shr,'','',
                         @qty,@old_BillID,default,default,'',default,default,default,@qty,default,'','0',''

    return @returnBillId

go