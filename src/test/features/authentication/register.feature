Feature: Pendaftaran Pengguna
  Sebagai pengguna baru yang belum memiliki akun,
  Saya ingin mendaftarkan akun baru,
  Sehingga saya dapat masuk dan menggunakan layanan penyewaan lapangan.

  Background:
    Given Pengguna berada di halaman register

  Scenario: Pendaftaran berhasil dengan data valid
    When Pengguna mengisi formulir pendaftaran dengan nama "PPPL", username "PPPL", email "PPPL@mail.com", number "08654321234", password "password", dan confirm password "password"
    And Pengguna mencentang checkbox "I agree to all the Terms and Privacy Policies"
    And Pengguna menekan tombol "daftar" pada halaman register
    Then Pengguna diarahkan ke halaman login

  Scenario: Pendaftaran gagal karena password kurang dari 6 karakter
    When Pengguna mengisi formulir pendaftaran dengan nama "PPPL", username "PPPL2", email "PPPL2@mail.com", number "086543222345", password "pass", dan confirm password "pass"
    And Pengguna mencentang checkbox "I agree to all the Terms and Privacy Policies"
    And Pengguna menekan tombol "daftar" pada halaman register
    Then Sistem menampilkan pesan error "Password harus minimal 6 karakter" saat register
    And Pengguna tetap berada di halaman register

  Scenario: Pendaftaran gagal karena username sudah ada
    Given Pengguna dengan username "test" sudah terdaftar di sistem
    When Pengguna mengisi formulir pendaftaran dengan nama "PPPL", username "test", email "PPPL3@mail.com", number "08654323312", password "password", dan confirm password "password"
    And Pengguna mencentang checkbox "I agree to all the Terms and Privacy Policies"
    And Pengguna menekan tombol "daftar" pada halaman register
    Then Sistem menampilkan pesan error "Username sudah digunakan" saat register
    And Pengguna tetap berada di halaman register

  Scenario: Pendaftaran gagal karena email sudah ada
    Given Pengguna dengan username "test" sudah terdaftar di sistem
    When Pengguna mengisi formulir pendaftaran dengan nama "PPPL", username "PPPL3", email "test@gmail.com", number "08654323323", password "password", dan confirm password "password"
    And Pengguna mencentang checkbox "I agree to all the Terms and Privacy Policies"
    And Pengguna menekan tombol "daftar" pada halaman register
    Then Sistem menampilkan pesan error "Email sudah digunakan" saat register
    And Pengguna tetap berada di halaman register

  Scenario: Pendaftaran gagal karena nomor telepon berupa string
    When Pengguna mencoba mengisi field nomor telepon dengan "abcdefgh"
    Then Field nomor telepon tidak menerima input string
    And Field nomor telepon tetap kosong

  Scenario: Pendaftaran gagal karena confirm password tidak cocok
    When Pengguna mengisi formulir pendaftaran dengan nama "PPPL", username "PPPL4", email "PPPL4@mail.com", number "08654324323", password "password", dan confirm password "wrongpass"
    And Pengguna mencentang checkbox "I agree to all the Terms and Privacy Policies"
    And Pengguna menekan tombol "daftar" pada halaman register
    Then Sistem menampilkan pesan error "Confirm password tidak cocok dengan password" saat register
    And Pengguna tetap berada di halaman register

  Scenario: Pendaftaran gagal karena checkbox terms belum dicentang
    When Pengguna mengisi formulir pendaftaran dengan nama "PPPL", username "PPPL5", email "PPPL5@mail.com", number "08654325522", password "password", dan confirm password "password"
    And Pengguna tidak mencentang checkbox "I agree to all the Terms and Privacy Policies"
    And Pengguna menekan tombol "daftar" pada halaman register
    Then Sistem menampilkan pesan error "Anda harus menyetujui semua syarat dan ketentuan" saat register
    And Pengguna tetap berada di halaman register
