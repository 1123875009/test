package cn.itcast.itcaststore.domain;

public class Notice {
	private int n_id;//公告编码
	private String title;//标题
	private String details;//内容
	private String n_time;//发布时间
	
	public String getN_time() {
		return n_time;
	}
	public void setN_time(String n_time) {
		this.n_time = n_time;
	}
	public int getN_id() {
		return n_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
