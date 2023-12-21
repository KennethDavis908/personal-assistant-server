package com.davis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * ToDoLists will house tasks for a particular day
 *
 * @author Kenneth Davis
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "to_do_list")
public class ToDoList {

    @Id
    @Column(name = "to_do_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "to_do_list_id")
    private List<Task> tasks = new ArrayList<Task>();

    public ToDoList(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
