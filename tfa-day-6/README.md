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

    create table user(
      id serial primary key,
      name varchar,
      email varchar
    );
    ```

3. Membuat table product

    ```pgsql
    create table product(
      id serial primary key,
      name varchar,
      description varchar
    );
    ```

4. Membuat table product_type

    ```pgsql
    create table product_type(
      id serial primary key,
      name varchar,
    );
    ```

5. Membuat table operators

    ```pgsql
    create table operators(
      id serial primary key,
      name varchar,
    );
    ```

6. Membuat table payment_method

    ```pgsql
    create table payment_method(
      id serial primary key,
      name varchar,
    );
    ```

7. Membuat table transaction

    ```pgsql
    create table transaction(
      id serial primary key,
    );
    ```

8. Membuat table kurir

    ```pgsql
    create table kurir(
      id serial primary key,
      name varchar,
      created_at date,
      updated_at date,
    );
    ```

9. Menambahkan kolom ongkos_dasar ke table kurir

    ```pgsql
    alter table courier add ongkos_dasar int;
    ```

10. Merubah nama table kurir menjadi shipping

    ```pgsql
    alter table courier rename to shipping;
    ```

11. Menghapus table shipping yang ternyata tidak dibutuhkan

    ```pgsql
    drop table shipping;
    ```

12. Menambahkan entity baru dengan relation 1-to-1

    ```pgsql
    alter table payment_method add description varchar;
    ```

13. Menambahkan entity baru dengan relation 1-to-many

    ```pgsql
    alter table user add alamat varchar;
    ```

14. Menambahkan entity baru dengan relation many-to-many

    ```pgsql
    alter table user add user_payment_method_detail integer;
    alter table user add constraint fk_user_payment_method_detail foreign key(user_payment_method_detail) references payment_method(id);
    ```

15. Menambakan entity relation ke table transaction

    ```pgsql
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

### Task 3: Data Manipulation Language

1. Insert 5 operators pada table operators

    ```js
    insert into operators(name) values ('XL', 'Telkomsel', 'Indosat', 'Smartfren', 'By.U');
    ```

2. Insert 3 product type

    ```js
    insert into product_types(name) values ('Pulsa', 'Kuota', 'Masa Aktif Nomor');
    ```

3. Insert 2 product dengan product type id = 1 dan operator id = 3

    ```js
    insert into products(product_type_id, operator_id, code, name, status) values
    (1, 3, 'PT1-OP3-5000', 'Pulsa 5000', 1),
    (1, 3, 'PT1-OP3-10000', 'Pulsa 10000', 1);
    ```

4. Insert 3 product dengan product_type_id = 2 dan operator id = 1

    ```js
    insert into products(product_type_id, operator_id, code, name, status) values
    (2, 1, 'PT2-OP1-10GB', 'Combo Plus 10GB', 1),
    (2, 1, 'PT2-OP1-20GB', 'Combo Plus 20GB', 1),
    (2, 1, 'PT2-OP1-30GB', 'Combo Plus 30GB', 1),
    ```

5. Insert 3 product dengan product_type_id = 3 dan operator id = 4

    ```js
    insert into products(product_type_id, operator_id, code, name, status) values
    (3, 4, 'PT3-OP4-7HARI', 'Masa aktif 7 hari', 1),
    (3, 4, 'PT3-OP4-21HARI', 'Masa aktif 21 hari', 1),
    (3, 4, 'PT3-OP4-60HARI', 'Masa aktif 60 hari', 1),
    ```

6. Insert product description pada setiap product

    ```js
    // Menambahkan foreign key product_id ke table product_descriptions
    // Untuk relasi terhadap product
    alter table product_descriptions add product_id int;
    alter table product_descriptions add constraint fk_product_id foreign key(product_id) references products(id) on delete cascade;

    // Kemudian menambahkan description ke setiap product
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

    ```js
    insert into payment_methods(name, status) values
    ('Gopay', 1),
    ('LinkAja', 1),
    ('Bank Transafer', 1),
    ```

8. Insert 5 user pada table users

    ```js
    // Menambahkan column name pada table users untuk nama user
    alter table users add name varchar;

    // Menambahkan user
    insert into users(name, dob, gender, status) values
    ('Naufal', '1989-08-24', 'M', 1),
    ('Abbad', '1990-08-24', 'M', 1),
    ('Abduh', '1991-08-24', 'M', 1),
    ('Tuasikal', '1992-08-24', 'M', 1),
    ('Nuzul', '1993-08-24', 'M', 1),
    ('Dia', '1994-08-24', 'F', 1);
    ```

9. Insert 3 transaksi di masing-masing user

    ```js
    insert into transactions(user_id, payment_method_id, status, total_qty, total_price, product_id) values
    (1, 1, 1, 1, 5000, 1),
    (1, 2, 1, 1, 10000, 2),
    (1, 3, 1, 1, 20000, 3),

    (2, 1, 1, 1, 5000, 1),
    (2, 2, 1, 1, 10000, 2),
    (2, 3, 1, 1, 20000, 3),

    (3, 1, 1, 1, 5000, 1),
    (3, 2, 1, 1, 10000, 2),
    (3, 3, 1, 1, 20000, 3),

    (4, 1, 1, 1, 5000, 1),
    (4, 2, 1, 1, 10000, 2),
    (4, 3, 1, 1, 20000, 3),

    (5, 1, 1, 1, 5000, 1),
    (5, 2, 1, 1, 10000, 2),
    (5, 3, 1, 1, 20000, 3),

    (6, 1, 1, 1, 5000, 1),
    (6, 2, 1, 1, 10000, 2),
    (6, 3, 1, 1, 20000, 3),
    ```

10. Insert 3 product di masing-masing transaksi

    ```js
    // Menambahkan product_ids ke table transactions untuk mengumpulkan product_id
    alter table transactions add product_ids int[];

    // Menambahkan product ke masing-masing transaksi
    update transactions set product_ids = array[1,2,3] where id = 1;
    update transactions set product_ids = array[1,2,3] where id = 2;
    update transactions set product_ids = array[1,2,3] where id = 3;
    update transactions set product_ids = array[1,2,3] where id = 4;
    update transactions set product_ids = array[1,2,3] where id = 5;
    update transactions set product_ids = array[1,2,3] where id = 6;
    update transactions set product_ids = array[1,2,3] where id = 7;
    update transactions set product_ids = array[1,2,3] where id = 8;
    update transactions set product_ids = array[1,2,3] where id = 9;
    update transactions set product_ids = array[1,2,3] where id = 10;
    update transactions set product_ids = array[1,2,3] where id = 11;
    update transactions set product_ids = array[1,2,3] where id = 12;
    update transactions set product_ids = array[1,2,3] where id = 13;
    update transactions set product_ids = array[1,2,3] where id = 14;
    update transactions set product_ids = array[1,2,3] where id = 15;
    update transactions set product_ids = array[1,2,3] where id = 16;
    update transactions set product_ids = array[1,2,3] where id = 17;
    update transactions set product_ids = array[1,2,3] where id = 18;
    ```

11. Tampilkan nama user/pelanggan dengan gender laki-laki/M

    ```js
    select name from users where gender = 'M';
    ```

12. Tampilkan product dengan id = 3

    ```js
    select * from products where id = 3;
    ```

13. Tampilkan data pelanggan yang created_at dalam range 7 hari kebelakang dan mempunyai nama mengandung kata 'a'

    ```js
    select * from users where name like '%a%' and created_at > current_date - interval '7 days';
    ```

14. Hitung jumlah user/pelanggan dengan status gender perempuan

    ```js
    select count(*) as user_count from users where gender = 'F';
    ```

15. Tampilkan data pelanggan dengan urutan sesuai nama abjad

    ```js
    select * from users order by name ASC;
    ```

16. Tampilkan 5 data pada data product

    ```js
    select * from products limit 5;
    ```

17. Ubah data product id 1 dengan nama 'product dummy'

    ```js
    update products set name = 'product dummy' where id = 1;
    ```

18. Update qty = 3 pada transaction detail dengan product id 1

    ```js
    update transaction_details set qty = 3 where product_id = 1;
    ```

19. Delete data pada tabel product dengan id 1

    ```js
    delete from products where id = 1;
    ```

20. Delete pada tabel product dengan product type id 1

    ```js
    delete from products where product_type_id = 1;
    ```
