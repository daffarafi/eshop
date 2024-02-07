<details>
    <summary>Reflection 1</summary>

Naming Convention: 
Disini saya menggunakan penamaan yang deskriptif dan konsisten untuk variabel, kelas, metode, dan komponen lainnya.
Contohnya adalah createProduct_titleMessage_isCorrect pada functional testing untuk melakukan testing apakah judul pada halaman CreateProduct sudah sesuai atau belum.
Modularity: 
Disini kode yang dibuat dipecah menjadi bagian-bagian tertentu yang disebut modul atau komponen dengan fungsinya masing-masing. Hal ini dilakukan untuk meningkatkan keterbacaan, pemeliharaan, dan pengujian.
Contohnya adalah folder Controller yang berfungsi untuk menerima permintaan HTTP, Model yang berfungsi untuk mewakili objek atau data pada aplikasi, dan Service yang berisi logic aplikasi.

</details>

<details>
    <summary>Reflection 2</summary>

Menulis unit test dapat memberikan perasaan yang baik karena memberikan keyakinan bahwa kode yang ditulis telah diuji dengan baik dan dapat berfungsi sebagaimana yang kita diharapkan. UNtuk menentukan berapa banyak unit test yang harus dibuat dalam sebuah kelas menurut saya tergantung pada seberapa kompleks suatu aplikasi serta kebutuhan fungsionalitas kelas tersebut. 
Memiliki 100% code coverage tidak menjamin bahwa kode tidak memiliki bug atau kesalahan. Code coverage hanya menunjukkan seberapa banyak kode yang diuji oleh unit test, namun tidak menjamin bahwa semua kemungkinan skenario telah ter-cover.

Ketika membuat functional test suite baru tentu akan membuat kode semakin kuat dan mengcover lebih banyak skenario, salah satu yang disebutkan adalah jumlah item pada product list. Namun menambahkan functional test baru tentu akan memberikan potensi baru adanya aturan clean code yang dilanggar. Misalnys seperti Duplikasi Kode, Pelanggaran DRY (Don't Repeat Yourself), Ketergantungan yang Tinggi Antar Test Case, dan lainnya. Hal ini dapat terjadi karena test case mungkin dibuat oleh lebih dari satu orang, mungkin saja orang lain tersebut tidak mengerti kode yang telah dibuat sebelumnya sehingga ia membuat fungsi baru dan melanggar aturan DRY.

</details>