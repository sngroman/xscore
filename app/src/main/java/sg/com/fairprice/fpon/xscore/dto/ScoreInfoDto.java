package sg.com.fairprice.fpon.xscore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Builder
@ToString
public class ScoreInfoDto {

    private String fPEmailId;

    private Date startDate;

    private Date endDate;

    private String status;

    private String marketingConsent;

    private String scoreEmail;
}
