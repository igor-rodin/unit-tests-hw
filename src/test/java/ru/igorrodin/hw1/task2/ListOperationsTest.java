package ru.igorrodin.hw1.task2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListOperationsTest {

    @Test
    public void testSumList() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 5);

        List<Integer> expectedList = List.of(5, 7, 8);
        List<Integer> actualList = ListOperations.sumLists(list1, list2);

        assertThat(expectedList).isEqualTo(actualList);
    }

    @Test
    public void testFindMax() {
        List<Integer> list = List.of(-1, 2, -33);
        int expectedMax = 2;

        assertThat(expectedMax).isEqualTo(ListOperations.findMax(list));
    }

    @Test
    public void testFilterString() {
        List<String> list = List.of("asd", "22", "qwerty", "a");
        List<String> expectedWords = List.of("asd", "qwerty");
        int minLength = 3;

        List<String> actualWords = ListOperations.filterStrings(list, minLength);


        assertThat(actualWords).isEqualTo(expectedWords);
    }

    @Test
    public void testFilterStringWithEmptyResult() {
        List<String> list = List.of("asd", "22", "qwerty", "a");
        List<String> expectedWords = List.of();
        int minLength = 7;

        List<String> actualWords = ListOperations.filterStrings(list, minLength);


        assertThat(actualWords).isEqualTo(expectedWords);
    }
}
