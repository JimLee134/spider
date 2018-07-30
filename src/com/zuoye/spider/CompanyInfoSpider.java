package com.zuoye.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.swing.text.Document;
import javax.swing.text.html.parser.DocumentParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;


public class CompanyInfoSpider implements Runnable {
	String urlString;

	public CompanyInfoSpider(String url) {
		this.urlString = url;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		String charset = "utf-8";
		String htm_str = null;
		int sec_cont = 1000;
		try {
			URLConnection url_con = url.openConnection();
			url_con.setDoOutput(true);
			url_con.setReadTimeout(10 * sec_cont);
			url_con.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
			InputStream htm_in = url_con.getInputStream();

			htm_str = InputStream2String(htm_in, charset);
			 /*System.out.print(htm_str); */
		} catch (IOException e) {
			e.printStackTrace();
		}
		org.jsoup.nodes.Document doc = Jsoup.parse(htm_str);
		 /*System.out.print(doc); */
		
        List<Element>	right = doc.getElementsByClass("company-page-item-right");
        List<Element> left = doc.getElementsByClass("company-page-item-left");
		/*System.out.println(right);*/
		for(int i=0;i<left.size();i++){
			System.out.println(left.get(i).text()+"  "+right.get(i).text());
		}

	}

	public static String InputStream2String(InputStream in_st, String charset)
			throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(in_st,
				charset));
		StringBuffer res = new StringBuffer();
		String line = "";
		while ((line = buff.readLine()) != null) {
			res.append(line);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		CompanyInfoSpider cis = new CompanyInfoSpider(
				StringUrl.getStockCompanyInfoUrl("832500"));
		cis.run();
	}
}