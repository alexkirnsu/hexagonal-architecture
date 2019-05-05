package com.alexkirnsu.hexarch.inside.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
@Data
public class Order {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private int unitCount;
}
