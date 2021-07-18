package tms.storage;

import tms.entity.Operation;
import tms.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationStorage {

    private static List<Operation> operationList = new ArrayList<>();

    public void save(Operation o){
        operationList.add(o);
    }

    public List<Operation> getAll(){
        return new ArrayList<>(operationList);
    }

    public List<Operation> getAllByUser(User user){
        return operationList.stream().filter(operation -> operation.getUser().equals(user)).collect(Collectors.toList());
    }

}
