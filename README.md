<details>
    <summary>Reflection Module 4</summary>

1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.

    Meninjau alur TDD menggunakan pertanyaan reflektif yang diusulkan oleh Percival, penting untuk mengevaluasi apakah proses tersebut efektif dalam mencapai tujuannya. Mengingat tujuan pengujian, jika alur TDD tidak cukup berguna, saya perlu mengidentifikasi area untuk diperbaiki.
    
    Menurut saya, alur TDD yang telah saya lakukan selama mengerjakan module 4 ini cukup berguna. Berdasarkan usulan yang diberikan Percival, saya mengevaluasi proses TDD yang saya lakukan seperti berikut.
    
    Pertama, saya akan memeriksa apakah alur TDD cukup menangani kebutuhan dan fungsionalitas dari kode yang sedang di test?. Apakah test mencakup semua aspek yang diperlukan dari kode? Apakah terdapat celah dalam cakupan pengujian? Sejauh ini, saya menilai testing yang telah ditulis sudah memenuhi pertanyaan-pertanyaan tersebut
    
    Kedua, saya akan menilai efisiensi dari tahapan testing dengan metode TDD. Apakah proses ini menghasilkan siklus development yang lebih cepat dan kode yang lebih baik? Apakah ada bottleneck atau menghambat proses development? Menurut saya kode testing yang diberikan membantu menghasilkan kode lebih baik, walau dalam pembuatan testing akan sedikit menghambat, namun sepadang dengan fungsi testing itu sendiri, yaitu menemukan bug lebih awal, sehingga akan membantu dalam bug fixing nantinya.
    
    Ketiga, saya akan memperhatikan test yang telah dibuat. Apakah tes mudah dipahami dan direfactor jika dibutuhkan? Sejauh ini, test yang dibuat masih tidak terlalu kompleks, sehingga masih mudah dipahami dan tidak perlu di refactor.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.

    Fast: Apakah tes berjalan dengan cepat? Sejauh ini test masih berjalan dengan cepat dan tidak menghambat proses development.
    
    Isolated/Independent: Apakah tes independen satu sama lain? Ketergantungan satu sama lain dapat membuat kode kurang baik dan menyebabkan bug yang sulit di fix. Sejauh ini kode masih terisolasi dengan baik.
    
    Repeatable: Apakah tes dapat dijalankan secara konsisten di berbagai lingkungan? Ketidak konsistenan biasanya terjadi karena program bergantung pada faktor eksternal seperti package yang digunakan. Sejauh ini package masih tertulis dengan baik dan tidak bergantung dengan faktor eksternal. Seharusnya test akan menghasilkan hasil yang sama terlepas dari lingkungan di mana test tersebut dieksekusi.
    
    Self-validating: Apakah tes secara otomatis menentukan keberhasilan atau kegagalan mereka? Ya, semua test yang terpikiran sudah tertulis dalam test.
    
    Timely: Apakah tes ditulis tepat waktu, idealnya sebelum kode? Berdasarkan proses TDD, semua test yang ditulis telah ditulis sebelum kode program ditulis

</details>

<details>
<summary>Reflection Module 3</summary>

1) Explain what principles you apply to your project!

    Saya sudah menerapkan semua prinsip SOLID pada kode saya, berikut penjelasannya:
   - SRP
    Untuk menerapkan prinsip SRP saya memindahkan CarController yang ada pada ProductController.java ke file terpisah yaitu CarController.java. Menurut saya, menempatkan CarController pada ProductController.java tidak sesuai karena CarController tidak berhubungan dengan ProductController, selain itu CarController memiliki tugas yang terpisah dengan ProductController, yaitu agar web dapat mengakses endpoint /car.
   - OCP
    Untuk menerapkan prinsip OSP saya membuat sebuah abstract class untuk repository, yaitu AbstractRepository. Saya melihat banyak kemiripan antara CarRepository dan ProductRepository, salah satu perbedaannya adalah method update. Oleh karena itu, saya membuat abstract class yang sama, hanya saja method update saya buat abstract agar masing-masing dari ProductRepository dan CarRepository dapat mengextend AbstractRepository dan mengimplementasikan method updatenya masing-masing.
   - LSP
    Untuk menerapkan prinsip LSP saya merubah model Car agar mengextend model Product. Saya melihat kemiripan properti antara Car dan Product, yang membedakan adalah Car memiliki properti Color. oleh karena itu saya buat agar Car mengextend Product dan menambahkan properti baru yaitu Color. Hal ini mirip dengan kasus Square yang mengextend Rectangle. 
   - ISP
    Menurut saya, kode yang telah diberikan tidak melanggar prinsip ISP. Disini saya menganggap Product adalah Base Model dari model-model lainnya, salah satunya Car. Ketika ada model baru, maka model baru tersebut akan mengextend model Product, mirip seperti yang dilakukan oleh model Car. Saya mungkin bisa memecah Repository yang ada menjadi method CRUD masing-masing seperti CreateRepository, RetrieveRepository, DeleteRepository, dan UpdateRepository. Namun menurut saya hal itu tidak perlu, karena saya menganggap method-method CRUD menjadi method minimal untuk sebuah Repository.
   - DIP
    Untuk menerapkan DIP saya membuat ProductService menjadi sebuah interface yang memiliki Generic Type. Saya melihat kemiripan antara CarService dan ProductService, sehingga saya membuat kedua implementasi tersebut mengimplementasikan interface yang sama, yaitu ProductService, yang membedakan adalah Typenya. Saya tidak membuat abstract class seperti Repository karena menurut saya service sering kali memiliki logic yang berbeda, sehingga saya hanya membuat Interfacenya saja.

2) Explain the advantages of applying SOLID principles to your project with examples.

    Terdapat beberapa keuntungan pada proyek saya ketika menerapkan prinsip SOLID, diantaranya ialah:

    - Kualitas Kode yang Lebih Baik: SOLID membantu dalam pembuatan kode yang lebih bersih, terstruktur, dan mudah dimengerti. Hal ini meminimalkan kesalahan, memudahkan debugging, dan meningkatkan keandalan perangkat lunak. Contoh yang ada pada proyek saya adalah pemisahan CarController dari ProductController.java. Hal ini memudahkan karena isi dari ProductController.java tidak terlalu panjang sehingga developer tidak kesulitan dalam mencari kode.
    
    - Pengurangan Duplikasi Kode: Prinsip SOLID mendorong penggunaan pola-pola desain yang mengurangi duplikasi kode. Hal ini menghasilkan kode yang lebih bersih dan efisien. Contohnya adalah model dan repository pada proyek saya. Car model mengextend Product model, sehingga tidak perlu adanya pemisahan nama variable yang redundant seperti carId dan productId, cukup dengan id namun id tersebut ada pada masing-masing Car dan Product. CarRepository dan ProductRepository juga mengextend AbstractRepository dan hanya membuat method update yang berbeda.
    - Skalabilitas: SOLID memungkinkan struktur kode yang memfasilitasi pertumbuhan dan perubahan sistem seiring waktu. Dengan menerapkan prinsip-prinsip ini, Saya dapat menghindari pembuatan kode yang kaku dan sulit diperluas, sehingga sistem lebih mudah disesuaikan dengan kebutuhan baru. Contohnya adalah AbstractRepository dan ProductService, saya membuat AbstractRepository agar ketika ada Repository baru, Repository tersebut cukup mengextend AbstractRepository yang ada. Sedangkan jika ada Service baru, maka Service tersebut hanya perlu mengimplement ProductService, jika dibutuhkan method baru diluar ProductService, maka hanya perlu membuat interface baru yang mengimplement ProductService.
    
    Secara keseluruhan, menerapkan prinsip SOLID membantu dalam menciptakan basis kode yang kokoh, mudah dikelola, dan dapat berkembang dengan baik seiring waktu.

3) Explain the disadvantages of not applying SOLID principles to your project with examples.

    Tidak menerapkan prinsip SOLID dalam sebuah proyek dapat mengakibatkan beberapa kerugian yang signifikan:
    
    - Duplikasi Kode dan Ketidak Konsistenan: Tanpa SOLID, mungkin sulit untuk mengidentifikasi pola umum dan memperkenalkan abstraksi yang tepat. Hal ini sering mengakibatkan duplikasi kode di berbagai bagian proyek, yang tidak hanya membuang waktu tetapi juga dapat menyebabkan ketidak konsistenan antara bagian-bagian yang berbeda. Dapat dilihat pada branch before-solid, terdapat banyak sekali duplikasi kode pada Repository.
    
    - Kesulitan dalam Pengujian: Kode yang tidak menerapkan SOLID tentu akan membutuhkan kode testing yang lebih banyak, hal ini dikarenakan adanya duplikasi kode, dan banyak kode yang bergantung satu sama lain.
    
    - Kesulitan dalam Pemeliharaan dan Perbaikan Bug: Tanpa SOLID, ketika sebuah bug ditemukan atau perubahan diperlukan, pengembang mungkin perlu melakukan perubahan yang signifikan pada banyak bagian kode. Hal ini meningkatkan risiko memperkenalkan bug baru dan membuat pemeliharaan menjadi lebih rumit dan memakan waktu.
</details>

<details>
<summary>Reflection Module 2</summary>

1. Dalam pengerjaan module 2 kali ini, terdapat beberapa perbaikan dari kode saya, pertama saat mengimplementasikan JaCoCo dan yang kedua adalah saat mengimplementasikan Sonar Cloud. Saat mengimplementasikan JaCoCo saya mencoba memberikan unit test pada seluruh kode saya hingga coverage mencapai angka 100%. Hal ini mulai dari controller, service, hingga repository. Sedangkan pada saat mengimplementasikan Sonar Cloud, saya mencoba untuk menerapkan saran-saran yang diberikan oleh Sonar Cloud. Hal ini mulai dari menghapus penggunaan public yang tidak disarankan, memperbaiki penggunaan Autowired, dan lain sebagainya.
2. Menurut saya workflows yang saya tulis sudah memenuhi CI/CD. Continuous Integration yang saya lakukan adalah memanggil ./gradlew test dan ./gradlew sonar untuk melakukan automation testing. Automation testing yang digunakan menggunakan JaCoCo dan Sonar Cloud untuk melihat test coverage. Sedangkan untuk Continuous Deployment saya menggunakan Koyeb

</details>

<details>
<summary>Reflection Module 1</summary>

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
</details>