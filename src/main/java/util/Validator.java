package util;

import repository.MapRepository;

public class Validator {
    private final MapRepository mapRepository ;

    public Validator() {
        this.mapRepository = MapRepository.getInstance();
    }

    public boolean validateLoginPassword(String username, String password) {
        return mapRepository.isValidCredentials(username, password);
    }

    public boolean validateLoginPassword(String username, String password, String confirmPassword) {
        return username != null &&
                username.length() > 3 &&
                password != null &&
                password.length() > 3 &&
                password.equals(confirmPassword) &&
                !mapRepository.isUsernameContains(username);
    }
}