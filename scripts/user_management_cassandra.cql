CREATE KEYSPACE IF NOT EXISTS migeri WITH REPLICATION ={ 'class' : 'SimpleStrategy','replication_factor' : '1'};

CREATE TABLE IF NOT EXISTS migeri.shopping_cart (
    id int PRIMARY KEY,
    name text,
    address text,
    age int
);

