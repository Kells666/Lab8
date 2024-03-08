package com.example.lab8;

import android.content.Context;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    private Context context;

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

    @Test
    public void testDeleteCity() {
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city.getCityName()));
        list.deleteCity(city);
        assertFalse(list.hasCity(city.getCityName()));
    }

    @Test
    public void testCountCities() {
        CustomList cityList = new CustomList(context, new ArrayList<>());
        cityList.addCity(new City("Edmonton", "AB"));
        int initialSize = cityList.countCities(); // should be 1
        cityList.addCity(new City("Calgary", "AB"));
        assertEquals(initialSize + 1, cityList.countCities());
    }




}
