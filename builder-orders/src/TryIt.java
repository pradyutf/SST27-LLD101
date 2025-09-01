import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        // Order o = new Order("o2", "a@b.com");
        // o.addLine(l1);
        // o.addLine(l2);
        // o.setDiscountPercent(10);

        List<OrderLine> lines = List.of(l1, l2);

        //create order using builder
        Order o = new Order.OrderBuilder("3","email.com",lines)
                .discountPercent(10)
                .expedited(true)
                .notes("Please deliver between 3-5PM")
                .build();

        System.out.println("Before: " + o.totalAfterDiscount());

        //l1.setQuantity(999); // demonstrates mutability leak

        System.out.println("After:  " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable due to defensive copies.");
    }
}
