/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Jason
 * @param <Member>
 */
public interface MemberListInterface<Member> {
    
    public void add(Member newMember);
    public void remove(Member member);
    public boolean isEmpty();
    public boolean login(String username,String password);
    public Member forgotPassword(String email);
    
}
