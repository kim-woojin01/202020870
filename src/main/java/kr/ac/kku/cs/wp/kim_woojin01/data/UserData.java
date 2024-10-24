package kr.ac.kku.cs.wp.kim_woojin01.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import User.User;

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

public class UserData extends Exception {

    // 싱글톤 인스턴스
    private static UserData THIS;

    // 유저 데이터를 저장하는 맵
    private Map<String, User> users;

    // private 생성자 (싱글톤)
    private UserData() {
        this.initData();
    }



    // 초기 데이터 설정
    private void initData() {
        users = new HashMap<>();  // Map을 HashMap으로 초기화

        String[] sNames = {"김구", "안창호", "안중근", "유관순", "홍범도", "김좌진", "남자현", "윤봉길", "이봉창", "김원봉"};
        String[] sEmails = {"kim1@kku.ac.kr", "an1@kku.ac.kr", "an2@kku.ac.kr", "yu@kku.ac.kr",
                            "hong@kku.ac.kr", "kim2@kku.ac.kr", "nam@kku.ac.kr", "yun1@kku.ac.kr",
                            "lee@kku.ac.kr", "kim3@kku.ac.kr"};

        String[] sRoles = {"관리자", "개발자", "시스템관리자"};

        // 유저 객체 생성 및 맵에 추가
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setPhotoSRC("https://via.placeholder.com/150");
            user.setUsername(sNames[(i + 1) % 10]);
            user.setEmail(sEmails[(i + 1) % 10]);
            user.setId("kku_" + (1000 + i));

            // 역할 리스트 설정
            List<String> roles = new ArrayList<>();
            roles.add(sRoles[(i + 2) % 3]);
            roles.add(sRoles[(i + 1) % 3]);
            user.setRoles(roles);

            user.setStatus("재직중");

            // 유저 객체를 Map에 추가 (ID를 키로 사용)
            users.put(user.getId(), user);
        }
    }

    // Map 데이터 반환
    public Map<String, User> getData() {
        return users;
    }
    
 // 싱글톤 인스턴스 반환
    public static synchronized UserData getInstance() {
        if (THIS == null) {
            THIS = new UserData();
        }
        return THIS;
    }
}