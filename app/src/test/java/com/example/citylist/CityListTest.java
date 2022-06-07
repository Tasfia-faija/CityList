package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * this function will check if the city  exists  or not if exists it will  delete the city
     * and if not it will send an exception  .
     */

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.count());

        cityList.delete(city);
        assertEquals(1, cityList.count());

    }

    /**
     * this function will check the number of cities present in the list
     */
    @Test
    public void testCount() {
        CityList cityList=mockCityList();
        assertEquals(1,cityList.count());
        City city = new City("Regina", "SK");
        cityList.add(city);
        assertEquals(2,cityList.count());
    }

    /**
     * this function will  handle delete exception
     */
    @Test
    public void testDeleteException() {
        CityList cityList= new CityList();
        City city = new City("Regina", "SK");
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     *this function will return the  sorted city list .The sort will  happen either by cities name or
     * province name
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));

        assertEquals(0, city.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));
    }

}
