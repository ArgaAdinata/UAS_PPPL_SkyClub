Feature: Top Up Saldo oleh Penyewa
  Sebagai penyewa yang telah login,
  Saya ingin melakukan top up saldo,
  Sehingga saya dapat menggunakan saldo tersebut untuk memesan lapangan.

  Background:
    Given Pengguna sudah login
    And Pengguna berada pada halaman dompet

  @requires_login
  Scenario: Top up berhasil dengan nominal valid integer
    When Pengguna memasukkan nominal top up "100000"
    And Pengguna menyelesaikan proses pembayaran
    Then Sistem menambahkan saldo ke akun pengguna
    And Saldo pengguna bertambah sesuai nominal top up

  @requires_login
  Scenario: Top up berhasil dengan nominal desimal
    When Pengguna memasukkan nominal top up "50000.50"
    And Pengguna menyelesaikan proses pembayaran
    Then Saldo pengguna bertambah dengan menghilangkan desimal (50000)

@requires_login
  Scenario: Top up gagal karena nominal kurang dari 0
    When Pengguna memasukkan nominal top up "-10000"
    And Pengguna menekan tombol top up
    Then Sistem menampilkan pesan error "Nominal top up harus lebih dari 0"
    And Saldo pengguna tidak berubah
    And Pengguna tetap berada di halaman dompet

@requires_login
  Scenario: Top up gagal karena nominal 0
    When Pengguna memasukkan nominal top up "0"
    And Pengguna menekan tombol top up
    Then Sistem menampilkan pesan error "Nominal top up harus lebih dari 0"
    And Saldo pengguna tidak berubah
    And Pengguna tetap berada di halaman dompet

@requires_login
  Scenario: Top up gagal karena field nominal kosong
    When Pengguna membiarkan field nominal top up kosong
    And Pengguna menekan tombol top up
    Then Sistem menampilkan pesan error "Nominal top up harus lebih dari 0"
    And Saldo pengguna tidak berubah
    And Pengguna tetap berada di halaman dompet

@requires_login
  Scenario: Top up gagal karena nominal berupa huruf
    When Pengguna mencoba memasukkan nominal top up "satu juta"
    Then Field nominal top up tidak menerima input huruf
    And Field nominal top up tetap kosong