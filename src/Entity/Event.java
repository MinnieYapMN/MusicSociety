/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import ADT.CompareInterface;
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
//    private int EventNo;
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

//    public String toString() {
//        return "Event{" + "EventD=" + EventD + ", member=" + member + ", status=" + status + ", regisNo=" + regisNo + '}';
//    }
    @Override
    public String toString() {
//        return "Event{" + "\nEventD=" + EventD.getEntry(0).getEventNo() + "\nmember=" + member.getEntry(0).getStudentID()+ "\nstatus=" + status + "\nregisNo=" + regisNo + '}';
//        return String.format("%-4s %-4s %-4s %-2s %-8s %-8s %-6s ",eventNo,title,date,time,location,description,fees);
        return String.format("%-6s %12s %-10s %-10s ", regisNo, member.getEntry(0).getStudentID(), EventD.getEntry(0).getEventNo(), status);
    }

//    @Override
//    public String toString1() {
//        return "Event{" + "\nEventD=" + EventD.getEntry(0).getEventNo() + "\nmember=" + member.getEntry(0).getStudentID()+ "\nstatus=" + status + "\nregisNo=" + regisNo + "\nAnnou=" + annou +'}';
//    }
//    
//    public int compare(Event searchRegisNo, Event searchStudID, Event searchEventNo) {
//        if ((this.regisNo.equals(searchRegisNo.regisNo))
//                || (this.member.getEntry(0).getStudentID().equals(searchStudID.member.getEntry(0).getStudentID()))
//                || (this.EventD.getEntry(0).getEventNo() == (searchEventNo.EventD.getEntry(0).getEventNo()))) {
//            return 0;
//        } else {
//            return -1;
//        }
//    }
    
//    @Override
//     public int compareRegisNo(Event t){
//         return this.regisNo.compareTo(t.regisNo);     
//     }
     
//        @Override
//    public int compareByID(Game t) {
//        return this.id.compareTo(t.id);
//    }

    

//    public int compareByAdvance(Game filterId1, Game filterName1, Game filterDate1, Game filterDesc1,
//            Game filterURL1, Game filterKeyword1, Game filtersysRequirement1, Game filterPEGI1,
//            Game filterSize1, Game filterRating1) {
//
//        if ((this.id.equals(filterId1.id)) || (this.PEGI.equals(filterPEGI1.PEGI)) || (this.name.equals(filterName1.name))
//                || (this.keyword.equals(filterKeyword1.keyword)) || (this.rating.equals(filterRating1.rating))
//                || (this.size.equals(filterSize1.size)) || (this.sysRequirement.equals(filtersysRequirement1.sysRequirement)
//                || (this.desc.equals(filterDesc1.desc)) || (this.URL.equals(filterURL1.URL))
//                || (this.date.equals(filterDate1.date)))) {
//            return 0;
//        } else {
//            return -1;
//        }
//    }
}
