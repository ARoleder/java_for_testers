package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
