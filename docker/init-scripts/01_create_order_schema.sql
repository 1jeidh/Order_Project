CREATE SCHEMA IF NOT EXISTS "order";

CREATE TABLE "order".orders (
                                id UUID PRIMARY KEY,
                                customer_id UUID NOT NULL,
                                restaurant_id UUID NOT NULL,
                                tracking_id UUID NOT NULL UNIQUE,
                                price NUMERIC(10,2) NOT NULL,
                                order_status VARCHAR(20) NOT NULL,
                                failure_messages VARCHAR,
                                created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);