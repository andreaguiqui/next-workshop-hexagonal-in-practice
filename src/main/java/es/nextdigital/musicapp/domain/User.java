package es.nextdigital.musicapp.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String id;
    private String name;
    private String email;
    private Set<String> favoriteSongs = new HashSet<>();
    private static final int FAVORITES_LIMIT = 5;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void addFavoriteSong(String songId) {
        if (songId == null || songId.isBlank()) {
            throw new IllegalArgumentException("Song ID cannot be empty");
        }
        this.favoriteSongs.add(songId);
    }

    public boolean hasReachedFavoriteLimit() {
        return this.favoriteSongs.size() >= FAVORITES_LIMIT;
    }
}
