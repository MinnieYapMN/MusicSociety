/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import ADT.*;

/**
 *
 * @author HP Pavilion
 */
public class Event {

    private EventLinkedStackInterface<EventDetails> EventD;
    private LinkListInterface<Member> member;
    private String status;
    private String regisNo;
    private String annou;
    private static String nextregisterNo = "000";
    private static int countRegister = 0;

    public Event() {
    }

    public Event(String regisNo, String status, EventLinkedStackInterface<EventDetails> EventD, LinkListInterface<Member> member) {
        int num = Integer.parseInt(nextregisterNo);
        num++;
        countRegister++;
        this.EventD = EventD;
        this.member = member;
        this.status = status;
        this.regisNo = new String(String.format("%04d", num));
        nextregisterNo = new String(String.format("%04d", num));
    }

    public Event(String status, EventLinkedStackInterface<EventDetails> EventD, LinkListInterface<Member> member) {
        int num = Integer.parseInt(nextregisterNo);
        num++;
        countRegister++;
        this.EventD = EventD;
        this.member = member;
        this.status = status;
        regisNo = new String(String.format("%04d", num));
        nextregisterNo = new String(String.format("%04d", num));
    }

    public Event(String annou) {
        this.annou = annou;
    }

    public String getAnnou() {
        return annou;
    }

    public void setAnnou(String annou) {
        this.annou = annou;
    }

    public EventLinkedStackInterface<EventDetails> getEventD() {
        return EventD;
    }

    public LinkListInterface<Member> getMember() {
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

    public void setMember(LinkListInterface<Member> member) {
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

    public int getEventNo() {
        return this.EventD.getEntry(0).getEventNo();
    }

    @Override
    public String toString() {
        return String.format("%-20s %-12s %-10s %-10s", regisNo, member.getEntry(0).getStudentID(), EventD.getEntry(0).getEventNo(), status);
    }

}
