package fr.efrei.repository;

import fr.efrei.domain.Session;

import java.util.List;

public interface ISessionRepository extends IRepository<Session, Integer> {
    List<Session> getAll();
}
