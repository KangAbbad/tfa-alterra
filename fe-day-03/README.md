# Frontend Day 03

## Task Javascript

### Task 1

![task-1](https://github.com/KangAbbad/tfa-alterra/blob/master/fe-day-03/images/ss-01.png?raw=true)

Link: [https://github.com/KangAbbad/tfa-alterra/tree/master/fe-day-03/main.js](https://github.com/KangAbbad/tfa-alterra/tree/master/fe-day-03/main.js)

### Task 2.a

```notes
Jelaskan kenapa line 21, 22, 23 tidak dapat tampil?
> Karena variable 'terdaftar' value nya 'false'
```

### Task 2.b

```notes
Jelaskan kenapa deklarasi pada baris 26 menyebabkan error?
> Karena deklarasi variable 'nama' adalah const. Const berarti tidak bisa di replace dengan data baru
```

### Task 2.c

```notes
Dengan melakukan komen pada baris ke 26, apakah baris 28 dapat dieksekusi? jelaskan
> Baris 28 dapat dieksekusi. Karena dibaris 26 melakukan assign data ke variable const dan ini menyebabkan error, sehingga dengan mengkomen baris 26 maka baris 28 tereksekusi dengan baik
```

### Task 3

```javascript
  const foo = ["Budi", "Sita", "Ayu"];
  const [a, b, c] = foo;
```

### Task 4

```javascript
  let bdays = ["10-17", "05-19", "20-19"];
  bdays.reduce((acc, curr) => [...acc, curr.replace("-", "/")], []);
```

### Task 5

```javascript
  let value = [1, 2, 3, 4, 5, 6];
  value.reduce((acc, curr) => [...acc, curr * 2], []);
```

### Task 6

```javascript
  let arr = [1.5, 2.56, 5.1, 12.33];
  arr.reduce((acc, curr) => [...acc, Math.round(curr)], []);
```
