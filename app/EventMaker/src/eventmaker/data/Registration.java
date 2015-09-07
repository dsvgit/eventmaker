package eventmaker.data;

import eventmaker.data.enums.ApproveState;
import eventmaker.data.enums.PaymentState;
import eventmaker.data.shared.Entity;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "registration")
public class Registration extends Entity {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    
    @Enumerated(EnumType.ORDINAL)
    private ApproveState approveState;
    
    @Enumerated(EnumType.ORDINAL)
    private PaymentState paymentState;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Registration() {
    }

    public Registration(Event event, ApproveState approveState, 
            PaymentState paymentState, User user) {
        this.event = event;
        this.approveState = approveState;
        this.paymentState = paymentState;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ApproveState getApproveState() {
        return approveState;
    }

    public void setApproveState(ApproveState approveState) {
        this.approveState = approveState;
    }

    public PaymentState getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Object getIdentifier() {
        return id;
    }
    
}
