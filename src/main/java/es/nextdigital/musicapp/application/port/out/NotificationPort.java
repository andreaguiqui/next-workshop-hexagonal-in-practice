package es.nextdigital.musicapp.application.port.out;

import es.nextdigital.musicapp.domain.User;

public interface NotificationPort {
    void notifyFavoriteLimitReached(User user);
}
