import java.util.HashMap;
import java.util.Map;

public class Auth {
    private Map<String, String> users = new HashMap<>();

    public Auth() {
        users.put("admin", "123456");
        users.put("user", "password");
    }

    public boolean login(String username, String password) {
        try {
            // Проверка входных данных
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя пользователя не может быть пустым");
            }

            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Пароль не может быть пустым");
            }

            // Проверка существования пользователя
            if (!users.containsKey(username)) {
                throw new RuntimeException("Пользователь не найден");
            }

            // Проверка пароля
            String storedPassword = users.get(username);
            if (!storedPassword.equals(password)) {
                throw new RuntimeException("Неверный пароль");
            }

            System.out.println("Успешный вход: " + username);
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
            return false;
        } catch (RuntimeException e) {
            System.out.println("Ошибка авторизации: " + e.getMessage());
            return false;
        } finally {
            System.out.println("Попытка входа завершена для: " + username);
        }
    }

    // Пример использования
    public static void main(String[] args) {
        Auth auth = new Auth();

        // Тестируем разные сценарии
        System.out.println("1. " + auth.login("admin", "123456"));     // Успешно
        System.out.println("2. " + auth.login("user", "wrong"));       // Неверный пароль
        System.out.println("3. " + auth.login("unknown", "123"));      // Пользователь не найден
        System.out.println("4. " + auth.login("", "123"));             // Пустое имя
        System.out.println("5. " + auth.login("admin", null));         // Null пароль
    }
}