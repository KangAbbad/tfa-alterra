# Task Day 10

## Task Spring JWT

### Task 1 - JWT Generator

Link: [https://github.com/KangAbbad/tfa-alterra/tree/master/tfa-day-10/authapp](https://github.com/KangAbbad/tfa-alterra/tree/master/tfa-day-10/authapp)

### Task 2 - JWT Extraction

Link: [https://github.com/KangAbbad/tfa-alterra/tree/master/tfa-day-10/authapp](https://github.com/KangAbbad/tfa-alterra/tree/master/tfa-day-10/authapp)

### How To Use

1. Lakukan git clone/download folder/project authapp
2. Rename file `env.properties.copy` menjadi `env.properties`
3. Buka file `env.properties` kemudian isikan nama database tujuan dan credentials database postgres Anda
4. Run project authapp
5. Sebelum aplikasi digunakan, masuk ke database Anda atau lakukan `psql -d <nama-database>` di terminal terlebih dahulu kemudian melakukan inisialisasi `role user`

    ```pgsql
    insert into roles(name, created_at, updated_at) values ('ADMIN', now(), now()), ('USER', now(), now());
    ```

6. API siap digunakan
