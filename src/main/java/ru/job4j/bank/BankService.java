package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Главный сервис.
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод должен добавить пользователя в систему.
     * @param user метод принимает пользователя банка.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Этот метод позволит удалить пользователя из системы.
     * @param passport метод принимает номер паспорта пользователя банка.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Следующий метод должен добавить новый счет к пользователю.
     * @param passport номер паспорта пользователя банка.
     * @param account счет для добавления пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> value = users.get(user);
            if (!value.contains(account)) {
                value.add(account);
            }
        }
    }

    /**
     * Этот метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта.
     * @return метод возвращает пользователя.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Следующий метод ищет счет пользователя по реквизитам.
     * @param passport номер паспорта.
     * @param requisite реквизиты.
     * @return метод возвращает счет пользователя.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * @param sourcePassport номер паспорта источника, т.е. пользователя, от которого планируется перечисление.
     * @param sourceRequisite реквизиты источника (например номер карты), пользователя, от которого планируется перечисление.
     * @param destinationPassport номер паспорта пользователя - получателя перечисления.
     * @param destinationRequisite реквизиты пользователя (например номер карты) - получателя перечисления.
     * @param amount сумма для перечисления.
     * @return метод возвращает подтверждение о переводе в виде булевого типа значения True, если перевод завершился удочно.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);
        boolean result = false;
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод используется только в тестах.
     * @param user пользователь банка.
     * @return метод возвращает список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}