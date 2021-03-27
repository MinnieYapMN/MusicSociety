/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import ADT.*;

/**
 *
 * @author Lim Fung Ann 20WMR08932
 */
public class Event {

    private EventDetails EventD;
    private Member member;
    private String status;
    private String regisNo;
    private static String nextregisterNo = "000";
    private static int countRegister = 0;

    public Event() {
    }

    public Event(String regisNo, String status, EventDetails EventD, Member member) {
        int num = Integer.parseInt(nextregisterNo);
        num++;
        countRegister++;
        this.EventD = EventD;
        this.member = member;
        this.status = status;
        this.regisNo = new String(String.format("%04d", num));
        nextregisterNo = new String(String.format("%04d", num));
    }
    
    public Event(String status, EventDetails EventD, Member member) {
        int num = Integer.parseInt(nextregisterNo);
        num++;
        countRegister++;
        this.EventD = EventD;
        this.member = member;
        this.status = status;
        regisNo = new String(String.format("%04d", num));
        nextregisterNo = new String(String.format("%04d", num));
    }

    public EventDetails getEventD() {
        return EventD;
    }

    public Member getMember() {
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

    public void setEventD(EventDetails EventD) {
        this.EventD = EventD;
    }

    public void setMember(Member member) {
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
        return this.EventD.getEventNo();
    }
    
     public String getStudId() {
        return this.member.getStudentID();
    }

    @Override
    public String toString() {
        return String.format("%-10s \t %-15s   %-10s    %6.2f \t%-10s", regisNo, member.getStudentID(), EventD.getEventNo(), EventD.getFees(), status);
    }
    
}
