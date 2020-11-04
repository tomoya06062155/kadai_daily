package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
    @NamedQueries({
        @NamedQuery(
                name = "getAllComments_descending_order",
                query = "SELECT c FROM Comment AS c ORDER BY c.id DESC"
                ),
        @NamedQuery(
                name = "getAllComments_ascending_order",
                query = "SELECT c FROM Comment AS c ORDER BY c.id ASC"
                ),
        @NamedQuery(
                name = "getCommentsCount",
                query = "SELECT COUNT(c) FROM Comment AS c"
                )

    })

@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment_date")
    private Date comment_date;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Lob
    @Column(name = "Content")
    private String content;

    @Column(name = "Created_at")
    private Timestamp created_at;

    public Integer getid(){
        return id;
    }


    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }


    public Report getReport(){
        return report;
    }
    public void setReport(Report report){
        this.report = report;
    }

    public Date getComment_date(){
        return comment_date;
    }
    public void setComment_date(Date comment_date){
        this.comment_date = comment_date;
    }


    public Employee getEmployee(){
        return employee;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }


    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public Timestamp getCreated_at(){
        return created_at;
    }
    public void setCreated_at(Timestamp Created_at){
        this.created_at = Created_at;
    }


}
