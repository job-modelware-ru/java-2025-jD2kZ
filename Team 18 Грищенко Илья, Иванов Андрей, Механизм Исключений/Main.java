import java.util.HashMap;
import java.util.Map;

class AuthService {
    private Map<String, String> users = new HashMap<>();

    public AuthService() {
        users.put("user1", "pass1");
        users.put("user2", "pass2");
    }

    public boolean login(String username, String password)
            throws IllegalArgumentException, IllegalStateException {

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }

        if (!users.containsKey(username)) {
            throw new IllegalStateException("Пользователь не найден");
        }

        if (!users.get(username).equals(password)) {
            throw new IllegalStateException("Неверный пароль");
        }

        System.out.println("Успешный вход: " + username);
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        try {
            auth.login("user1", "pass11");
        } catch (IllegalStateException e) {
            System.out.println("Ошибка входа: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

    }
}