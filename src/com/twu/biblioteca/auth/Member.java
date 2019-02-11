package com.twu.biblioteca.auth;

public class Member {

    private String libraryNumber;
    private String password;
    private MemberType memberType;

    public Member(String libraryNumber, String password, MemberType memberType) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.memberType = memberType;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
