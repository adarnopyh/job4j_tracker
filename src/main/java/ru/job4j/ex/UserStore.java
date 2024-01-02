package ru.job4j.ex;

import java.util.Objects;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User user1 : users) {
            if (login.equals(user1.getUsername())) {
                user = user1;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("This user is not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("This user is Invalid");
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true),
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}