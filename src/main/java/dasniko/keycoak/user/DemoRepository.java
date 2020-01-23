package dasniko.keycoak.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class DemoRepository {

    private List<DemoUser> users;

    DemoRepository() {
        users = Arrays.asList(
                new DemoUser("1", "Guilherme", "Maneskul"),
                new DemoUser("2", "Guilherme", "Lazzarini"),
                new DemoUser("3", "Wellington", "Carvalho"),
                new DemoUser("4", "Daniel", "Rodrigues"),
                new DemoUser("5", "Diego", "Sanches"),
                new DemoUser("6", "Fernanda", "Lopes"),
                new DemoUser("7", "Edgar", "Gobbo")
        );
    }

    List<DemoUser> getAllUsers() {
        return users;
    }

    int getUsersCount() {
        return users.size();
    }

    DemoUser findUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    DemoUser findUserByUsernameOrEmail(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username) || user.getEmail().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }

    List<DemoUser> findUsers(String query) {
        return users.stream()
                .filter(user -> user.getUsername().contains(query) || user.getEmail().contains(query))
                .collect(Collectors.toList());
    }

    boolean validateCredentials(String username, String password) {
        return findUserByUsernameOrEmail(username).getPassword().equals(password);
    }

    boolean updateCredentials(String username, String password) {
        findUserByUsernameOrEmail(username).setPassword(password);
        return true;
    }

}
