package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository extends AbstractRepository<Car> {
    static int id = 0;

    public CarRepository() {
        this.data = new ArrayList<>();
    }

    @Override
    public Car update(String id, Car updatedCar) {
        for (Car car : data) {
            if (car.getId().equals(id)) {
                car.setName(updatedCar.getName());
                car.setColor(updatedCar.getColor());
                car.setQuantity(updatedCar.getQuantity());
                return car;
            }
        }
        return null;
    }
}
