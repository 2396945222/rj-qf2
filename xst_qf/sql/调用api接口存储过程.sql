CREATE   PROCEDURE [dbo].[zxy_CallApi]
--传递的url,因为是get方式接口,参数直接拼接在url后面就可以
 @URLS varchar(300)
 AS
 BEGIN
    DECLARE @OBJ INT
    DECLARE @URL VARCHAR(500)
    DECLARE @RESPONSE VARCHAR(3000)
    DECLARE @RET VARCHAR(1000)
    SET @URL ='http://zsh-lj.gnway.cc:8028/'+@URLS;
    EXEC SP_OACREATE 'MSXML2.ServerXMLHttp',@OBJ OUT
    EXEC SP_OAMETHOD @OBJ,'Open',NULL,'get',@URL,FALSE
    EXEC SP_OAMETHOD @OBJ,'send'
     --@RET : 0（成功）或非零数字（失败），是由 OLE 自动化对象返回的 HRESULT 整数值。
    EXEC @RET = SP_OAGETPROPERTY @OBJ,'responseText',@RESPONSE OUT
    IF @RET <> 0
        BEGIN
             EXEC sp_OAGetErrorInfo @OBJ
         END
        --select @RET AS 'ret(0即成功)'
    --原本以为这个[d]是返回数据中的一个值(例如这样{"d":"Hello World"}),是必须写[d]的
     --正确的解释是：这个[d]是SELECT 的一个列名,和SELECT GETDATE() AS TIME 中的TIME是一样性质的.指定列名;
    --SELECT @RESPONSE--这个是(无列名)
    --SELECT @RESPONSE[d]
    SELECT @RESPONSE AS 'd'--SELECT @RESPONSE[d] 等于SELECT @RESPONSE AS 'd'
     --释放、销毁
    EXEC SP_OADESTROY @OBJ
 END