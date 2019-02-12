package com.twu.biblioteca.auth;

public class BibliotecaMembership extends Membership {

    private Member customer = new Member("000-0000", "000", MemberType.CUSTOMER, "Daenerys", "00000000", "daenerys@example.com");
    private Member librarian = new Member("111-1111", "111", MemberType.LIBRARIAN, "John Snow", "11111111", "johnsnow@example.com");

    @Override
    public Member[] getMembers() {
        return new Member[]{
                customer,
                librarian
        };
    }
}
