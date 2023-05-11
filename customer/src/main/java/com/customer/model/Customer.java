package com.customer.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
   @Id
   @SequenceGenerator(name = "customer_id_sequence",
           sequenceName = "customer_id_sequence",initialValue = 1, allocationSize=1
   )
   @GeneratedValue(strategy = GenerationType.SEQUENCE,
           generator = "customer_id_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
