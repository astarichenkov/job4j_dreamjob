package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.List;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<User> findAllUsers();

    void save(Post post);

    void save(Candidate candidate);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    void removeCandidateById(int id);

    User save(User user);

    User findByEmail(String email);

    User findUserById(int id);

    String getCity(int id);

    List<City> getAllCities();

    int getCityIdByName(String name);

    List<Post> getTodayVacancies();

    List<Candidate> getTodayCandidates();

}