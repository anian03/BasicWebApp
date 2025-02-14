package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Anian";
        } else if (query.contains("plus")) {
            String first = query.split("is ")[1].split(" ")[0];
            String second = query.split("plus ")[1];
            return Integer.toString(Integer.parseInt(first) + Integer.parseInt(second));
        } else if (query.contains("which of the following numbers is the largest")) {
            String b = query.split("which of the following numbers is the largest: ")[1];
            String[] numbers = b.split(", ");
            Integer[] nums = List.of(numbers).stream().map(e -> Integer.parseInt(e)).toArray(Integer[]::new);

            List<Integer> ints = new ArrayList<>(List.of(nums));

            while (ints.size() > 2) {
                int first = ints.remove(0);
                int second = ints.remove(1);
                ints.add(Integer.max(first, second));
            }

            return Integer.toString(Integer.max(ints.get(0),ints.get(1) ));
        } else {
            return "";
        }
    }
}
