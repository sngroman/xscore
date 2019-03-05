package sg.com.fairprice.fpon.xscore.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "XSCORE")
@Data
@ToString
public class ScoreInfo {

    @Id
    @Column(name = "SCORE_EMAIL")
    private String scoreEmail;

    @Column(name = "FR_EMAIL")
    private String fPEmailId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "SCORE_STATUS")
    private String status;

}
