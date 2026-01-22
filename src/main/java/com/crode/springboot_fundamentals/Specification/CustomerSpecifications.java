package com.crode.springboot_fundamentals.Specification;

import com.crode.springboot_fundamentals.model.Billing.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecifications {

    public static Specification<Customer> hasName(String name) {
        return (root, query, cb) ->
                name == null ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Customer> hasEmail(String email) {
        return (root, query, cb) ->
                email == null ? null : cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

    public static Specification<Customer> isFromCountry(String country) {
        return (root, query, cb) ->
                country == null ? null : cb.equal(root.get("country"), country);
    }
}
