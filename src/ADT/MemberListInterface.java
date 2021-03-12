/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Entity.Admin;

/**
 *
 * 
 * @param <Member>
 */
public interface MemberListInterface<Member> {
    
    public void add(Member newMember);
    public void remove(Member member);
    public boolean isEmpty();
    public String login(String username,String password);
    public Admin forgotPassword(String email);
    public Member get(int position);
    public int getLength();
    
}
