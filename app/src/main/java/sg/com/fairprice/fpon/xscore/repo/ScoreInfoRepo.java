package sg.com.fairprice.fpon.xscore.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sg.com.fairprice.fpon.xscore.model.ScoreInfo;

@Repository
public interface ScoreInfoRepo extends CrudRepository<ScoreInfo, String> {
}
