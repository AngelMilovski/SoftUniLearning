package premium_phone;

import java.util.HashMap;
import java.util.Map;

public class FailFastExample {
    public static void main(String[] args) {

        Map<String, String> premiumPhone = new HashMap<>() {{
            put("Apple", "Iphone");
            put("HTC", "HTC One");
            put("Samsung", "A3");
        }};


        for (String key : premiumPhone.keySet()) {
            System.out.println(key);
            premiumPhone.put("Sony", "Xperia Z");
        }
    }
}
