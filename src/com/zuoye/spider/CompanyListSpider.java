package com.zuoye.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CompanyListSpider implements Runnable{
	String urlString;
	public CompanyListSpider(String url){
		this.urlString = url;
	}
	@Override
	public void run() {
		URL url = null;
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {

			url = new URL(this.urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(is));
			while ((line = buffer.readLine()) != null) {
				sb.append(line);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*System.out.print(sb);*/
		/*JSONObject json = JSONObject.parseObject(sb.toString());*/
		/*System.out.print("\n"+json); */
		/*String jsonArr =json.getString("result"); */
		/*System.out.print("\n"+jsonArr);*/
		 

		// 转为JSON数据格式
		JSONObject job = JSONObject.parseObject(sb.toString());
		/*System.out.println("\n" + job.get("result"));*/ 
		// 取出数组
		JSONArray jarr = (JSONArray) job.get("result");
		 /*System.out.println("\n" + jarr); */

		List<Stock> l = new ArrayList<Stock>();

		for (int i = 0; i < jarr.size(); i++) {
			JSONObject jsonItem = jarr.getJSONObject(i);
			/*System.out.println(jsonItem.getString("Amount")); */
			/*System.out.println(jsonItem);*/

			// 装入数组中
			Stock stock = new Stock();
			stock.setAmount(jsonItem.getString("Amount"));
			stock.setChange(jsonItem.getString("Change"));
			stock.setChangePersent(jsonItem.getString("ChangePersent"));
			stock.setClose(jsonItem.getString("Close"));
			stock.setCode(jsonItem.getString("Code"));
			stock.setFlag(jsonItem.getString("Flag"));
			stock.setLow(jsonItem.getString("Low"));
			stock.setMarketValue(jsonItem.getString("MarketValue"));
			stock.setName(jsonItem.getString("Name"));
			stock.setOpen(jsonItem.getString("Open"));
			stock.setPERation(jsonItem.getString("PERation"));
			stock.setVolume(jsonItem.getString("Volume"));
			stock.setTBMMType(jsonItem.getString("TMMType"));
			System.out.println(stock); 
			StockDao stockDao = new StockDao();
			stockDao.insertStock(stock);
		}
	}
	
	public static void main(String[] args){
		CompanyListSpider cls = 
				new CompanyListSpider(StringUrl.getStockCompanyListUrl("1", "20"));
		cls.run();
		
		
		
		/*URL url = null;
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {

			url = new URL("http://xinsanban.eastmoney.com/api/QuoteCenter/GPGS/GetGPGS?level=1&page=2&pagesize=50&sortType=ChangePercent&sortRule=-1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(is));
			while ((line = buffer.readLine()) != null) {
				sb.append(line);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(sb);
		JSONObject json = JSONObject.parseObject(sb.toString());
		System.out.print("\n"+json); String jsonArr =
		json.getString("result"); System.out.print("\n"+jsonArr);
		 

		// 转为JSON数据格式
		JSONObject job = JSONObject.parseObject(sb.toString());
		 System.out.println("\n" + job.get("result")); 
		// 取出数组
		JSONArray jarr = (JSONArray) job.get("result");
		 System.out.println("\n" + jarr); 

		List<Stock> l = new ArrayList<Stock>();

		for (int i = 0; i < jarr.size(); i++) {
			JSONObject jsonItem = jarr.getJSONObject(i);
			 System.out.println(jsonItem.getString("Amount")); 
			System.out.println(jsonItem);

			// 装入数组中
			Stock stock = new Stock();
			stock.setAmount(jsonItem.getString("Amount"));
			stock.setChange(jsonItem.getString("Change"));
			stock.setChangePersent(jsonItem.getString("ChangePersent"));
			stock.setClose(jsonItem.getString("Close"));
			stock.setCode(jsonItem.getString("Code"));
			stock.setFlag(jsonItem.getString("Flag"));
			stock.setLow(jsonItem.getString("Low"));
			stock.setMarketValue(jsonItem.getString("MarketValue"));
			stock.setName(jsonItem.getString("Name"));
			stock.setOpen(jsonItem.getString("Open"));
			stock.setPERation(jsonItem.getString("PERation"));
			stock.setVolume(jsonItem.getString("Volume"));
			stock.setTBMMType(jsonItem.getString("TMMType"));
			 System.out.println(stock); 
		}*/
	}
}
