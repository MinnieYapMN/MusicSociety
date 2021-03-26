package Entity;


import ADT.*;
import java.util.Objects;

/**
 * 
 * @author Khau Wen Xuen 20WMR08920
 */
public class Payment {
    public static int nextNumber = 1000;
    private int paymentNo;
   // private double totalAmount;
    private String paymentDate;
    private String paymentTime;
    private Event event;
//    private SetInterface<Event> event;
//    private EventLinkedStackInterface<EventDetails> eventNo;
//    private LinkListInterface<Member> studID;
    
    public Payment() {
        this.paymentNo = nextNumber++;
    }
    

    public Payment( String paymentDate, String paymentTime, Event event) {
        this.paymentNo = nextNumber++;
        //this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.event = event;
//        this.eventNo = eventNo;
//        this.studID = studID;
        
    }

    public int getPaymentNo() {
        return paymentNo;
        
    }

//    public double getTotalAmount() {
//        return totalAmount;
//    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    

    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }

//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

//    public Event getRegisNo() {
//        return regisNo;
//    }
//
//    public void setRegisNo(Event regisNo) {
//        this.regisNo = regisNo;
//    }

    

//    public SetInterface<Event> getEvent() {
//        return event;
//    }
//
//    public void setEvent(SetInterface<Event> event) {
//        this.event = event;
//    }

//    public EventLinkedStackInterface<EventDetails> getEventNo() {
//        return eventNo;
//    }
//
//    public LinkListInterface<Member> getStudID() {
//        return studID;
//    }
//
//    public void setEventNo(EventLinkedStackInterface<EventDetails> eventNo) {
//        this.eventNo = eventNo;
//    }
//
//    public void setStudID(LinkListInterface<Member> studID) {
//        this.studID = studID;
//    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    
 
    
    
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Payment other = (Payment) obj;
//        if (!Objects.equals(this.paymentNo, other.paymentNo)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString(){
        String output = "   " + paymentNo + "       " + paymentDate + "       " + paymentTime + "          " + event.getRegisNo() + "          " + event.getRegisNo() + "         " + event.getMember().getEntry(0).getStudentID() + "           " + event.getEventD().getEntry(0).getFees();
        return output;
    }
}
