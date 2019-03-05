package sg.com.fairprice.fpon.xscore.mapper;

import sg.com.fairprice.fpon.xscore.dto.ScoreInfoDto;
import sg.com.fairprice.fpon.xscore.model.ScoreInfo;

public class XscoreMapper {

    public static ScoreInfo map(ScoreInfoDto dto) {
        ScoreInfo result = new ScoreInfo();
        result.setStartDate(dto.getStartDate());
        result.setEndDate(dto.getEndDate());
        result.setFPEmailId(dto.getFPEmailId());
        result.setScoreEmail(dto.getScoreEmail());
        result.setStatus(dto.getMarketingConsent());
        return result;
    }
}
