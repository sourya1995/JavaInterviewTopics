package JavaCodingProblems.DataStructures.Map;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) throws UnknownHostException {
        Map<String, String> map = new HashMap<>();
        map.put("postgresql", "127.0.0.1:5432");
        map.put("mysql", "192.168.0.50:3306");
        map.put("cassandra", "192.168.1.5:9042");

        String hp1 = map.getOrDefault("derby", "127.0.0.1:5432");
        System.out.println(hp1);

        map.get("derby");

        BiFunction<String, String, String> jdbcUrl = (k, v) -> "jdbc:" + k + "://" + v + "/customers_db";
        String mySqlJdbcUrl = map.computeIfPresent("mysql", jdbcUrl);

        String address = Inet4Address.getLocalHost().getHostAddress();

        Function<String, String> jdbcUrl2 = k -> k + "://" + address + ":5432/customers_db";
        String mySqlJdbcUrl2 = map.computeIfAbsent("mongodb", jdbcUrl2);

        BiFunction<String, String, String> jdbcUrl3 = (k, v) -> "jdbc:" + k + "://" + ((v == null) ? address : v) + "/customers_db";
        String mySqlJdbcUrl3 = map.compute("clickhouse", jdbcUrl3);
        System.out.println(mySqlJdbcUrl3);
        System.out.println(map);

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "postgresql");
        map2.put(2, "mysql");
        map2.put(3, null);

        String v1 = map2.putIfAbsent(1, "derby"); // postgresql
        String v2 = map2.putIfAbsent(3, "derby"); // null
        String v3 = map2.putIfAbsent(4, "cassandra");

        System.out.println(map2);

        map2.entrySet().removeIf(e -> e.getValue().equals("dynamodb"));

    }
}
