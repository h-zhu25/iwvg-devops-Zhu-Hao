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
                .filter(fraction -> Math.abs(fraction.getNumerator()) > Math.abs(fraction.getDenominator())) // 过滤不正确的分数
                .map(Fraction::decimal);
    }

    public Stream<String> findUserFamilyNameBySomeImproperFraction() {
        return this.usersDatabase.findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> Math.abs(fraction.getNumerator()) > Math.abs(fraction.getDenominator()))) // 筛选包含不正确分数的用户
                .map(User::getFamilyName); // 获取这些用户的姓氏
    }













}









