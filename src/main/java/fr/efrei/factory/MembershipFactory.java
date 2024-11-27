package fr.efrei.factory;

import fr.efrei.domain.Membership;
import fr.efrei.util.Helper;

import java.time.LocalDate;

public class MembershipFactory {
    public static Membership buildMembership(String membershipStatus, String paymentRate, LocalDate startDate, LocalDate endDate) {
        if (Helper.isNullOrEmpty(membershipStatus) || Helper.isNullOrEmpty(paymentRate) || Helper.emptyDate(startDate) || Helper.emptyDate(endDate)) {
            System.out.println("Empty membership data");
            return null;
        }

        if (Helper.endBeforeStart(startDate, endDate)) {
            System.out.println("The start date is before the end date.");
            return null;
        }

        return new Membership.Builder().setMembershipStatus(Membership.MembershipStatus.valueOf(membershipStatus.toUpperCase()))
                .setPaymentRate(Membership.PaymentRate.valueOf(paymentRate.toUpperCase()))
                .setStartDate(startDate)
                .setEndDate(endDate)
                .build();
    }
}
