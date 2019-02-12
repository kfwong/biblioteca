package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.auth.Member;

public class ProfileMenu extends Menu{

    public static final String PROFILE_FORMAT = "%-20s%-20s";

    @Override
    public void execute(BibliotecaApp context, String... args) {
        displayProfile(context.getLoggedInMember());
    }

    public void displayProfile(Member member){

        String name = String.format(PROFILE_FORMAT, "Name", member.getName()).trim();
        String email = String.format(PROFILE_FORMAT, "Email", member.getEmail()).trim();
        String phone = String.format(PROFILE_FORMAT, "Phone", member.getPhone()).trim();
        String libraryNumber = String.format(PROFILE_FORMAT, "Library Number", member.getLibraryNumber()).trim();
        String memberType = String.format(PROFILE_FORMAT, "Member Type", member.getMemberType()).trim();

        System.out.println(name);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(libraryNumber);
        System.out.println(memberType);
    }
}
