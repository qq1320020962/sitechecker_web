package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author fengorz ʵ��Serializable�����ã�
 *         ʵ��serializable�ӿڵ������Ǿ��ǿ��԰Ѷ���浽�ֽ�����Ȼ����Իָ����������������Ķ���ûʵ�����л���ô���ܽ������紫����
 *         ��Ҫ���紫��͵�תΪ�ֽ����������ڷֲ�ʽӦ���У���͵�ʵ�����л�������㲻��Ҫ�ֲ�ʽӦ�ã��Ǿ�û�Ǹ���Ҫʵ�����л���
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long uid;//�û���ID
	private String username;//�˺�
	private String password;
	private String name;//�û�����
	private String state;//�û������߻�������״̬��
	private String sex;//�Ա�
	private String post;//ְλ
	private String email;//����
	private String tel;//�绰����
	private int finish_sum;//������������
	public int getFinish_sum() {
		return finish_sum;
	}

	public void setFinish_sum(int finish_sum) {
		this.finish_sum = finish_sum;
	}

	private Date lastlogin;//�ϴε�¼��ʱ��
	private String lastIP;//�ϴ���¼��ip
	private Set<Inspect> inspects;
	private Set<Record> records;
	private Set<Image> imgs;
	
	private Terminal terminal;//�û�������Ա��

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
