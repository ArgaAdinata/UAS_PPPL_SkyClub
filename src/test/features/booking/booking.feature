Feature: Pemesanan Lapangan oleh Penyewa
  Sebagai penyewa yang telah login, saya ingin memesan lapangan,
  Sehingga saya dapat menggunakannya pada jadwal yang dipilih.

  Background:
    Given Pengguna berada pada halaman detail lapangan

  @requires_login
  Scenario: Pemesanan berhasil dengan saldo cukup
    Given Pengguna memiliki saldo yang cukup
    When Pengguna memilih jadwal yang tersedia
    And Pengguna menuju ke halaman pembayaran
    And Pengguna menyelesaikan pemesanan
    Then Sistem membuat jadwal lapangan dipesan
    And Saldo Pengguna dikurangi

  @requires_login2
  Scenario: Pemesanan gagal karena saldo tidak cukup
    Given Pengguna tidak memiliki saldo yang cukup
    When Pengguna memilih jadwal yang tersedia
    And Pengguna menuju ke halaman pembayaran
    And Pengguna menyelesaikan pemesanan
    Then Sistem menampilkan pesan "saldo tidak cukup"
    And Saldo pengguna tidak berubah pada halaman pembayaran

  @requires_login
  Scenario: Pemesanan gagal karena tidak memilih jadwal
    Given Pengguna memiliki saldo yang cukup
    When Pengguna tidak memilih jadwal apapun
    And Pengguna menuju ke halaman pembayaran
    Then Sistem menampilkan pesan "Pilih jadwal terlebih dahulu"
    And Pengguna tetap berada di halaman detail lapangan