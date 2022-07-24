package tech.igrant.weekly_contest.no303.no3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodRatingsTest {

    @Test
    public void testCase36() {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"czopaaeyl", "lxoozsbh", "kbaxapl"},
                new String[]{"dmnuqeatj", "dmnuqeatj", "dmnuqeatj"},
                new int[]{11, 2, 15}
        );
        foodRatings.changeRating("czopaaeyl", 12);
//        Assert.assertEquals(
//                "kbaxapl",
//                foodRatings.highestRated("dmnuqeatj")
//        );
        foodRatings.changeRating("kbaxapl", 8);
        foodRatings.changeRating("lxoozsbh", 5);
        Assert.assertEquals(
                "czopaaeyl",
                foodRatings.highestRated("dmnuqeatj")
        );
    }
}