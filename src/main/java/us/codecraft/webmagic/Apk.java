package us.codecraft.webmagic;

import java.util.UUID;

/**
 * the class for apk
 * @author Administrator
 *
 */
public class Apk {
	private String appName;
	private String appDetailUrl;
	private String appDownloadUrl;
	private String osPlatform ;
	private String appVersion;
	private String appSize;
	private String appUpdateDate;
	private String appType;
	private String appDownloadedTime;
	private String cookie;
	private String appCrawlTime;//the timestamp of crawling app
	private String channelId;//the channel id of app

	/**
	 * create an apk object with the following parameter
	 * @param appName
	 * @param appDetailUrl
	 * @param appDownloadUrl
	 * @param osPlatform
	 * @param appVersion
	 * @param appSize
	 * @param appUpdateDate
	 * @param appType
	 * @param appDownloadedTime
	 * @param cookie
	 */
	public Apk(String appName,String appDetailUrl,String appDownloadUrl,String osPlatform ,
			String appVersion,String appSize,String appUpdateDate, String appType,String appDownloadedTime ,String cookie){	
		init();
		create(appName,appDetailUrl, appDownloadUrl, osPlatform,appVersion,
				appSize,appUpdateDate, appType,appDownloadedTime,cookie);
	}
	
	/**
	 * create an apk object with the following parameter
	 * @param appName
	 * @param appDetailUrl
	 * @param appDownloadUrl
	 * @param osPlatform
	 * @param appVersion
	 * @param appSize
	 * @param appUpdateDate
	 * @param appDownloadedTime
	 * @param appType
	 */
	public Apk(String appName,String appDetailUrl,String appDownloadUrl,String osPlatform ,
			String appVersion,String appSize,String appUpdateDate, String appType , String appDownloadedTime){
		init();
		create(appName,appDetailUrl, appDownloadUrl, osPlatform,appVersion,
				appSize,appUpdateDate, appType , appDownloadedTime,null);
	}
	
	/**
	 * create an apk object with the following parameter
	 * @param appName
	 * @param appDetailUrl
	 * @param appDownloadUrl
	 * @param osPlatform
	 * @param appVersion
	 * @param appSize
	 * @param appUpdateDate
	 * @param appDownloadedTime
	 */
	public Apk(String appName,String appDetailUrl,String appDownloadUrl,String osPlatform ,
			String appVersion,String appSize,String appUpdateDate , String appDownloadedTime){
		init();
		create(appName,appDetailUrl, appDownloadUrl, osPlatform,appVersion,
				appSize,appUpdateDate, appDownloadedTime,null,null);
	}
	
	/**
	 * create an apk object with the following parameter
	 * @param appName
	 * @param appDetailUrl
	 * @param appDownloadUrl
	 * @param osPlatform
	 * @param appVersion
	 * @param appSize
	 * @param appUpdateDate
	 */
	public Apk(String appName,String appDetailUrl,String appDownloadUrl,String osPlatform ,
			String appVersion,String appSize , String appUpdateDate){
		init();
		create(appName,appDetailUrl, appDownloadUrl, osPlatform,appVersion,
				appSize,appUpdateDate,null, null,null);
	}
	/**
	 * create an apk object with the following parameter
	 * @param appName
	 * @param appDetailUrl
	 * @param appDownloadUrl
	 * @param osPlatform
	 * @param appVersion
	 * @param appSize
	 */
	public Apk(String appName,String appDetailUrl,String appDownloadUrl,String osPlatform ,
			String appVersion,String appSize){
		init();
		create(appName,appDetailUrl, appDownloadUrl, osPlatform,appVersion,appSize,
				null,null, null,null);
	}
	private void init(){
		this.appCrawlTime = String.valueOf(System.currentTimeMillis());
	}
	public void create(String appName,String appDetailUrl,String appDownloadUrl,String osPlatform ,
			String appVersion,String appSize,String appUpdateDate, String appType,String appDownloadedTime , String cookie){
		init();
		this.appName = appName;
		this.appVersion = appVersion;
		this.appType = appType;
		this.appSize = appSize;
		this.appUpdateDate = appUpdateDate;
		this.osPlatform = osPlatform;
		this.appDetailUrl = appDetailUrl;
		this.appDownloadUrl = appDownloadUrl;
		this.appDownloadedTime = appDownloadedTime;
		this.cookie = cookie;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAppSize() {
		return appSize;
	}

	public void setAppSize(String appSize) {
		this.appSize = appSize;
	}

	public String getAppUpdateDate() {
		return appUpdateDate;
	}

	public void setAppUpdateDate(String appUpdateDate) {
		this.appUpdateDate = appUpdateDate;
	}

	public String getOsPlatform() {
		return osPlatform;
	}

	public void setOsPlatform(String osPlatform) {
		this.osPlatform = osPlatform;
	}

	public String getAppDetailUrl() {
		return appDetailUrl;
	}

	public void setAppDetailUrl(String appDetailUrl) {
		this.appDetailUrl = appDetailUrl;
	}

	public String getAppDownloadUrl() {
		return appDownloadUrl;
	}

	public void setAppDownloadUrl(String appDownloadUrl) {
		this.appDownloadUrl = appDownloadUrl;
	}
	public String getAppCrawlTime() {
		return appCrawlTime;
	}

	public void setAppCrawlTime(String appCrawlTime) {
		this.appCrawlTime = appCrawlTime;
	}
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	public String getAppDownloadedTime() {
		return appDownloadedTime;
	}

	public void setAppDownloadedTime(String appDownloadedTime) {
		this.appDownloadedTime = appDownloadedTime;
	}
	
	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	@Override
	public String toString(){
		return "uuid:" + UUID.randomUUID().toString() + ",name:" + this.appName;
	}
	
	public static void main(String[] args){
		System.out.println(UUID.randomUUID().toString());
	}

}
