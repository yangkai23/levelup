package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anirudh
 * @since 20/04/26
 */
public class Test {
    // Kn blr
    // kn hub
    // mh mum
    // mh pun

    // null mys


    // null, nag


    static {
        i = 10;
    }


    static int i = 20;

    // kn= [blr,hub]


    public static void get() {
        System.out.println(i);
    }

    public static void main(String[] args) {

        get();


        // { ( [ <

        // } ) ] >

        // {()[]<>}  test case

        // {


        // { <)}  test case 2


//        List<CityDetails> cityDetailsList = new ArrayList<>();
//
//        CityDetails kn1 = new CityDetails("kn", "blr");
//        CityDetails kn2 = new CityDetails("kn", "hub");
//
//        cityDetailsList.add(kn1);
//        cityDetailsList.add(kn2);
//
//        //
//
////        Map<String, List<CityDetails>> collect = cityDetailsList.stream()
////                .collect(Collectors.groupingBy(CityDetails::getState));
//
//
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (CityDetails cityDetails : cityDetailsList) {
//
//
//            String state = cityDetails.getState();
//
//            if (map.containsKey(state)) {
//                map.get(state).add(cityDetails.city);
//            } else {
//
//                List<String> list = new ArrayList<>();
//                list.add(cityDetails.getCity());
//                map.put(state, list);
//            }
//
//
//        }
//
//        System.out.println(map);


    }


}


class CityDetails {
    String state;
    String city;

    public CityDetails(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CityDetails{");
        sb.append("state='").append(state).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }


}

