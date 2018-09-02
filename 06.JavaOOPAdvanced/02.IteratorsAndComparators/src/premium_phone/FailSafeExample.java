package premium_phone;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeExample {

    public static void main(String[] args) {

        Map<String, String> premiumPhone = new ConcurrentHashMap<>() {{
            put("Apple", "Iphone");
            put("HTC", "HTC One");
            put("Samsung", "A3");
        }};

        for (String key : premiumPhone.keySet()) {
            System.out.println(key);
            premiumPhone.put("Nokia", "2600");
        }

        System.out.println("----------------------");

        for (String key : premiumPhone.keySet()) {
            System.out.println(key);
        }
    }
}

