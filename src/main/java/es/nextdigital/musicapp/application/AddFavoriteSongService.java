package es.nextdigital.musicapp.application;

import es.nextdigital.musicapp.application.port.out.NotificationPort;
import es.nextdigital.musicapp.application.port.out.UserRepository;
import es.nextdigital.musicapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class AddFavoriteSongService {

    private final UserRepository userRepository;
    private final NotificationPort notificationPort;

    public AddFavoriteSongService(UserRepository userRepository, NotificationPort notificationPort) {
        this.userRepository = userRepository;
        this.notificationPort = notificationPort;
    }

    public void addFavoriteSong(String userId, String songId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.addFavoriteSong(songId);
        userRepository.save(user);

        if (user.hasReachedFavoriteLimit()) {
            notificationPort.notifyFavoriteLimitReached(user);
        }
    }
}