# TFA - DAY 1

## TASK GITHUB

1. Membuat repository di akun github kita (saya namakan `tfa-day-1`)
  ![step-1](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-1.png?raw=true)
2. Membuat folder dengan nama yang sama dengan nama repository di github, kemudian `cd` atau `masuk` ke dalam folder tersebut
  ![step-2](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-2.png?raw=true)
3. Melakukan inisialisasi git dengan perintah `git init`
  ![step-3](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-3.png?raw=true)
4. Membuat file pertama dengan nama file `README.md`, kemudian diisi file nya dan di inspect dengan perintah `cat README.md`
  ![step-4](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-4.png?raw=true)
5. Masukkan file baru ke dalam kondisi `staged` dengan maksud file siap di commit ke repo. Perintah `git add .`
  ![step-5](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-5.png?raw=true)
6. Melakukan perintah `commit` dengan `git commit -m "بسم الله الرحمن الرحيم"`
  ![step-6](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-6.png?raw=true)
7. Melakukan perintah untuk mengkoneksikan repo local dengan repo server dengan `git remote add origin git@github.com:KangAbbad/tfa-day-1.git`
  ![step-7](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-7.png?raw=true)
8. Melakukan perintah `push` untuk mengirim hasil commit ke repo server dengan `git push --set-upstream origin master`
  ![step-8](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-8.png?raw=true)
9. Membuat branch `development` dan melakukan commit pertama di branch tersebut, kemudian melakukan `git push`
  ![step-9](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-9.png?raw=true)
  ![step-9.1](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-10.png?raw=true)
10. Membuat branch `featureA` dengan `git checkout -b featureA`
  ![step-10](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-11.png?raw=true)
11. Mengirim branch `featureA` ke repo server dengan `git push --set-upstream origin featureA`
  ![step-11](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-12.png?raw=true)
12. Membuat branch `featureB` dengan `git checkout -b featureB`
  ![step-12](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-13.png?raw=true)
13. Mengirim branch `featureB` ke repo server dengan `git push --set-upstream origin featureB`
  ![step-13](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-14.png?raw=true)
14. Melakukan `checkout` ke branch `featureA`
  ![step-14](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-44.png?raw=true)
15. Melakukan `git pull origin development` untuk mendapatkan update terbaru dari branch `development`
  ![step-15](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-19.png?raw=true)
16. Melakukan perubahan di file `README.md` dan `push` perubahan
  ![step-16](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-21.png?raw=true)
  ![step-16.1](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-23.png?raw=true)
17. Melakukan `checkout` ke branch `featureB`, dan melakukan perubahan di file `README.md` kemudian `push` perubahan
  ![step-17](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-23.png?raw=true)
18. Melakukan `checkout` ke branch `development` dan melakukan `git merge featureA` untuk menggabungkan perubahan dari branch `featureA`, kemudian melakukan `git push` untuk mengirim perubahan ke repo server
  ![step-18](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-26.png?raw=true)
  ![step-18.1](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-46.png?raw=true)
19. Melakukan `git merge featureB` untuk menggabungkan perubahan dari branch `featureA`
  ![step-19](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-27.png?raw=true)
20. Kita mendapati `CONFLICT` perubahan pada file, kemudian kita solve
  ![step-20](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-28.png?raw=true)
21. Melakukan `commit` dan `push` setelah solving `CONFLICT`
  ![step-21](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-29.png?raw=true)
  ![step-21.1](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-30.png?raw=true)
22. Melakukan sedikit perubahan di branch `development` kemudian `stash` perubahan
  ![step-22](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-47.png?raw=true)
23. Melakukan `checkout` ke branch `featureA` untuk melakukan perubahan lagi dan `push` perubahan
  ![step-23](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-32.png?raw=true)
24. Melakukan `checkout` ke branch `development` dan `git merge featureA`
  ![step-24](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-34.png?raw=true)
25. Melakukan `stash pop` untuk mengembalikan kerjaan yang tertunda
  ![step-25](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-37.png?raw=true)
  ![step-25.1](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-38.png?raw=true)
  ![step-25.2](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-39.png?raw=true)
26. Melakukan solving `CONFLICT`, kemudian `commit` dan `push`
  ![step-26](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-40.png?raw=true)
27. Melakukan merge no fast forward `git merge --no-ff` di branch `featureA` untuk mendapatkan update terbaru dari branch `development`
  ![step-26](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-45.png?raw=true)
28. Screenshot history commit / screenshot network di github
  ![step-28](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-41.png?raw=true)
  ![step-28.1](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-42.png?raw=true)
  ![step-28.2](https://github.com/KangAbbad/tfa-day-1/blob/featureA/images/ss-43.png?raw=true)
