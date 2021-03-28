/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.*;
import Entity.*;
import java.text.ParseException;
import static Client.LoginAndUserMaintenance.firstPage;
import  Client.EventMaintenance;
import  Client.PaymentModule;
import  Client.CoreBusinessModule;
import static Client.EventMaintenance.menu;

/**
 *
 * @author Music Society
 */
public class MusicSociety {

    public static EventMaintenance eDetails;
    public static MemberListInterface<Member> memberList = new MemberLinkedList();
    public static Admin admin = new Admin("admin", "admin", "1001", "6011-11932585", "admin@tarc.edu.my", "17/03/1999");
    public static EventLinkedStackInterface<EventDetails> eventList = new EventLinkedStack<EventDetails>();

    public static SetInterface<Event> memberEvent = new ArraySet<>();

    LinkListInterface<Admin> adminList;

    public void initialize() throws ParseException {

        Member n = new Member("20WMR08981", "Ming Nee", "0123456789", "minnie@gmail.com", "30/7/1999");
        memberList.add(n);
        n = new Member("20WMR08928", "Tzu Wey", "0124455667", "ren@gmail.com", "12/12/2000");
        memberList.add(n);
        n = new Member("20WMR08932", "Fung Ann", "0102233445", "falim@gmail.com", "11/11/2000");
        memberList.add(n);
        n = new Member("20WMR08920", "Wen Xuen", "0137788999", "wxkhau@gmail.com", "10/5/2000");
        memberList.add(n);
        n = new Member("20WMR08905", "Jen Nam", "01155556677", "super@gmail.com", "17/03/1999");
        memberList.add(n);
        n = new Member("20WMR08952", "Devon", "01110990922", "devon@gmail.com", "30/5/2000");
        memberList.add(n);
        n = new Member("20WMR08983", "Jia Wei", "0168822337", "jwyeok@gmail.com", "24/10/2000");
        memberList.add(n);
        n = new Member("20WMR08927", "Jia Yi", "01122331216", "daniel@gmail.com", "26/12/1999");
        memberList.add(n);
        n = new Member("20WMR08973", "Chia Qi", "0172323565", "cqwong@gmail.com", "09/07/2000");
        memberList.add(n);
        n = new Member("20WMR08929", "Jing Zhao", "0187755889", "handsome@gmail.com", "26/06/1999");
        memberList.add(n);
        n = new Member("20WMR08999", "Sook Jing", "0134567899", "sjhere@gmail.com", "07/06/2000");
        memberList.add(n);
        n = new Member("20WMR08998", "Sammy Yong", "0156341235", "sammy@gmail.com", "24/08/1999");
        memberList.add(n);
        n = new Member("20WMR08989", "Chee Weng", "0189674125", "wengbob@gmail.com", "07/07/1999");
        memberList.add(n);
        n = new Member("20WMR08959", "Qing Qing", "0131973899", "doubleqing@gmail.com", "03/10/2000");
        memberList.add(n);
        n = new Member("20WMR08921", "Sue Faye", "0145678201", "justina@gmail.com", "01/01/2001");
        memberList.add(n);
        n = new Member("20WMR08931", "Qian Ying", "0182245698", "qiany@gmail.com", "05/04/2000");
        memberList.add(n);

        EventDetails e = new EventDetails("Music festival", "22/12/2021", "20:00-22:00", "Live Stream", "Please enter room early 10 mminutes", 20.00);
        eventList.push(e);

        e = new EventDetails("Singing Lession", "19/11/2020", "20:00-21:00", "Google Meet Link(Code: Sing lesson)", "Lesson will conduct at monday and thursday end at 23/12/2020.(8 Lesson) ", 100.00);
        eventList.push(e);

        e = new EventDetails("Advance Guitar Lesson", "24/11/2020", "18:00-19:00", "Google Meet Link(Code: Advanced Guitar lesson)", "Advance guitar lession teach by teacher Thiam every friday. Lesson end at 27/12/2020 (8 Lesson)", 100.00);
        eventList.push(e);

        e = new EventDetails("Guitar Lesson", "24/11/2020", "19:30-20:30", "Google Meet Link(Code: Guitar lesson)", "Beginner guitar lession teach by teacher Thiam every friday. Lesson end at 27/11/2020 (8 Lesson)", 100.00);
        eventList.push(e);

        e = new EventDetails("Music Night", "22/01/2021", "17:00-22:00", "Google Meet Link (Code: MusicNight)", "Visual welcome party for the new member. Performance by Senior member, Free for all member ", 70.00);
        eventList.push(e);

        e = new EventDetails("Visual Music Fiesta", "23/04/2021", "19:00-21:00", "Google Meet Link(Code:MusicFiesta)", "Visual music concert for for all member. Guest performer： xxx ", 65.00);
        eventList.push(e);

        e = new EventDetails("Music Sharing", "26/03/2021", "20:00", "Google Meet Link(Code:MusicSharing)", "Music sharing between member. Member require to prepare song and share the story about the song in the event ", 30.00);
        eventList.push(e);

        e = new EventDetails("OO Night", "25/05/2021", "20:00-22:00", "Google Meet Link (code: OONight)", "Welcome party for new intake student. Only allow new intake student to join the party", 25.00);
        eventList.push(e);

        LinkListInterface<Member> memList = new LinkList();
        LinkListInterface<Member> memList1 = new LinkList();
        LinkListInterface<Member> memList2 = new LinkList();

        memList.add(memberList.get(1));
        memList1.add(memberList.get(2));
        memList2.add(memberList.get(3));

        memberEvent.add(new Event("0001", "Confirmed", eventList.getEntry(0), memberList.get(0)));
        memberEvent.add(new Event("0002", "Confirmed", eventList.getEntry(1), memberList.get(1)));
        memberEvent.add(new Event("0003", "Confirmed", eventList.getEntry(2), memberList.get(2)));
        memberEvent.add(new Event("0004", "Confirmed", eventList.getEntry(3), memberList.get(3)));
        memberEvent.add(new Event("0005", "Confirmed", eventList.getEntry(4), memberList.get(4)));
        memberEvent.add(new Event("0006", "Confirmed", eventList.getEntry(5), memberList.get(5)));

    }

    public static void main(String[] args) throws ParseException {
        MusicSociety app = new MusicSociety();

        app.initialize();
        firstPage();
    }

}
