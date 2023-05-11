package com.microservice.notification.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notification {
    @Id
    @SequenceGenerator(name = "notification_id_sequence",
            sequenceName = "notification_id_sequence",initialValue = 1, allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence")
    private Long id;
    private Long toCustomerId;
    private String customerEmail;
    private String sender;
    private String message;
    private Date dateTime;


}
