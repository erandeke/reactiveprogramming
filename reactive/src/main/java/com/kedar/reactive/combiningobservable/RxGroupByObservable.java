package com.kedar.reactive.combiningobservable;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author Kedar Erande
 */

class Employee {

    private Integer empId;
    private String empName;
    private Double Rating;

    public Employee(Integer empId, String empName, Double rating) {
        this.empId = empId;
        this.empName = empName;
        Rating = rating;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }
}

public class RxGroupByObservable {
    public static void main(String[] args) {
        Observable<Employee> obs = Observable.just(
                new Employee(1, "Ron", 4.5),
                new Employee(3, "Pie", 5.0),
                new Employee(2, "Alaou", 4.0),
                new Employee(10, "Brain", 5.0),
                new Employee(6, "Rock", 4.5)
        );

        obs.groupBy(e->e.getRating())
                .flatMapSingle(e-> e.toMultimap(key -> e.getKey() , emp ->  emp.getRating()))
                .subscribe(e-> System.out.println(e));


    }
}
