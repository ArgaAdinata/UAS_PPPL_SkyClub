Feature: Login Pengguna
  Sebagai pengguna yang telah terdaftar,
  Saya ingin masuk ke dalam sistem,
  Sehingga saya dapat mengakses layanan penyewaan.

  Background:
    Given Pengguna memiliki akun dengan username "PPPL" dan password "password"
    And Pengguna telah membuka halaman login

  Scenario: Login berhasil dengan kredensial yang benar
    When Pengguna mengisi username "PPPL" dan password "password"
    And Pengguna menekan tombol "Login"
    Then Pengguna berhasil login
    And Pengguna diarahkan ke halaman yang sesuai

  Scenario: Login gagal karena password salah
    When Pengguna mengisi username "PPPL" dan password "wrongpass"
    And Pengguna menekan tombol "Login"
    Then Sistem menampilkan pesan "username atau password salah" di halaman yang sama
    And Pengguna tetap berada di halaman login

  Scenario: Login gagal karena password kurang dari 6 karakter
    When Pengguna mengisi username "PPPL" dan password "pass"
    And Pengguna menekan tombol "Login"
    Then Sistem menampilkan pesan "Password minimal 6 karakter" di halaman yang sama
    And Pengguna tetap berada di halaman login

  Scenario: Login gagal karena username tidak terdaftar
    When Pengguna mengisi username "usernotexist" dan password "password"
    And Pengguna menekan tombol "Login"
    Then Sistem menampilkan pesan "username atau password salah" di halaman yang sama
    And Pengguna tetap berada di halaman login

  Scenario: Login gagal karena field username kosong
    When Pengguna mengisi username "" dan password "password"
    And Pengguna menekan tombol "Login"
    Then Sistem menampilkan pesan "Username tidak boleh kosong" di halaman yang sama
    And Pengguna tetap berada di halaman login

  Scenario: Login gagal karena field password kosong
    When Pengguna mengisi username "PPPL" dan password ""
    And Pengguna menekan tombol "Login"
    Then Sistem menampilkan pesan "Password tidak boleh kosong" di halaman yang sama
    And Pengguna tetap berada di halaman login

  Scenario: Login gagal karena kedua field kosong
    When Pengguna mengisi username "" dan password ""
    And Pengguna menekan tombol "Login"
    Then Sistem menampilkan pesan "Username dan password tidak boleh kosong" di halaman yang sama
    And Pengguna tetap berada di halaman login