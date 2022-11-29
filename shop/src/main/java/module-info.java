module pl.training.shop {
    requires pl.training.payments.adapters;
    requires pl.training.payments.domain;
    requires transitive pl.training.payments.ports;

    requires pl.training.orders.adapters;
    requires pl.training.orders.domain;
    requires transitive pl.training.orders.ports;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.webmvc;
    requires lombok;
}
