package cn.itcast.itcaststore.domain;

public class Msgboard {
private int msg_id;
private String msgcontent;
private String msgdate;
private String username;
private int Status;
private String msgreply;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getStatus() {
	return Status;
}
public void setStatus(int status) {
	Status = status;
}


public Msgboard(int msg_id, String msgcontent, String msgdate, String username, int status, String msgreply) {
	super();
	this.msg_id = msg_id;
	this.msgcontent = msgcontent;
	this.msgdate = msgdate;
	this.username = username;
	Status = status;
	this.msgreply = msgreply;
}
public int getMsg_id() {
	return msg_id;
}

public String getMsgreply() {
	return msgreply;
}
public void setMsgreply(String msgreply) {
	this.msgreply = msgreply;
}
public void setMsg_id(int msg_id) {
	this.msg_id = msg_id;
}
public Msgboard() {
	super();
}

}
