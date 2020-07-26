package chap08.testable;


import chap08.subs.Product;
import chap08.subs.ProductDao;

import java.util.HashMap;
import java.util.Map;

public class MemoryProductDao implements ProductDao {
    private Map<String, Product> prds = new HashMap<>();

    @Override
    public Product selectById(String productId) {
        return null;
    }
}
