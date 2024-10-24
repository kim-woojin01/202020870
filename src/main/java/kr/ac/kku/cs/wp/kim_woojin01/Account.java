package kr.ac.kku.cs.wp.kim_woojin01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 저작권 (C) 2024 김우진 202020870 모든 권리 보유.
 *
 * 이 소프트웨어는 고급웹프로그래밍 중간고사 코딩 시험 제출용입니다.
 * 이 소프트웨어는 개인적, 교육적 또는 비상업적 목적으로 자유롭게 사용할 수 있습니다.
 * 상업적 사용을 위해서는 타인의 권리를 침해하지 않도록 주의해야 합니다.
 *
 * 연락처: kjwelf@naver.com
 */

/**
 * MessageException
 *
 * @author 김우진 202020870
 * @since 2024. 10. 24.
 * @version 1.0
 */
public class Account extends Exception {

	private String id;
	private String role;
	private List <String> roles;
	private String name;
	private String email;

	
	// username getter와 setter
    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
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
    
    // 단일 String 역할을 설정할 때 사용
    public void setRole(String role) {
        this.roles = Collections.singletonList(role);
    }

    // 콤마로 구분된 여러 역할을 설정할 때 사용
    public void setRolesFromString(String rolesString) {
        this.roles = Arrays.asList(rolesString.split(","));
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}