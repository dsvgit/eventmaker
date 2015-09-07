package eventmaker.data;

import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.shared.Entity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "event")
public class Event extends Entity {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    
    @Column(name="name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @Column(name="event_date")
    private Date eventDate;
    
    @Column(name="description")
    private String description;
    
    @Enumerated(EnumType.ORDINAL)
    private ApproveRule approveRule;
    
    @Enumerated(EnumType.ORDINAL)
    private PaymentRule paymentRule;
    
    @Enumerated(EnumType.ORDINAL)
    private Availability availability;
    
    @Column(name="cost")
    private BigDecimal cost;
    
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Event() {
    }

    public Event(String name, Category category, Date eventDate,
            String description, ApproveRule approveRule,
            PaymentRule paymentRule, Availability availability,
            BigDecimal cost, Company company) {
        this.name = name;
        this.category = category;
        this.eventDate = eventDate;
        this.description = description;
        this.approveRule = approveRule;
        this.paymentRule = paymentRule;
        this.availability = availability;
        this.cost = cost;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApproveRule getApproveRule() {
        return approveRule;
    }

    public void setApproveRule(ApproveRule approveRule) {
        this.approveRule = approveRule;
    }

    public PaymentRule getPaymentRule() {
        return paymentRule;
    }

    public void setPaymentRule(PaymentRule paymentRule) {
        this.paymentRule = paymentRule;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }    

    @Override
    public Object getIdentifier() {
        return id;
    }
    
}
