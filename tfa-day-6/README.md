# Task Day 6

## Task Database Relational

### Task 1 - Schema Database

Link: [https://github.com/KangAbbad/tfa-alterra/blob/master/tfa-day-6/digital%20outlet](https://github.com/KangAbbad/tfa-alterra/blob/master/tfa-day-6/digital%20outlet)

### Task 2 - Data Definition Language

1. Membuat database dengan nama alta_online_shop

    ```postgresql
    createdb alta_online_shop
    ```

2. Membuat table user

    ```postgresql
    psql -d alta_online_shop

    create table user(
      id serial primary key,
      name varchar,
      email varchar
    );
    ```

3. Membuat table product

    ```postgresql
    create table product(
      id serial primary key,
      name varchar,
      description varchar
    );
    ```

4. Membuat table product_type

    ```postgresql
    create table product_type(
      id serial primary key,
      name varchar,
    );
    ```

5. Membuat table operators

    ```postgresql
    create table operators(
      id serial primary key,
      name varchar,
    );
    ```

6. Membuat table payment_method

    ```postgresql
    create table payment_method(
      id serial primary key,
      name varchar,
    );
    ```

7. Membuat table transaction

    ```postgresql
    create table transaction(
      id serial primary key,
    );
    ```

8. Membuat table kurir

    ```postgresql
    create table kurir(
      id serial primary key,
      name varchar,
      created_at date,
      updated_at date,
    );
    ```

9. Menambahkan kolom ongkos_dasar ke table kurir

    ```postgresql
    alter table courier add ongkos_dasar int;
    ```

10. Merubah nama table kurir menjadi shipping

    ```postgresql
    alter table courier rename to shipping;
    ```

11. Menghapus table shipping yang ternyata tidak dibutuhkan

    ```postgresql
    drop table shipping;
    ```

12. Menambahkan entity baru dengan relation 1-to-1

    ```postgresql
    alter table payment_method add description varchar;
    ```

13. Menambahkan entity baru dengan relation 1-to-many

    ```postgresql
    alter table user add alamat varchar;
    ```

14. Menambahkan entity baru dengan relation many-to-many

    ```postgresql
    alter table user add user_payment_method_detail integer;
    alter table user add constraint fk_user_payment_method_detail foreign key(user_payment_method_detail) references payment_method(id);
    ```

15. Menambakan entity relation ke table transaction

    ```postgresql
    ## Menambahkan field user id
    alter table transaction add user_id integer;
    alter table transaction add constraint fk_user_id foreign key(user_id) references user(id);

    ## Menambahkan field product id
    alter table transaction add product_id integer;
    alter table transaction add constraint fk_product_id foreign key(product_id) references product(id);

    ## Menambahkan field payment method id
    alter table transaction add payment_method_id integer;
    alter table transaction add constraint fk_payment_method_id foreign key(payment_method_id) references payment_method(id);

    ## Menambahkan field operator id
    alter table transaction add operator_id integer;
    alter table transaction add constraint fk_operator_id foreign key(operator_id) references operators(id);
    ```
