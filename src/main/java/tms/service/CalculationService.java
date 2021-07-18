package tms.service;

import tms.entity.Operation;
import tms.entity.User;
import tms.storage.OperationStorage;

import java.util.List;

public class CalculationService {

    private final OperationStorage operationStorage = new OperationStorage();

    public Operation calc(double a, double b, String operation, User user) {
        switch (operation) {
            case "sum":
                Operation sum = new Operation(a, b, operation, a + b, user);
                operationStorage.save(sum);
                return sum;
            case "sub":
                Operation sub = new Operation(a, b, operation, a - b, user);
                operationStorage.save(sub);
                return sub;
            case "mult":
                Operation mult = new Operation(a, b, operation, a * b, user);
                operationStorage.save(mult);
                return mult;
            case "div":
                Operation div = new Operation(a, b, operation, a / b, user);
                operationStorage.save(div);
                return div;
        }
        return null;
    }

    public List<Operation> findAllByUser(User user){
        return operationStorage.getAllByUser(user);
    }

}