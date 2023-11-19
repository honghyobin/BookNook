// ReservationFrame.java
package project;

import javax.swing.*;
import java.awt.FlowLayout;

public class SoloReservationFrame extends JFrame {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Reservation Frame");
    Operator operator;

    SoloReservationFrame(Operator o) {
        setTitle("Reservation");
        operator = o;

        panel.setLayout(new FlowLayout());
        panel.add(label);

        JButton reserveButton = new JButton("자리 예약하기");
        JButton clearButton = new JButton("자리 비우기");

        reserveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "자리 예약이 완료되었습니다.");
            goBack(); // 확인 버튼을 누르면 이전 페이지로 이동
        });

        clearButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "자리를 비웠습니다.");
            goBack(); // 자리 비우기 버튼을 누르면 이전 페이지로 이동
        });

        panel.add(reserveButton);
        panel.add(clearButton);

        setContentPane(panel);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재 프레임만 닫기
    }

    private void goBack() {
        SoloGroupCheck soloGroupCheck = new SoloGroupCheck(operator);
        soloGroupCheck.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        SoloReservationFrame reservationFrame = new SoloReservationFrame(operator);
        reservationFrame.setVisible(true);
    }
}
