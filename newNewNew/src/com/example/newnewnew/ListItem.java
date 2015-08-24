package com.example.newnewnew;

public class ListItem {

	private String headline;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	@Override
	public String toString() {
		return "headline=" + headline;
	}
}
