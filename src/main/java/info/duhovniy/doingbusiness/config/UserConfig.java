package info.duhovniy.doingbusiness.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Component
public class UserConfig implements Serializable {

    public List<String> exclude;

    @Value("${exclude}")
    private void setExclude(String[] exclude) {
        this.exclude = Arrays.asList(exclude);
    }
}
