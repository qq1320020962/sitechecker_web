package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author fengorz 实现Serializable的作用：
 *         实现serializable接口的作用是就是可以把对象存到字节流，然后可以恢复。所以你想如果你的对象没实现序列化怎么才能进行网络传输呢
 *         ，要网络传输就得转为字节流，所以在分布式应用中，你就得实现序列化，如果你不需要分布式应用，那就没那个必要实现序列化。
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;//用户的ID
	private String username;//账号
	private String password;
	private String name;//用户名字
	private String state;//用户的在线或者离线状态。
	private String sex;//性别
	private String post;//职位
	private String email;//邮箱
	private String tel;//电话号码
	private int finish_sum;//完成任务的数量
	public int getFinish_sum() {
		return finish_sum;
	}

	public void setFinish_sum(int finish_sum) {
		this.finish_sum = finish_sum;
	}

	private Date lastlogin;//上次登录的时间
	private String lastIP;//上传登录的ip
	private Set<Inspect> inspects;
	private Set<Record> records;
	private Set<Image> imgs;
	
	private Terminal terminal;//用户所处的员工

	public Set<Image> getImgs() {
		return imgs;
	}

	public void setImgs(Set<Image> imgs) {
		this.imgs = imgs;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLastIP() {
		return lastIP;
	}

	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}

	public Set<Inspect> getInspects() {
		return inspects;
	}

	public void setInspects(Set<Inspect> inspects) {
		this.inspects = inspects;
	}

	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

}
