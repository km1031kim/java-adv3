package optional;

import optional.model.Delivery;
import optional.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DeliveryMain {
    static Map<Long, Order> orderRepository = new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    public static void main(String[] args) {


    }

    private static String getDeliveryStatus(Long orderId) {
        // 딜리버리가 없거나 캔슬상태인경우 배송X 라고 출력
        return findOrder(orderId)
                .map(Order::getDelivery)
                .filter(d -> !d.isCanceled()) // Optiona.empty() 반환
                .map(Delivery::getStatus)
                .orElse("배송X"); //
    }

    static Optional<Order> findOrder(Long orderId) {
        return Optional.ofNullable(orderRepository.get(orderId));
    }
}
