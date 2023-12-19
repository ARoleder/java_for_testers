package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTests {

    //тест для списков
    @Test
    void listTests() {
        var list = new ArrayList<>(List.of("a", "b", "c", "a"));
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals("a", list.get(0));
    }

    //тест для множеств
    //в множестве элементы не могут повторяться
    @Test
    void setTests() {
        var set = new HashSet<>(List.of("a", "b", "c", "a")); // так можно обхитрить систему и создать множество из списка
        //   var set = Set.of("a","b","c","a")); упадет с ошибкой, так как в множестве повторяется "a"
        Assertions.assertEquals(3, set.size());
        //   set.iterator().next(); берется любой элемент множества
        var element = set.stream().findAny().get();// преобразование множества в поток и взятие любого элементе, заранее не хзнаем какой элемент вернется

        set.add("f");
        Assertions.assertEquals(4, set.size());
    }

    @Test
    void testMap() {
        var digits = new HashMap<Character, String>(); //словарь, который сопоставляет символу строку
        digits.put('1', "one"); //цифре 1 сопоставляем название one
        digits.put('2', "two");
        digits.put('3', "three");
        Assertions.assertEquals("one", digits.get('1'));
        digits.put('1', "один");
        Assertions.assertEquals("один", digits.get('1'));

    }
}
