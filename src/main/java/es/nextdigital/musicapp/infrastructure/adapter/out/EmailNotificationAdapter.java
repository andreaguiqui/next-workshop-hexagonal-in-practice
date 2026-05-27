package es.nextdigital.musicapp.infrastructure.adapter.out;

import es.nextdigital.musicapp.application.port.out.NotificationPort;
import es.nextdigital.musicapp.domain.User;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationAdapter implements NotificationPort {

    @Override
    public void notifyFavoriteLimitReached(User user) {
        // Simulación de envío de email
        System.out.println("--- ENVIANDO EMAIL A " + user.getEmail() + " ---");
        System.out.println("Hola " + user.getName() + ", has alcanzado el límite máximo de canciones favoritas.");
        System.out.println("----------------------------------------");
    }
}
