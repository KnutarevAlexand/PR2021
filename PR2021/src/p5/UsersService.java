package p5;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

public class UsersService {

    private List<Users> users;

    public UsersService(List<Users> users) {
        this.users = users;
    }

    public List<Users> getUsers() {
        return users;
    }

    public List<Users> createNewUser(String name, LocalDate dateOfBirth) throws Exception {
        validateUser(name, dateOfBirth);
        Users user = new Users(name, dateOfBirth);
        users.add(user);
        return users;
    }

    public void removeUser(String name) {
        users = users.stream().filter(it -> !it.name.equals(name)).collect(Collectors.toList());
    }

    public boolean isBirthDay(Users user, LocalDate date) throws CustomFieldException {
        if (user == null || user.dateOfBirth == null) {
            throw new CustomFieldException("User or date of birth is null");
        }
        if (date == null) {
            throw new CustomFieldException("Compare date must not be null");
        }
        return date.getDayOfMonth() == user.dateOfBirth.getDayOfMonth() && date.getMonth().equals(user.dateOfBirth.getMonth());
    }

    private void validateUser(String name, LocalDate dateOfBirth) throws Exception {
        if (name == null ) {
            throw new CustomFieldException("Name could not be empty or null");
        }
        if (dateOfBirth == null) {
            throw new CustomFieldException("Date of birth could not be null");
        }
    }
}