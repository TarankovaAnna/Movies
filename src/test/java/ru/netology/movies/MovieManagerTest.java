package ru.netology.movies;


import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class MovieManagerTest {

    // вывод фильмов в порядке добавления
    @Test
    public void shouldAddMovies() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");


        String[] expected = {"Film 1", "Film 2", "Film 3", "Film 4"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }



    @Test
    public void shouldAddZeroMovies () {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovies () {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");

        String[] expected = {"Film 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // вывод фильмов в обратном порядке, когда лимит фильмов установлен по умолчанию

    @Test
    public void shouldLastTen () {
        MovieManager manager = new MovieManager();

        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");
        manager.add("7");
        manager.add("8");
        manager.add("9");
        manager.add("10");


        String[] expected = {"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldLastTenThanMoviesMoreThanTen () {
        MovieManager manager = new MovieManager();

        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");
        manager.add("7");
        manager.add("8");
        manager.add("9");
        manager.add("10");
        manager.add("11");


        String[] expected = {"11", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldLastTenThanMoviesLessThanTen () {
        MovieManager manager = new MovieManager();

        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");
        manager.add("7");
        manager.add("8");
        manager.add("9");


        String[] expected = {"9", "8", "7", "6", "5", "4", "3", "2", "1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTenThanMoviesIsOne () {
        MovieManager manager = new MovieManager();

        manager.add("1");


        String[] expected = {"1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldLastTenThanMoviesIsTwo () {
        MovieManager manager = new MovieManager();

        manager.add("1");
        manager.add("2");


        String[] expected = {"2", "1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTenThanMoviesIsZero () {
        MovieManager manager = new MovieManager();


        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    // вывод фильмов в обратном порядке, с лимитом, установленном в ручную
    @Test
    public void shouldLastTestThanLimitIsZero () {
        MovieManager manager = new MovieManager(0);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldLastTestThanMoviesMoreThanLimit () {
        MovieManager manager = new MovieManager(0);

        manager.add("1");

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTestThanMoviesEqualLimit () {
        MovieManager manager = new MovieManager(1);

        manager.add("1");

        String[] expected = {"1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTestThanMoviesMoreThanLimitAndLimitIsOne () {
        MovieManager manager = new MovieManager(1);

        manager.add("1");
        manager.add("2");

        String[] expected = {"2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastTestThanMoviesIsZero () {
        MovieManager manager = new MovieManager(1);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastTestThanMoviesLessThanLimit () {
        MovieManager manager = new MovieManager(5);

        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");

        String[] expected = {"4", "3", "2", "1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
