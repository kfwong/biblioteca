package com.twu.biblioteca.auth;

public class BibliotecaMembership extends Membership {

    private Member customer = new Member("000-0000", "000", MemberType.CUSTOMER);
    private Member librarian = new Member("111-1111", "111", MemberType.LIBRARIAN);

    @Override
    public Member[] getMembers() {
        return new Member[]{
                customer,
                librarian
        };
    }
}
