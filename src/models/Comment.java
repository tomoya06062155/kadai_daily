package models;

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
@Table(name = "comment")
    @NamedQueries({
        @NamedQuery(
                name = "getAllComment",
                query = "SELECT c FROM Comment AS c ORDER BY c.id DESC"
                ),
        @NamedQuery(
                name = "getCommentCount",
                query = "SELECT COUNT(c) FROM Comment AS c"
                ),
    })


public class Comment {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report_id;

    @ManyToOne
    @JoinColumn(name = "Employee_id")
    private Employee employee_id;

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


    public Report getReport_id(){
        return report_id;
    }
    public void setReport_id(Report report_id){
        this.report_id = report_id;
    }


    public Employee getEmployee_id(){
        return employee_id;
    }
    public void setEmployee_id(Employee employee_id){
        this.employee_id = employee_id;
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
    public void setCreated_at(Timestamp created_at){
        this.created_at = created_at;
    }



}
