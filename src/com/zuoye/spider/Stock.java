package com.zuoye.spider;

import java.io.Serializable;

public class Stock implements Serializable{
	String Code;//代号
	String Name;//名称
	String PreviousClose;//昨收
	String PERation;//市盈率
	String Close;//收盘
	String High;//最高
	String Low;//最低
	String Amount;//成交额
	String Volume;//成交量
	String Change;//涨跌
	String ChangePersent;//涨跌幅
	String Flag;//
	String TBMMType;//竞价类型
	String MarketValue;//总市值
	String Open;//开盘
	public Stock() {
		super();
	}
	public Stock(String code, String name, String previousClose,
			String pERation, String close, String high, String low,
			String amount, String volume, String change, String changePersent,
			String flag, String tBMMType, String marketValue, String open) {
		super();
		Code = code;
		Name = name;
		PreviousClose = previousClose;
		PERation = pERation;
		Close = close;
		High = high;
		Low = low;
		Amount = amount;
		Volume = volume;
		Change = change;
		ChangePersent = changePersent;
		Flag = flag;
		TBMMType = tBMMType;
		MarketValue = marketValue;
		Open = open;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPreviousClose() {
		return PreviousClose;
	}
	public void setPreviousClose(String previousClose) {
		PreviousClose = previousClose;
	}
	public String getPERation() {
		return PERation;
	}
	public void setPERation(String pERation) {
		PERation = pERation;
	}
	public String getClose() {
		return Close;
	}
	public void setClose(String close) {
		Close = close;
	}
	public String getHigh() {
		return High;
	}
	public void setHigh(String high) {
		High = high;
	}
	public String getLow() {
		return Low;
	}
	public void setLow(String low) {
		Low = low;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getVolume() {
		return Volume;
	}
	public void setVolume(String volume) {
		Volume = volume;
	}
	public String getChange() {
		return Change;
	}
	public void setChange(String change) {
		Change = change;
	}
	public String getChangePersent() {
		return ChangePersent;
	}
	public void setChangePersent(String changePersent) {
		ChangePersent = changePersent;
	}
	public String getFlag() {
		return Flag;
	}
	public void setFlag(String flag) {
		Flag = flag;
	}
	public String getTBMMType() {
		return TBMMType;
	}
	public void setTBMMType(String tBMMType) {
		TBMMType = tBMMType;
	}
	public String getMarketValue() {
		return MarketValue;
	}
	public void setMarketValue(String marketValue) {
		MarketValue = marketValue;
	}
	public String getOpen() {
		return Open;
	}
	public void setOpen(String open) {
		Open = open;
	}
	@Override
	public String toString() {
		return "Stock [Code=" + Code + ", Name=" + Name + ", PreviousClose="
				+ PreviousClose + ", PERation=" + PERation + ", Close=" + Close
				+ ", High=" + High + ", Low=" + Low + ", Amount=" + Amount
				+ ", Volume=" + Volume + ", Change=" + Change
				+ ", ChangePersent=" + ChangePersent + ", Flag=" + Flag
				+ ", TBMMType=" + TBMMType + ", MarketValue=" + MarketValue
				+ ", Open=" + Open + "]";
	}
	
}
