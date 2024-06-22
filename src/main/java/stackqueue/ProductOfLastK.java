package stackqueue;

import java.util.ArrayList;
import java.util.List;

class ProductOfLastK {
    List<Integer> product;
    int prev;

    public ProductOfLastK() {
        product = new ArrayList<>();
        prev = 1;
    }

    public void add(int num) {
        if (num == 0) {
            product.clear();
            prev = 1;
            return;
        }
        prev *= num;
        product.add(prev);
    }

    public int getProduct(int k) {
        if (product.size() < k) return 0;
        int ans = product.get(product.size() - 1);
        if (product.size() == k) return ans;
        return (ans / product.get(product.size() - 1 - k));

    }
}
