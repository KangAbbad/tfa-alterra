# Task Day 6

## Task Database Relational

### Task 1 - Schema Database

Link: [https://github.com/KangAbbad/tfa-alterra/blob/master/tfa-day-6/digital%20outlet](https://github.com/KangAbbad/tfa-alterra/blob/master/tfa-day-6/digital%20outlet)

### Task 2 - Data Definition Language

1. Membuat database dengan nama alta_online_shop

    ```pgsql
    createdb alta_online_shop
    ```

2. Membuat table user

    ```pgsql
    psql -d alta_online_shop

    create table users(
      id serial primary key,
      status smallint,
      dob date,
      gender char,
      name varchar,
      created_at timestamp,
      updated_at timestamp
    );
    ```

3. Membuat table products

    ```pgsql
    create table products(
      id serial primary key,
      product_type_id int,
      operator_id int,
      code varchar,
      name varchar,
      status smallint,
      created_at timestamp,
      updated_at timestamp,
      constraint fk_product_type_id foreign key(product_type_id) references product_types(id),
      constraint fk_operator_id foreign key(operator_id) references operators(id)
    );
    ```

4. Membuat table product_types

    ```pgsql
    create table product_types(
      id serial primary key,
      name varchar,
      created_at timestamp,
      updated_at timestamp
    );
    ```

5. Membuat table operators

    ```pgsql
    create table operators(
      id serial primary key,
      name varchar,
      created_at timestamp,
      updated_at timestamp
    );
    ```

6. Membuat table payment_methods

    ```pgsql
    create table payment_methods(
      id serial primary key,
      name varchar,
      created_at timestamp,
      updated_at timestamp
    );
    ```

7. Membuat table transactions

    ```pgsql
    create table transaction(
      id serial primary key,
      user_id int,
      payment_method_id int,
      status varchar,
      total_qty int,
      total_price numeric,
      created_at timestamp,
      updated_at timestamp,
      constraint fk_user_id foreign key(user_id) references users(id),
      constraint fk_payment_method_id foreign key(payment_method_id) references payment_methods(id),
    );
    ```

8. Membuat table kurir

    ```pgsql
    create table kurir(
      id serial primary key,
      name varchar,
      created_at timestamp,
      updated_at timestamp,
    );
    ```

9. Menambahkan kolom ongkos_dasar ke table kurir

    ```pgsql
    alter table kurir add ongkos_dasar numeric;
    ```

10. Merubah nama table kurir menjadi shipping

    ```pgsql
    alter table kurir rename to shipping;
    ```

11. Menghapus table shipping yang ternyata tidak dibutuhkan

    ```pgsql
    drop table shipping;
    ```

12. Menambahkan entity baru dengan relation 1-to-1

    ```pgsql
    create table payment_method_descriptions(
      id serial primary key,
      payment_method_id int,
      description text,
      constraint fk_payment_method_id foreign key(payment_method_id) references payment_methods(id)
    );
    ```

13. Menambahkan entity baru dengan relation 1-to-many

    ```pgsql
    create table addresses(
      id serial primary key,
      address text,
      user_id int,
      constraint fk_user_id foreign key(user_id) references users(id)
    );
    ```

14. Menambahkan entity baru dengan relation many-to-many

    ```pgsql
    alter table users add column user_payment_method_detail int
    constraint fk_user_payment_method_detail references payment_methods(id);
    ```

### Task 3: Data Manipulation Language

1. Insert 5 operators pada table operators

    ```pgsql
    insert into operators(name) values ('XL', 'Telkomsel', 'Indosat', 'Smartfren', 'By.U');
    ```

2. Insert 3 product types

    ```pgsql
    insert into product_types(name) values ('Pulsa', 'Kuota', 'Masa Aktif Nomor');
    ```

3. Insert 2 product dengan product type id = 1 dan operator id = 3

    ```pgsql
    insert into products(product_type_id, operator_id, code, name, status) values
    (1, 3, 'PT1-OP3-5000', 'Pulsa 5000', 1),
    (1, 3, 'PT1-OP3-10000', 'Pulsa 10000', 1);
    ```

4. Insert 3 product dengan product_type_id = 2 dan operator id = 1

    ```pgsql
    insert into products(product_type_id, operator_id, code, name, status) values
    (2, 1, 'PT2-OP1-10GB', 'Combo Plus 10GB', 1),
    (2, 1, 'PT2-OP1-20GB', 'Combo Plus 20GB', 1),
    (2, 1, 'PT2-OP1-30GB', 'Combo Plus 30GB', 1),
    ```

5. Insert 3 product dengan product_type_id = 3 dan operator id = 4

    ```pgsql
    insert into products(product_type_id, operator_id, code, name, status) values
    (3, 4, 'PT3-OP4-7HARI', 'Masa aktif 7 hari', 1),
    (3, 4, 'PT3-OP4-21HARI', 'Masa aktif 21 hari', 1),
    (3, 4, 'PT3-OP4-60HARI', 'Masa aktif 60 hari', 1),
    ```

6. Insert product description pada setiap product

    ```pgsql
    insert into product_descriptions(description, product_id) values
    ('Menambah saldo pulsa sebesar 5000', 1),
    ('Menambah saldo pulsa sebesar 10000, 2'),
    ('Menambah kuota internet XL sebesar 10GB', 3),
    ('Menambah kuota internet XL sebesar 20GB', 4),
    ('Menambah kuota internet XL sebesar 30GB', 5),
    ('Menambah masa aktif nomor Smartfren selama 7 hari', 6),
    ('Menambah masa aktif nomor Smartfren selama 21 hari', 7),
    ('Menambah masa aktif nomor Smartfren selama 60 hari', 8);
    ```

7. Insert 3 payment methods

    ```pgsql
    insert into payment_methods(name, status) values
    ('Gopay', 1),
    ('LinkAja', 1),
    ('Bank Transafer', 1),
    ```

8. Insert 5 user pada table users

    ```pgsql
    insert into users(name, dob, gender, status) values
    ('Naufal', '1989-08-24', 'M', 1),
    ('Abbad', '1990-08-24', 'M', 1),
    ('Abduh', '1991-08-24', 'M', 1),
    ('Tuasikal', '1992-08-24', 'M', 1),
    ('Dia', '1994-08-24', 'F', 1);
    ```

9. Insert 3 transaksi di masing-masing user

    ```pgsql
    insert into transactions(user_id, payment_method_id, status, total_qty, total_price) values
    (1, 2, 'PAID', 3, 15000),
    (1, 2, 'PAID', 3, 30000),
    (1, 2, 'PAID', 3, 45000),

    (2, 2, 'PAID', 3, 15000),
    (2, 2, 'PAID', 3, 30000),
    (2, 2, 'PAID', 3, 45000),

    (3, 2, 'PAID', 3, 15000),
    (3, 2, 'PAID', 3, 30000),
    (3, 2, 'PAID', 3, 45000),

    (4, 2, 'PAID', 3, 15000),
    (4, 2, 'PAID', 3, 30000),
    (4, 2, 'PAID', 3, 45000),

    (5, 2, 'PAID', 3, 15000),
    (5, 2, 'PAID', 3, 30000),
    (5, 2, 'PAID', 3, 45000);
    ```

10. Insert 3 product di masing-masing transaksi

    ```pgsql
    insert into transaction_details(transaction_id, product_id, status, qty, price) values
    (1, 1, 'PAID', 3, 5000),
    (2, 2, 'PAID', 3, 10000),
    (3, 3, 'PAID', 3, 15000),
    (4, 1, 'PAID', 3, 5000),
    (5, 2, 'PAID', 3, 10000),
    (6, 3, 'PAID', 3, 15000),
    (7, 1, 'PAID', 3, 5000),
    (8, 2, 'PAID', 3, 10000),
    (9, 3, 'PAID', 3, 15000),
    (10, 1, 'PAID', 3, 5000),
    (12, 2, 'PAID', 3, 10000),
    (13, 3, 'PAID', 3, 15000),
    (14, 1, 'PAID', 3, 5000),
    (15, 2, 'PAID', 3, 10000),
    (16, 3, 'PAID', 3, 15000),
    (17, 1, 'PAID', 3, 5000),
    (18, 2, 'PAID', 3, 10000);
    ```

11. Tampilkan nama user/pelanggan dengan gender laki-laki/M

    ```pgsql
    select name from users where gender = 'M';
    ```

12. Tampilkan product dengan id = 3

    ```pgsql
    select * from products where id = 3;
    ```

13. Tampilkan data pelanggan yang created_at dalam range 7 hari kebelakang dan mempunyai nama mengandung kata 'a'

    ```pgsql
    select * from users where name like '%a%' and created_at > current_date - interval '7 days';
    ```

14. Hitung jumlah user/pelanggan dengan status gender perempuan

    ```pgsql
    select count(*) as user_count from users where gender = 'F';
    ```

15. Tampilkan data pelanggan dengan urutan sesuai nama abjad

    ```pgsql
    select * from users order by name ASC;
    ```

16. Tampilkan 5 data pada data product

    ```pgsql
    select * from products limit 5;
    ```

17. Ubah data product id 1 dengan nama 'product dummy'

    ```pgsql
    update products set name = 'product dummy' where id = 1;
    ```

18. Update qty = 3 pada transaction detail dengan product id 1

    ```pgsql
    update transaction_details set qty = 3 where product_id = 1;
    ```

19. Delete data pada tabel product dengan id 1

    ```pgsql
    delete from products where id = 1;
    ```

20. Delete pada tabel product dengan product type id 1

    ```pgsql
    delete from products where product_type_id = 1;
    ```

### Task 4: Data Control Language

1. Gabungkan data transaksi dari user id 1 dan user id 2

    ```pgsql
    select * from transactions where user_id in (1, 2);
    ```

2. Tampilkan jumlah harga transaksi user id 1

    ```pgsql
    select sum(total_price) as total_price from transactions where user_id = 1;
    ```

3. Tampilkan total transaksi dengan product type 2

    ```pgsql
    ```

4. Tampilkan semua field product dan field name tabel product type yang saling berhubungan

    ```pgsql
    select
        products.id,
        product_types.name as product_type_name,
        products.operator_id,
        products.code,
        products.name as product_name,
        products.status,
        products.created_at,
        products.updated_at
    from products
        inner join product_types on products.product_type_id = product_types.id;
    ```

5. Tampilkan semua field table transaction, field name table product, dan field name table user.

    ```pgsql
    ```

6. Buat function setelah data transaksi dihapus maka transaction detail terhapus juga dengan transaction id yang dimaksud.

    ```pgsql
    ```

7. Buat function setelah data transaksi detail dihapus maka data total_qty terupdate berdasarkan qty data transaction id yang dihapus.

    ```pgsql
    ```

8. Tampilkan data products yang tidak pernah ada di tabel transaction_details dengan sub-query.

    ```pgsql
    ```
