package com.twu.biblioteca.auth;

import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MembershipTest {

    private Member customer = new Member("000-0000", "000", MemberType.CUSTOMER, "Daenerys", "00000000", "daenerys@example.com");
    private Member librarian = new Member("111-1111", "111", MemberType.LIBRARIAN, "John Snow", "11111111", "johnsnow@example.com");
    private final Membership membership = new Membership() {
        @Override
        public Member[] getMembers() {
            return new Member[]{customer, librarian};
        }
    };

    @Test
    public void should_get_list_of_members(){
        assertEquals(2, membership.getMembers().length);
    }

    @Test
    public void should_login_successfully_given_valid_credentials(){
        assertNull(membership.getLoggedInMember());
        assertTrue(membership.login("000-0000", "000"));
        assertNotNull(membership.getLoggedInMember());
        assertEquals(membership.getLoggedInMember().getMemberType(), MemberType.CUSTOMER);
    }

    @Test
    public void should_not_login_given_invalid_credentials(){
        assertNull(membership.getLoggedInMember());
        assertFalse(membership.login("999-9999", "999"));
        assertNull(membership.getLoggedInMember());
    }

    @Test
    public void should_not_allow_double_login(){
        assertTrue(membership.login("111-1111", "111"));
        assertFalse(membership.login("111-1111", "111"));
        assertFalse(membership.login("000-0000", "000"));
    }

    @Test
    public void should_allow_signed_in_member_to_logout(){
        membership.login("111-1111", "111");

        assertNotNull(membership.getLoggedInMember());

        assertTrue(membership.logout());

        assertNull(membership.getLoggedInMember());
    }

    @Test
    public void should_not_allow_logout_given_not_signed_in_at_all(){
        assertFalse(membership.logout());
    }

    @Test
    public void should_not_allow_double_logout(){
        membership.login("111-1111", "111");

        assertTrue(membership.logout());
        assertFalse(membership.logout());
    }

    @Test
    public void should_pass_correct_library_number_format(){
        assertTrue(membership.validateLibraryNumber("123-4567"));
        assertTrue(membership.validateLibraryNumber("abc-defg"));
        assertTrue(membership.validateLibraryNumber("ABC-DEFG"));
        assertTrue(membership.validateLibraryNumber("Ab3-De6G"));
    }

    @Test
    public void should_not_pass_incorrect_library_number_format(){
        assertFalse(membership.validateLibraryNumber(""));
        assertFalse(membership.validateLibraryNumber("123"));
        assertFalse(membership.validateLibraryNumber("1234-567"));
        assertFalse(membership.validateLibraryNumber("!@#-^&*6"));
        assertFalse(membership.validateLibraryNumber("--------"));
        assertFalse(membership.validateLibraryNumber("        "));
    }


}
