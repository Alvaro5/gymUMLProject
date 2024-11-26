package fr.efrei.repository;

import fr.efrei.domain.Coach;

import java.util.List;

public interface ICoachRepository extends IRepository<Coach, Integer> {
    List<Coach> getAll();

}
