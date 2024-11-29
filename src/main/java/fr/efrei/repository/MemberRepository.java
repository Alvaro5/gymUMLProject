package fr.efrei.repository;

import fr.efrei.domain.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository implements IMemberRepository {
    private static IMemberRepository repository = null;
    private List<Member> memberList;

    private MemberRepository() {
        memberList = new ArrayList<>();
    }

    public static IMemberRepository getRepository() {
        if (repository == null) {
            repository = new MemberRepository();
        }
        return repository;
    }


    @Override
    public Member create(Member member) {
        boolean success = memberList.add(member);
        if (success) {
            return member;
        }
        return null;
    }

    @Override
    public Member read(Integer id) {
        for (Member m : memberList) {
            if (m.getMemberID() == id)
                return m;
        }
        return null;
    }

    @Override
    public Member update(Member member) {
        int id = member.getMemberID();
        Member memberOld = read(id);
        if (memberOld == null)
            return null;

        boolean success = delete(id);
        if (success) {
            if (memberList.add(member))
                return member;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Member memberToDelete = read(id);
        if (memberToDelete == null)
            return false;
        return memberList.remove(memberToDelete);
    }

    @Override
    public List<Member> getAll() {
        return memberList;
    }
}
