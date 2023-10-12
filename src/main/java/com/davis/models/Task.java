package com.davis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tasks will store items on ToDo lists
 *
 * @author Kenneth Davis
 *
 */
@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "complete", nullable = false)
    private boolean complete;

    @Column(name = "to_do_list_id")
    private int toDoListId;
}
