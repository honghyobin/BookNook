// Database.java
package project;

import java.sql.*;

public class Database {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost/study?serverTimezone=Asia/Seoul";
    String user = "root";
    String passwd = "0000";

    private String currentUserId;
    private String currentUserPassword;

    Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
            System.out.println("MySQL 서버 연동 성공");
        } catch (Exception e) {
            System.out.println("MySQL 서버 연동 실패 > " + e.toString());
        }
    }

    public String getCurrentUserID() {
        return currentUserId;
    }

    public String getCurrentUserPassword() {
        return currentUserPassword;
    }

    private void setCurrentUser(String userId, String password) {
        currentUserId = userId;
        currentUserPassword = password;
    }

    /* 로그인 정보를 확인 */
    boolean logincheck(String _i, String _p) {
        boolean flag = false;

        String id = _i;
        String pw = _p;

        try {
            String checkingStr = "SELECT password FROM booknook WHERE id='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            int count = 0;
            while (result.next()) {
                if (pw.equals(result.getString("password"))) {
                    flag = true;
                    System.out.println("로그인 성공");
                    setCurrentUser(id, pw); // 로그인 성공 시 현재 사용자 설정
                } else {
                    flag = false;
                    System.out.println("로그인 실패");
                }
                count++;
            }
        } catch (Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
        }

        return flag;
    }

    boolean joinCheck(String _i, String _p) {
        boolean flag = false;

        String id = _i;
        String pw = _p;

        try {
            String insertStr = "INSERT INTO booknook VALUES('" + id + "', '" + pw + "')";
            stmt.executeUpdate(insertStr);

            flag = true;
            System.out.println("회원가입 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("회원가입 실패 > " + e.toString());
        }

        return flag;
    }
}
