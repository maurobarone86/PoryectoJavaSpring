package ttps.spring.model.model;

/**
 * @author manuel
 */
public class Credentials {

    private String token;
    private int exp;
    private String username;
    private Long id;

    public Credentials() {
    }

    public Credentials(String token, int exp, String username, Long unId) {
        this.token = token;
        this.exp = exp;
        this.username = username;
        this.id=unId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
