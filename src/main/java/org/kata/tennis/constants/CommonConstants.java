package org.kata.tennis.constants;

import java.util.Arrays;
import java.util.List;

public interface CommonConstants {
    Integer THIRTY_SCORE = 2;
    Integer FORTY_SCORE = 3;
    Integer ADVANTAGE_SCORE = 4;
    List<String> pointsList = Arrays.asList("0", "15", "30", "40", "ADV");
    Long SCORE_DELAY = 500L;
}
