package ut.ex;

import net.jqwik.api.*;
import net.jqwik.api.statistics.Statistics;

import static org.junit.jupiter.api.Assertions.*;

import java.math.RoundingMode;
import java.util.List;

class SimpleListProperties {

    @Property
    void simpleStats(@ForAll RoundingMode mode) {
        Statistics.collect(mode);
    }

    @Property
    void addingOneElementIncreasesSize(@ForAll("nullableStrings") String element) {
        SimpleList<String> list = new SimpleList<>();
        int initialSize = list.size();
        list.add(element);
        assertEquals(initialSize + 1, list.size());
    }

    @Property
    void addedElementIsRetrievable(@ForAll("nullableStrings") String element) {
        SimpleList<String> list = new SimpleList<>();
        list.add(element);
        assertEquals(element, list.get(0));
    }

    @Property
    void removingElementDecreasesSize(@ForAll("nullableStrings") String element) {
        SimpleList<String> list = new SimpleList<>();
        list.add(element);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Property
    void multipleAddsThenGetReturnCorrectElements(
            @ForAll("nullableStringList") List<String> elements) {
        Assume.that(elements.size() <= 50); // avoid excessive test size
        SimpleList<String> list = new SimpleList<>();
        for (String element : elements) {
            list.add(element);
        }
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(elements.get(i), list.get(i));
        }
    }

    @Property
    void getOnEmptyThrows(@ForAll int index) {
        Assume.that(index >= 0);
        SimpleList<String> list = new SimpleList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
}


    @Provide
    Arbitrary<String> nullableStrings() {
        return Arbitraries.strings()
                .withCharRange('a', 'z')
                .ofMinLength(0)
                .ofMaxLength(10)
                .injectNull(0.1); // 10% chance of null
    }

    @Provide
    Arbitrary<List<String>> nullableStringList() {
        return nullableStrings().list().ofMinSize(0).ofMaxSize(30);
    }
}

