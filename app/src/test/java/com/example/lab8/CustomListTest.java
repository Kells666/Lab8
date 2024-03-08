package com.example.lab8;

import android.content.Context;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void createMockList() {
        Context context = Mockito.mock(Context.class); // Mock the Context as it's required by CustomList
        list = new CustomList(context, new ArrayList<City>());
    }


    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void testHasCity() {
        City city = new City("Edmonton", "AB");
        assertFalse(list.hasCity(city.getCityName()));
        list.addCity(city);
        assertTrue(list.hasCity(city.getCityName()));
    }




}
