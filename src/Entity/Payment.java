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
    private String paymentDate;
    private String paymentTime;
    private Event event;

    
    public Payment() {
        this.paymentNo = nextNumber++;
    }
    

    public Payment( String paymentDate, String paymentTime, Event event) {
        this.paymentNo = nextNumber++;
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.event = event;        
    }

    
    public int getPaymentNo() {
        return paymentNo;
        
    }

    
    public String getPaymentDate() {
        return paymentDate;
    }

    
    public String getPaymentTime() {
        return paymentTime;
    }

    
    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }


    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    
    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }


    public Event getEvent() {
        return event;
    }

    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    
 
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
        String output = "   " + paymentNo + "       " + paymentDate + "       " + paymentTime + "          " + event.getRegisNo() + "             " + event.getEventNo() + "          " + event.getMember().getStudentID() + "            " + event.getEventD().getFees();
        return output;
    }
}
