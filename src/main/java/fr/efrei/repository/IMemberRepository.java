package fr.efrei.repository;

import fr.efrei.domain.Member;

import java.util.List;

public interface IMemberRepository extends IRepository<Member, Integer> {
    Member save(Member member);              // Create or update a member
    Member findById(int memberId);           // Read
    List<Member> getAll();                  // Read all
    void deleteById(int memberId);           // Delete
}
