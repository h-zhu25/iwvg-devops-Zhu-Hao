package es.upm.miw.iwvg_devops.code;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Searches {

    private UsersDatabase usersDatabase;
    public Searches() {
        this.usersDatabase = new UsersDatabase();
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return this.usersDatabase.findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> Math.abs(fraction.getNumerator()) > Math.abs(fraction.getDenominator()))
                .map(Fraction::decimal);
    }

    public Stream<String> findUserFamilyNameBySomeImproperFraction() {
        return this.usersDatabase.findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> Math.abs(fraction.getNumerator()) > Math.abs(fraction.getDenominator())))
                .map(User::getFamilyName);
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return this.usersDatabase.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())  // 获取该用户的分数列表并展开
                .filter(fraction -> Math.abs(fraction.getNumerator()) < Math.abs(fraction.getDenominator()))
                .findFirst()
                .orElse(null);
    }













}









