/*
*
*
*
 */
package ADT;

import Entity.Admin;
import Entity.Member;

/**
 *
 * @author Ming Nee
 */
public class MemberLinkedList implements MemberListInterface<Member> {

    LinkListInterface<Member> memberList;
    LinkListInterface<Admin> adminList;

    public MemberLinkedList() {
        memberList = new LinkList();
//        Member n = new Member("20WMR08981", "Ming Nee", "0123456789", "minnie@gmail.com", "30/7/1999");
//        memberList.add(n);
//        n = new Member("20WMR08928", "Tzu Wey", "0124455667", "ren@gmail.com", "12/12/2000");
//        memberList.add(n);
//        n = new Member("20WMR08932", "Fung Ann", "0102233445", "falim@gmail.com", "11/11/2000");
//        memberList.add(n);
//        n = new Member("20WMR08920", "Wen Xuen", "0137788999", "wxkhau@gmail.com", "10/5/2000");
//        memberList.add(n);
//        n = new Member("20WMR08905", "Jen Nam", "01155556677", "super@gmail.com", "17/03/1999");
//        memberList.add(n);
//        n = new Member("20WMR08952", "Devon", "01110990922", "devon@gmail.com", "30/5/2000");
//        memberList.add(n);
//        n = new Member("20WMR08983", "Jia Wei", "0168822337", "jwyeok@gmail.com", "24/10/2000");
//        memberList.add(n);
//        n = new Member("20WMR08927", "Jia Yi", "01122331216", "daniel@gmail.com", "26/12/1999");
//        memberList.add(n);
//        n = new Member("20WMR08973", "Chia Qi", "0172323565", "cqwong@gmail.com", "09/07/2000");
//        memberList.add(n);
//        n = new Member("20WMR08929", "Jing Zhao", "0187755889", "handsome@gmail.com", "26/06/1999");
//        memberList.add(n);
//        n = new Member("20WMR08999", "Sook Jing", "0134567899", "sjhere@gmail.com", "07/06/2000");
//        memberList.add(n);
//        n = new Member("20WMR08998", "Sammy Yong", "0156341235", "sammy@gmail.com", "24/08/1999");
//        memberList.add(n);
//        n = new Member("20WMR08989", "Chee Weng", "0189674125", "wengbob@gmail.com", "07/07/1999");
//        memberList.add(n);
//        n = new Member("20WMR08959", "Qing Qing", "0131973899", "doubleqing@gmail.com", "03/10/2000");
//        memberList.add(n);
//        n = new Member("20WMR08921", "Sue Faye", "0145678201", "justina@gmail.com", "01/01/2001");
//        memberList.add(n);
//        n = new Member("20WMR08931", "Qian Ying", "0182245698", "qiany@gmail.com", "05/04/2000");
//        memberList.add(n);
//
    }

    @Override
    public void add(Member newMember) {
        memberList.add(newMember);
    }

    @Override
    public void remove(Member member) {
        for (int i = 0; i < memberList.getNumberOfEntries(); i++) {
            if (memberList.getEntry(i).equals(member)) {
                memberList.remove(i);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return memberList.isEmpty();
    }

    @Override
    public String login(String username, String password) {
        for (int i = 0; i < adminList.getNumberOfEntries(); i++) {
            if (adminList.getEntry(i).getUsername().equals(username) && adminList.getEntry(i).getPassword().equals(password)) {
                return adminList.getEntry(i).getAdminID();
            }
        }

        return null;
    }

    @Override
    public Admin forgotPassword(String email) {
        for (int i = 0; i < adminList.getNumberOfEntries(); i++) {
            if (adminList.getEntry(i).getEmail().equals(email)) {
                return adminList.getEntry(i);
            }
        }
        return null;
    }

   @Override
    public Member get(int position) {
        return memberList.getEntry(position);
    }

    @Override
    public int getLength() {
        return memberList.getNumberOfEntries();
    }

}
