package com.example.order.domain.event;

public interface DomainEvent<T> {
    T getEntity();
}