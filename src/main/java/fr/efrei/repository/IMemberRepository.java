package fr.efrei.repository;

import fr.efrei.domain.Member;

import java.util.List;

public interface IMemberRepository extends IRepository<Member, Integer> {
    List<Member> getAll();
}
