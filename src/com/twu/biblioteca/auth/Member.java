package com.twu.biblioteca.auth;

public class Member {

    private String libraryNumber;
    private String password;
    private MemberType memberType;
    private String name;
    private String phone;
    private String email;

    public Member(String libraryNumber, String password, MemberType memberType, String name, String phone, String email) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.memberType = memberType;
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
