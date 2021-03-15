/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import ADT.*;
import java.util.logging.Logger;

/**
 *
 * @author HP Pavilion
 */
public class Event {

    private EventLinkedStackInterface<EventDetails> EventD;
    private MemberListInterface<Member> member;
    private String status;
    private String regisNo;
    private static String nextregisterNo = "00";
    private static int countRegister = 0;

    public Event() {
    }

    public Event(String regisNo, String status, EventLinkedStackInterface<EventDetails> EventD, MemberListInterface<Member> member) {
        int num = Integer.parseInt(nextregisterNo);
        num++;
        countRegister++;
        this.EventD = EventD;
        this.member = member;
        this.status = status;
        this.regisNo = new String(String.format("%03d", num));
        nextregisterNo = new String(String.format("%03d", num));
    }

    public EventLinkedStackInterface<EventDetails> getEventD() {
        return EventD;
    }

    public MemberListInterface<Member> getMember() {
        return member;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegisNo() {
        return regisNo;
    }

    public void setRegisNo(String regisNo) {
        this.regisNo = regisNo;
    }

    public void setEventD(EventLinkedStackInterface<EventDetails> EventD) {
        this.EventD = EventD;
    }

    public void setMember(MemberListInterface<Member> member) {
        this.member = member;
    }

    public static String getNextRegisterNo() {
        int num = Integer.parseInt(nextregisterNo);
        nextregisterNo = "" + num;
        return String.format("%03d", num);
    }

    public static int getCountregister() {
        return countRegister;
    }

    @Override
    public String toString() {
        return "Event{" + "EventD=" + EventD + ", member=" + member + ", status=" + status + ", regisNo=" + regisNo + '}';
    }

}
