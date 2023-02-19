package com.kedar.reactive.operators;

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


public class RxOepratorransform {

    private static final Double RECOMMENDED_RATING = 3.5;
    public static void main(String[] args) {
        Observable<Employee> obs = Observable.just(
                new Employee(1, "Ron", 4.5),
                new Employee(3, "Pie", 3.2),
                new Employee(2, "Alaou", 4.0),
                new Employee(10, "Brain", 5.0)
                );

        //get the top 2 employees whose rating is best and get their names

        obs.filter(emp -> emp.getRating() > RECOMMENDED_RATING)
                .sorted((e1,e2) -> Double.compare(e2.getRating(),e1.getRating()))
                .map(e->e.getEmpName())
                .take(2)
                .subscribe(System.out::println);


        //reduce final result : 60
        //reduce final result : 60
         Observable.just(10,20,30)
                .reduce((a,b)->a+b)
                .subscribe(System.out::println);


    }
}
