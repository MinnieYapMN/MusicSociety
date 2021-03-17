/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import ADT.*;
import Entity.*;
import static client.Login.*;
/**
 *
 * @author Music Society
 */
public class MusicSociety {
   public static MemberListInterface<Member> memberList = new MemberLinkedList();
    public static Admin admin = new Admin("admin", "admin", "1001", "6011-11932585", "admin@tarc.edu.my", "17/03/1999");
    public static void main(String[] args) {
        firstPage();
    }
}
