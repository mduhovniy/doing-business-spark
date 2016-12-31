package info.duhovniy.doingbusiness.services;


import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Service;

@Service
public class DTFRatingServiceImpl implements DTFRatingService {

    @Override
    public String topXCountries(DataFrame df, int x) {
        return df.first().getString(0);
    }
}
