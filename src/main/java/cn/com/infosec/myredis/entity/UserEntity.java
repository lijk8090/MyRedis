package cn.com.infosec.myredis.entity;

public class UserEntity {

	private int uuid;
	private String username;
	private String password;

	public UserEntity() {
		super();
		this.uuid = 6379;
		this.username = "redis";
		this.password = "11111111";
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
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

	@Override
	public String toString() {
		return "UserEntity [uuid=" + uuid + ", username=" + username + ", password=" + password + "]";
	}

}
