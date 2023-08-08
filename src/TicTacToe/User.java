package TicTacToe;
import java.time.LocalDateTime;

public class User {
	private String userName;
	private final String userId ;
	public User(String userName) {
		super();
		this.userName = userName;
		this.userId = LocalDateTime.now().toString();
	}
	public User() {
		this.userId = LocalDateTime.now().toString();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
}
