package co.techandsolve.mudanza.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LogExecution")
@Entity
public class LogExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Document")
    private String document;

    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "Travels")
    private String travels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTravels() {
        return travels;
    }

    public void setTravels(String travels) {
        this.travels = travels;
    }

    @Override
    public String toString() {
        return "LogExecution{" +
                "id=" + id +
                ", document='" + document + '\'' +
                ", date=" + date +
                ", travels='" + travels + '\'' +
                '}';
    }
}
