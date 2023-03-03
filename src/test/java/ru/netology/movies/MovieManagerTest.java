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
    public void shouldAddZeroMovies() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovies() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");

        String[] expected = {"Film 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // вывод фильмов в обратном порядке, когда лимит фильмов установлен по умолчанию

    @Test
    public void shouldLastTen() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");
        manager.add("Film 8");
        manager.add("Film 9");
        manager.add("Film 10");


        String[] expected = {"Film 10", "Film 9", "Film 8", "Film 7", "Film 6", "Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldLastTenThanMoviesMoreThanTen() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");
        manager.add("Film 8");
        manager.add("Film 9");
        manager.add("Film 10");
        manager.add("Film 11");


        String[] expected = {"Film 11", "Film 10", "Film 9", "Film 8", "Film 7", "Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTenThanMoviesLessThanTen() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");
        manager.add("Film 8");
        manager.add("Film 9");


        String[] expected = {"Film 9", "Film 8", "Film 7", "Film 6", "Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTenThanMoviesIsOne() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");


        String[] expected = {"Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTenThanMoviesIsTwo() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");
        manager.add("Film 2");


        String[] expected = {"Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTenThanMoviesIsZero() {
        MovieManager manager = new MovieManager();


        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    // вывод фильмов в обратном порядке, с лимитом, установленном в ручную
    @Test
    public void shouldLastTestThanLimitIsZero() {
        MovieManager manager = new MovieManager(0);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldLastTestThanMoviesMoreThanLimit() {
        MovieManager manager = new MovieManager(0);

        manager.add("Film 1");

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTestThanMoviesEqualLimit() {
        MovieManager manager = new MovieManager(1);

        manager.add("Film 1");

        String[] expected = {"Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastTestThanMoviesMoreThanLimitAndLimitIsOne() {
        MovieManager manager = new MovieManager(1);

        manager.add("Film 1");
        manager.add("Film 2");

        String[] expected = {"Film 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastTestThanMoviesIsZero() {
        MovieManager manager = new MovieManager(1);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastTestThanMoviesLessThanLimit() {
        MovieManager manager = new MovieManager(5);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
