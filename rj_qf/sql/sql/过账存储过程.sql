 --郑晓羽新加过账调接口开始
			if (select IFChecked from BillIndex where BillID = @billid) = 1
			begin
			  if @billtype in (6,11,34,45)
				begin
					DECLARE @URLS VARCHAR(100);
					declare @varBillId varchar(200);
					set @varBillId  = (select @BillId+'''')
					SET @URLS = ''qf/qfBillAuditing?billId=''+@varBillId
					EXEC zxy_CallApi @URLS
				end
			end
			--郑晓羽新加过账调接口结束