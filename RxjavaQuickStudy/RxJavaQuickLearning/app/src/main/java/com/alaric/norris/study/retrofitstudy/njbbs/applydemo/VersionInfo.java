package com.alaric.norris.study.retrofitstudy.njbbs.applydemo;
/**
 *@author py
 *@date 2012-8-2
 *@comment
 */
public class VersionInfo {
	public VersionInfo () {
	}
	public int versionCode;
	public String versionName ;
	public String versionNote ;
	public String iphoneVersion;
	public String apkFileUrl;
	public boolean isForced;
	public int getVersionCode() {
		return versionCode;
	}
	public String getVersionName() {
		return versionName;
	}
	public String getVersionNote() {
		return versionNote;
	}
	public String getIphoneVersion() {
		return iphoneVersion;
	}
	public String getApkFileUrl() {
		return apkFileUrl;
	}
	public boolean isForced() {
		return isForced;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public void setVersionNote(String versionNote) {
		this.versionNote = versionNote;
	}
	public void setIphoneVersion(String iphoneVersion) {
		this.iphoneVersion = iphoneVersion;
	}
	public void setApkFileUrl(String apkFileUrl) {
		this.apkFileUrl = apkFileUrl;
	}
	public void setForced(boolean isForced) {
		this.isForced = isForced;
	}
 
	
	
	
	
	
}
