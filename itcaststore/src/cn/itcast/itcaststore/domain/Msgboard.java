package cn.itcast.itcaststore.domain;

public class Msgboard {
private String msgcontent;
private String msgdate;
private User user;
public String getMsgcontent() {
	return msgcontent;
}
public void setMsgcontent(String msgcontent) {
	this.msgcontent = msgcontent;
}
public String getMsgdate() {
	return msgdate;
}
public void setMsgdate(String msgdate) {
	this.msgdate = msgdate;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Msgboard(String msgcontent, String msgdate, User user) {
	super();
	this.msgcontent = msgcontent;
	this.msgdate = msgdate;
	this.user = user;
}
public Msgboard() {
	super();
}

}
