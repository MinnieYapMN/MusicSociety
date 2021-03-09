/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Entity.Member;

/**
 *
 * @author Jason
 */
public class MemberLinkedList implements MemberListInterface<Member> {

    ListInterface<Member> memberList;

    public MemberLinkedList() {
        memberList = new LList();
        Member m = new Member("minnie", "1234", "20WMR08981", "Ming Nee","0123456789","minnie@gmail.com","30/7/1999");
        memberList.add(m);
    }

    @Override
    public void add(Member newMember) {
        memberList.add(newMember);
    }

    @Override
    public void remove(Member member) {
        for (int i = 0; i < memberList.getLength(); i++) {
            if (memberList.getEntry(i).equals(member)) {
                memberList.remove(i);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return memberList.isEmpty();
    }

    @Override
    public boolean login(String username, String password) {
        for (int i = 1; i < memberList.getLength() + 1; i++) {
            if (memberList.getEntry(i).getUsername().equals(username) && memberList.getEntry(i).getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Member forgotPassword(String email) {
        for (int i = 1; i < memberList.getLength() + 1; i++) {
            if (memberList.getEntry(i).getEmail().equals(email)) {
                return memberList.getEntry(i);
            }
        }
        return null;
    }

}
