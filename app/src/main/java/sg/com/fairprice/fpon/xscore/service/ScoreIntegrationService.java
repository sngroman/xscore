package sg.com.fairprice.fpon.xscore.service;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.com.fairprice.fpon.xscore.dto.ScoreInfoDto;
import sg.com.fairprice.fpon.xscore.mapper.XscoreMapper;
import sg.com.fairprice.fpon.xscore.model.ScoreInfo;
import sg.com.fairprice.fpon.xscore.repo.ScoreInfoRepo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class ScoreIntegrationService {

    private ScoreInfoRepo scoreInfoRepo;

    DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public ScoreIntegrationService(ScoreInfoRepo scoreInfoRepo) {
        this.scoreInfoRepo = scoreInfoRepo;
    }

    public long readCsv(String filename) throws IOException, ParseException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(filename));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("FPEmailId", "SubStartdate", "SubEndDate",
                                "Status", "MarketingConsent", "ScoreEmail")
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                if (csvParser.getCurrentLineNumber() != 1) {
                    ScoreInfoDto record = ScoreInfoDto.builder()
                            .fPEmailId(csvRecord.get("FPEmailId"))
                            .startDate(FORMAT.parse(csvRecord.get("SubStartdate")))
                            .endDate(FORMAT.parse(csvRecord.get("SubEndDate")))
                            .status(csvRecord.get("Status"))
                            .marketingConsent(csvRecord.get("MarketingConsent"))
                            .scoreEmail(csvRecord.get("ScoreEmail"))
                            .build();
                    ScoreInfo scoreInfo = XscoreMapper.map(record);
                    System.out.println(scoreInfo);
                    scoreInfoRepo.save(scoreInfo);
                }

            }
            return csvParser.getRecordNumber() - 1;
        }






    }
}
