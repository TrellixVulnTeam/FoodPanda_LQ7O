package app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(nullable = false, length = 100)
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "user")
    private Set<PlacedOrder> placedOrders;

    @OneToOne(mappedBy = "admin")
    private Restaurant restaurant;

    public void addPlacedOrder(PlacedOrder placedOrder) {
        placedOrders.add(placedOrder);
    }
}
