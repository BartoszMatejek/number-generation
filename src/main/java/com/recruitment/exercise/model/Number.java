package com.recruitment.exercise.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Number {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "number_seq_generator")
    @SequenceGenerator(
            sequenceName = "number_id_seq",
            name = "number_seq_generator",
            allocationSize = 1)
    private long id;
    private long value;
}
