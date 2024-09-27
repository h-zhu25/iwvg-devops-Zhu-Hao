package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SearchesTest {


    @Test
    void testFindDecimalImproperFractionByUserName() {
        Searches searches = new Searches();
        List<Double> expected = List.of(1.5, 1.3333333333333333);
        List<Double> result = searches.findDecimalImproperFractionByUserName("John").collect(Collectors.toList());
        assertEquals(expected, result);
    }

    @Test
    void testFindUserFamilyNameBySomeImproperFraction() {
        Searches searches = new Searches();
        List<String> result = searches.findUserFamilyNameBySomeImproperFraction().collect(Collectors.toList());
        List<String> expected = List.of("Fernandez", "Blanco", "Doe");
        assertEquals(expected, result);
    }









}