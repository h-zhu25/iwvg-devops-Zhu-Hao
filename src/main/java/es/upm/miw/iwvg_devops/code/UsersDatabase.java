package es.upm.miw.iwvg_devops.code;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UsersDatabase {
    private List<User> users;

    public UsersDatabase() {
        this.users = new ArrayList<>();
        // 添加用户数据
    }
    public List<User> getUsers() {
        return this.users;
    }

    public Stream<User> findAll() {
        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions2 = List.of(
                new Fraction(2, 1),
                new Fraction(-1, 5),
                new Fraction(2, 4),
                new Fraction(4, 3)
        );
        List<Fraction> fractions5 = List.of(
                new Fraction(0, 1),
                new Fraction(0, -2),
                new Fraction(0, 3)
        );

        List<Fraction> fractionsSmith = List.of(
                new Fraction(1, 2),
                new Fraction(3, 4)
        );

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1),
                new User("2", "Ana", "Blanco", fractions2),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("3", "John", "Smith", fractionsSmith)
        );

    }
}
