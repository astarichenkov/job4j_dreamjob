package ru.job4j.dream.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class DbStoreTest {

    private static Connection connection;


    @BeforeClass
    public static void initConnection() {
        try (InputStream in = DbStore.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("jdbc.driver"));
            connection = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from post")) {
            statement.execute();
        }
        try (PreparedStatement statement = connection.prepareStatement("delete from candidate")) {
            statement.execute();
        }
        try (PreparedStatement statement = connection.prepareStatement("ALTER TABLE post ALTER COLUMN id RESTART WITH 1")) {
            statement.execute();
        }
        try (PreparedStatement statement = connection.prepareStatement("ALTER TABLE candidate ALTER COLUMN id RESTART WITH 1")) {
            statement.execute();
        }
    }

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void findAllPosts() {
        Collection<Post> posts;
        Store store = DbStore.instOf();
        Post firstPost = new Post(0, "Java Job");
        Post secondPost = new Post(0, "Junior/Middle Developer");
        store.save(firstPost);
        store.save(secondPost);
        posts = store.findAllPosts();
        assertThat(posts, is(List.of(firstPost, secondPost)));
    }

    @Test
    public void findAllCandidates() {
        Collection<Candidate> candidates;
        Store store = DbStore.instOf();
        Candidate first = new Candidate(0, "Vasya");
        Candidate second = new Candidate(0, "Slava");
        store.save(first);
        store.save(second);
        candidates = store.findAllCandidates();
        assertThat(candidates, is(List.of(first, second)));
    }

    @Test
    public void whenRemoveCandidateById() {
        Collection<Candidate> candidates;
        Store store = DbStore.instOf();
        Candidate first = new Candidate(0, "Vasya");
        store.save(first);
        store.removeCandidateById(1);
        candidates = store.findAllCandidates();
        assertThat(candidates.isEmpty(), is(true));
    }
}