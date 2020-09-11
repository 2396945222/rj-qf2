
CREATE TABLE [dbo].[zxy_UpLoadBill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[billCode] [varchar](100) NULL,
	[ord] [int] NULL,
	[billtype] [int] NOT NULL,
	[Create_date] [datetime] NULL,
	[deleted] [int] NOT NULL,
	[DELETED_DATE] [datetime] NULL,
	[ysjl_flags] [int] NULL,
	[GETYSJL_DATE] [datetime] NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON, FILLFACTOR = 100) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'行号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'zxy_UpLoadBill', @level2type=N'COLUMN',@level2name=N'ord'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'单据类型
11：销售单
34：采购单
6 ：采购退货单
45：销售退货单' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'zxy_UpLoadBill', @level2type=N'COLUMN',@level2name=N'billtype'
GO

ALTER TABLE [dbo].[zxy_UpLoadBill] ADD  DEFAULT (getdate()) FOR [Create_date]
GO

ALTER TABLE [dbo].[zxy_UpLoadBill] ADD  CONSTRAINT [DF_zxy_UpLoadBill_deleted]  DEFAULT ((0)) FOR [deleted]
GO

ALTER TABLE [dbo].[zxy_UpLoadBill] ADD  CONSTRAINT [DF_zxy_UpLoadBill_ysjl_flags]  DEFAULT ((0)) FOR [ysjl_flags]
GO


