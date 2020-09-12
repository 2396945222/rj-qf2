package com.rj.qf.http;

public class InvokeTest {

	public static void main(String[] args) throws Exception {
		InvokeHelper.POST_K3CloudURL = "http://192.168.19.113/K3Cloud/";
		String dbId = "55bb19192ebcde";
		String uid = "Demo";
		String pwd = "888888";
		int lang = 2052;
		
		if (InvokeHelper.Login(dbId, uid, pwd, lang)) {

			// 销售订单保存测试
			// 业务对象Id
			String sFormId = "SAL_SaleOrder";
			//需要保存的数据
			// 如下字段可能需要根据自己实际值做修改
			// FCustId FSalerId FMaterialId FUnitID
			String sContent = "{\"Creator\":\"String\",\"NeedUpDateFields\":[\"FBillTypeID\",\"FDate\",\"FBusinessType\",\"FSaleOrgId\",\"FCustId\",\"FSettleCurrId\",\"FSalerId\",\"SAL_SaleOrder__FSaleOrderEntry\",\"FMaterialId\",\"FSettleOrgIds\",\"FUnitID\",\"FQty\",\"SAL_SaleOrder__FSaleOrderFinance\",\"FSettleCurrId\",\"FLocalCurrId\",\"FIsIncludedTax\",\"FBillTaxAmount\",\"FBillAmount\",\"FBillAllAmount\",\"FExchangeTypeId\",\"FExchangeRate\"],\"Model\":{\"FID\":0,\"FBillTypeID\":{\"FNumber\":\"XSDD01_SYS\"},\"FBusinessType\":\"NORMAL\",\"FSaleOrgId\":{\"FNUMBER\":\"100\"},\"FCustId\":{\"FNUMBER\":\"CUST0001\"},\"FSettleCurrId\":{\"FNUMBER\":\"PRE001\"},\"FSalerId\":{\"FNUMBER\":\"0002\"},\"SAL_SaleOrder__FSaleOrderFinance\":{\"FExchangeRate\":6.8123},\"SAL_SaleOrder__FSaleOrderEntry\":[{\"FMaterialId\":{\"FNUMBER\":\"001\"},\"FSettleOrgIds\":{\"FNUMBER\":\"100\"},\"FUnitID\":{\"FNumber\":\"个\"},\"FQty\":10}]}}";
			InvokeHelper.Save(sFormId, sContent);

			System.out.println("hola success");
		}
	}
}
