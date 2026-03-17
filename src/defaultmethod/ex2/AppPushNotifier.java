package defaultmethod.ex2;

import java.time.LocalDateTime;

public class AppPushNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("[APP] " + message);

    }
}
