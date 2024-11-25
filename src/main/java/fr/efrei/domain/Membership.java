package fr.efrei.domain;

import java.time.LocalDate;

public class Membership {
    private MembershipStatus membershipStatus;
    private PaymentRate paymentRate;
    private LocalDate startDate;
    private LocalDate endDate;

    public enum MembershipStatus {
        ACTIVE, SUSPENDED, PENDING, INACTIVE, EXPIRED, CANCELLED
    }

    public enum PaymentRate {
        DAILY, MONTHLY, YEARLY;
    }

    private Membership() {
    }

    private Membership(Builder builder) {
        this.membershipStatus = builder.membershipStatus;
        this.paymentRate = builder.paymentRate;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public PaymentRate getPaymentRate() {
        return paymentRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "membershipStatus=" + membershipStatus +
                ", paymentRate=" + paymentRate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class Builder {
        private MembershipStatus membershipStatus;
        private PaymentRate paymentRate;
        private LocalDate startDate;
        private LocalDate endDate;

        public Builder setMembershipStatus(MembershipStatus membershipStatus) {
            this.membershipStatus = membershipStatus;
            return this;
        }

        public Builder setPaymentRate(PaymentRate paymentRate) {
            this.paymentRate = paymentRate;
            return this;
        }

        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder copy(Membership membership) {
            this.membershipStatus = membership.membershipStatus;
            this.paymentRate = membership.paymentRate;
            this.startDate = membership.startDate;
            this.endDate = membership.endDate;
            return this;
        }

        public Membership build() {
            return new Membership(this);
        }
    }
}
