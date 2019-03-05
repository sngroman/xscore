package sg.com.fairprice.fpon.xscore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.com.fairprice.fpon.xscore.dto.ScoreConfigDto;
import sg.com.fairprice.fpon.xscore.service.ScoreIntegrationService;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/score-integration")
public class ScoreIntegrationFireController {

    private ScoreIntegrationService scoreIntegrationService;

    @Autowired
    public ScoreIntegrationFireController(ScoreIntegrationService scoreIntegrationService) {
        this.scoreIntegrationService = scoreIntegrationService;
    }

    @PostMapping("/start")
    @ResponseBody
    public ResponseEntity<String> readCsv(@RequestBody ScoreConfigDto conf) throws IOException, ParseException {
        String filename = "/Users/1041767/Documents/projects/xscore/app/samples/clients.csv";
        return ResponseEntity.ok(scoreIntegrationService.readCsv(conf.getFilename()) + " rows was read");
    }
}
