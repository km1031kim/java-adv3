package defaultmethod.ex2;

import java.time.LocalDateTime;

public class EmailNotifier implements Notifier {

    @Override
    public void notify(String message) {
        System.out.println("[Email] " + message);

    }

    @Override
    public void scheduleNotification(String message, LocalDateTime scheduleTime) {
        System.out.println("[Email 전용 스케줄링] message : " + message + ", 시간 : " + scheduleTime);
    }
}
