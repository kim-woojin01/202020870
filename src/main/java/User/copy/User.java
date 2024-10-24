package User.copy;

import java.util.ArrayList;
import java.util.List;


public class User {

		   private String photoSRC;       // 사용자 프로필 사진 경로
		    private String username;       // 사용자 이름
		    private String email;          // 사용자 이메일
		    private String id;             // 사용자 ID
		    private List<String> roles;    // 사용자 역할 (리스트로 저장)
		    private String status;         // 사용자 상태
		    private String password = null;
		    // 기본 생성자
		    public User() {
		        roles = new ArrayList<>(); // roles 리스트 초기화
		    }

		    // photoSRC getter와 setter
		    public String getPhotoSRC() {
		        return photoSRC;
		    }

		    public void setPhotoSRC(String photoSRC) {
		        this.photoSRC = photoSRC;
		    }

		    // username getter와 setter
		    public String getUsername() {
		        return username;
		    }

		    public void setUsername(String username) {
		        this.username = username;
		    }

		    // email getter와 setter
		    public String getEmail() {
		        return email;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }

		    // id getter와 setter
		    public String getId() {
		        return id;
		    }

		    public void setId(String id) {
		        this.id = id;
		    }

		    // roles getter와 setter
		    public List<String> getRoles() {
		        return roles;
		    }

		    public void setRoles(List<String> roles) {
		        this.roles = roles;
		    }

		    // status getter와 setter
		    public String getStatus() {
		        return status;
		    }

		    public void setStatus(String status) {
		        this.status = status;
		    }

		    // 역할을 추가하는 메서드
		    public void addRole(String role) {
		        if (roles == null) {
		            roles = new ArrayList<>();
		        }
		        roles.add(role);
		    }
	}