package fr.efrei.factory;

import fr.efrei.domain.Member;
import fr.efrei.util.Helper;

public class MemberFactory {
    public static Member buildMember(int id, String firstName, String lastName, int age, Member.MembershipStatus membershipStatus) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(String.valueOf(id))) {
            return null;
        }

        return new Member.Builder().setMemberID(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setMembershipStatus(membershipStatus)
                .build();
    }

    public static Member buildMember(String firstName, String lastName, int age, Member.MembershipStatus membershipStatus) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            return null;
        }

        int id = Helper.generateId();

        return new Member.Builder().setMemberID(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setMembershipStatus(membershipStatus)
                .build();
    }
}
