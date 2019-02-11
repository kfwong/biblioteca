package com.twu.biblioteca.auth;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public abstract class Membership {

    private Member currentMember;

    public boolean login(String libraryNumber, String password){
        if(this.currentMember != null ) return false;

        Optional<Member> member = getMember(libraryNumber, password);

        if(member.isPresent()){
            this.currentMember = member.get();
            return true;
        }

        return false;
    }

    public Optional<Member> getMember(String libraryNumber, String password){
        return Arrays.stream(getMembers())
                .filter(member -> member.getLibraryNumber().equals(libraryNumber) && member.getPassword().equals(password))
                .findFirst();
    }

    public boolean logout(){
        if(this.currentMember == null) return false;

        this.currentMember = null;

        return true;
    }
    public Member getLoggedInMember(){
        return currentMember;
    }

    public boolean isLoggedIn(){
        return currentMember!= null;
    }

    public boolean validateLibraryNumber(String libraryNumber){
        Pattern libraryNumberPattern = Pattern.compile("[a-zA-Z0-9]{3}-[a-zA-Z0-9]{4}");
        return libraryNumberPattern.matcher(libraryNumber).matches();
    }

    public abstract Member[] getMembers();
}
