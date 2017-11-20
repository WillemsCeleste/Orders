package be.cegeka.orders.order.domain.orders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class SupplierService {
    public List<Order> getOrderListFromSupplier() {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);

        return null;
    }
}
