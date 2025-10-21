CREATE SCHEMA IF NOT EXISTS "order";

CREATE TYPE order_status AS ENUM ('PENDING','PAID','APPROVED','CANCELLING','CANCELLED');

CREATE TABLE "order".orders (
                                id UUID PRIMARY KEY,
                                customer_id UUID NOT NULL,
                                restaurant_id UUID NOT NULL,
                                tracking_id UUID NOT NULL UNIQUE,
                                price NUMERIC(10,2) NOT NULL,
                                order_status order_status NOT NULL,
                                failure_messages VARCHAR,
                                created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);