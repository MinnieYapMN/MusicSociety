/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.society;

/**
 *
 * @author Ming Nee
 */
public interface MemberListInterface<T> {
     public void add(T newMember);
     public void remove(T Member);
     public boolean isEmpty();
     public boolean login();
     public boolean forgotPassword();
     public boolean update();
}
