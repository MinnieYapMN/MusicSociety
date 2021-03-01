/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.society;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ming Nee
 */
public class MemberLinkedList<T> implements MemberListInterface<T> {
    
    List<Member> memberList;
    
    public MemberLinkedList(){
        memberList = new ArrayList<>();
    }
    
    public void add(T newMember){
        
    }
     public void remove(T Member){
         
     }
     public boolean isEmpty(){
         return true;
     }
     public boolean login(){
         return true;
     }
     public boolean forgotPassword(){
         return true;
     }
     public boolean update(){
         return true;
     }
}
