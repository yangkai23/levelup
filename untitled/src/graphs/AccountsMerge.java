package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 10/12/25
 */
public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = List.of(
                List.of("David", "Avid0@m.co", "David0@m.co", "David1@m.co"),
                List.of("David", "Gvid3@m.co", "David3@m.co", "David4@m.co"),
                List.of("David", "David4@m.co", "David5@m.co"),
                List.of("David", "David2@m.co", "David3@m.co"),
                List.of("David", "David1@m.co", "David2@m.co")
        );


        System.out.println(accountsMerge(accounts));

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        //email,vertex
        HashMap<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (map.containsKey(email)) {

                    ds.unionBySize(map.get(email), i);
                } else {
                    map.put(email, i);
                }
            }
        }
        Map<Integer, List<String>> grouped = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int parent = ds.findUltimateParent(entry.getValue());
            grouped.computeIfAbsent(parent, k -> new ArrayList<>())
                    .add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : grouped.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.addFirst(accounts.get(entry.getKey()).getFirst());
            result.add(emails);
        }
        return result;

    }
}
