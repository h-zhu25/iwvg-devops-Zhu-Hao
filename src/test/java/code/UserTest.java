package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User userInstance;
    private Fraction fractionA;
    private Fraction fractionB;

    @BeforeEach
    void initialize() {
        fractionA = new Fraction(1, 2);
        fractionB = new Fraction(3, 4);

        List<Fraction> fractionList = new ArrayList<>();
        fractionList.add(fractionA);
        fractionList.add(fractionB);

        userInstance = new User("1", "Alice", "Smith", fractionList);
    }

    @Test
    void verifyFullName() {
        assertEquals("Alice Smith", userInstance.fullName());
    }

    @Test
    void verifyInitials() {
        assertEquals("A.", userInstance.initials());
    }

    @Test
    void testAddNewFraction() {
        Fraction additionalFraction = new Fraction(2, 5);
        userInstance.addFraction(additionalFraction);
        List<Fraction> fractionList = userInstance.getFractions();
        assertEquals(3, fractionList.size());
        assertEquals(additionalFraction, fractionList.get(2));
    }

    @Test
    void validateId() {
        assertEquals("1", userInstance.getId());
    }

    @Test
    void validateName() {
        assertEquals("Alice", userInstance.getName());
    }

    @Test
    void validateFamilyName() {
        assertEquals("Smith", userInstance.getFamilyName());
    }

    @Test
    void modifyAndValidateFractions() {
        List<Fraction> newFractionList = new ArrayList<>();
        Fraction fractionC = new Fraction(2, 5);
        newFractionList.add(fractionC);
        userInstance.setFractions(newFractionList);
        assertEquals(newFractionList, userInstance.getFractions());
    }

    @Test
    void verifyToString() {
        String expectedString = "User{id='1', name='Alice', familyName='Smith', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=4}]}";
        assertEquals(expectedString, userInstance.toString());
    }
}

