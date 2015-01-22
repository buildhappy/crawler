package com.appCrawler.pagePro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


import us.codecraft.webmagic.Apk;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 机锋论坛http://apk.gfan.com/
 * jiFengLunTanPagePro
 * @author Administrator
 *
 */
public class ApkGfan implements PageProcessor{
	Site site = Site.me().setCharset("utf-8").setRetryTimes(0).setSleepTime(300);
	@Override
	public Apk process(Page page) {
		//index page
		if(page.getUrl().regex("http://apk\\.gfan\\.com/search/*").match()){
			//app的具体介绍页面											
			List<String> url1 = page.getHtml().links("//div[@class='list-page']").regex("http://apk\\.gfan\\.com/.*").all();
			System.out.println("after get url1");
			//添加下一页url(翻页)
			List<String> url2 = page.getHtml().links("//div[@class='page_bar']").regex("http://apk\\.gfan\\.com/search/.*").all();
			url1.addAll(url2);
			
			//remove the duplicate urls in list
			HashSet<String> urlSet = new HashSet<String>(url1);
			
			//add the urls to page
			Iterator<String> it = urlSet.iterator();
			while(it.hasNext()){
				page.addTargetRequest(it.next());
			}
		}
		
		//the app detail page
		if(page.getUrl().regex("http://apk\\.gfan\\.com/Product/*").match()){
			Apk apk = null;
			String appName = null;				//app名字
			String appDetailUrl = null;			//具体页面url
			String appDownloadUrl = null;		//app下载地址
			String osPlatform = null ;			//运行平台
			String appVersion = null;			//app版本
			String appSize = null;				//app大小
			String appUpdateDate = null;		//更新日期
			String appType = null;				//下载的文件类型 apk？zip？rar？
			String appvender = null;			//app开发者  APK这个类中尚未添加
			
			appName =page.getHtml().xpath("//h4[@class='curr-tit']/text()").toString();
			appDetailUrl = page.getUrl().toString();
			appDownloadUrl = page.getHtml().xpath("//div[@class='app-view-bt']/a/@href").toString();
			osPlatform = null;
				String versionString = page.getHtml().xpath("//div[@class='app-info']/p[1]/text()").toString();
				System.out.println("versionString="+versionString+"start="+versionString.indexOf("：")+" end="+versionString.length());
			appVersion = versionString.substring(versionString.indexOf("：")+1,versionString.length());
				String sizeString = page.getHtml().xpath("//div[@class='app-info']/p[4]/text()").toString();
			appSize = sizeString.substring(sizeString.indexOf("：")+1,sizeString.length());
				String updatedateString = page.getHtml().xpath("//div[@class='app-info']/p[3]/text()").toString();
			appUpdateDate = updatedateString.substring(updatedateString.indexOf("：")+1,updatedateString.length());
			appType = "apk";
				String venderString = page.getHtml().xpath("//div[@class='app-info']/p[2]/text()").toString();
			appvender = venderString.substring(venderString.indexOf("：")+1,venderString.length());
		
			if(appName != null && appDownloadUrl != null){
				apk = new Apk(appName,appDetailUrl,appDownloadUrl,osPlatform ,appVersion,appSize,appUpdateDate,appType,null);
			}
			
			return apk;
		}
		
		return null;

	}

	@Override
	public Site getSite() {
		return site;
	}

}
