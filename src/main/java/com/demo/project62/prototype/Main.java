package com.demo.project62.prototype;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees(new ArrayList<>());
        emps.seedData();
        Employees dataSet1 = (Employees) emps.clone();
        Employees dataSet2 = (Employees) emps.clone();

        System.out.println("dataSet1 size: " + dataSet1.getEmpList().size());
        System.out.println("dataSet2 size: " + dataSet2.getEmpList().size());

        dataSet2.getEmpList().add("jhon");
        System.out.println("dataSet1 size: " + dataSet1.getEmpList().size());
        System.out.println("dataSet2 size: " + dataSet2.getEmpList().size());
    }

}

@AllArgsConstructor
@Data
class Employees implements Cloneable {

    private List<String> empList;

    public void seedData() {
        for (int i = 0; i < 100; i++) {
            empList.add("employee_" + i);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String s : this.empList) {
            temp.add(s);
        }
        return new Employees(temp);
    }
}